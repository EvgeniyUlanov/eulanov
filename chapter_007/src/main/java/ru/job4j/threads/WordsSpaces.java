package ru.job4j.threads;

/**
 * class WordsSpaces
 */
public class WordsSpaces {

    private static void calculateWordsSpaces(String str) throws InterruptedException {
        System.out.println("Start calculating");
        System.out.println(str);
        Thread wordCalcThread = new Thread(new WordsCalc(str));
        Thread spaceCalcThread = new Thread(new SpacesCalc(str));
        wordCalcThread.start();
        spaceCalcThread.start();
        Thread.sleep(1000);
        wordCalcThread.interrupt();
        spaceCalcThread.interrupt();
        System.out.println("Finish");
    }

    public static void main(String[] args) throws InterruptedException {
        String string = "Some words with some spaces";
        calculateWordsSpaces(string);
    }
}

class WordsCalc implements Runnable {

    private String str;

    WordsCalc(String str) {
        this.str = str;
    }

    private int wordCalc(String str) {
        String[] strings = str.split(" ");
        return strings.length;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        if (!thread.isInterrupted()) {
            System.out.println(String.format("The number of words: %s", wordCalc(str)));
        }
    }
}

class SpacesCalc implements Runnable {

    private String str;

    SpacesCalc(String str) {
        this.str = str;
    }

    private int wordCalc(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result++;
            }
        }
        return result;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        if (!thread.isInterrupted()) {
            System.out.println(String.format("The number of spaces: %s", wordCalc(str)));
        }
    }
}


