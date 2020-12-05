package com.jimhoran.com.jimhoran.function;

import com.jimhoran.functions.EyeColorValidator;
import com.jimhoran.functions.HairColorValidator;
import com.jimhoran.functions.HeightValidator;
import com.jimhoran.functions.PIDValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void testHeightValidator(){

        HeightValidator hv = new HeightValidator();

        assertTrue(hv.test("150cm"));
        assertFalse(hv.test("150ft"));
        assertTrue(hv.test("60in"));
        assertFalse(hv.test("58in"));
        assertFalse(hv.test("174"));

    }

    @Test
    public void testHairColorValidator(){
        HairColorValidator hcv = new HairColorValidator();

        assertTrue(hcv.test("#a2349f"));
        assertFalse(hcv.test("#a2349g"));
        assertFalse(hcv.test("#a2349f55"));
    }

    @Test
    public void testEyeColorValidator(){

        EyeColorValidator ecv = new EyeColorValidator();

        assertTrue(ecv.test("brn"));
        assertFalse(ecv.test("brown"));

    }

    @Test
    public void testPIDValidator(){
        PIDValidator validator = new PIDValidator();

        assertTrue(validator.test("123456789"));
        assertFalse(validator.test("1234567890"));
        assertFalse(validator.test("12345678f"));
        assertFalse(validator.test("12345678"));


    }



}
