package leaderboard;

import hashMap.HashMap2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		//HashMap2 hashMap = new HashMap2();
		int[] l = {1, 5, 3, 4, 2, 6, 9, 8, 6, 6, 3, 5, 9, 7};
		Entry[] elist = mergeSort(l);
		for(Entry e : elist) {
			System.out.println(e.toString() + " ");
		}
	}
	
	public static Entry[] mergeSort(int[] list) { //For testing only
		Entry[] input = new Entry[list.length];
		for(int i = 0; i < list.length; i++) {
			input[i] = new Entry(list[i], "Hello" + i%10);
		}
		return mergeSort(input);
	}
	
	public static Entry[] mergeSort(Entry[] list) {
		// Uses merge sort, and does not change the original array.
		if(list.length == 1) {
			return Arrays.copyOf(list, 1);
		} else {
			Entry[] list1 = Arrays.copyOfRange(list, list.length/2, list.length);
			Entry[] list2 = Arrays.copyOfRange(list, 0, list.length/2);
			return merge(mergeSort(list1), mergeSort(list2));
		}
	}
	
	private static Entry[] merge(Entry[] list1, Entry[] list2) {
		Entry[] output = new Entry[list1.length + list2.length];
		int p1 = 0, p2 = 0;
		for(int i = 0; i < output.length; i++) {
			if(p2 >= list2.length) {
				output[i] = list1[p1];
				p1++;
			} else if(p1 >= list1.length || list1[p1].getScore() > list2[p2].getScore()) {
				output[i] = list2[p2];
				p2++;
			} else if(list1[p1].getScore() < list2[p2].getScore()) {
				output[i] = list1[p1];
				p1++;
			} else if(list1[p1].getScore() == list2[p2].getScore()) {
				Entry[] sortedByName = bubbleSort(new Entry[] {list1[p1], list2[p2]});
				output[i] = sortedByName[0];
				output[i+1] = sortedByName[1];
				p1++;
				p2++;
				i++;
			} else {
				System.out.println("Error!");
				break; // Something has gone horribly wrong.
			}
		}
		return output;
	}
	
	public static String[] bubbleSort(String[] names) { //For testing only
		String temp;
		boolean isSorted;
		do {
			isSorted = true;
			for(int i = 1; i < names.length; i++) {
				if(names[i-1].compareTo(names[i]) > 0) {
					temp = names[i-1];
					names[i-1] = names[i];
					names[i] = temp;
					isSorted = false;
				}
			}
		} while(!isSorted);
		return names;
	}
	
	private static Entry[] bubbleSort(Entry[] names) {
		Entry temp;
		boolean isSorted;
		do {
			isSorted = true;
			for(int i = 1; i < names.length; i++) {
				if(names[i-1].getName().compareTo(names[i].getName()) > 0) {
					temp = names[i-1];
					names[i-1] = names[i];
					names[i] = temp;
					isSorted = false;
				}
			}
		} while(!isSorted);
		return names;
	}
}
