package com.jimhoran;

import java.util.*;

public class Passport {

    Map<String, String> fields;
    List<String> requiredFields;
    List<String> missingFields;
    String ID;
    private boolean valid;

    { fields = new TreeMap<>();
      setValid(true);
      requiredFields = Arrays.asList("byr", "ecl", "eyr", "hcl", "hgt", "iyr", "pid");
      missingFields = new ArrayList<>();
    }


    Passport(String passportString) {
        List<String> fieldStrings = Arrays.asList(passportString.split(" "));
        for (String string : fieldStrings) {
            String[] kv = string.split(":");
            fields.put(kv[0], kv[1]);
        }

        for (String requiredFieldKey : requiredFields){
            if (!fields.containsKey(requiredFieldKey)) {
                setValid(false);
                missingFields.add(requiredFieldKey);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passport{\n");
        sb.append("ID: " + fields.get("pid") + "\n");
        for (String key : fields.keySet()){
            sb.append("  " + key + "," + fields.get(key) + "\n");
        }
        sb.append("valid: " + isValid() + "\n");
        sb.append("fields:" + fields.size());
        sb.append("  cid missing? " + !fields.containsKey("cid") + "\n");
        sb.append("Missing Fields: " + missingFields);
        sb.append("\n}");
        return sb.toString();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
