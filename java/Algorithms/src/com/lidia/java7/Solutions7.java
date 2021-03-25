package com.lidia.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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

	public static void diagonalDifference() throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = diagonalDifference(arr);
        result = diagonalDifferenceV2(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}

	/*
	 * INPUT 
	 * 3 
	 * 11 2 4 
	 * 4  5 6 
	 * 10 8 -12 
	 * OUTPUT 
	 * 15
	 * https://www.hackerrank.com/challenges/diagonal-difference/problem
	 * https://www.hackerrank.com/challenges/diagonal-difference/leaderboard
	 */
	private static int diagonalDifference(List<List<Integer>> arr) {
		int d1=0, d2=arr.size()-1;
		int sumD1 =0 , sumD2 = 0;
		for (int i=0; i< arr.size(); i++) {
			for (int j=0; j< arr.get(i).size(); j++) {
				if (d1 == j) {
					sumD1 = sumD1 + arr.get(i).get(j);
					d1++;
					break;
				}				
			}
			
			for (int j=arr.get(i).size()-1; j>=0; j--) {
				if (d2 == j) {
					sumD2 = sumD2 + arr.get(i).get(j);
					d2--;
					break;
				}
			}
		}
		System.out.println("SUM D1= " + sumD1); //4
		System.out.println("SUM D2= " + sumD2); //19
		int result = Math.abs(sumD1- sumD2);
		System.out.println("diagonalDifference Result "+ result); //15
//		return Math.abs(sumD1- sumD2);
		return result;
	}

	public static void diagonalDifferenceBest() {
		Scanner in = new Scanner(System.in); 
		int n ;
		int diag1 = 0 ; int diag2 = 0;
		n = Integer.parseInt(in.nextLine());
		for(int i =0 ; i < n; i++){
			String str[] = in.nextLine().split(" ");
			diag1 = diag1 + Integer.parseInt(str[i]);
			diag2 = diag2 + Integer.parseInt(str[n-1-i]);
		}
		
		int diagDiff = Math.abs(diag1 -  diag2);		
		System.out.println(diagDiff);
	}
	
	private static int diagonalDifferenceV2(List<List<Integer>> arr) {
		//TODO
		int leftdiagonal = 0, rightdiagonal = 0;
		for(int i = 0, j = arr.get(0).size()-1; i < arr.get(0).size(); i++, j--){
		        leftdiagonal = leftdiagonal + arr.get(i).get(i);
		        rightdiagonal = rightdiagonal + arr.get(i).get(j);
		}
		int result =  Math.abs(leftdiagonal - rightdiagonal);
		System.out.println("diagonalDifferenceV2 "+ result);
//		return Math.abs(leftdiagonal - rightdiagonal);
		return result;
	}

	
	/*
	 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
	 * INPUT
	 * 6
	 * -4 3 -9 0 4 1 
	 * OUTPUT
	 * 0.500000
	 * 0.333333
	 * 0.166667
	 * https://www.hackerrank.com/challenges/plus-minus/problem
	 * */
	public static void plusMinus() {
		Scanner scanner = new Scanner(System.in); 
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

	private static void plusMinus(int[] arr) {
		int poz=0, neg=0, zero=0;
		for (int i=0; i< arr.length; i++) {
			if (arr[i]<0) {
				neg++;
			}
			else if ( arr[i]==0) {
				zero++;
			}
			else {
				poz++;
			}
		}
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println(df.format(Float.valueOf(poz)/arr.length));
		System.out.println(df.format(Float.valueOf(neg)/arr.length));
		System.out.println(df.format(Float.valueOf(zero)/arr.length));
	}
}
