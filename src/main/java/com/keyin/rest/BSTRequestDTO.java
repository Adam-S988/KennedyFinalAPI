package com.keyin.rest;

import java.util.List;

public class BSTRequestDTO {
    private List<Integer> numbers;

    // Default constructor
    public BSTRequestDTO() {
    }

    // Constructor with parameters
    public BSTRequestDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // Getter and setter
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}