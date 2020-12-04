package com.jimhoran;

public class Field {

    Field(String string, String delimiter) {
        String[] values = string.split(delimiter);
        this.key = values[0];
        this.value = values[1];
    }

    String key;
    String value;

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
