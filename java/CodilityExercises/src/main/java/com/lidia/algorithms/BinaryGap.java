package com.lidia.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * */
public class BinaryGap {

	public static void main(String[] args) {
		// Given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
		// Test cases
		// 9 -> 1001  Result 2
		// 529 ->  1000010001 Result 4
		// 20 ->  10100 Result 1
		// 15 ->  1111  Result 0
		// 32 ->  100000 Result 0
		// 1162 ->  10010001010 = 3
		// 51712 -> 1100101000000000 = 2
		// 66561 -> 10000010000000001 = 9
		// 6291457 -> 11000000000000000000001 = 20
		// 74901729 -> 100011101101110100011100001 = 4
		// 805306373 -> 110000000000000000000000000101 = 25
        // 1376796946 -> 1010010000100000100000100010010 = 5
		// 1610612737 -> 1100000000000000000000000000001 = 28
		int result = 0;
		int[] input = new int[] {9 , 529 , 20 , 15 , 32 , 1041, 328 , 6, 1162, 51712, 66561, 6291457, 74901729, 805306373, 1376796946, 1610612737 };
//		int[] input = new int[] {328 };
		for (int i=0; i< input.length ; i++) {
			System.out.print("" + input[i]+ " -> ");
			result  = solution(input[i]);
			System.out.print(" = "+ result);
			System.out.println();
		}
	}

	
	 public static int solution(int N) {
	        String myString = Integer.toBinaryString(N);
	        System.out.print(myString); 
	        char[] myList = myString.toCharArray();
	        Integer start = null;
	        List<Integer> results = new ArrayList<Integer>();
	        for (int i=0; i< myList.length; i++) {
	            if (myList[i] == '0') {
	            	start++;
	            }
	            else if ( myList[i] == '1') {
	                if (start !=null) {
	                	results.add(start);
	                }
	                start=0;
	            }
	        }
	        
	        List<Integer> sortedList = results.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());     
	        if (!sortedList.isEmpty()) {
	        	return sortedList.get(0);
	        }
	        return 0;
	    }
}
