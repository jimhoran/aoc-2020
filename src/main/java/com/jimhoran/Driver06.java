package com.jimhoran;

import java.util.List;

public class Driver06 {

    public static void main(String[] args){
        Utilities utils = new Utilities();

        List<String> rawForms = utils.readFileOfStrings("main", 6);
        System.out.println("Answer puzzle 1: " + new CustomsScore().anyone(rawForms));
        System.out.println("Answer puzzle 2: " + new CustomsScore().everyone(rawForms));

    }
}
