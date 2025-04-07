package com.keyin.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BSTNode {
    @JsonProperty("value")
    private int value;

    @JsonProperty("left")
    private BSTNode left;

    @JsonProperty("right")
    private BSTNode right;

    // Default constructor needed for Jackson
    public BSTNode() {
    }

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