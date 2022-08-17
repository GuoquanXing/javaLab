package com.example.lab.demo.searching;

public class BinarySearcher {

    public int search(int[] nums, int num) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == num) {
				return mid;
			} else if (nums[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
    
}
