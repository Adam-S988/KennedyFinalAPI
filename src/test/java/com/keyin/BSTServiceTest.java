package com.keyin;

import com.keyin.rest.BST;
import com.keyin.rest.BSTRepository;
import com.keyin.rest.BSTResponseDTO;
import com.keyin.rest.BSTService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BSTServiceTest {

    @Mock
    private BSTRepository bstRepository;

    @InjectMocks
    private BSTService bstService;

    public BSTServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTreesReturnsCorrectDTOs() {
        BST tree1 = new BST(Arrays.asList(1, 2, 3), "{\"root\":{\"value\":2}}");
        BST tree2 = new BST(Arrays.asList(4, 5, 6), "{\"root\":{\"value\":5}}");
        tree1.setId(1L);
        tree2.setId(2L);

        when(bstRepository.findAll()).thenReturn(Arrays.asList(tree1, tree2));

        List<BSTResponseDTO> result = bstService.getAllTrees();

        assertEquals(2, result.size());

        assertEquals(1L, result.get(0).getId());
        assertEquals(Arrays.asList(1, 2, 3), result.get(0).getNumbers());
        assertEquals("{\"root\":{\"value\":2}}", result.get(0).getTreeJson());

        assertEquals(2L, result.get(1).getId());
        assertEquals(Arrays.asList(4, 5, 6), result.get(1).getNumbers());
        assertEquals("{\"root\":{\"value\":5}}", result.get(1).getTreeJson());
    }
}
