package com.jimhoran;

import java.util.List;

public class Driver05 {

    public static void main(String[] args){

        Utilities utils = new Utilities();

        List<String> seats = utils.readFileOfStrings("main", 5);

        boolean[] seatMap = new boolean[1024];
        int highestSeatId = 0;
        int mySeatId = 0;

        // populate map, grabbing the max while you're at it.
        for (String seat :seats){
            int seatId = new BoardingPass(seat).getSeatId();
            highestSeatId = Math.max(seatId, highestSeatId);
            seatMap[seatId] = true;
        }
        System.out.println("highestSeatId=" + highestSeatId);

        int occupiedSeats = 0;
        int vacantSeats = 0;

        for (int i=2; i<1024; i++){
            if (seatMap[i - 2] && !seatMap[i-1] && seatMap[i]) {
                mySeatId = i - 1;
            }
            if (seatMap[i]) {
                occupiedSeats++;
            } else {
                vacantSeats++;
            }
        }

        System.out.println("mySeatId=" + mySeatId);
        System.out.println("occupiedSeats=" + occupiedSeats);
        System.out.println("vacantSeats=" + vacantSeats);

    }
}