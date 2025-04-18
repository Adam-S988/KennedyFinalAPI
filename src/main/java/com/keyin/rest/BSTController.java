package com.keyin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bst")
public class BSTController {
    @Autowired
    private BSTService bstService;

    @PostMapping("/process-numbers")
    public ResponseEntity<BSTResponseDTO> processNumbers(@RequestBody BSTRequestDTO request) {
        BSTResponseDTO response = bstService.createAndStoreBST(request.getNumbers());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<List<BSTResponseDTO>> getPreviousTrees() {
        return ResponseEntity.ok(bstService.getAllTrees());
    }
}
