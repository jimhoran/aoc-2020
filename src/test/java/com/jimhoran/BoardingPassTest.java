package com.jimhoran;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardingPassTest {

    String seatId = "FBFBBFFRLR";
    BoardingPass pass = new BoardingPass(seatId);

    @Test
    public void testGetSeatId() {

        assertEquals(357, pass.getSeatId());

    }

    @Test
    public void testGetRow() {
        assertEquals(44, pass.getRow());
    }


}
