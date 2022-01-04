package ru.geekbrains.j2hw3;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        String[] firstTask = {
                "it", "must", "be", "simple", "object-oriented", "and", "familiar",
                "it", "must", "be", "robust", "and", "secure",
                "it", "must", "be", "architecture-neutral", "and", "portable"
        };

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < firstTask.length; i++) {
            map.put(i + 1, firstTask[i]);
        }

//        System.out.println(map);

//        long streamUnique = map.values().stream().distinct().count(); /* googled */
//        System.out.println("Unique words: " + streamUnique);

        Set<String> setFirstTask = new TreeSet<>(map.values());
        System.out.println(setFirstTask);
        System.out.println("Unique words: " + setFirstTask.size());
        System.out.println("Total words: " + map.size());

//        Map<String, Integer> countWords = new LinkedHashMap<>(); /* googled */
//        for (String c : map.values()) {
//            int count = countWords.get(c) == null ? 0 : countWords.get(c);
//            countWords.put(c, count + 1);
//        }
//        System.out.println(countWords);

        Map<String, Integer> countWordsAlt = new LinkedHashMap<>();
        for (String s : firstTask) {
            int countAlt = countWordsAlt.getOrDefault(s, 0);
            countWordsAlt.put(s, countAlt + 1);
        }
        System.out.println(countWordsAlt);

        System.out.println();

        YellowBook yellowBook = new YellowBook();

        yellowBook.add("Ivanov", "+1-111-850-058");
        yellowBook.add("Petrov", "+1-122-025-520");
        yellowBook.add("Sidoro", "+1-333-964-469");
        yellowBook.add("Petrov", "+1-222-753-357");
        yellowBook.add("Ivanov", "+1-211-951-159");

        yellowBook.get("Ivanov");
        yellowBook.get("Petrov");
        yellowBook.get("Sidoro");
        yellowBook.get("NoName");

    }
}
