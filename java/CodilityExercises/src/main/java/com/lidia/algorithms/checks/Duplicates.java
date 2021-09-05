package com.lidia.algorithms.checks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicates {
	// How to find a unique element in a list of duplicate pairs

	public static void main(String[] args) {
		int [] list={1,3,4,1,5,4,5}; // this should produce 3
		System.out.println("UniqueByXOR: "+uniqueElementByXOR(list));
		
		list = new int []{2,8,14,3,14,7,9,9,2,8,3}; // this should produce 7
		List<Integer> myList = Arrays.stream(list).boxed().collect(Collectors.toList());
		Collections.sort(myList);
		System.out.println(myList);
		System.out.println("UniqueByXOR: "+uniqueElementByXOR(list));
		
	}
	
	public static int uniqueElementByXOR(int[] list){
		if (list.length % 2!=0 ) {
			
			int listLen = list.length;
			
			int currentMask = 0;
			for (int i=0; i<listLen; i++) {
//				System.out.println(Integer.toBinaryString(currentMask));
//				System.out.println(Integer.toBinaryString(list[i]));
				System.out.print(currentMask+ " ^ "+list[i]+ " = ");
				
				currentMask=currentMask ^ list[i];
				System.out.println(currentMask);
//				System.out.println(Integer.toBinaryString(currentMask));
//				System.out.println();
			}
			
			return currentMask;
		}
		return -1;
	}
}
