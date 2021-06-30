package com.fahrul.java8.parralel_stream;

import java.util.List;
import java.util.stream.IntStream;

import com.fahrul.java8.map_reduce.Employee;
import com.fahrul.java8.map_reduce.EmployeeDatabase;

public class ParallelStreamExample {

	public static void main(String[] args) {
		Long start = 0L;
		Long end = 0L;

		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Plain stream took time : " + (end - start));

		System.out.println("==============================================");

		start = System.currentTimeMillis();
		IntStream.range(1, 1000).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stram took time : " + (end + start));

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		List<Employee> employees = EmployeeDatabase.getEmployees();

		start = System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average()
				.getAsDouble();

		end = System.currentTimeMillis();

		System.out.println("Parallel stream execution time : " + (end + start) + " : Avg salary : " + salaryWithStream);
	}

}
