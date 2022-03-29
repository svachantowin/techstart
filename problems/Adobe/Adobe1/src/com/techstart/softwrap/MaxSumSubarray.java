package com.techstart.softwrap;

public class MaxSumSubarray {

    public static void main(String[] args) {
        System.out.println("Max SUm");
        int[] input = new int[] {-2,-3,-1,-5,-2};
        System.out.println("MaxSum:"+maxSum(input));
    }

    //[2,3,1,0,-5,-2,1,7]
    public static int maxSum(int[] inputs){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<inputs.length;i++){
            sum+=inputs[i];
            max = Math.max(sum,max);
            if(sum<0)
                sum = 0;
        }

        return max;

    }

}
