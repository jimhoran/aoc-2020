package com.jimhoran;

public class BoardingPass {

    String seatSpecification;


    BoardingPass(String seatSpecification) {
        this.seatSpecification = seatSpecification;
    }

    int getSeatId() {

        int row = getRow();
        int seatId = 0;

        return seatId;
    }

    int getRow() {

        int row = 0;
        for (int i = 0; i < 7; i++) {
            char c = seatSpecification.charAt(i);
            if ( c == 'B'){
                row = row + (1 << (6-i));
            }
        }
        return row;
    }


}
