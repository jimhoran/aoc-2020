package com.jimhoran.functions;


import java.util.function.Predicate;

public class BirthYearValidator implements Predicate<String> {
    @Override
    public boolean test(String year) {
        try {
            if (year.length() != 4) return false;
            int y = Integer.parseInt(year);
            if (y < 1920 || y > 2002) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}