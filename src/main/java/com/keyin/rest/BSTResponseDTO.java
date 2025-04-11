package com.keyin.rest;

import java.util.List;

public class BSTResponseDTO {
    private Long id;
    private List<Integer> numbers;
    private String treeJson;

    public BSTResponseDTO(List<Integer> numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    public BSTResponseDTO(Long id, List<Integer> numbers, String treeJson) {
        this.id = id;
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

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