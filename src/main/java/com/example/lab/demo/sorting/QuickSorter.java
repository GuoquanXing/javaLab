package com.example.lab.demo.sorting;

public class QuickSorter {
    public void sort(int[] nums) {// 
		quickSortWithMedianAsPivot(nums, 0, nums.length - 1);
	}

	private void quickSortWithMedianAsPivot(int[] nums, int left, int right) {
		int pivotIndex = partition2(nums, left, right);
		if (left < pivotIndex - 1)
			quickSortWithMedianAsPivot(nums, left, pivotIndex - 1);
		if (pivotIndex < right)
			quickSortWithMedianAsPivot(nums, pivotIndex, right);
	}

	private int partition2(int[] nums, int low, int high) {
		int pivotValue = nums[(low + high) / 2];

		int left = low, right = high;

		while(left <= right){
			while(nums[left] < pivotValue) left++;
			while(nums[right] > pivotValue) right--;

			if(left <= right){
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] nums, int low, int high) {
		int tmp = nums[low];
		nums[low] = nums[high];
		nums[high] = tmp;
	}
    
}
