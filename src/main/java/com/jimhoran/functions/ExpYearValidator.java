package com.jimhoran.functions;

import java.util.function.Predicate;

public class ExpYearValidator implements Predicate<String> {
    @Override
    public boolean test(String year) {
        try {
            if (year.length() != 4) return false;
            int y = Integer.parseInt(year);
            if (y < 2020 || y > 2030) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
