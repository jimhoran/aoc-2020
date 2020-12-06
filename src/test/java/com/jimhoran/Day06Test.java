package com.jimhoran;

import org.junit.Test;

import java.util.List;

public class Day06Test {

    @Test
    public void testCustoms() {

        Utilities utils = new Utilities();

        List<String> rawForms = utils.readFileOfStrings("test", 6);
        org.junit.Assert.assertEquals(15, rawForms.size());

        CustomsScore cs = new CustomsScore();
        org.junit.Assert.assertEquals(11, cs.anyone(rawForms));
        org.junit.Assert.assertEquals(6, cs.everyone(rawForms));

    }

}