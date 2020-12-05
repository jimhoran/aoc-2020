package com.jimhoran.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EyeColorValidator implements Predicate<String> {

    static List<String> validColors =Arrays.asList("amb","blu","brn","gry","grn","hzl","oth");

    @Override
    public boolean test(String eyc){
        return validColors.contains(eyc);
    }
}

