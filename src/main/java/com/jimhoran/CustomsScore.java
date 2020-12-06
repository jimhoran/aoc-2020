package com.jimhoran;

import java.util.*;

public class CustomsScore {


    public int anyone(List<String> rawForms) {

        HashSet<Character> groupYesAnswers = new HashSet<>();

        int total = 0;
        ListIterator<String> it = rawForms.listIterator();
        while (it.hasNext()) {
            String form = it.next();
            if (form.isBlank() == false) {
                for (int i = 0; i < form.length(); i++) {
                    groupYesAnswers.add(form.charAt(i));
                }
            }
            if (form.isBlank() || it.hasNext() == false) {  // add total if at delimiter OR EOF
                total = total + groupYesAnswers.size();
                groupYesAnswers.clear();
            }
        }

        return total;

    }


    public int everyone(List<String> rawForms) {

        HashMap<Integer, Integer> groupYesAnswers = new HashMap<>();
        int[] grpYesAnswers = new int[26];
        HashSet<Integer> everyoneYesAnswers = new HashSet<>();

        int groupSize=0;
        int total = 0;
        ListIterator<String> it = rawForms.listIterator();

        while (it.hasNext()) {
            String form = it.next();
            if (form.isBlank() == false) {
                groupSize++;
                for (int i = 0; i < form.length(); i++) {
                    int q = form.charAt(i) - 97;
                    grpYesAnswers[q]++;
                }
            }

            if (form.isBlank() || it.hasNext() == false) {  // add total if at delimiter OR EOF
                for (int i=0; i<26; i++){
                    if (grpYesAnswers[i]==groupSize){
                        total++;
                    }
                }
                grpYesAnswers = new int[26];
                groupSize=0;
            }
        }

        return total;

    }


}
