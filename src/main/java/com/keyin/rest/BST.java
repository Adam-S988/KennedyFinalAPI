package com.keyin.rest;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class BST {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> numbers;

    @Lob
    private String treeJson;

    public BST() {}

    public BST(List<Integer> numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<Integer> getNumbers() { return numbers; }
    public void setNumbers(List<Integer> numbers) { this.numbers = numbers; }

    public String getTreeJson() { return treeJson; }
    public void setTreeJson(String treeJson) { this.treeJson = treeJson; }

    //Test
}
