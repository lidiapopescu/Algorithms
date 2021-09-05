package com.lidia.algorithms;

import java.util.Arrays;

/**
 * Task:
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * My Result 
 * https://app.codility.com/demo/results/training8B4R6P-JVA/
 * 
 * */
public class CyclicRotation {

	public static void main(String[] args) {
		
		int result[]= cyclicRotation(new int[] {3, 8, 9, 7, 6}, 3);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {1,0,0,0}, 5);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {3,5,1,1,2}, 7);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {1000},4);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {1000, 2000},4);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {}, 4);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {1,2,3,4}, 18);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {0,0,0}, 1);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {1,2,3,4}, 4);
		System.out.println(java.util.Arrays.toString(result));
		
		result = cyclicRotation(new int[] {3, 8, 9, 7, 6}, 6);
		System.out.println(java.util.Arrays.toString(result));
	}

	/**
	 * 
	 * Rotation of the array means that each element is shifted right by one index,
	 * and the last element of the array is moved to the first place. A = [3, 8, 9,
	 * 7, 6] K = 3 RESULT -> [9, 7, 6, 3, 8]
	 * 
	 * Your test case: [[1000], 4] Returned value: [1000]
	 * 
	 * Your test case: [[1000, 2000], 4] Returned value: [1000, 2000]
	 * 
	 * Your test case: [[1000, 2000, 3000], 5] Returned value: [2000, 3000, 1000]
	 * 
	 * Your test case: [[], 1]  TIMEOUT ERROR (Killed. Hard limit reached: 5.000 sec.)
	 * Your test case: [[], 1]  Returned value: []
	 * 
	 * Your test case: [[1, 2, 3], 223] Returned value: [3, 1, 2]
	 */
	private static int[] cyclicRotation(int[] A, int K) {
		System.out.print(Arrays.toString(A)+" (" +K +") -> ");
		int[] B = new int[A.length];
		if (K == 0 || K == A.length || A.length == 1 || A.length == 0)
			return A;
		K= K % A.length;
		if (K <= A.length) {
			int M = 0;
			int AA[] = A;
			while (M < K) {
				M++;
				B[0] = AA[AA.length - 1];
				for (int i = 1; i < AA.length; i++) {
					B[i] = AA[i - 1];
				}
				System.arraycopy(B, 0, AA, 0, AA.length);
			}
		}
		return B;
	}
}
