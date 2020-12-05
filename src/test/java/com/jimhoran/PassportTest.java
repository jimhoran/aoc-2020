package com.jimhoran;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PassportTest {


    @Test
    public void testPassport(){

        Passport p = new Passport("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884");
        assertEquals(p.isValid(), false);
        assertEquals(p.fields.get("iyr"), "2013");

        p = new Passport("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in");
        assertEquals(false, p.isValid());
        assertEquals("2011", p.fields.get("iyr"));

    }

    @Test
    public void testGetPassportsFromTestFile(){
        PassportReader pr = new PassportReader();

        List<Passport> testPassports = pr.getPassportsFromFile("test", 4);
        assertEquals(2, getValidPassports(testPassports));
    }


    @Test
    public void testGetPassportsFromFile(){

        PassportReader pr = new PassportReader();

        List<Passport> mainPassports = pr.getPassportsFromFile("main", 4);
        int validMainPassports = getValidPassports(mainPassports);
        System.out.println(validMainPassports);
        assertEquals(114, validMainPassports);

    }



    private int getValidPassports(List<Passport> passports) {
        int validPassports = 0;
        for (Passport p : passports){
            System.out.println(p);
            if (p.isValid()) validPassports++;
        }
        return validPassports;
    }

}
