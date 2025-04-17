package com.keyin;

import com.keyin.rest.BSTNode;
import com.keyin.rest.BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTest {

    @Test
    void testCreateBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();

        List<Integer> input = Arrays.asList(10, 5, 15, 3, 7);

        for (int value : input) {
            tree.insert(value);
        }

        BSTNode root = tree.getRoot();

        assertEquals(10, root.getValue());
        assertEquals(5, root.getLeft().getValue());
        assertEquals(15, root.getRight().getValue());
        assertEquals(3, root.getLeft().getLeft().getValue());
        assertEquals(7, root.getLeft().getRight().getValue());
    }

    @Test
    void testCreateBinarySearchTreeWithAnotherSet() {
        BinarySearchTree tree = new BinarySearchTree();

        List<Integer> input = Arrays.asList(5, 2, 8, 1, 3);

        for (int value : input) {
            tree.insert(value);
        }

        BSTNode root = tree.getRoot();

        assertEquals(5, root.getValue());
        assertEquals(2, root.getLeft().getValue());
        assertEquals(8, root.getRight().getValue());
        assertEquals(1, root.getLeft().getLeft().getValue());
        assertEquals(3, root.getLeft().getRight().getValue());
    }

    @Test
    void testBuildBalancedBST_structureMatchesActualTree() {
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> input = Arrays.asList(7, 3, 9, 1, 5);

        tree.buildBalancedBST(input);
        BSTNode root = tree.getRoot();

        assertEquals(5, root.getValue());

        BSTNode left = root.getLeft();
        assertNotNull(left);
        assertEquals(1, left.getValue());
        assertNotNull(left.getRight());
        assertEquals(3, left.getRight().getValue());

        BSTNode right = root.getRight();
        assertNotNull(right);
        assertEquals(7, right.getValue());
        assertNotNull(right.getRight());
        assertEquals(9, right.getRight().getValue());
    }

    @Test
    void testSearchInBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();

        List<Integer> input = Arrays.asList(20, 10, 30, 5, 15, 25, 35);

        for (int value : input) {
            tree.insert(value);
        }

        // Test searching for values that exist
        assertNotNull(tree.search(20));
        assertNotNull(tree.search(10));
        assertNotNull(tree.search(35));

        // Test searching for values that don't exist
        assertEquals(null, tree.search(0));
        assertEquals(null, tree.search(40));
    }

}
