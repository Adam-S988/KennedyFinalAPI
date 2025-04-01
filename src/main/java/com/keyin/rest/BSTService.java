package com.keyin.rest;

import com.keyin.rest.BSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BSTService {
    @Autowired
    private BSTRepository bstRepository;

    public BSTResponseDTO createAndStoreBST(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);

        BST bstEntity = new BST(numbers, bst.toJson());
        bstRepository.save(bstEntity);

        return new BSTResponseDTO(numbers, bst.toJson());
    }

    public List<BSTResponseDTO> getAllTrees() {
        return bstRepository.findAll()
                .stream()
                .map(entity -> new BSTResponseDTO(entity.getNumbers(), entity.getTreeJson()))
                .collect(Collectors.toList());
    }
}
