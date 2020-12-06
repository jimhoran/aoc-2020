package com.jimhoran;

import java.util.ArrayList;
import java.util.List;

public class PassportReader {

    Utilities utils;
    List<Passport> passports;

    List<Passport> getPassportsFromFile(String tm, Integer day) {

        utils = new Utilities();
        List<String> strings = utils.readFileOfStrings(tm, day);
        List<Passport> passports = new ArrayList<>();

        String passportString = null;
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (!string.isEmpty() && !string.isBlank()) {
                sb.append(string);
                sb.append(" ");
            } else {
                passportString = sb.toString();
                passports.add(new Passport(passportString));
                sb.setLength(0);
            }
        }

        return passports;
    }
}
