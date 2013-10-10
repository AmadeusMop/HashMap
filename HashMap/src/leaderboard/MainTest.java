package leaderboard;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void sortTest() {
		Entry[] elist, flist;

		elist = generateEntryList(new int[] {0, 1, 2, 3});
		assertArrayEquals("Already-sorted list", Main.mergeSort(elist), elist);
		
		elist = generateEntryList(new int[] {0, 2, 1, 3});
		flist = generateEntryList(new int[] {0, 1, 2, 3});
		assertArrayEquals("Unsorted list", Main.mergeSort(elist), flist);
		
		elist = generateEntryList(new int[] {0, 1, 2, 2, 3, 3});
		assertArrayEquals("Already-sorted list with duplicates", Main.mergeSort(elist), elist);
		
		elist = generateEntryList(new int[] {3, 0, 2, 1, 2, 3});
		flist = generateEntryList(new int[] {0, 1, 2, 2, 3, 3});
		assertArrayEquals("Unsorted list with duplicates", Main.mergeSort(elist), flist);
		
		elist = generateEntryList(new int[] {0, 1, 2, 3}, new String[] {"zero", "one", "two", "three"});
		assertArrayEquals("Already-sorted list with names", Main.mergeSort(elist), elist);
		
		elist = generateEntryList(new int[] {3, 0, 2, 1}, new String[] {"three", "zero", "two", "one"});
		flist = generateEntryList(new int[] {0, 1, 2, 3}, new String[] {"zero", "one", "two", "three"});
		assertArrayEquals("Unsorted list with names", Main.mergeSort(elist), flist);
		
		// This part also tests the bubbleSort() method.
		
		elist = generateEntryList(new int[] {0, 1, 1, 2, 3, 3}, new String[] {"zero", "one A", "one B", "two", "three A", "three B"});
		assertArrayEquals("Already-sorted list with names and duplicates", Main.mergeSort(elist), elist);
		
		elist = generateEntryList(new int[] {3, 0, 1, 3, 2, 1}, new String[] {"three B", "zero", "one A", "three A", "two", "one B"});
		flist = generateEntryList(new int[] {0, 1, 1, 2, 3, 3}, new String[] {"zero", "one A", "one B", "two", "three A", "three B"});
		assertArrayEquals("Unsorted list with names and duplicates", Main.mergeSort(elist), flist);
	}
	
	@Test
	public void bubbleSortTest() {
		String[] list = new String[] {"hello", "goodbye", "blueberry", "spam", "eggs", "foo"};
		String[] sorted = new String[] {"blueberry", "eggs", "foo", "goodbye", "hello", "spam"};
		
		assertArrayEquals("Bubble-sorting a String[]", Main.bubbleSort(list), sorted);
	}
	
	private Entry[] generateEntryList(int[] ilist, String[] slist) {
		assert(ilist.length == slist.length);
		int len = ilist.length;
		Entry[] output = new Entry[len];
		for(int i = 0; i < len; i++) {
			output[i] = new Entry(ilist[i], slist[i]);
		}
		return output;
	}
	
	private Entry[] generateEntryList(int[] l) {
		Entry[] output = new Entry[l.length];
		for(int i = 0; i < l.length; i++) {
			output[i] = new Entry(l[i], "A");
		}
		return output;
	}
}
