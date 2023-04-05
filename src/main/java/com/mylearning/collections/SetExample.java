package com.mylearning.collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<String>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Papaya");
        fruits.add("Grapes");
        fruits.add("Orange");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println(" ");

        System.out.println(fruits.contains("Grapes"));
        System.out.println(" ");

        fruits.remove("Papaya");
        System.out.println(fruits.contains("Papaya"));
        System.out.println(" ");

        for (String fruit : fruits) {
            System.out.println(fruit);
            if (fruit.equals("Mango")) {
                System.out.println("This is a Mango Fruit");
            }
        }
    }
}
