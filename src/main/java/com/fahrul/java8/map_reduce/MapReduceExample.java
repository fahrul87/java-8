package com.fahrul.java8.map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

		List<String> words = Arrays.asList("Istimiwir", "Istimicrit", "Istrinyewa");

		int sum = 0;
		for (int no : numbers) {
			sum = sum + no;
		}
		System.out.println(sum);

		int sum1 = numbers.stream().mapToInt(i -> i).sum();
		System.out.println(sum1);

		Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(reduceSum);

		Optional<Integer> reduceSumWithMethodRefrence = numbers.stream().reduce(Integer::sum);
		System.out.println(reduceSumWithMethodRefrence.get());

		Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(mulResult);

		Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(maxValue);

		Integer maxValueWithMethodRefrence = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxValueWithMethodRefrence);

		String longlestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
				.get();
		System.out.println(longlestString);

		// get employee whose grade A
		// get salary

		double avgSalary = EmployeeDatabase.getEmployees().stream()
				.filter(employee -> employee.getGrade().equalsIgnoreCase("A")).map(employee -> employee.getSalary())
				.mapToDouble(i -> i).sum();
		System.out.println(avgSalary);

		double sumSalary = EmployeeDatabase.getEmployees().stream()
				.filter(employee -> employee.getGrade().equalsIgnoreCase("A")).map(employee -> employee.getSalary())
				.mapToDouble(i -> i).sum();
		System.out.println(sumSalary);
	}

}
