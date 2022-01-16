package com.techstart.problems;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {


//        int[] nums = new int[]{9999,9998,9997,.....,3,2,1,0,0};
        int[] nums = new int[]{2,3,1,1,4};


//        System.out.println("JumpGame Reached End :"+traverse(nums,0));
        System.out.println("JumpGame Reached End :"+canJump(nums));

    }

    // Following the Jump projectile algorithm
    public static boolean canJump(int[] nums){
        int longReachable = 0;

        for(int i=0;i<nums.length;i++){
            if(longReachable<i)
                return false;
            longReachable = Math.max(longReachable,nums[i]+i);
        }
        return true;
    }

    // This method cannot process when the array contains larger values
    // Stack out of memory may come
    //Cannot process this input int[] nums = new int[]{9999,9998,9997,.....,3,2,1,0,0};
    public static boolean traverse(int[] nums, int index){

         if(index == nums.length-1)
            return true;
        if(nums[index]==0)
            return false;
        for(int i=1;i<=nums[index];i++){
            if(traverse(nums,index+i) == true)
                return true;
        }
        return false;
    }

}
