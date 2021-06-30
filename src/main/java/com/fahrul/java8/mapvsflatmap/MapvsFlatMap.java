package com.fahrul.java8.mapvsflatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapvsFlatMap {

	public static void main(String[] args) {
		List<Customer> customers = ArkaDatabase.getAll();

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> customer.getEmail()
		// customer -> customer.getEmail() one to one mapping
		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(emails);

		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<List<String>> phoneNumbers = customers.stream().map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(phoneNumbers);

		// List<Customer> convert List<String> -> Data Transformation
		// mapping : customer -> phone Numbers
		// customer -> customer.getPhoneNumbers() ->> one to many mapping
		List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println(phones);

		/*
		 * Differences between Java 8 Map() Vs flatMap() :
		 * 
		 * map() | flatMap() | --- | --- | It processes stream of values. | It processes
		 * stream of stream of values. It does only mapping. | It performs mapping as
		 * well as flattening. It’s mapper function produces single value for each input
		 * value. | It’s mapper function produces multiple values for each input value.
		 * It is a One-To-One mapping. | It is a One-To-Many mapping. Data
		 * Transformation : From Stream<T> to Stream<R> | Data Transformation : From
		 * Stream<Stream<T> to Stream<R> Use this method when the mapper function is
		 * producing a single value for each input value. | Use this method when the
		 * mapper function is producing multiple values for each input value.
		 */

	}

}
