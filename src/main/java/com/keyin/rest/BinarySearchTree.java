package com.keyin.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearchTree {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTree.class);
    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private BSTNode insertRecursive(BSTNode node, int value) {
        if (node == null) {
            return new BSTNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursive(node.getRight(), value));
        }

        return node;
    }

    public void buildBalancedBST(List<Integer> numbers) {
        logger.info("Building balanced BST with numbers: {}", numbers);

        if (numbers == null || numbers.isEmpty()) {
            logger.error("Numbers list is empty or null");
            return;
        }

        // Sort numbers
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        logger.info("Sorted numbers: {}", sortedNumbers);

        // Build balanced BST
        root = buildBalancedBSTHelper(sortedNumbers, 0, sortedNumbers.size() - 1);

        if (root != null) {
            logger.info("Root value: {}", root.getValue());
            logger.info("Left child: {}", (root.getLeft() != null ? root.getLeft().getValue() : "null"));
            logger.info("Right child: {}", (root.getRight() != null ? root.getRight().getValue() : "null"));
        } else {
            logger.error("Root is null after building BST");
        }
    }

    private BSTNode buildBalancedBSTHelper(List<Integer> sortedNumbers, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the middle element
        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(sortedNumbers.get(mid));
        logger.debug("Created node with value: {} (range: {}-{})", node.getValue(), start, end);

        // Recursively construct left and right subtrees
        node.setLeft(buildBalancedBSTHelper(sortedNumbers, start, mid - 1));
        node.setRight(buildBalancedBSTHelper(sortedNumbers, mid + 1, end));

        return node;
    }

    public String toJson() {
        try {
            if (root == null) {
                logger.error("Cannot generate JSON: root is null");
                return "{}";
            }

            ObjectMapper objectMapper = new ObjectMapper();
            // Wrap the root node in a "root" object to match the required format
            RootWrapper wrapper = new RootWrapper(root);
            String json = objectMapper.writeValueAsString(wrapper);
            logger.info("Generated JSON: {}", json);
            return json;
        } catch (Exception e) {
            logger.error("Error generating JSON", e);
            e.printStackTrace();
            return "{}";
        }
    }

    // Wrapper class to match the required format
    public static class RootWrapper {
        @JsonProperty("root")
        private BSTNode root;

        public RootWrapper() {
        }

        public RootWrapper(BSTNode root) {
            this.root = root;
        }

        public BSTNode getRoot() {
            return root;
        }

        public void setRoot(BSTNode root) {
            this.root = root;
        }
    }
}