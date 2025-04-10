package com.keyin.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BSTNode {
    private int value;
    private BSTNode left;
    private BSTNode right;

    // Default constructor
    public BSTNode() {
    }

    // Constructor with value
    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public static class BinarySearchTreeService {

        public BSTNode buildTree(List<Integer> values) {
            BSTNode root = null;
            for (int val : values) {
                root = insert(root, val);
            }
            return root;
        }

        private BSTNode insert(BSTNode node, int value) {
            if (node == null) return new BSTNode(value);
            if (value < node.getValue()) node.setLeft(insert(node.getLeft(), value));
            else node.setRight(insert(node.getRight(), value));
            return node;
        }
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}