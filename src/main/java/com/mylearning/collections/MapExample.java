package com.mylearning.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new HashMap<>();
        phoneBook.put("Sowmya", 1234);
        phoneBook.put("Ram", 5678);
        phoneBook.put("Myra", 8899);
        phoneBook.put("Bala", 5566);
        phoneBook.put("Chandra", 1133);
        phoneBook.put("XYZ", 0000);

        int phoneNumber = phoneBook.get("Sowmya");
        System.out.println("Sowmya's phone number is " + phoneNumber);

        phoneBook.remove("XYZ");

        for (Map.Entry<String, Integer> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
