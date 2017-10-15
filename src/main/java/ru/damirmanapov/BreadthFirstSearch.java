package ru.damirmanapov;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {


    public static List<Node> breadthFirstSearch(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        List<Node> nodes = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.getChildren() != null) {
                queue.addAll(currentNode.getChildren());
            }
            nodes.add(currentNode);

        }

        return nodes;

    }
}


