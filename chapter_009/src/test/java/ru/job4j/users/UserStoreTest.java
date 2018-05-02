package ru.job4j.users;

import org.junit.*;
import ru.job4j.connectionpool.DBConnectionPool;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class UserStoreTest {

    private static UserStore userStore;

    /**
     * method init connection to db.
     */
    @BeforeClass
    public static void createConnectionAndTable() {
        userStore = UserStore.getInstance();
    }

    @Before
    public void createTable() {
        userStore.createTable();
    }
//
//    /**
//     * method close connection to db.
//     */
//    @AfterClass
//    public static void closeConnection() {
//        DBConnectionPool.closeConnection();
//    }

    /**
     * tests method addUser.
     */
    @Test
    public void whenAddUserThanResultTrueIfUserAlreadyExistThanResultFalse() throws ClassNotFoundException {
        User user = new User("igor", "login", "email");

        boolean result = userStore.addUser(user);
        Assert.assertThat(result, is(true));
        Assert.assertThat(userStore.getUser("igor"), is(user));

        result = userStore.addUser(user);
        Assert.assertThat(result, is(false));
    }

    /**
     * tests method deleteUser
     */
    @Test
    public void whenDeleteUserThanResultTrueIfUserDoesNotExistThanResultFalse() {
        User user = new User("igor", "login", "email");
        userStore.addUser(user);

        boolean result = userStore.deleteUser(user.getLogin());
        Assert.assertThat(result, is(true));

        User expected = null;
        Assert.assertThat(userStore.getUser("igor"), is(expected));

        result = userStore.deleteUser(user.getLogin());
        Assert.assertThat(result, is(false));
    }

    /**
     * tests method getAll.
     */
    @Test
    public void whenGetAllThanResultIsListOfAllUsers() {
        List<User> users = new ArrayList<>();
        User igor = new User("igor", "human", "email");
        User timon = new User("timon", "beast", "email");
        User pumba = new User("pumba", "animal", "email");
        users.add(igor);
        users.add(timon);
        users.add(pumba);
        userStore.addUser(igor);
        userStore.addUser(timon);
        userStore.addUser(pumba);

        List<User> result = userStore.getAll();

        Assert.assertTrue(result.contains(igor));
        Assert.assertTrue(result.contains(timon));
        Assert.assertTrue(result.contains(pumba));
    }
}
