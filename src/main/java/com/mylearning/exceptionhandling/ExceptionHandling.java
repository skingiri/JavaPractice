package com.mylearning.exceptionhandling;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the divider number");
        int num = input.nextInt();
        System.out.println("What is your name?");
        String name = input.next();
        System.out.println(name);
        ArithmeticException(num);
        NullPointer();
        ArrayException();
    }

    private static void ArithmeticException(int num) {
        try {
            int a = 50;
            int result = a / num;
            System.out.println("Answer is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("An error occurred" + e.getMessage());
        } finally {
            System.out.println("End the division program");
        }
    }

    private static void NullPointer() {
        try {
            String str = null;
            str.length();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End the String program");
        }
    }

    private static void ArrayException() {
        try {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End the array program");
        }
    }
}
