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
    /** constant text to find.*/
    private static final String TEXT = "@Test";
    /** constant directory where need to find.*/
    private static final Path ROOT = Paths.get("C:\\projects\\eulanov\\");

    /**
     * main method.
     * @param args - args.
     * @throws IOException - IO exception.
     * @throws InterruptedException - Interrupt exception.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> exts = new ArrayList<>(Arrays.asList("java"));
        List<Path> result = startSearch(ROOT, TEXT, exts);
        int i = 0;
        for (Path path : result) {
            System.out.println(i++ + " - " + path.getFileName());
        }
    }

    /**
     * method startSearch.
     * @param root - directory where need to find.
     * @param text - text to find.
     * @param exts - extentioins of file where need to find text.
     * @return list of paths.
     * @throws IOException - IO exception.
     * @throws InterruptedException - Interrupt exception.
     */
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
    /** path.*/
    private Path path;
    /** text.*/
    private String text;
    /** list.*/
    private List<Path> list;

    /**
     * constructor.
     * @param path - path.
     * @param list - list.
     * @param text - text.
     */
    SearchThread(Path path, List<Path> list, String text) {
        this.path = path;
        this.text = text;
        this.list = list;
    }

    /**
     * method run.
     */
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
