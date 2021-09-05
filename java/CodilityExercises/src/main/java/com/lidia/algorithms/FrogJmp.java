package com.lidia.algorithms;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * 
 * My Result:
 * https://app.codility.com/demo/results/training9DM9ZG-JB8/
 * 
 * A small frog wants to get to the other side of the road. The frog is
 * currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.
 * 
 * Count the minimal number of jumps that the small frog must perform to reach
 * its target.
 * 
 * For example, given:
 * 
 * X = 10 Y = 85 D = 30 the function should return 3, because the frog will be
 * positioned as follows:
 * 
 * after the first jump, at position 10 + 30 = 40 after the second jump, at
 * position 10 + 30 + 30 = 70 after the third jump, at position 10 + 30 + 30 +
 * 30 = 100
 */
public class FrogJmp {

	public static void main(String[] args) {
		
		System.out.println("" + frogJmp(10,85,30));
		
		System.out.println("" + frogJmp(3, 999111321, 7)); // Correct 142730189
	}
	
	/**
	 * For example, for the input (3, 999111321, 7) the solution returned a wrong answer (got 142730192 expected 142730189).
	 * */
	public static int frogJmp(int X, int Y, int D) {
        if ( Y<X )
            return 0;
        
        double Z=Y-X;
        double result = Z/(double)D; 
       
        return (int)Math.ceil(result);
    }
}
