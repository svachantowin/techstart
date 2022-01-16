package com.techstart.problems;

import java.util.Arrays;

public class MeetingRoomII {
    public static void main(String[] args) {

        Interval interval = new Interval(0,30);
        Interval interval1 = new Interval(5,10);
        Interval interval2 = new Interval(15,20);

        Interval[] intervals = new Interval[]{interval,interval1,interval2};
        System.out.println("Max number of meeting  rooms required :"+ meetingRoom2(intervals) );
    }

    public static class Interval{
        int startTime;
        int endTime;

        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

    }

    // Time - O(nlogn)
    // Space - O(n)
    public static int meetingRoom2(Interval[] intervals){

        int[] startArray = new int[intervals.length];
        int[] endArray = new int[intervals.length];

        int index = 0;
        for(Interval interval:intervals){
            startArray[index] = interval.startTime;
            endArray[index] = interval.endTime;
            index++;
        }

        //Sort the start time and end time of the given intervals separately
        Arrays.sort(startArray);
        Arrays.sort(endArray);

        int parallelMeeting =0, noOfRooms = 0;

        // Maintaing two pointer - one for current shortest startTime & one for current shorted endTime
        int start =0, end = 0;


        // Loop through each intervals and check how many meetings are happening in parallel
        for(int i=0;i<intervals.length;i++){
            // if startTime lesser than shortest endTime then meeting is in place
            // so increment the number of meeting counts and start checking the next meeting's start Time
            // Move to next shortest start time
            if(startArray[start]<endArray[end]){
                parallelMeeting++;
                start++;
            }
            else{
                // If startTime greater than currently pointing shortest endTime, then a meeting has ended
                // so decrement the meeting count and move the pointer to next shorted endTime
                parallelMeeting--;
                end++;
            }
            // Maximum of parallel meetings through out the given interval says the maximum meeting room required
            noOfRooms = Math.max(noOfRooms,parallelMeeting);
        }

        return noOfRooms;
    }
}
