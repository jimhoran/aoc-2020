package com.jimhoran;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day03TobogganTrajectory {

    public static final File PROD_HILL = new File("./src/main/resources/input-3.txt");

    public static void main(String[] args){
        System.out.println("This is day 3");
//        doPuzzlePart1();
        doPuzzlePart2();
    }

    private static void doPuzzlePart1() {

        Hill hill = null;
        try {
            hill = new Hill(PROD_HILL);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("Number of Trees Part 1: " + hill.getTreesOnTrajectory(0,0,3));
    }

    private static void doPuzzlePart2() {

        Hill hill = null;
        try {
            hill = new Hill(PROD_HILL);
        } catch (Exception e) {
            System.out.println("Exiting with error: " + e.getMessage());

        }


        List<Pair<Integer>> slopes = new ArrayList<>();
        slopes.add(new Pair(1,1));
        slopes.add(new Pair(1, 3));
        slopes.add(new Pair(1,5));
        slopes.add(new Pair(1,7));
        slopes.add(new Pair(2,1));

        BigInteger trees = null;
        for (Pair<Integer> slope : slopes){
            System.out.println("Checking trees for slope: " + slope.toString());
            if (trees == null){
                trees = BigInteger.valueOf(1);
            }
            trees = trees.multiply(BigInteger.valueOf(hill.getTreesOnTrajectory( slope.left,slope.right)));
            System.out.println("trees=" + trees);
        }
        ;
        System.out.println("Number of Trees Part 2: " + trees);
    }

}
