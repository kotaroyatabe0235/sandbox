package com.demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
      int[] nums = {1,1,1,1,1};
      int[] ret = runningSum(nums);
      for (int element : ret) {
	System.out.print(element);
	System.out.print(" ");
      }
    }
  
    public static int[] runningSum(int[] nums) {
      int beforeVal = 0;
      int[] retArray = new int[nums.length];
      for (int x = 0; x < nums.length; x++) {
	beforeVal = nums[x] + beforeVal;
	retArray[x] = beforeVal;
      } 
      
      return retArray;
    }
}
