package ru.job4j.testtask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Comparator;


/**
 * class SortCodeArray - create dictionary of organization code and sort it.
 * @author Evgeniy Ulanov (komrad1812@yandex.ru)
 * @version $Id$.
 * @since 0.1.
 */
public class SortCodeArray {
    /**
     * metod create set of strings for dictionary.
     * @param incomingArray - sourse Array.
     * @return ArreyList.
     */
    public static TreeSet<String> createSrtSet(Collection<String> incomingArray) {
        TreeSet<String> result = new TreeSet<>();
        for (String str : incomingArray) {
            ArrayList<String> splitStr = splitBySlash(str);
            StringBuilder strToAdd = new StringBuilder();
            for (String string : splitStr) {
                strToAdd.append(string);
                result.add(strToAdd.toString());
                strToAdd.append("\\");
            }
        }
        return result;
    }

    /**
     * metod split string by slash.
     * @param str - sourse string.
     * @return ArrayList.
     */
    private static ArrayList<String> splitBySlash(String str) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\\') {
                result.add(str.substring(j, i));
                j = i + 1;
            }
            if (i == str.length() - 1) {
                result.add(str.substring(j, i + 1));
            }
        }
        return result;
    }

    /**
     * metod sort Array by decrease elements.
     * @param incoming - incoming Array.
     * @return sorted Array.
     */
    public static TreeSet<String> sortDecrease(Collection<String> incoming) {
        TreeSet<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1.length() < o2.length() && o1.contains(o2.substring(0, o1.length())))
                        || (o2.length() < o1.length() && o2.contains(o1.substring(0, o2.length())))) {
                    return Integer.compare(o1.length(), o2.length());
                }
                return o2.compareTo(o1);
            }
        });
        result.addAll(createSrtSet(incoming));
        return result;
    }
}
