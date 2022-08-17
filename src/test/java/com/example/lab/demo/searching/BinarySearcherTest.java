package com.example.lab.demo.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearcherTest {

    @Test
	void testBinarySearch() {
		BinarySearcher searcher = new BinarySearcher();
		int[] nums = { 1, 2, 3, 4, 5, 6 };

		int index = searcher.search(nums, 3);
		assertEquals(2, index);

		index = searcher.search(nums, 7);
		assertEquals(-1, index);

		index = searcher.search(nums, 6);
		assertEquals(5, index);

		index = searcher.search(nums, 1);
		assertEquals(0, index);

	}
    
}
