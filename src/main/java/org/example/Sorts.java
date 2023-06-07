package org.example;

public class Sorts {

	public static int[] bubbleSort(int[] arr){
		int replInt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					replInt = arr[j + 1];
					arr[j+1] = arr[j];
					arr[j] = replInt;
				}
			}
		}
		return arr;
	}
	public static int[] selectionSort(int[] arr){
		int replInt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int minElementIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minElementIndex]) {
					minElementIndex = j;
				}
			}
			replInt = arr[minElementIndex];
			arr[minElementIndex] = arr[i];
			arr[i] = replInt;
		}
		return arr;
	}
	public static int[] insertionSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] >= temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
		return arr;
	}

	public static Integer[] insertionSort(Integer[] arr){
		for (int i = 1; i < arr.length; i++) {
			Integer temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] >= temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
		return arr;
	}
}
