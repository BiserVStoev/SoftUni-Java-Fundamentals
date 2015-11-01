package com.company;

import java.util.*;

/**
 * Use the .sorted() method to sort an array of integers. The first line of input is the array. The second is the sorting order.
 */

public class _14_SortArrayWithStreamAPI {
    public static void main(String[] args) {
        System.out.print("Enter array of integers: ");

        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>();

        numbers.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));

        System.out.print("Enter the sorting order (Ascending or Descending): ");

        String sortingOrder = scanner.nextLine();

        if (sortingOrder.equals("Descending")){
            numbers.stream().sorted(Comparator.<String>reverseOrder()).forEach(num -> System.out.print(num + " "));
        }else{
            numbers.stream().sorted().forEach(num -> System.out.print(num + " "));
        }
    }
}
