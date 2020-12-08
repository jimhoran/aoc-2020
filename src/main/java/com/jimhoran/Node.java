package com.jimhoran;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {

    public List<Node> containedBy;
    public List<Node> contains;
    List<String> containsRules;
    private Map<String, Integer> containsRulesMap;
    List<String> nodeIDsThatCanBeReached;

    public String nodeId;
    String rulesString = null;
    Pattern noOfBagsPattern = null;
    Pattern colorOfBagsPattern = null;
    Pattern noOtherBagsPattern = null;

    {
        noOfBagsPattern = Pattern.compile(" *([0-9]*)");
        colorOfBagsPattern = Pattern.compile(" [0-9]* (.*) bag.*");
        noOtherBagsPattern = Pattern.compile(" no other bags.");
        setContainsRulesMap(new HashMap<>());
        nodeIDsThatCanBeReached = new ArrayList<>();
        contains = new ArrayList<>();
    }


    Node(String nodeId) {
        this.nodeId = nodeId;
    }

    void setRulesString(String rulesString) {
        this.rulesString = rulesString;
        containsRules = Arrays.asList(rulesString.split(","));
        for (String rule : containsRules) {
            // get number and color of contained bag
            int ruleQty = 0;
            String color = null;
            if (noOtherBagsPattern.matcher(rule).matches()) {
                continue;
            }
            Matcher noOfBagsMatcher = noOfBagsPattern.matcher(rule);
            if (noOfBagsMatcher.find()) {
                String m = noOfBagsMatcher.group(1);
                ruleQty = Integer.valueOf(m);
            }

            Matcher colorMatcher = colorOfBagsPattern.matcher(rule);
            if (colorMatcher.find()) {
                color = colorMatcher.group(1);
            }
            getContainsRulesMap().put(color, ruleQty);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node=")
                .append(nodeId);
//                .append("\n");
//        for (Node node : contains) {
//            sb.append(node.toString())
//                    .append(("\n"));
//        }
//        sb.append(("=================\n"));

        return sb.toString();
    }

    public Map<String, Integer> getContainsRulesMap() {
        return containsRulesMap;
    }
    public void setContainsRulesMap(Map<String, Integer> containsRulesMap) {
        this.containsRulesMap = containsRulesMap;
    }

    Set<String> getNodeIDsThatCanBeReached(){
        return containsRulesMap.keySet();
    }

}
