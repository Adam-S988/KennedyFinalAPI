package com.keyin.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private BSTNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private BSTNode insertRecursive(BSTNode node, int value) {
        if (node == null) {
            return new BSTNode(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(root);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}

class BSTNode {
    int value;
    BSTNode left, right;

    public BSTNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}
