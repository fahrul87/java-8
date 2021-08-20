package com.fahrul.java8.stream;

import java.util.function.BiPredicate;

public class BiPredicateExample {
	public static void main(String[] args) {
		BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
			@Override
			public boolean test(String t, String u) {
				// TODO Auto-generated method stub
				return t.equals(u);
			}

		};

		System.out.println(biPredicate.test("arka", "arka"));

		BiPredicate<String, String> equalPredicate = (t, u) -> t.equals(u);
		BiPredicate<String, String> lengthPredicate = (t, u) -> t.length() == u.length();

		boolean output = lengthPredicate.and(equalPredicate).test("arka", "arka");
		System.out.println("output : " + output);

		boolean orOutput = lengthPredicate.or(equalPredicate).test("arka", "azriel");
		System.out.println(orOutput);

		System.out.println(equalPredicate.test("arka", "arka"));
	}

}
