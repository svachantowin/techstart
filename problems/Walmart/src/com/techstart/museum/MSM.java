package com.techstart.museum;

import java.util.*;

public class MSM {

    // Mapping of room & its exit info
//    Map<Integer, Room> inventory = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Starting analysis");
    }

    List<Integer> findPath(List<List<Integer>> roomConns,  int numOfRooms, int[] exitRooms, int startRoom){

        List<Integer> exitPath = new ArrayList<>();
        Map<Integer,Room> connections = new HashMap<>();

        // [0,1] => room0 to room1
        // Adjacent list creation
        for(List<Integer> conn : roomConns){
            int key = conn.get(0);
            int value = conn.get(1);
            if(connections.containsKey(key)){
                Room room = new Room(value,new ArrayList<>(),false);
                //connections.get(key).add(room);
                connections.put(key,room);
            }
        }


        boolean[] visited = new boolean[numOfRooms];
        Arrays.fill(visited,false);

        if(dfs(connections,exitPath,visited,startRoom)== true)
            return exitPath;

        return exitPath;

    }

    // 0->2->4->2
    // 0->2->5->6->Exit
    // 0->2->5->3->Exit
    //0->1->3->Exit


    boolean dfs(Map<Integer,Room> connections, List<Integer> path, boolean[] visited, int currRoom){

        if(visited[currRoom]==true){
            return false;
        }

        visited[currRoom] = true;
        if(connections.get(currRoom).exitRoom == true){
            path.add(currRoom);
            return true;
        }

        for(Room connectedRoom : connections.get(currRoom).connRooms){
            if(dfs(connections,path,visited,connectedRoom.roomNumber)==true) {
                path.add(currRoom);
                return true;
            }
        }
        //visited[currRoom] = false;
        return  false;
    }

}
