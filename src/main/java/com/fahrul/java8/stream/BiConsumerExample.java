package com.fahrul.java8.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer> {

	@Override
	public void accept(String t, Integer u) {
		System.out.println("input 1 " + t + ": input 2 " + u);

	}

	public static void main(String[] args) {
		BiConsumer<String, Integer> biConsumer = new BiConsumerExample();
		biConsumer.accept("araz", 5900);

		BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() {
			@Override
			public void accept(String t, Integer u) {
				System.out.println(t + ":" + u);

			}
		};

		biConsumer.accept("Welcome", 143);

		BiConsumer<String, Integer> biConsumer2 = (t, u) -> System.out.println("key :" + t + " value : " + u);
		biConsumer2.accept("azriel", 786);

		Map<String, Integer> map = new HashMap<>();
		map.put("fahrul", 5000);
		map.put("arka", 14000);
		map.put("azriel", 11000);

		map.forEach((k, v) -> System.out.println(k + "," + v));
	}
}
