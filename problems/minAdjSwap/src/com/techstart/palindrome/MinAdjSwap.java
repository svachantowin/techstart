package com.techstart.palindrome;

public class MinAdjSwap {

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println("Execution Started");

        System.out.println("Number of swaps required :"+minAdjSwapTwo(s));

    }


    public static boolean isPossiblePalindrome(String s){

        int[] alpCount = new int[26];
        for(char c : s.toCharArray()){
            alpCount[c-'a']++;
        }
        int oddCount = 0;
        for(int count : alpCount){
            if(count%2 != 0){
                oddCount++;
            }
        }

        return oddCount <=1;
    }

    // This algorithm can any string if the characters can be joined to form palindrome
    public static int minAdjSwapTwo(String s){

        if(!isPossiblePalindrome(s))
            return -1;

        int count = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();
        for(int i=0;i<length/2;i++){
            int left = i;
            int right = length-i-1;

            if(charArray[left]==charArray[right]){
                left++;
                right--;
            }
            else{

                while(left<right){
                    if(charArray[left] == charArray[right]){
                        break;
                    }
                    right--;
                }
                if(left==right) {
                   swap(charArray,left,right+1);
                   count++;
                }
                else{
                    for(int j=right;j<length-left-1;j++){
                        swap(charArray,j,j+1);
                        count++;
                    }
                    left++;
                    right--;
                }
            }
        }
//        for(char c: charArray){
//            System.out.print(c);
//        }
        return count;
    }

    // This algorithm unable to swap "ntiin" but can swap aabcb
    public static int minAdjSwap(String s){

        int count = 0;

        int length = s.length();
        char[] charArray = s.toCharArray();
        for(int i=0;i<length/2;i++){
            int left = i;
            int right = length-i-1;

            while(left<right){
                if(charArray[left] == charArray[right]){
                    break;
                }
                right--;
            }
            if(left==right)
                return -1;
            for(int j=right;j<length-left-1;j++){
                swap(charArray,j,j+1);
                count++;
            }
        }
        return count;
    }

    public static void swap(char[] charArray, int left, int right) {
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
    }



}
