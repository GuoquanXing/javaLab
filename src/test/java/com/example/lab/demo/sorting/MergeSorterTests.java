package com.example.lab.demo.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSorterTests {

    @Test
	void testMergeSort() {

        MergeSorter sorter = new MergeSorter();

		int[] sortesorterrray = { 1, 2, 3, 4, 5, 6 };

		int[] array = { 1, 3, 4, 2, 6, 5 };
		sorter.sort(array);
		assertEquals(Arrays.toString(sortesorterrray), Arrays.toString(array));
		assertEquals(true, Arrays.equals(array, sortesorterrray));

		int[] array1 = { 1, 4, 3, 2, 6, 5 };
		sorter.sort(array1);
		assertEquals(true, Arrays.equals(array1, sortesorterrray));

		int[] array2 = { 1, 4, 3, 2, 5, 6 };
		sorter.sort(array2);
		assertEquals(true, Arrays.equals(array2, sortesorterrray));

		int[] array3 = { 6, 5, 1, 4, 2, 3 };
		sorter.sort(array3);
		assertEquals(true, Arrays.equals(array3, sortesorterrray));

		int[] array4 = { 3, 4, 2, 2, 5 };
		sorter.sort(array4);
		assertEquals(true, Arrays.equals(array4, new int[] { 2, 2, 3, 4, 5 }));

		int[] array5 = { 3, 4, 1, 2, 5, 6 };
		sorter.sort(array5);
		assertEquals(true, Arrays.equals(array5, sortesorterrray));
	}
    
}
