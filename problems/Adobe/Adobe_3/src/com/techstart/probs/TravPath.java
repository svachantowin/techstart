package com.techstart.probs;


// What is the minimum hop required to reach the end of the array
// Input 3, 2,5,1,6,8,9
// Output: 2 hops ==> index 0 -> index 2 -> End of the array
// Input 3,4,0,1,6,8,9
//// Output: 3 hops ==> index 0 -> index 1 -> index 4 -> End of the array
public class TravPath {
    public static void main(String[] args) {
        System.out.println("Start Traversing");

        int[] nums = new int[]{3, 2,5,1,6,8,9};
        System.out.println("Min traversal :"+minHop(nums));

    }

    public static int minHop(int[] nums){
        int longReachable = 0;
        int minHop = 0;
        for(int i=0;i<nums.length;i++){
            if(longReachable<i)
                return -1;
            if(longReachable<nums[i]+i){
                longReachable = nums[i]+i;
                minHop+=1;
                System.out.println(nums[i]);
                if(longReachable>=nums.length)
                    return minHop;

            }
        }
        return -1;
    }

//   public static int minTrav(int[] nums){
//
//        int hop = 1;
//        int maxLength = nums.length;
//        int locSum = nums[0];
//        int maxMove = nums[0];
//        int maxIndex = 0;
//
//
//        //3, 2,5,1,6,8,9
////        for(int i=0;i< nums.length;i++){
//        int i=1;
//        while(i<maxLength){
//            for(int j=i+1;j<nums[i] && j<maxLength;j++){
//                locSum+=nums[i];
//                if(locSum>maxMove){
//                    maxIndex = j;
//                    maxMove = locSum;
//                }
//            }
//            hop+=1;
//            if(maxMove>maxIndex)
//                return hop;
//            i = maxIndex;
//        }
//        return  hop;
//    }

}
