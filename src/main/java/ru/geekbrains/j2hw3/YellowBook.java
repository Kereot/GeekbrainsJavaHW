package ru.geekbrains.j2hw3;

import java.util.*;

public class YellowBook {
    private Map<String, List<String>> yw = new HashMap<>();

    public void add(String surname, String tel) {
        yw.putIfAbsent(surname, new ArrayList<>());
        yw.get(surname).add(tel);
    }

    public void get(String surname) {
        if (yw.get(surname) != null) {
            System.out.println(surname + ": " + yw.get(surname));
        } else {
            System.out.println("Surname " + surname + " not found.");
        }
    }

}
