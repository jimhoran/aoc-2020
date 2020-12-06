package com.jimhoran.functions;

import java.util.function.Predicate;

public class HairColorValidator implements Predicate<String> {
    @Override
    public boolean test(String hairColor) {
        try {
            if (hairColor.charAt(0) != '#') return false;
            String color = hairColor.substring(1);
            if (color.length() != 6) return false;
            for (char c : color.toCharArray()) {
                int ascii = (int) c;
                if (( ascii < 48 || ascii > 57 ) && (ascii < 97 || ascii > 102)){
                    return false;
                }
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
}