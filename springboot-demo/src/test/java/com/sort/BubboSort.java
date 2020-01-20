package com.sort;

import java.util.Arrays;

public class BubboSort {
	public static void main(String[] args) {
		int[] arr = {5, 8, 6, 5, 4, 3, 7, 89, 76, 34, 98, 56};
		int arrlength = arr.length;
		for (int i = 0; i < arrlength - 1; i++) {
			for (int j = 0; j < arrlength - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		int m = 100 << 1;
		System.out.println(m);
	}
}
