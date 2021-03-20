package com.lidia.java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.lidia.algorithms.Main;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solutions8 {

	public static void compareTriplets() throws IOException {
		//TODO
		List<Integer> a = Stream.of(Main.bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	    List<Integer> b = Stream.of(Main.bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());
	    
	    List<Integer> result = compareTriplets(a, b);
	    
	    Main.bufferedWriter.write(
	            result.stream()
	                .map(Object::toString)
	                .collect(joining(" "))
	            + "\n"
	     );
    }

	/**
	 * INPUT1 5 6 7 3 6 10 OUTPUT1 1 1
	 * 
	 * INPUT2 17 28 30 99 16 8 OUTPUT2 2 1
	 * 
	 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
	 */
	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		//TODO optimize for Java 8
		if (a == null || b == null) {
			return null;
		}
		if (a.size() != b.size()) {
			return null;
		}
		int i = 0;
		Integer alice = 0, bob = 0;
		while (i < a.size()) {
			if (a.get(i) > b.get(i)) {
				alice++;
			} else if (a.get(i) < b.get(i)) {
				bob++;
			}
			i++;
		}
		List<Integer> list = new ArrayList<>();
		list.add(alice);
		list.add(bob);
		return list;
	}
}
