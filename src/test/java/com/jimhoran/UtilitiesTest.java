package com.jimhoran;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class UtilitiesTest {

    @Test
    public void testReadFile() {
        Utilities utils = new Utilities();

        List<Integer> testInput =
                utils.readFileOfIntegers(new File("./src/test/resources/test.txt"));

        assertTrue(testInput.size() == 6);
    }

    @Test
    public void testReadFileOfStrings(){
        Utilities utils = new Utilities();
        List<String> passportList = new ArrayList<>(8);

        List<String> input = utils.readFileOfStrings("test", 4);
        input.stream().filter(x -> x.isEmpty()).filter(x -> x.isBlank()).forEach(System.out::println);
        assertTrue(input.size() == 28);





    }

}
