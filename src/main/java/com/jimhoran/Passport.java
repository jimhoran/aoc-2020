package com.jimhoran;

import com.jimhoran.functions.*;

import java.util.*;
import java.util.function.Predicate;


public class Passport {

    String ID;
    Map<String, String> fields;

    Map<String, Predicate<String>> requiredFieldValidatorMap;
    List<String> missingFields;
    List<String> invalidFields;

    private boolean valid;

    {   setValid(true);

        fields = new TreeMap<>();
        requiredFieldValidatorMap = new TreeMap<>();
        requiredFieldValidatorMap.put("byr", new BirthYearValidator());
        requiredFieldValidatorMap.put("iyr", new IssueYearValidator());
        requiredFieldValidatorMap.put("eyr", new ExpYearValidator());
        requiredFieldValidatorMap.put("hgt", new HeightValidator());
        requiredFieldValidatorMap.put("hcl", new HairColorValidator());
        requiredFieldValidatorMap.put("ecl", new EyeColorValidator());
        requiredFieldValidatorMap.put("pid", new PIDValidator());

        missingFields = new ArrayList<>();
        invalidFields = new ArrayList<>();

    }


    Passport() {

    }

    Passport(String passportString) {
        List<String> fieldStrings = Arrays.asList(passportString.split(" "));
        for (String string : fieldStrings) {
            String[] kv = string.split(":");
            fields.put(kv[0], kv[1]);
        }

        // check for presence and validity of requiredFields
        for (String key : requiredFieldValidatorMap.keySet()) {
            if (!fields.containsKey(key)) {
                // If the field does not contain the key, invalidate this passport and
                // add the key to the list of missing fields.
                setValid(false);
                missingFields.add(key);
            } else {
                // The fields do contain the key, so grab the validator and validate it.
                String value = fields.get(key);
                if (isFieldValid(value, requiredFieldValidatorMap.get(key))) {
                    // do nothing.
                } else{
                    invalidFields.add(key);
                }

            }
            if (invalidFields.size() > 0) setValid(false);
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passport ==== { ");
        sb.append("ID: " + fields.get("pid") + "\n");
        for (String key : fields.keySet()) {
            sb.append("  " + key + "," + fields.get(key) + "\n");
        }
        sb.append("valid: " + isValid() + "\n")
                .append("fields:" + fields.size())
                .append("  cid missing? " + !fields.containsKey("cid") + "\n")
                .append("Missing Fields: ").append(missingFields).append(", ")
                .append("Invalid Fields: ").append(invalidFields)
                .append("\n}");
        return sb.toString();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    boolean isFieldValid(String value, Predicate p) {
        return p.test(value);
    }


}
