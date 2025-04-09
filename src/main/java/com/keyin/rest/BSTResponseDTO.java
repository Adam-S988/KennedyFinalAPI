package com.keyin.rest;

import java.util.List;

public class BSTResponseDTO {
    private Long id;
    private List<Integer> numbers;
    private String treeJson;

    // Default constructor
    public BSTResponseDTO() {
    }

    // Constructor with parameters
    public BSTResponseDTO(List<Integer> numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    // Constructor with all parameters
    public BSTResponseDTO(Long id, List<Integer> numbers, String treeJson) {
        this.id = id;
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }
}