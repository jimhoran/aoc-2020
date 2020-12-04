package com.jimhoran;

public class Pair<Object> {


        Pair(){}

        Pair(String string, String delimiter){
                String[] values = string.split(delimiter);
                this.left = (Object) values[0];
                this.right = (Object) values[1];
        }
        Pair(Object left, Object right){
            this.left = left; this.right = right;
        }
        Object left;
        Object right;

        @Override
        public String toString() {
                return "Pair{" +
                        "left=" + left +
                        ", right=" + right +
                        '}';
        }
}
