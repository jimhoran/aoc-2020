package com.jimhoran;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07Test {

    Map<String, Node> nodes;

    public void init(String mainTest, Integer day) {
        nodes = new HashMap<>();
        List<String> ruleSet = new Utilities().readFileOfStrings(mainTest, day);
        // build nodes from file and add to map with color as nodeId, and Node as the value
        // Internal to each node is a map of adjacents
        for (String line : ruleSet) {
            String[] parts = line.split(" bags contain");
            Node node = new Node(parts[0]);
            node.setRulesString(parts[1]);
            nodes.put(node.nodeId, node);
        }
    }

    @Test
    public void testPuzzleOne() {

        init("main", 7);
        System.out.println("Ingested file with " + nodes.size() + " colors.");

        Set<Node> nodeList;
        final String TARGET2 = "shiny gold";

        int total = 0;
        for (String nodeId : nodes.keySet()) {

            Set<Node> allTheChildren = getChildrenFlattened(nodes.get(nodeId), new CopyOnWriteArraySet<>());
            System.out.println("NodeId:" + nodeId + " allTheChildren:" + allTheChildren);
            for (Node node : allTheChildren) {
                if (node.nodeId.equals(TARGET2))
                    total++;
            }
        }
        System.out.println("The total number of routes that include " + TARGET2 + "=" + total);
        System.out.println("Since you're including the root node in the path, subtract 1 from total above.");

    }


    public Set<Node> getChildrenFlattened(Node n, Set<Node> children) {

        Set<String> reachableNodes = n.getNodeIDsThatCanBeReached();
        children.add(n);
        if (!reachableNodes.isEmpty()) {
            for (String nodeId : reachableNodes) {
                getChildrenFlattened(nodes.get(nodeId), children);
            }
        }
        return children;
    }


    // pass in the node, add
    public int totalChildren(String nodeId) {
        Node node = nodes.get(nodeId);
        Map<String, Integer> rulesMap = node.getContainsRulesMap();
        if (rulesMap.keySet().size() == 0) {
            return 1;
        } else {
            int localTotal = 0;
            for (String s : rulesMap.keySet()) {
                int multiplier = rulesMap.get(s);
                localTotal += multiplier * totalChildren(s);
            }
            return localTotal + 1;
        }
    }

    @Test
    public void testPuzzleTwo() {


        init("main", 7);
        System.out.println("Ingested file with " + nodes.size() + " colors.");

        final String TARGET2 = "shiny gold";
        int answer = totalChildren(TARGET2);
        System.out.println("The answer for " + TARGET2 + " = " + answer);
        System.out.println("Since you're including the root node in the path, subtract 1 from total above.");

    }


    @Test
    public void testRegex() {
        Pattern p = Pattern.compile(" [0-9]* (.*) bag.*");
        Matcher colorMatcher = p.matcher(" 1 bright yellow bags.");
        boolean matches = colorMatcher.matches();
        System.out.println(matches);
        if (matches) {
            System.out.println(colorMatcher.group(1));
        }


    }
}
