package com.example.lab.demo.sorting;

public class MergeSorter {

    public void sort(int[] numbs){
        mergeSort(numbs, 0, numbs.length - 1);
    }

    private void mergeSort(int[] numbs, int start, int end){
        if(start == end) return;

		int mid = start + (end - start) / 2;

		mergeSort(numbs, start, mid);
		mergeSort(numbs, mid + 1, end);

		merge(numbs, start, mid, end);
	}

	private void merge(int[] numbs, int lo, int mid, int hi) {

		int leftLength = mid - lo + 1, rightLength = hi - mid;
		int l[] = new int[leftLength], r[] = new int[rightLength];

		// fill tmp array for left
		for(int i = 0; i < leftLength; i++){
			l[i] = numbs[lo + i];
		}
		// fill tmp array for right
		for (int i = 0; i < rightLength; i++) {
			r[i] = numbs[mid + 1 + i];
		}
		
		int left = 0, right = 0;
		// initial index of merged sub-array
		int k = lo;

		while(left < leftLength && right < rightLength){
			if(l[left] <= r[right]){
				numbs[k] = l[left++];
			}else{
				numbs[k] = r[right++];
			}
			k++;
		}
		// copy remaining left
		while(left < leftLength){
			numbs[k] = l[left++];
			k++;
		}
		// copy remaining right
		while(right < rightLength){
			numbs[k] = r[right++];
			k++;
		}
	}
    
}
