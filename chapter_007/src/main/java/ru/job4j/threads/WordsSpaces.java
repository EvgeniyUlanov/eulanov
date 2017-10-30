package ru.job4j.threads;

/**
 * class WordsSpaces
 */
public class WordsSpaces {
    /**
     * method calculateWordsSpaces.
     * @param str - incoming string.
     * @throws InterruptedException - exception.
     */
    private static void calculateWordsSpaces(String str) throws InterruptedException {
        System.out.println("Start calculating");
        System.out.println(str);
        Thread wordCalcThread = new Thread(new WordsCalc(str));
        Thread spaceCalcThread = new Thread(new SpacesCalc(str));
        wordCalcThread.start();
        spaceCalcThread.start();
        Thread.sleep(100);
        wordCalcThread.interrupt();
        spaceCalcThread.interrupt();
        System.out.println("Finish");
    }

    /**
     * method main.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {
        String string = "Some words with some spaces";
        calculateWordsSpaces(string);
    }
}

/**
 * class WordsCalc.
 */
class WordsCalc implements Runnable {
    /** str.*/
    private String str;

    /**
     * constructor.
     * @param str - srt.
     */
    WordsCalc(String str) {
        this.str = str;
    }

    /**
     * method wordCalc.
     * @param str - string.
     * @return string length.
     */
    private int wordCalc(String str) {
        int numberOfWords = 0;
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (!Thread.currentThread().isInterrupted()) {
                if (str.charAt(i) == ' ') {
                    numberOfWords++;
                    j = i;
                }
                if (i == str.length() - 1 && j != i) {
                    numberOfWords++;
                }
            }
        }
        return numberOfWords;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(String.format("The number of words: %s", wordCalc(str)));
        } else {
            System.out.println("Thread WordCalc was interrupted.");
        }
    }
}

/**
 * class SpacesCalc.
 */
class SpacesCalc implements Runnable {
    /** string.*/
    private String str;

    /**
     * constructor.
     * @param str - string.
     */
    SpacesCalc(String str) {
        this.str = str;
    }

    /**
     * method wordCalc.
     * @param str - string.
     * @return number of spaces.
     */
    private int spacesCalc(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            if (str.charAt(i) == ' ') {
                result++;
            }
        }
        return result;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(String.format("The number of spaces: %s", spacesCalc(str)));
        } else {
            System.out.println("Thread SpaceCalc was interrupted.");
        }
    }
}


