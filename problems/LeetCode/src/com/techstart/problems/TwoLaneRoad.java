package com.techstart.problems;

import java.util.Arrays;

// Problem statement
// Two lane road problem
// Lane1 & Lane2 are given as string where . represents road & x represents potholes
// Aim of the problem - Without disturbing the traffic, potholes should be repaired
// Constraints - Traffic should not be stopped
// Vehicles should reach from one end to another end of the lane
// It is ok to have potholes in the reroutes path
// Maximum of one switch between lanes is allowed
// Find maximum number of potholes that can be repaired without disturbing the moving traffic


public class TwoLaneRoad {

    static int minPotHoles = Integer.MAX_VALUE;

    public static void main(String[] args) {

        //Input 1 - Exp Output = 4
        String l1 = "..xx.x.";
        String l2 = "x.x.x..";

        //Input2 - Exp Output = 6
//        String l1 = ".xxx...x";
//        String l2 = "..x.xxxx";

        //Input3 - Exp output = 5
//        String l1 = "xxxxx";
//        String l2 = ".x..x";

        //Input4 - Exp output = 2
//        String l1 = "x...x";
//        String l2 = "..x..";

        System.out.println("MaxPotHoles that can be repaired :"+maxRepair(l1,l2));
    }

    public static int maxRepair(String l1, String l2){

        int[][] routeMap = new int[2][l1.length()];
        int totalPotHoles = 0;
        int col = 0;
        for(char c : l1.toCharArray()){
            if(c == 'x'){
                routeMap[0][col++] = 0;
                totalPotHoles++;
            }

            else
                routeMap[0][col++] = 1;
        }
        col = 0;
        for(char c : l2.toCharArray()){
            if(c == 'x') {
                routeMap[1][col++] = 0;
                totalPotHoles++;
            }
            else
                routeMap[1][col++] = 1;
        }

        for(int i=0;i<routeMap.length;i++){
            for(int j=0;j< routeMap[0].length;j++){
                System.out.print(routeMap[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("TotalPotHoles :"+totalPotHoles);


        traverse(routeMap,new int[]{0,0},0,new int[]{0,0},false);
        traverse(routeMap,new int[]{1,0},0,new int[]{1,0},false);

        System.out.println("MinPotHoles :"+minPotHoles);

        // Subtracting MinPotHoles from totalPotholes will give number of potholes to be repaired
        return totalPotHoles-minPotHoles;
    }

    public static void traverse(int[][] routeMap, int[] coordindates, int count, int[] prevNode,boolean turnedAlready){

        int row = coordindates[0];
        int col = coordindates[1];



        if(row >=2 || row <0 || col >=routeMap[0].length || col <0)
            return;

//        if(visitedMap[row][col]==1)
//            return;
//
//        visitedMap[row][col]=1;


        if(routeMap[row][col]==0)
            count++;

//        for(int i=0;i<visitedMap.length;i++){
//            for(int j=0;j< visitedMap[0].length;j++){
//                System.out.print(visitedMap[i][j]+" ");
//            }
//            System.out.println();
//        }

//        System.out.println("Row :"+row +" Col:"+col +" Count:"+count);

        if(col == routeMap[0].length-1){
            // MinPotHoles can be arrived only after reaching end of the lane
            minPotHoles = Math.min(minPotHoles,count);
            return;
        }

        int prevRow = prevNode[0];
        int prevCol = prevNode[1];

        boolean switchLane = false;
        if(row == 0){

//            if(row+1!=prevRow && turnedAlready==false) {
            if(turnedAlready==false) {
                switchLane = true;
                traverse(routeMap, new int[]{row + 1, col}, count, new int[]{row, col},switchLane);
            }
        }
        else if(row == 1){
//            if(row-1!=prevRow && turnedAlready==false) {
          if(turnedAlready==false) {
                switchLane = true;
                traverse(routeMap, new int[]{row - 1, col}, count, new int[]{row, col}, switchLane);
            }
        }
        if(col+1!=prevCol)
            traverse(routeMap,new int[]{row,col+1},count,new int[]{row,col},turnedAlready);

    }

}
