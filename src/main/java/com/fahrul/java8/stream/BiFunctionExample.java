package com.fahrul.java8.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> t, List<Integer> u) {
		// TODO Auto-generated method stub
		return Stream.of(t, u).flatMap(List::stream).distinct().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		BiFunction biFunction = new BiFunctionExample();
		List<Integer> list1 = Stream.of(1, 2, 4, 6, 7, 9, 19).collect(Collectors.toList());
		List<Integer> list2 = Stream.of(11, 3, 43, 6, 7, 19).collect(Collectors.toList());
		System.out.println("Traditional Approach : " + biFunction.apply(list1, list2));

		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {

			@Override
			public List<Integer> apply(List<Integer> t, List<Integer> u) {
				// TODO Auto-generated method stub
				return Stream.of(t, u).flatMap(List::stream).distinct().collect(Collectors.toList());
			}
		};

		System.out.println("annonymous impl : " + biFunction1.apply(list1, list2));

		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {

			@Override
			public List<Integer> apply(List<Integer> t, List<Integer> u) {
				// TODO Auto-generated method stub
				return Stream.of(t, u).flatMap(List::stream).distinct().collect(Collectors.toList());
			}
		};

		Function<List<Integer>, List<Integer>> sortedFunction = (lists) -> lists.stream().sorted()
				.collect(Collectors.toList());

		System.out.println("Lambda approach ; " + biFunction2.andThen(sortedFunction).apply(list1, list2));

		Map<String, Integer> map = new HashMap<>();

		map.put("fahrul", 5000);
		map.put("arka", 15000);
		map.put("azriel", 11000);

		BiFunction<String, Integer, Integer> increaseSalaryBiFunction = new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String t, Integer u) {
				// TODO Auto-generated method stub
				return u + 1000;
			}
		};

		// map.replaceAll(increaseSalaryBiFunction);

		// BiFunction<String,Integer,Integer> increaseSalBiFunction= ( key, value) ->
		// value+2000;

		map.replaceAll((key, value) -> value + 2500);

		System.out.println(map);
	}

}
