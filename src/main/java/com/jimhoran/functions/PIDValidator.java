package com.jimhoran.functions;

public class PIDValidator implements java.util.function.Predicate<String> {
    @Override
    public boolean test(String pid){
        if (pid.length() != 9) return false;
        for (char c : pid.toCharArray()) {
            int ascii = (int) c;
            if ( ascii < 48 || ascii > 57 ) {
                return false;
            }
        }
        return true;
    }
}
