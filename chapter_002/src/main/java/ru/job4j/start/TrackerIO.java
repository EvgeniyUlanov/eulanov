package ru.job4j.start;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TrackerIO class - class for encapsulate input/output for tracker.
 *
 * @author Evgeniy Ulanov (komrad1812@yandex.ru).
 * @version $Id$.
 * @since 0.1.
 */
public class TrackerIO {
    /** instance. */
    private static TrackerIO instance = new TrackerIO();
    /** output. */
    private Consumer<String> output;
    /** input. */
    private Input input;

    /**
     * private constructor without args.
     */
    private TrackerIO() {
    }

    /**
     * method for getting instance of trackerIO.
     * @return - trackerIO
     */
    public static TrackerIO getInstance() {
        return instance;
    }

    /**
     * method for initiate trackerIO by setting output and input.
     * @param output - output.
     * @param input - input.
     */
    public void initTrackerIO(Consumer<String> output, Input input) {
        this.output = output;
        this.input = input;
    }

    /**
     * method for output message for client.
     * @param message - message
     */
    public void out(final String message) {
        if (output != null) {
            output.accept(message);
        } else {
            throw new MenuOutException("TrackerIO is not initiated");
        }
    }

    /**
     * method for getting message from client.
     * @param question - question.
     * @return - client message.
     */
    public String in(final String question) {
        return getValue(() -> input.ask(question));
    }

    /**
     * method for getting number from client.
     * @param question - client number.
     * @param range - valid number range
     * @return - client number.
     */
    public int in(final String question, final List<Integer> range) {
        return getValue(() -> input.ask(question, range));
    }

    private <T> T getValue(Supplier<T> supplier) {
        if (input != null) {
            return supplier.get();
        } else {
            throw new MenuOutException("TrackerIO in not initiated");
        }
    }
}
