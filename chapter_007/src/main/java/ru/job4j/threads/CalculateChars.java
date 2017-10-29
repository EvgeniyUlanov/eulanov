package ru.job4j.threads;

/**
 * class CalculateChars.
 */
public class CalculateChars {
    /** time.*/
    private static int time = 0;

    /**
     * method start.
     * @param str - incoming string.
     * @param timeToStop - stop time.
     * @throws InterruptedException - exception.
     */
    private static void start(String str, int timeToStop) throws InterruptedException {
        System.out.println("Start");
        Thread threadTime = new Thread(new TimeCalc());
        Thread threadCalc = new Thread(new CharCalc(str));
        threadTime.start();
        threadCalc.start();
        while (time < timeToStop) {
            Thread.sleep(100);
        }
        threadTime.interrupt();
        threadCalc.interrupt();
        System.out.println("Finish");
    }

    /**
     * method main.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {
        String str = "Some text with some sense for something";
        int timeToStop = 1000;
        start(str, timeToStop);
    }

    /**
     * class TimeCalc.
     */
    static class TimeCalc implements Runnable {
        /**
         * method run.
         */
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            Thread thread = Thread.currentThread();
            while (!thread.isInterrupted()) {
                time = (int) (System.currentTimeMillis() - startTime);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Time thread is interrupted");
                    return;
                }
            }
        }
    }

    /**
     * class CharCalc.
     */
    static class CharCalc implements Runnable {
        /** string.*/
        private String string;

        /**
         * constructor.
         * @param string - incoming string.
         */
        CharCalc(String string) {
            this.string = string;
        }

        /**
         * method run.
         */
        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != ' ') {
                    sum++;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("CharCalc thread is interrupted");
                    return;
                }
            }
            System.out.println(String.format("Sum of char in string - %s", sum));
        }
    }
}