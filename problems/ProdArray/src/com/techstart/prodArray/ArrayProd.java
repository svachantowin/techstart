package com.techstart.prodArray;

public class ArrayProd {

    public static void main(String[] args) {

        int[] array = new int[]{1073741824,1073741824};
        int prod = 1;
        for(int val : array){
//            prod = (prod * val)%1000000007;
            prod = (prod * val);
        }
        System.out.println("Product :"+prod);

    }
}
