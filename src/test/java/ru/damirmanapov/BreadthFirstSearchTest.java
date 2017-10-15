package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Test
public class BreadthFirstSearchTest {

    private static final Logger logger = LoggerFactory.getLogger(BreadthFirstSearchTest.class);

    @Test
    public void testBreadthFirstSearch() {

        // Level 4
        Node n10 = new Node(10);
        Node n9 = new Node(9);

        // Level 3
        Node n5 = new Node(5, Arrays.asList(n9));
        Node n6 = new Node(6, Arrays.asList(n10));
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        // Level 2
        Node n2 = new Node(2, Arrays.asList(n5));
        Node n3 = new Node(3, Arrays.asList(n6, n7));
        Node n4 = new Node(4, Arrays.asList(n8));

        // Level 1
        Node n1 = new Node(1, Arrays.asList(n2, n3, n4));

        breadthFirstSearch(n1);

    }

    private void breadthFirstSearch(Node node) {

        int depth = depth(node);

        for (int i = 1; i <= depth; i++) {
            List<Node> nodesOnDepth = nodesOnDepth(node, i);
            for (Node nodeOnDepth : nodesOnDepth) {
                logger.info(nodeOnDepth.toString());
            }
        }

    }

    @Test
    public void testValuesOnDepth() {

        // Level 4
        Node n10 = new Node(10);
        Node n9 = new Node(9);

        // Level 3
        Node n5 = new Node(5, Arrays.asList(n9));
        Node n6 = new Node(6, Arrays.asList(n10));
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        // Level 2
        Node n2 = new Node(2, Arrays.asList(n5));
        Node n3 = new Node(3, Arrays.asList(n6, n7));
        Node n4 = new Node(4, Arrays.asList(n8));

        // Level 1
        Node n1 = new Node(3, Arrays.asList(n2, n3, n4));

        assertThat(nodesOnDepth(n1, 1), is(Arrays.asList(n1)));
        assertThat(nodesOnDepth(n1, 2), is(Arrays.asList(n2, n3, n4)));
        assertThat(nodesOnDepth(n1, 3), is(Arrays.asList(n5, n6, n7, n8)));
        assertThat(nodesOnDepth(n1, 4), is(Arrays.asList(n9, n10)));
    }

    private List<Node> nodesOnDepth(Node node, int depth) {

        List<Node> values = new LinkedList<>();

        if (depth == 1) {
            values.add(node);
        } else {
            if (node.getChildren() != null) {
                for (Node child : node.getChildren()) {
                    List<Node> current = nodesOnDepth(child, depth - 1);
                    if (current != null) {
                        values.addAll(current);
                    }
                }
            } else {
                return null;
            }
        }

        return values;

    }

    @Test
    public void testDepth() {

        // Level 4
        Node n10 = new Node(10);
        Node n9 = new Node(9);

        // Level 3
        Node n5 = new Node(5, Arrays.asList(n9));
        Node n6 = new Node(6, Arrays.asList(n10));
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        // Level 2
        Node n2 = new Node(2, Arrays.asList(n5));
        Node n3 = new Node(3, Arrays.asList(n6, n7));
        Node n4 = new Node(4, Arrays.asList(n8));

        // Level 1
        Node n1 = new Node(3, Arrays.asList(n2, n3, n4));

        assertThat(depth(n1), is(4));

        // Level 1
        Node n1_ = new Node(3);

        assertThat(depth(n1_), is(1));
    }

    private int depth(Node node) {

        int currentDepth = 0;

        if (node.getChildren() != null) {
            for (Node child : node.getChildren()) {
                currentDepth = Math.max(depth(child), currentDepth);
            }
        }

        return currentDepth + 1;

    }

    class Node {
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
}


