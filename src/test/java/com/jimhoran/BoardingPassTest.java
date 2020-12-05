package com.jimhoran;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testGetColumn(){
        assertEquals(5, pass.getColumn());
    }

    @Test
    public void bulkTest(){
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("BFFFBBFRRR", 567);
        testMap.put("FFFBBBFRRR", 119);
        testMap.put("BBFFBBFRLL", 820);
        for (String s: testMap.keySet()){
            BoardingPass p = new BoardingPass(s);
            assertEquals(testMap.get(s), Integer.valueOf(p.getSeatId()));
        }

    }

    @Test
    public void checkMyMathTest(){
        BoardingPass p = new BoardingPass("BBBBBBBRRR");
        assertEquals(1023, p.getSeatId());
    }




}
