package com.lidia.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.lidia.java7.Solutions7;

import java.util.*;

public class Main {

	public static final Scanner scanner = new Scanner(System.in);

	public static BufferedWriter bufferedWriter;
	public static BufferedReader bufferedReader;
	
	public static void main(String[] args) throws IOException {
		
//		bufferedWriter  = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
//		bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
		
//		int result = Solutions7.simpleArraySum(getArray());
//        System.out.println("RESULT 7 "+ result);
//		bufferedWriter.write(String.valueOf(result));
          
//		Solutions7.compareTriplets();
//		Solutions8.compareTriplets();
		
//		Solutions7.aVeryBigSum();
//		Solutions7.diagonalDifference();
//		Solutions7.diagonalDifferenceBest();
//		Solutions8.diagonalDifference();
		
//		Solutions7.plusMinus();
//		Solutions8.plusMinus();
        
//		Solutions7.staircase();
		Solutions7.extraLongFactorials();
				
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();
    }

	static int[] getArray(){
		  int arCount = Integer.parseInt(scanner.nextLine().trim());

	        int[] ar = new int[arCount];

	        String[] arItems = scanner.nextLine().split(" ");

	        for (int arItr = 0; arItr < arCount; arItr++) {
	            int arItem = Integer.parseInt(arItems[arItr].trim());
	            ar[arItr] = arItem;
	        }
	        return ar;

	}
	


}
