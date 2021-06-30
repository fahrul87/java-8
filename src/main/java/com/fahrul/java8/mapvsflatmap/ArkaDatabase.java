package com.fahrul.java8.mapvsflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArkaDatabase {

	public static List<Customer> getAll() {
		return Stream
				.of(new Customer(101, "fahrul", "fahrul@gmail.com", Arrays.asList("397937955", "21654725")),
						new Customer(102, "arka", "arka@gmail.com", Arrays.asList("89563865", "2487238947")),
						new Customer(103, "azriel", "azriel@gmail.com", Arrays.asList("38946328654", "3286487236")),
						new Customer(104, "mama", "mama@gmail.com", Arrays.asList("389246829364", "948609467")))
				.collect(Collectors.toList());
	}

}
