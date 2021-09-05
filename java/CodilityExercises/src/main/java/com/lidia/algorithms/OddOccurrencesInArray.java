package com.lidia.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Task:
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * RESULT:
 * https://app.codility.com/demo/results/training47VBQW-3DF/
 * 
 * A non-empty array A consisting of N integers is given. The array contains an
 * odd number of elements, and each element of the array can be paired with
 * another element that has the same value, except for one element that is left
 * unpaired.
 * 
 * For example, in array A such that:
 * 
 * A[0] = 9 A[1] = 3 A[2] = 9 A[3] = 3 A[4] = 9 A[5] = 7 A[6] = 9 the elements
 * at indexes 0 and 2 have value 9, the elements at indexes 1 and 3 have value
 * 3, the elements at indexes 4 and 6 have value 9, the element at index 5 has
 * value 7 and is unpaired.
 */
public class OddOccurrencesInArray {

	public static void main(String[] args) {
		
		int result = oddOccurrencesInArray(new int []{9,3,9,3,9,7,9});
		System.out.println(result);
		
		result = oddOccurrencesInArray(new int []{2,8,14,3,14,7,9,9,2,8,3});
		System.out.println(result);
		
		result = oddOccurrencesInArray(new int []{2,2,3});
		System.out.println(result);
	}

	private static int oddOccurrencesInArray(int[] A) {
		if ( A.length % 2!=0 ) {
			int current = 0;
			for (int i=0; i<A.length ; i++) {
				current = current ^ A[i];
			}			
			return current;
		}
		return -1;
	}
	/**
	 * Version 1
	 * Result https://app.codility.com/demo/results/trainingKYQF76-Q5D/
	 * 
	 * 88% TIMEOUT ERROR, running time: 0.116 sec., time limit: 0.100 sec.
	 */
	private static int oddOccurrencesInArrayV1(int[] A) {		
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
//		Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
		
		Collections.sort(list);
		System.out.println(list);
				
		Integer last=-1;
		for (Integer value: list) {
			if (last != -1 ) {
				if ( value.equals(last)) {
					last =-1;
				} else { 
					return last;
				}
			}
			else {
				last = value;
			}
		}
		if (last !=-1) {
			return last;
		}
		return 0;
	}
}
