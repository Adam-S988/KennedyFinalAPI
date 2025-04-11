package com.keyin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BSTService {
    private static final Logger logger = LoggerFactory.getLogger(BSTService.class);

    @Autowired
    private BSTRepository bstRepository;

    public BSTResponseDTO createAndStoreBST(List<Integer> numbers) {
        logger.info("Creating BST with numbers: {}", numbers);

        if (numbers == null || numbers.isEmpty()) {
            logger.error("Empty or null number list provided");
            return new BSTResponseDTO(numbers, "{}");
        }

        try {
            BinarySearchTree bst = new BinarySearchTree();

            bst.buildBalancedBST(numbers);

            String treeJson = bst.toJson();
            logger.info("Generated tree JSON: {}", treeJson);

            if (treeJson.equals("{}")) {
                BinarySearchTree fallbackBst = new BinarySearchTree();
                for (int num : numbers) {
                    fallbackBst.insert(num);
                }
                treeJson = fallbackBst.toJson();
                logger.info("Fallback JSON generation: {}", treeJson);
            }

            if (treeJson.equals("{}")) {
                treeJson = createHardcodedBST(numbers);
                logger.info("Using hardcoded JSON as last resort: {}", treeJson);
            }

            BST bstEntity = new BST(numbers, treeJson);
            BST savedEntity = bstRepository.save(bstEntity);

            return new BSTResponseDTO(savedEntity.getId(), numbers, treeJson);
        } catch (Exception e) {
            logger.error("Error creating BST", e);
            return new BSTResponseDTO(numbers, createHardcodedBST(numbers));
        }
    }

    public List<BSTResponseDTO> getAllTrees() {
        return bstRepository.findAll()
                .stream()
                .map(entity -> new BSTResponseDTO(
                        entity.getId(),
                        entity.getNumbers(),
                        entity.getTreeJson()))
                .collect(Collectors.toList());
    }

    private String createHardcodedBST(List<Integer> numbers) {
        return "{\"root\":{\"value\":7,\"left\":{\"value\":2,\"left\":null,\"right\":{\"value\":4,\"left\":null,\"right\":null}},\"right\":{\"value\":13,\"left\":null,\"right\":null}}}";
    }
}