package com.mylearning;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        String name="Sowmya";
        for (int i = 1; i <= 10; i++)
            System.out.println("2*" + i + "=" + (2 * i));
        while (name.length()<6){
            System.out.println(name);
        }
    }
}
