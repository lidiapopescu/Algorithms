package com.lidia.java7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * INPUT square 3x3
 * 4 8 2
 * 4 5 7
 * 6 1 6
 * OUTPUT
 * 4
 * 
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * https://www.hackerrank.com/rest/contests/master/challenges/magic-square-forming/hackers/LidiaPopescu/download_solution
 * */
public class FormingMagicSquare {
	
	//all possible magic squares
	private static int[][][] mSquares = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
			{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
			{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, 
			{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
			{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}, 
			{{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
			{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}, 
			{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}};

	static int minCost = Integer.MAX_VALUE;
	static int n=0;
	static boolean showLogs = false;
	
	
	
	
	/**
	 * Returns Cost for a specific MagisSquare
	 * 
	 * magicSquare -  known, checked magic square
	 * s - the provided matrix to get cost for magic square
	 * */
	private static int getMaqicSquareCost(int[][] magicSquare, int[][] s) {
		int diff = 0;
		int min = Integer.MAX_VALUE;
		for (int x = 0; x < s.length; x++) {
			for (int y = 0; y < s.length; y++) {
				diff += Math.abs(magicSquare[x][y] - s[x][y]);
			}
		}
		if (diff < min)
			min = diff;
		return min;
	}


	/**
	 * INPUT square 3x3
	 * 4 8 2
	 * 4 5 7
	 * 6 1 6
	 * OUTPUT
	 * 4
	 * 
	 * */
	private static int formingMagicSquare(int[][] s) {
		int[] digitsArr = {1,2,3,4,5,6,7,8,9};
		int[][] targetSquare = {{0,0,0},{0,0,0},{0,0,0}};
		minCost= Integer.MAX_VALUE;
		dfs(digitsArr, targetSquare, s, 0);
		System.out.println("formingMagicSquare= " + minCost);
		return minCost;
	}


	/**
	 * dfs -> generate all possible 3x3
	 * Will generate 9! permutation, which is 362880, [0, 362879]
	 * */
	private static void dfs(int[] digitsArr, int[][] targetSquare, int[][] s, int currentIndex) {
		if (currentIndex > digitsArr.length)
			return;

		if (currentIndex == digitsArr.length) {
			if (showLogs)
				System.out.print("[" + currentIndex + ","+ n++ +"] " + Arrays.toString(digitsArr) + " ");

			int currentCost = 0;
			int index = 0;

			for (int i = 0; i < targetSquare.length; i++) {
				for (int j = 0; j < targetSquare[i].length; j++) {
					targetSquare[i][j] = digitsArr[index++];
					currentCost += Math.abs(targetSquare[i][j] - s[i][j]);
				}
			}
			if (showLogs)
				System.out.println(Arrays.deepToString(targetSquare));
			if (isMagicSquare(targetSquare, 15)) {				
				minCost = Math.min(currentCost, minCost);
			}
			return;
		}

		for (int i = currentIndex; i < digitsArr.length; i++) {
			// doing elements swap
			int temp = digitsArr[i];
			digitsArr[i] = digitsArr[currentIndex];
			digitsArr[currentIndex] = temp;

			dfs(digitsArr, targetSquare, s, currentIndex+1);
			temp = digitsArr[i];
			digitsArr[i] = digitsArr[currentIndex];
			digitsArr[currentIndex] = temp;
		}
	}

	/**
	 * isMagicSquare -> to check if a specific square is magic square
	 * */
	static boolean isMagicSquare(int[][] s, int targetSum) {
		for (int i=0; i<s.length; i++) {
			int rowSum = 0;
			int colSum = 0;
			for (int j=0; j<s[i].length; j++) {
				rowSum += s[i][j];
				colSum += s[j][i];
			}
			if (rowSum != targetSum) return false;
			if (colSum != targetSum) return false;
		}
		
		int leftDiagSum = 0;
		int k=0, j=0;
		while (k< s.length && j< s[k].length) {
			leftDiagSum += s[k][j];
			k++;
			j++;
		}
			
		if (leftDiagSum != targetSum) return false;
		int rightDiagSum = 0;
		k=0;
		j=s[k].length-1;
			
		while (k < s.length && j>=0) {
			rightDiagSum += s[k][j];
			k++;
			j--;
		}
		if (rightDiagSum != targetSum) return false;
			
		if (showLogs) {
			System.out.println("isMagicSquare:");
			checkInputSquare(s);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
        int[][] s = new int[3][3];
        int result = Integer.MAX_VALUE;
//        s= getInputFromScanner2();
        
        s= getInput(new int[] {5,3,4,1,5,8,6,4,2}); // |5-8|+|8-9|+|4-7|=7  
        result =  getMaqicSquareCost(s);
        result =  formingMagicSquare(s);
//        s= getInput(new int[] {4,9,2,3,5,7,8,1,5}); // |6-5|=1
//        result =  getMaqicSquareCost(s);
//        result =  formingMagicSquare(s);
//        s= getInput(new int[] {4,8,2,4,5,7,6,1,6}); // |9-8|+|3-4|+|8-6|=4
//        result =  getMaqicSquareCost(s);
//        result =  formingMagicSquare(s);
//        s= getInput(new int[] {6,3,3,1,5,7,6,7,2}); // |6-8|+|3-4|+|7-9|=5
//        result =  getMaqicSquareCost(s);
//        result =  formingMagicSquare(s);
//        s= getInput(new int[] {4,9,2,3,5,7,8,1,5}); // =1  
//        result =  getMaqicSquareCost(s);
//        result =  formingMagicSquare(s);
//        s= getInput(new int[] {4,8,2,4,5,7,6,1,6}); // =4  
//        result =  getMaqicSquareCost(s);
//        result =  formingMagicSquare(s);
        
        //get custom input
//        Scanner scanner = new Scanner(System.in);
//      	for (int x = 0; x < 3; x++) {
//      		for (int y = 0; y < 3; y++) {
//      			s[x][y] = scanner.nextInt();
//      		}
//      	}
//      	scanner.close();
      	
//      	checkInputSquare(s);
//        result =  formingMagicSquare(s);
        System.out.println("minCost " + result);
//        writeOutputToFile(result);
	}

	private static void writeOutputToFile(int result) {
		try {
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Repos\\Algorithms\\output\\output.txt"));

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[][] getInputFromScanner2() {
		Scanner scanner = new Scanner(System.in);
		int[][] s = new int[3][3];
		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}
		scanner.close();
		return s;
	}

	/**
	 * Compares provided matrix with all possible, known magic squares and checks cost
	 * */
	private static int getMaqicSquareCost(int[][] s) {
		
		int min = Integer.MAX_VALUE;;
		for (int i = 0; i < 8; i++) {
			int diff = 0;
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					diff += Math.abs(mSquares[i][x][y] - s[x][y]);
				}
			}
			if (diff < min)
				min = diff;
		}
		System.out.println("getMaqicSquareCost= " + min);
		return min;
	}



	private static void checkInputSquare(int[][] s) {
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s.length; j++) {
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		//or		
		System.out.println(Arrays.deepToString(s));
		System.out.println();
	}



	private static int[][] getInput(int[] input) {
		int[][] s = new int[3][3];
		int k=0;
		for (int i=0; i<s.length; i++) {
			for (int j=0; j<s.length; j++) {
				s[i][j]=input[k];
				k++;
			}
		}
//		if (showLogs)
			checkInputSquare(s);
		return s;
	}
	
}
