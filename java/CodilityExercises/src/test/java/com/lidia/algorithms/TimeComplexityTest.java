package com.lidia.algorithms;

import org.junit.Assert;
import org.junit.Test;


import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class TimeComplexityTest extends TestCase
{    
	
    @Test
    public void testPermMissingElem() {
    	
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{2,3,1,5}) == 4);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{1,2,3,4,5,7,8,9,10}) == 6);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{1,2,3,4,5,6}) == 7);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{}) == 1);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{1}) == 2);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{2,3,4,5}) == 1);
        Assert.assertTrue( PermMissingElem.permMissingElem(new int[]{1,2,3,4}) == 5);
    }
    
    @Test
    public void testTapeEquilibrium() {
    	
        Assert.assertTrue( TapeEquilibrium.tapeEquilibrium(new int[]{3,1,2,4,3}) == 1);
        Assert.assertTrue( TapeEquilibrium.tapeEquilibrium(new int[]{1, 3, 4, 5, 10, 15, 28, 23, 21}) == 22);
        Assert.assertTrue( TapeEquilibrium.tapeEquilibrium(new int[]{1}) == 1);
        Assert.assertTrue( TapeEquilibrium.tapeEquilibrium(new int[]{-1, -2, -3, -4, -2}) == 0);
    }
    
}
