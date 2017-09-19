package ru.job4j.hashmap;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;

/**
 * class for testing UserConvertTest.
 * @author Evgeniy Ulanov(komrad1812@yandex.ru)
 * @version $Id$.
 * @since 0.1.
 */

public class UserConvertTest {
	/**
	 * test.
	 */
	@Test
	public void whenConvertListThanReturnHashMapConteinsElementsFromList() {
		List<User> sourseList = new ArrayList<>();
		HashMap<Integer, User> expected = new HashMap<>();
		User[] users = new User[10];
		for (int i = 0; i < users.length; i++) {
			users[i] = new User(String.format("user%s", i), "defoltCity");
			users[i].setId(1000 + i);
			sourseList.add(users[i]);
			expected.put(users[i].getId(), users[i]);
		}
		HashMap<Integer, User> resultMap;
		resultMap = UserConvert.process(sourseList);
		for (int i = 0; i < users.length; i++) {
			User userResult = resultMap.get(1000 + i);
			assert (expected.containsValue(userResult));
		}

	}
}