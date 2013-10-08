package leaderboard;

import hashMap.HashMap2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		HashMap2 hashMap = new HashMap2();
		int[] l = {1, 5, 3, 4, 2, 6, 9, 8, 7};
		System.out.println(Arrays.toString(mergeSort(l)));
	}
	
	private static int[] mergeSort(int[] list) {
		// Uses merge sort, and does not change the original array.
		if(list.length == 1) {
			return Arrays.copyOf(list, 1);
		} else {
			int[] list1 = Arrays.copyOfRange(list, list.length/2, list.length);
			int[] list2 = Arrays.copyOfRange(list, 0, list.length/2);
			return merge(list1, list2);
		}
	}
	
	private static int[] merge(int[] list1, int[] list2) {
		int[] output = new int[list1.length + list2.length];
		int pointer1 = 0;
		int pointer2 = 0;
		int i = 0;
		while(pointer1 < list1.length && pointer2 < list2.length) {
			if(list1[pointer1] < list2[pointer2]) {
				output[i] = list1[pointer1];
				pointer1++;
				i++;
				if(pointer1 >= list1.length) {
					for(int j = pointer2; j < list2.length; j++) {
						output[i] = list2[j];
						i++;
					}
				}
			} else {
				output[i] = list2[pointer2];
				pointer2++;
				i++;
				if(pointer2 >= list2.length) {
					for(int j = pointer1; j < list1.length; j++) {
						output[i] = list1[j];
						i++;
					}
				}
			}
		}
		return output;
	}
	
	private static String[] sortNames(String[] names) {
		// Uses bubble sort.
		return names;
	}
}
