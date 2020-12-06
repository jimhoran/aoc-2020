package com.jimhoran;

import org.junit.Test;

import java.io.File;
import java.util.List;


public class Day02Test {

    Utilities util = new Utilities();

    @Test
    public void testFileInput(){

        List<String> list =  util.readFileOfStrings(new File("./src/test/resources/input-2.txt"));
        int validPasswords = 0;
        for (String line : list){
            String[] fields=line.split(" ");
            int pos1 = Integer.parseInt(fields[0].split("-")[0]) - 1;
            int pos2 = Integer.parseInt(fields[0].split("-")[1]) - 1;
            String requiredChar = Character.toString(fields[1].charAt(0));

            boolean pos1Char = Character.toString(fields[2].charAt(pos1)).equals(requiredChar);
            boolean pos2Char = Character.toString(fields[2].charAt(pos2)).equals(requiredChar);

            if (pos1Char ^ pos2Char) validPasswords++;

            System.out.println("validPasswords=" + validPasswords);

        }



    }


}
