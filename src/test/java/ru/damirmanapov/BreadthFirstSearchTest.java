package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.damirmanapov.BreadthFirstSearch.*;

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

}


