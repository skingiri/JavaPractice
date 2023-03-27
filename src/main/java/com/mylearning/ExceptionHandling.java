package com.mylearning;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner=new Scanner( System.in);
        System.out.println("Enter the divider number");
        int num = scanner.nextInt();
        System.out.println();
        try{
            int a=50;
            int result = a/num;
            System.out.println("Answer is: "+result);
        }
        catch (ArithmeticException e){
            System.out.println("An error occurred" + e.getMessage());
        }
        finally {
            System.out.println("End the program");
        }

    }
}
