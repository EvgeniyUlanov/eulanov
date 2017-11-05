package ru.job4j.monitore;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * class ParallelSearch.
 */
public class ParallelSearch {

    private static final String TEXT = "@Test";
    private static final Path ROOT = Paths.get("C:\\projects\\eulanov\\");

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> exts = new ArrayList<>(Arrays.asList("java"));
        List<Path> result = startSearch(ROOT, TEXT, exts);
        int i = 0;
        for (Path path : result) {
            System.out.println(i++ + " - " + path.getFileName());
        }
    }

    private static List<Path> startSearch(Path root, String text, List<String> exts)
            throws IOException, InterruptedException {

        List<Path> result = new CopyOnWriteArrayList<>();
        List<Thread> threads = new ArrayList<>();
        StringBuilder pattern = new StringBuilder("regex:\\S+\\.(");
        for (int i = 0; i < exts.size(); i++) {
            pattern.append(exts.get(i));
            if (i < exts.size() - 1) {
                pattern.append("|");
            }
        }
        pattern.append(")");

        Files.walkFileTree(root, new SimpleFileVisitor<Path>()
            {
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    PathMatcher matcher = FileSystems.getDefault().getPathMatcher(pattern.toString());
                    if (matcher.matches(path.getFileName())) {
                        Thread thread = new SearchThread(path, result, text);
                        threads.add(thread);
                        thread.start();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        for (Thread thread : threads) {
            thread.join();
        }
        return result;
    }
}

/**
 * class MyThread.
 */
class SearchThread extends Thread {

    private Path path;
    private String text;
    private List<Path> list;

    public SearchThread(Path path, List<Path> list, String text) {
        this.path = path;
        this.text = text;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            String str = new String(Files.readAllBytes(path), Charset.defaultCharset());
            if (str.contains(text)) {
                list.add(path);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
