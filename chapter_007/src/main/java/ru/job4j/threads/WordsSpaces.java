package ru.job4j.threads;

/**
 * class WordsSpaces
 */
public class WordsSpaces {
    public static void main(String[] args) throws InterruptedException {
        String string = "Some words with some spaces";
        new Thread(new WordsCalc(string)).start();
        new Thread(new SpacesCalc(string)).start();
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
        System.out.println(String.format("The number of words: %s", wordCalc(str)));
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
        System.out.println(String.format("The number of spaces: %s", wordCalc(str)));
    }
}
