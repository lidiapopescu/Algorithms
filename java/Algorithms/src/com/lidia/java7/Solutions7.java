package com.lidia.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.lidia.algorithms.Main;

public class Solutions7 {

	/*
     * INPUT 
     * 6
     * 1 2 3 4 10 11
     * OUTPUT
     * 31
     */
    public static int simpleArraySum(int[] ar) {
    	 int sum=0;
         if (ar != null && ar.length>0) { 
            for (int i=0; i<ar.length; i++) {
                sum=sum+ar[i];
            }
         }
    	return sum;
    }
    
    public static void compareTriplets() throws IOException {

		String[] aItems = Main.bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> a = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
		}

		String[] bItems = Main.bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> b = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b.add(bItem);
		}

		List<Integer> result = Solutions7.compareTriplets(a, b);
		
		for (int i = 0; i < result.size(); i++) {
			Main.bufferedWriter.write(String.valueOf(result.get(i)));
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				Main.bufferedWriter.write(" ");
				System.out.print(" ");
			}
		}
	}

    /**
     * INPUT1
     * 5 6 7
     * 3 6 10
     * OUTPUT1
     * 1 1
     * 
     * INPUT2
     * 17 28 30
     * 99 16 8
     * OUTPUT2
     * 2 1
     * 
     * https://www.hackerrank.com/challenges/compare-the-triplets/problem
     * */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	// TODO https://www.hackerrank.com/challenges/compare-the-triplets/leaderboard?page=1
    	if (a == null || b == null) {
    		return null;
    	}
    	if (a.size() != b.size()) {
    		return null;
    	}
    	int i=0;
    	Integer alice=0, bob=0;
    	while (i < a.size()) {
    		if (a.get(i) > b.get(i)) {
    			alice++;
    		} else if (a.get(i) < b.get(i) ) {
    			bob++;
    		}
    		i++;
    	}
    	List<Integer> list = new ArrayList<>();
    	list.add(alice);
    	list.add(bob);
    	return list;
    }
    
    /**
     * 
     *
     * @throws IOException 
     * */
    public static void aVeryBigSum() throws IOException {
    	
    	Scanner scanner = new Scanner(System.in);
    	BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
    	
    	int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    /**
     * INPUT
     * 5
     * 1000000001 1000000002 1000000003 1000000004 1000000005
     * OUTPUT
     * 
     * https://www.hackerrank.com/challenges/a-very-big-sum/problem
     * */
	private static long aVeryBigSum(long[] ar) {
		long sum=0;
		for (int i=0; i<ar.length; i++) {
			sum = sum+ar[i];
//			System.out.println(sum);
		}
		return sum;
	}
}
