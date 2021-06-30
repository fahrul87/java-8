package com.fahrul.java8.map_reduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

	public static List<Employee> getEmployees() {
		return Stream
				.of(new Employee(101, "fahrul", "D", 60000), new Employee(102, "arka", "A", 70000),
						new Employee(102, "azriel", "A", 80000), new Employee(102, "mama", "C", 30000))
				.collect(Collectors.toList());
	}

}
