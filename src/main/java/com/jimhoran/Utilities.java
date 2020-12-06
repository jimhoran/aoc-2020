package com.jimhoran;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Utilities {

    Logger logger = Logger.getLogger(this.getClass().toString());
    private String stringDelimiter;

    public Utilities() {
        stringDelimiter = "\n";
    }

    File getFileName(String testMain, Integer day) {
        return new File("./src/" + testMain + "/resources/" + "input-" + day + ".txt");
    }

    List<Integer> readFileOfIntegers(String testMain, Integer day) {
        return readFileOfIntegers(getFileName(testMain, day));
    }

    List<Integer> readFileOfIntegers(File file) {

        List<Integer> integers = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextBigInteger()) {
                integers.add(scanner.nextInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        logger.info(("Utilities read in " + file + " with " + integers.size() + " integers."));

        return integers;

    }


    List<String> readFileOfStrings(String testMain, Integer day) {
        return readFileOfStrings(getFileName(testMain, day));
    }

    List<String> readFileOfStrings(File fqfn) {

        List<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(fqfn)) {
            scanner.useDelimiter(stringDelimiter);
            while (scanner.hasNext()) {
                strings.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        logger.info(("Utilities read in " + fqfn + " with " + strings.size() + " strings."));

        return strings;

    }

    public String getStringDelimiter() {
        return stringDelimiter;
    }

    public void setStringDelimiter(String stringDelimiter) {
        this.stringDelimiter = stringDelimiter;
    }
}
