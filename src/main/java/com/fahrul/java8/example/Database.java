package com.fahrul.java8.example;

import java.util.ArrayList;
import java.util.List;

public class Database {

	public static List<Employee> getEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Fahrul", "IT", 600000L));
		list.add(new Employee(102, "Arka", "IT", 800000L));
		list.add(new Employee(103, "Azriel", "IT", 700000L));
		list.add(new Employee(104, "Mama", "IT", 500000L));
		return list;
	}

}
