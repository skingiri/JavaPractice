package com.mylearning.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<String>(); //Initializing list

        //Adding elements to the list
        employees.add("Sowmya");
        employees.add("Usha");
        employees.add("Niveditha");
        employees.add("Madhavi");
        System.out.println(employees);
        System.out.println("Size of the initial list = " + employees.size());

        //Sorting elements in the list
        Collections.sort(employees);
        System.out.println(employees);
        System.out.println("Size of the sorted list = " + employees.size());

        //Replacing an element in the list
        employees.set(1, "Nivi");
        System.out.println(employees);
        System.out.println("Size of the above list = " + employees.size());

        //Removing an element from the list
        employees.remove(1);
        System.out.println(employees);
        System.out.println("Size of the new list = " + employees.size());

        //Adding element after few operations
        employees.add("Madas");
        System.out.println(employees);
        System.out.println("Size of the above new list = " + employees.size());

        //Clearing all the elements from the list
        employees.clear();
        System.out.println(employees);
        System.out.println("Size of the final list = " + employees.size());
    }
}
