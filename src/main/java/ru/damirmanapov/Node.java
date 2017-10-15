package ru.damirmanapov;

import java.util.List;

public class Node {

    private int value;
    private List<Node> children;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public List<Node> getChildren() {
        return children;
    }

}


