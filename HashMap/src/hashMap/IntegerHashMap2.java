package hashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class IntegerHashMap2 {
	private IntegerHashBucket[] map;
	private int size;
	
	/*
	 * Public methods specified in the assignment:
	 */
	
	public IntegerHashMap2(int size) {
		this.size = size;
		this.map = new IntegerHashBucket[size];
		for(int i = 0; i < size; i++) {
			map[i] = new IntegerHashBucket();
		}
	}
	
	public void set(String key, int value) {
		int hashedValue = hash(key);
		map[hashedValue].set(key, value);
	}
	

	public int get(String key) {
		int hashedValue = hash(key);
		return map[hashedValue].getValue(key);
	}
	
	public List<String> getKeys() {
		List<String> keysArray = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			keysArray.addAll(map[i].getKeys());
		}
		Collections.sort(keysArray);
		return keysArray;
	}
	
	public boolean exists(String key) {
		int hashedValue = hash(key);
		return map[hashedValue].containsKey(key);
	}
	
	public int size() {
		return size;
	}
	
	public int getBucket(String key) {
		return hash(key);
	}
	
	/*
	 * Private methods specified in the assignment:
	 */
	
	private int hash(String input) {
		int output = 0;
		for(int i = 0; i < input.length(); i++) {
			output += (int)input.charAt(i);
		}
		output %= this.size;
		return output;
	}
	
	/*
	 * Public and private methods not specified in the assignment:
	 */
	
	public IntegerHashMap2() {
		this(10);
	}
	
	public void add(IntegerHashMap2 other) {
		List<String> otherKeys = other.getKeys();
		Iterator<String> iter = otherKeys.iterator();
		String s;
		
		while(iter.hasNext()) {
			s = iter.next();
			if(exists(s)) {
				set(s, get(s) + other.get(s));
			} else {
				set(s, other.get(s));
			}
		}
	}
	
	public boolean add(String key, int value) {
		int hashedValue = hash(key);
		return map[hashedValue].add(key, value);
	}
	
	public List<Integer> getValues() {
		List<Integer> valuesList = new ArrayList<Integer>();
		for(int i = 0; i < size; i++) {
			valuesList.addAll(map[i].getValues());
		}
		return valuesList;
	}
	
	public boolean exists(String key, int value) {
		int hashedValue = hash(key);
		return map[hashedValue].containsKeyValuePair(key, value);
	}
	
	public List<String> sortedKeys() { //Returns a List of ints, sorted based on their corresponding values. Uses insertion sort.
		List<String> keysList = getKeys();
		int index;
		int v;
		String s;
		for(int i = 0; i < keysList.size(); i++) {
			index = i;
			s = keysList.remove(i);
			v = get(s);
			for(int j = 0; j < i; j++) {
				if(v < get(keysList.get(j))) {
					index = j;
					break;
				}
			}
			keysList.add(index, s);
		}
		return keysList;
	}
	
	public List<String> reverseSortedKeys() { //Returns a List of type String, sorted based on their corresponding values. Uses insertion sort.
		List<String> keysList = getKeys();
		int index;
		int v;
		String s;
		for(int i = 0; i < keysList.size(); i++) {
			index = i;
			s = keysList.remove(i);
			v = getInt(s);
			for(int j = 0; j < i; j++) {
				if(v > getInt(keysList.get(j))) {
					index = j;
					break;
				}
			}
			keysList.add(index, s);
		}
		return keysList;
	}
	
	private int getInt(String s) {
		return get(s);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(IntegerHashBucket bucket : map) {
			sb.append(bucket.toString());
		}
		sb.append("]");
		return sb.toString();
	}
}
