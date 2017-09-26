package ru.job4j.testtask;

import java.util.ArrayList;
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
    private static ArrayList<String> createSrtSet(ArrayList<String> incomingArray) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : incomingArray) {
            ArrayList<String> splitStr = splitBySlash(str);
            StringBuilder strToAdd = new StringBuilder();
            for (String string : splitStr) {
                strToAdd.append(string);
                if (!result.contains(strToAdd.toString())) {
                    result.add(strToAdd.toString());
                }
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
     * metod sort Array by increase elements.
     * @param incoming - incoming Array.
     * @return sorted Array.
     */
    public static ArrayList<String> sortIncrease(ArrayList<String> incoming) {
        ArrayList<String> result = createSrtSet(incoming);
        result.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String first, String second) {
                        return first.compareTo(second);
                    }
                }
        );
        return result;
    }

    /**
     * metod sort Array by decrease elements.
     * @param incoming - incoming Array.
     * @return sorted Array.
     */
    public static ArrayList<String> sortDecrease(ArrayList<String> incoming) {
        ArrayList<String> result = createSrtSet(incoming);
        result.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String first, String second) {
                        if ((first.length() < second.length() && first.contains(second.substring(0, first.length())))
                                || (second.length() < first.length() && second.contains(first.substring(0, second.length())))) {
                            return Integer.compare(first.length(), second.length());
                        }
                        return second.compareTo(first);
                    }
                }
        );
        return result;
    }
}
