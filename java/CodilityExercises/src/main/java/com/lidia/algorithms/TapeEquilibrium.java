package com.lidia.algorithms;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 *
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P - 1] and A[P], A[P + 1], ..., A[N - 1].
 * 
 * The difference between the two parts is the value of: 
 * |(A[0] + A[1] + ... + * A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first
 * part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in four
 * places:
 * 
 * P = 1, difference = |3 - 10| = 7 
 * P = 2, difference = |4 - 9| = 5 
 * P = 3, difference = |6 - 7| = 1 
 * P = 4, difference = |10 - 3| = 7
 * 
 * Write a function that, given a non-empty array A of N integers, returns the
 * minimal difference that can be achieved.
 **/
public class TapeEquilibrium {

	public static void main(String[] args) {
	
//		System.out.println(" "+tapeEquilibrium(new int[] {3,1,2,4,3}));     // 1
		System.out.println(" "+tapeEquilibrium(new int[] {1, 2, 3, 4, 2})); // 0
		System.out.println(" "+tapeEquilibrium(new int[] {1}));  // 1
		System.out.println(" "+tapeEquilibrium(new int[] {-1, -2, -3, -4, -2})); // 0
	}

	/**
	 * Your test case: [1, 3, 4, 5, 10, 15, 28, 23, 21]   Returned value: 22
	 * 
	 * 53% Performance 0% Timeout errors:  https://app.codility.com/demo/results/training2HKH97-25W/
	 * 100% https://app.codility.com/demo/results/trainingEFQR78-WBM/
	 * */
	public static int tapeEquilibrium(int[] A) {
		if (A.length == 1)
			return Math.abs(A[0]);

		int result = Integer.MAX_VALUE;
		int sumLeft = 0, sumRight = 0;
		int sumAll = 0;
		for (int i = 0; i < A.length; i++) {
			sumAll = sumAll + A[i];
		}

		for (int i = 0; i < A.length - 1; i++) {
			sumLeft = sumLeft + A[i];
			sumRight = sumAll - sumLeft;
			int difference = Math.abs(sumLeft - sumRight);
			System.out.println(i + " " + difference);
			result = Math.min(difference, result);
		}
		return result;
	}
	
	/**
	 *  53% Performance 0% Timeout errors:  https://app.codility.com/demo/results/training2HKH97-25W/
	 * */
	public int solution(int[] A) {
		if (A.length == 1)
			return Math.abs(A[0]);

		int result = -1;
		int left, right;
		int sumAll = 0;
		for (int i = 0; i < A.length; i++) {
			sumAll = sumAll + A[i];
		}

		for (int i = 1; i < A.length; i++) {
			left = 0;
			right = 0;
			for (int j = 0; j < i; j++) {
				left = left + A[j];
			}
			right = sumAll - left;
			int value = Math.abs(left - right);
			if (result == -1 || value < result)
				result = value;
		}
		return result;
	}
}
