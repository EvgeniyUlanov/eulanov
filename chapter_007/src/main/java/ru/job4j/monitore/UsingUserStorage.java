package ru.job4j.monitore;

/**
 * class UsingUserStorage.
 */
public class UsingUserStorage {
    /**
     * method main.
     * @param args - args.
     * @throws InterruptedException - exception.
     */
    public static void main(String[] args) throws InterruptedException {
        UserStorage storage = new UserStorage();
        for (int i = 0; i < 20; i++) {
            Thread thread = new StorageThread(storage, i);
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(storage);
    }
}

/**
 * class StorageThread.
 */
class StorageThread extends Thread {

    /** storage to use.*/
    private UserStorage storage;
    /** thread number.*/
    private int number;

    /**
     * constructor.
     * @param storage - storage.
     * @param number - thread number.
     */
    public StorageThread(UserStorage storage, int number) {
        this.storage = storage;
        this.number = number;
    }

    /**
     * method run.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            User user = new User(number * 1000 + i, 200);
            storage.add(user);
        }
    }
}