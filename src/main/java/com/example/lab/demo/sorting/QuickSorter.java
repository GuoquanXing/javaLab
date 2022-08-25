package com.example.lab.demo.sorting;

public class QuickSorter {
    

	public void sort1(int[] nums){
		quickSortWithLowAsPivot(nums, 0, nums.length - 1);
	}

	public void sort2(int[] nums) {// 
		quickSortWithMedianAsPivot(nums, 0, nums.length - 1);
	}

	private void quickSortWithLowAsPivot(int[] nums, int low, int high) {
		if(low >= high) return;
		int pivotIndex = partion1(nums, low, high);
		quickSortWithLowAsPivot(nums, low, pivotIndex - 1);
		quickSortWithLowAsPivot(nums, pivotIndex + 1, high);
	}

	private int partion1(int[] nums, int low, int high) {
		int pivotValue = nums[low];

		int left = low + 1, right = high;

		while(left <= right){
			while(left <= high && nums[left] <= pivotValue){
				left++;
			}
			while(right >= low && nums[right] > pivotValue){
				right--;
			}
			if(left < right){
				swap(nums, left, right);
			}
		}
		swap(nums, low, right);
		return right;
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
