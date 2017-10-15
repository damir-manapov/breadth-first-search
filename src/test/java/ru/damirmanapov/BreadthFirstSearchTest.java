package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.BreadthFirstSearch.breadthFirstSearch;
import static ru.damirmanapov.BreadthFirstSearch.depth;
import static ru.damirmanapov.BreadthFirstSearch.nodesOnDepth;

@Test
public class BreadthFirstSearchTest {

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

        assertThat(breadthFirstSearch(n1), is(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10)));

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

}


