package com.lidia.algorithms;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * 
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * 
 * Your goal is to find that missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 */
public class PermMissingElem {
	

	public static void main(String[] args) {
		
		System.out.println("" + permMissingElem(new int[]{2,3,1,5}));    // 4
		System.out.println("" + permMissingElem(new int[]{1,2,3,4,5,7,8,9,10}));  // 6
		System.out.println("" + permMissingElem(new int[]{1,2,3,4,5,6}));  // 7
		System.out.println("" + permMissingElem(new int[]{}));  // 1
		System.out.println("" + permMissingElem(new int[]{1})); //2
		System.out.println("" + permMissingElem(new int[]{2,3,4,5})); // 1
		System.out.println("" + permMissingElem(new int[]{1,2,3,4})); // 5
		
	}

	
	/**
	 * The sum of consecutive integers from 1 to n is equal to n(n+1)/2.
	 * 
	 * [2,3,4,5]
	 * [1,2,3,4]
	 * []  -> expected 1.
	 * [1]
	 * 
	 * 70% https://app.codility.com/demo/results/trainingWPWEXJ-G65/
	 * 
	 * TIMEOUT ERROR, running time: 0.132 sec., time limit: 0.128 sec.
	 * range sequence, length = 100,000    => got -2147483647 expected 1
	 * large test, length = ~100,000 => got -2147473647 expected 10001
	 * 
	 * 60% https://app.codility.com/demo/results/trainingH74GUK-UDY/
	 * 
	 * 90% https://app.codility.com/demo/results/trainingNQ98VR-6ZB/
	 * Detected time complexity: O(N) or O(N * log(N))
	 * */
	public static int permMissingElem(int[] list) {
		if (list == null)
			return 0;
		
		System.out.println(Arrays.toString(list));
		if (list.length == 0)
			return 1;
//		List<Integer> myList = Arrays.stream(list).boxed().collect(Collectors.toList());
//		Collections.sort(myList);
//		int lastElement =  myList.get(myList.size()-1);
		
//		long lastElement = (long)Arrays.stream(list).max().getAsInt();
//		System.out.println("lastElement " + lastElement);
//		
//		long sum = (lastElement*(lastElement+1))/2;
//		System.out.println("Sum: "+ sum);
		
		long sum = (((long)list.length+1)* ((long)list.length+2) )/2;
//		Integer existingSum = Arrays.stream(list).reduce(0, Integer::sum);
//		long existingSum = Arrays.stream(list).asLongStream().reduce(0, Long::sum);
		
		long existingSum = Arrays.stream(list).asLongStream().reduce(0, (a, b) -> a + b);
		System.out.println("existingSum: "+ existingSum);
		
		if (existingSum == sum) {
			return list.length+1;
		}
		return (int)(sum - existingSum);
	}
	
	 /**
	  * 70% https://app.codility.com/demo/results/trainingWPWEXJ-G65/
	 * */
	 public int solution70Perc(int[] A) {
	        if (A == null)
				return 0;
			if (A.length == 0)
				return 1;
			int lastElement = Arrays.stream(A).max().getAsInt();
			int sum = (lastElement*(lastElement+1))/2;
			
			Integer existingSum = Arrays.stream(A).reduce(0, Integer::sum);
			
			if (existingSum == sum) {
				return lastElement+1;
			}
			return sum - existingSum;
	    }

	/**
	 * 60% https://app.codility.com/demo/results/trainingH74GUK-UDY/
	 * */
	public int solution60Perc(int[] A) {
        if ( A == null)
            return 0;
        if (A.length == 0)
            return 1;

        int lastElement = Arrays.stream(A).max().getAsInt();
        long sum = (lastElement*(lastElement+1))/2;
        long existingSum = Arrays.stream(A).asLongStream().reduce(0, Long::sum);
        if (existingSum == sum) {
			return lastElement+1;
		}
        return (int)(sum - existingSum);
    }
	
	 /**
	  * 90% https://app.codility.com/demo/results/trainingNQ98VR-6ZB/
	  * 
	  * Detected time complexity: O(N) or O(N * log(N))
	  * */
	 public int solution90perc(int[] A) {
	        if ( A == null)
	            return 0;
	        if (A.length == 0)
	            return 1;

	        long lastElement = (long)Arrays.stream(A).max().getAsInt();
	        long sum = (lastElement*(lastElement+1))/2;
	        long existingSum = Arrays.stream(A).asLongStream().reduce(0, Long::sum);
	        if (existingSum == sum) {
				return (int)(lastElement+1);
			}
	  return (int)(sum - existingSum);
	  }
	 
	 /**
	  * https://app.codility.com/demo/results/trainingQAX3E8-8ND/
	  * 
	  * TIMEOUT ERROR, running time: 0.124 sec., time limit: 0.112 sec.
	  * Detected time complexity: O(N) or O(N * log(N))
	  * */
	 public int solution90per2(int[] A) {
	        if (A == null)
	            return 0;
	        if (A.length == 0)
	            return 1;
	        long sum = (((long)A.length+1)*((long)A.length+2))/2;
	        long existingSum = Arrays.stream(A).asLongStream().reduce(0, (a, b) -> a + b);
	        if (existingSum == sum) {
	            return A.length+1;
	        }
	   return (int)(sum - existingSum);
	   }
	 
	 /**
	  * https://app.codility.com/demo/results/trainingQF49AF-QF3/
	  * https://www.baeldung.com/java-hashset-arraylist-contains-performance
	  * */
	 public int solution100Per(int[] A) {
	        HashSet<Integer> set = new HashSet<>();
	        for (int i=1; i<= A.length+1; i++) {
	            set.add(i);
	        }
	        for (int i=0; i<A.length; i++) {
	            set.remove((Integer)A[i]);
	        }
	        return set.iterator().next();
	}

}
