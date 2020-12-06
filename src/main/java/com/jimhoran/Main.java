package com.jimhoran;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args){

        File file = new File("./src/main/resources/input-1.txt");

        Utilities utils = new Utilities();
        List<Integer> list = utils.readFileOfIntegers(file);

        System.out.println("file contains " + list.size() + " integers");

        for (Integer i : list){
            for (Integer j : list){
                for (Integer k : list){
                    if (( i+j + k ) == 2020) System.out.println("answer = " + i*j*k);
                }

            }
        }



    }

}
