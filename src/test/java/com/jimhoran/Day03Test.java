package com.jimhoran;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class Day03Test {

    public static final File FQFN = new File("./src/test/resources/test-input-3.txt");
    Utilities utils = new Utilities();

    @Test
    public void mapReadingTest() throws Exception {

        Hill hill = new Hill();
        hill.loadHill(FQFN);
        Hill.Square[][] rawHill = hill.getRawHill();

        assertTrue(rawHill[0][0] == Hill.Square.OPEN);
        assertTrue(rawHill[0][1] == Hill.Square.OPEN);
        assertTrue(rawHill[0][2] == Hill.Square.TREE);
        assertTrue(rawHill[1][0] == Hill.Square.TREE);
        assertTrue(rawHill[0][65] == Hill.Square.OPEN);
        assertTrue(rawHill[10][65] == Hill.Square.TREE);

        // test getSquare
        assertTrue(hill.getSquare(0,0) == Hill.Square.OPEN);
        assertTrue(hill.getSquare(0,2) == Hill.Square.TREE);
        assertTrue( hill.getSquare(0, 68) == Hill.Square.TREE);

        long trees = hill.getTreesOnTrajectory(0,0, 3);
        assertTrue(trees == 7);



    }



}