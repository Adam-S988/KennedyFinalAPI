package com.keyin.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

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