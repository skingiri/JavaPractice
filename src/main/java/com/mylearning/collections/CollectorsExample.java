package com.mylearning.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsExample {
    public static void main(String[] args) {
        List<String> fruits = Stream.of("Apple", "Banana", "Cherry")
                .collect(Collectors.toList());
        System.out.println("List: " + fruits);

        Set<Integer> numbers = Stream.of(10, 20, 30)
                .collect(Collectors.toSet());
        System.out.println("Set: " + numbers);

        Map<String, Integer> map = Stream.of("Apple", "Banana", "Cherry")
                .collect(Collectors.toMap(s -> s, s -> s.length()));
        System.out.println("Map: " + map);

        String joinedString = Stream.of("Apple", "Banana", "Cherry")
                .collect(Collectors.joining(", "));
        System.out.println("Joined String: " + joinedString);

        IntSummaryStatistics stats = IntStream.of(1, 2, 3, 4, 5).summaryStatistics();

        System.out.println("Statistics: " + stats);

        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("Sowmya", 100000, "Manager"));


    }
}
