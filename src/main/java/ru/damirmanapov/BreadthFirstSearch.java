package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {


    public static List<Node> breadthFirstSearch(Node node) {

        List<Node> nodes = new LinkedList<>();

        int depth = depth(node);

        for (int i = 1; i <= depth; i++) {
            List<Node> nodesOnDepth = nodesOnDepth(node, i);
            nodes.addAll(nodesOnDepth);
        }

        return nodes;

    }

    public static List<Node> nodesOnDepth(Node node, int depth) {

        List<Node> nodes = new LinkedList<>();

        if (depth == 1) {
            nodes.add(node);
        } else {
            if (node.getChildren() != null) {
                for (Node child : node.getChildren()) {
                    List<Node> current = nodesOnDepth(child, depth - 1);
                    if (current != null) {
                        nodes.addAll(current);
                    }
                }
            } else {
                return null;
            }
        }

        return nodes;

    }

    public static int depth(Node node) {

        int currentDepth = 0;

        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                currentDepth = Math.max(depth(child), currentDepth);
            }
        }

        return currentDepth + 1;

    }
}


