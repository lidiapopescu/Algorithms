package com.lidia.java8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.lidia.algorithms.Main;
import com.lidia.java7.Solutions7;

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

	public static void diagonalDifference() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();
        // TODO
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}

	private static int diagonalDifference(List<List<Integer>> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void plusMinus() {
//		Scanner scanner = new Scanner(System.in); 
//		int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        plusMinus(arr);
//
//        scanner.close();
		 plusMinus(new int[0]);
	}

	//https://www.geeksforgeeks.org/streams-arrays-java-8/
	private static void plusMinus(int[] arr) {
		//TODO
		int poz=0, neg=0, zero=0;
		arr = new int[] {-4, 3, -9, 0, 4, 1};
		Arrays.stream(arr)
			.forEach( e-> System.out.println(e + " "));
	}
}
