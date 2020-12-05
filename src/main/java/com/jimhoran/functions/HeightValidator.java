package com.jimhoran.functions;

import java.util.function.Predicate;
/*  hgt (Height) - a number followed by either cm or in:
        If cm, the number must be at least 150 and at most 193.
        If in, the number must be at least 59 and at most 76.
 */
public class HeightValidator implements Predicate<String> {
    @Override
    public boolean test(String height){
        int length = height.length();
        if (length < 4) return false;
        int h = Integer.parseInt(height.substring(0, length-2));
        String uom = height.substring(length-2);
        if ("cm".equals(uom) && h >=150 && h <=193) return true;
        if ("in".equals(uom) && h >=59 && h <=76) return true;
        return false;
    }
}