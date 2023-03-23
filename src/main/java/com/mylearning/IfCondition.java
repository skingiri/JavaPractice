package com.mylearning;

public class IfCondition {
    public static void main(String[] args) {
        int i=5;
        if(i>=0 && i<=10)
            System.out.println("It's a kid");
        else if(i>10 && i<=17)
            System.out.println("It's a teenager");
        else if(i>17 && i<=40)
            System.out.println("It's an adult");
        else if(i>40 && i<100)
            System.out.println("It's an elderly person");
        else
            System.out.println("It's an alien");
    }
}
