package com.jimhoran;

public class BoardingPass {

    String seatSpecification;


    BoardingPass(String seatSpecification) {
        this.seatSpecification = seatSpecification;
    }

    int getSeatId() {

        int row = getRow();
        int col = getColumn();

        int seatId = 8*row + col;

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
    int getColumn(){
        int column = 0;
        for (int i = 7; i < 10; i++) {
            char c = seatSpecification.charAt(i);
            if ( c == 'R'){
                column = column + (1 << (9-i));
            }
        }
        return column;
    }
}
