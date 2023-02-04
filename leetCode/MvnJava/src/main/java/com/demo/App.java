package com.demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
      int[] nums = {1,2,3,4};
      System.out.println(runningSum(nums));
    }
  
    public static int[] runningSum(int[] nums) {
      int[] retArray = new int[nums.length];
      for (int i=0; i<nums.length; i++) {
	retArray[i] = nums[i]+i;	
      }
      return retArray;
    }
}
