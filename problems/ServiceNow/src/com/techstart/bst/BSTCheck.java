package com.techstart.bst;

public class BSTCheck {


    public static void main(String[] args) {
        System.out.println("Test Start");
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(3);
        node.left.right = new Node(11);
        node.right.left = new Node(12);
        node.right.right = new Node(17);

        System.out.println("Is valid BST : "+checkBST(node));
    }


    public static boolean checkBST(Node node){

//        if(node==null)
//            return true;
//
//        return (checkBSTHelper(node.left, -1, node.value) &&
//                checkBSTHelper(node.right, node.value,-1));

        return checkBSTHelper(node,-1,-1);

    }

    public static boolean checkBSTHelper(Node node, int minValue, int maxValue){

        if(node==null)
            return true;

//        System.out.println( "Node:"+node.value+" minValue:"+minValue+" maxValue:"+maxValue);

//        if(minValue !=-1 && maxValue!=-1 && node.value<minValue && node.value>maxValue)
//            return (checkBSTHelper(node.left,minValue,node.value) &&
//                    checkBSTHelper(node.right,node.value,maxValue));


        if((minValue != -1 && node.value <=minValue) || (maxValue!=-1 && node.value >=maxValue))
            return false;


        return (checkBSTHelper(node.left,minValue,node.value) &&
                    checkBSTHelper(node.right,node.value,maxValue));

    }

}

class Node {

        int value;
        Node left;
        Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
};