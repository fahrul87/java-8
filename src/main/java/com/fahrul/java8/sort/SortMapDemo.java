package com.fahrul.java8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.fahrul.java8.example.Employee;

public class SortMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		employeeMap.put(new Employee(176, "Fahrul", "IT", 600000L), 60);
		employeeMap.put(new Employee(177, "Arka", "IT", 700000L), 70);
		employeeMap.put(new Employee(178, "Azriel", "IT", 800000L), 80);
		employeeMap.put(new Employee(179, "Mama", "IT", 500000L), 50);

		System.out.println(employeeMap);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		/*
		 * for (Entry<String, Integer> entry : entries) {
		 * System.out.println(entry.getKey() + "   " + entry.getValue()); }
		 */

		// map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

		System.out.println("===================================================");
		// map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))
				.forEach(System.out::println);

	}

}
