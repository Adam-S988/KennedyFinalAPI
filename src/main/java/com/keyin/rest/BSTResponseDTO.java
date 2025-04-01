package com.keyin.rest;

import java.util.List;

public class BSTResponseDTO {
    private List<Integer> numbers;
    private String treeJson;

    public BSTResponseDTO(List<Integer> numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    public List<Integer> getNumbers() { return numbers; }
    public void setNumbers(List<Integer> numbers) { this.numbers = numbers; }

    public String getTreeJson() { return treeJson; }
    public void setTreeJson(String treeJson) { this.treeJson = treeJson; }
}
