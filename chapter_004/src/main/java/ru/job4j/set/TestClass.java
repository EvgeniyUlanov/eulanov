package ru.job4j.set;

/**
 * class test.
 */
public class TestClass {
    /**
     * method main.
     * @param args - args.
     */
    public static void main(String[] args) {

        SimpleSet<String> simpleSet = new SimpleSet<>(10000);
        long currentTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            simpleSet.add("test" + i);
        }
        long time = (System.nanoTime() - currentTime) / 1000;
        System.out.println(time);

        SimpleLinkedSet<String> simpleSet2 = new SimpleLinkedSet<>();
        long currentTime2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            simpleSet2.add("test" + i);
        }
        long time2 = (System.nanoTime() - currentTime2) / 1000;
        System.out.println(time2);

        SimpleHashSet<String> simpleSet3 = new SimpleHashSet<>();
        long currentTime3 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            simpleSet3.add("test" + i);
        }
        long time3 = (System.nanoTime() - currentTime3) / 1000;
        System.out.println(time3);
    }
}
