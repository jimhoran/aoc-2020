package com.jimhoran.functions;

import java.util.function.Predicate;


public class IssueYearValidator implements Predicate<String> {
    @Override
    public boolean test(String year) {
        try {
            if (year.length() != 4) return false;
            Integer y = Integer.parseInt(year);
            if (y < 2010 || y > 2020) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}


