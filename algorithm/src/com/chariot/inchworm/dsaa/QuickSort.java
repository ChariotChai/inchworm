package com.chariot.inchworm.dsaa;

import java.util.Collections;

public class QuickSort {

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length);
	}

	private void quickSort(int[] arr, int gte, int lt) {
		if (lt - 1 < gte) {
			return;
		}

		int mi = partition(arr, gte, lt);
		quickSort(arr, gte, mi);
		quickSort(arr, mi + 1, lt);
	}

	private int partition(int[] arr, int gte, int lt) {
		int pivot = arr[gte];
		int crit = gte;

		for (int i = gte + 1; i < lt; i++) {
			if (arr[i] <= pivot) {
                crit++;
                swap(arr, i, crit);
			}
		}

		swap(arr, gte, crit);

		return crit;
	}

	private void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

    public static void main(String[] args) {
//	    int[] arr = new int[]{1, 3, 2, 5, 4};
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(arr);
//
//        for (int i: arr) {
//            System.out.print(i + ", ");
//        }

		int a = -2147483648;
		System.out.println(-a);
    }

}