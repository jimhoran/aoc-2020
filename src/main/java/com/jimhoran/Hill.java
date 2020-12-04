package com.jimhoran;

import java.io.File;
import java.util.List;

public class Hill {



    File prodHillFile = null;

    public Hill() {}

    public void setProdHillFile(File prodHill) {
        this.prodHillFile = prodHill;
    }

    enum Square {TREE, OPEN}

    Square[][] hill = null;
    int height = 0;
    int width = 0;

    public Hill(File prodHillFile) throws Exception {
        this.prodHillFile = prodHillFile;
        loadHill(prodHillFile);
    }

    // Load the hill file
    void loadHill(File file) throws Exception {

        Utilities utils = new Utilities();

        List<String> input = utils.readFileOfStrings(file);

        height = input.size();
        width = input.get(0).length();

        hill = new Square[height][width];

        for (int i = 0; i < height; i++) {
            String line = input.get(i);
            for (int j = 0; j < width; j++) {
                if (line.charAt(j) == '.') {
                    hill[i][j] = Square.OPEN;
                } else {
                    if (line.charAt(j) == '#') {
                        hill[i][j] = Square.TREE;
                    } else {
                        throw new Exception("input error.");
                    }
                }

            }
        }
        System.out.println("Successfully loaded hill:" + height + "x" + width);
    }

    Square[][] getRawHill(){
        return hill;
    }

    Square getSquare(int x, int y)  {
        return hill[x][y % width];
    }

    long getTreesOnTrajectory(int slopeX, int slopeY){
        int startX = 0;
        int startY = 0;
        return getTreesOnTrajectory( startX, startY, slopeX, slopeY);
    }


    long getTreesOnTrajectory(int startX, int startY, int slopeY){
        int slopeX = 1;
        return getTreesOnTrajectory(startX, startY, slopeX, slopeY);
    }


    long getTreesOnTrajectory(int startX, int startY, int slopeX, int slopeY){

        long trees = 0;
        for (int h=startX; h*slopeX < height; h++){
//            System.out.println("Checking h:" + h*slopeX + " w:" + h*slopeY + " trees:" + trees);
            if ( getSquare(h*slopeX, h*slopeY) == Square.TREE) trees++;
        }

        return trees;

    }


}
