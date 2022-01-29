package com.techstart.deploy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeploymentStrategy {
    public static void main(String[] args) {

        System.out.println("Start deploying");
        int[][] components = new int[10][2];

             components[0][0] = 2;
        components[0][1] = 4;
        components[1][0] = 6;
        components[2][0] = 3;
        components[3][0] = -1;
        components[4][0] = 7;
        components[5][0] = -1;
        components[6][0] = -1;
        components[7][0] = -1;
        components[8][0] = 0;

        identifyPreReq(components);


    }

    public static List<List<Integer>> identifyPreReq(int[][] compDepend) {

        // Todo - Check for boundary condition before processing

        int rows = compDepend.length;
        int cols = compDepend[0].length;

        List<List<Integer>> completeDep = new ArrayList<>();

        //List<List<Integer>> deployGraph = new ArrayList<>();
        Map<Integer, List<Integer>> paralleDepList = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Map<Integer, Boolean> visited = new HashMap<>();
                List<Integer> dependencies = new ArrayList<>();
                traverse(new int[]{i, j}, compDepend, visited, dependencies);
                if (dependencies.size() == 0) {
                    dependencies.add(i);
                }
                completeDep.add(dependencies);
                paralleDepList.put(dependencies.size(), dependencies);
            }


            for (List<Integer> deps : paralleDepList.values()) {
                for (Integer id : deps) {
                    deployComponent(id);
                }
            }

        }
        return completeDep;
    }

        public static void deployComponent(int index){
            //Deploy the component
            System.out.println("Deploying component :"+index);
        }

    public static void traverse(int[] index , int[][] compDepend, Map<Integer, Boolean > visited, List<Integer> dependencies){


            int row = index[0];
            int col = index[1];
            if(compDepend[row][col]==-1){
                return;
            }
            for(int i=0;i<compDepend[row].length;i++){
                //visited[index][i] = 1;
                traverse(new int[]{row,col},compDepend,visited,dependencies);
            }
            dependencies.add(row);

        }
}
