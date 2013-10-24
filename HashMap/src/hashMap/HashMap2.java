package hashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HashMap2 {
	private HashBucket[] map;
	private int size;
	
	/*
	 * Public methods specified in the assignment:
	 */
	
	public HashMap2(int size) {
		this.size = size;
		this.map = new HashBucket[size];
		for(int i = 0; i < size; i++) {
			map[i] = new HashBucket();
		}
	}
	
	public void set(String key, String value) {
		int hashedValue = hash(key);
		map[hashedValue].set(key, value);
	}
	

	public String get(String key) {
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
	
	public HashMap2() {
		this(10);
	}
	
	public boolean add(String key, String value) {
		int hashedValue = hash(key);
		return map[hashedValue].add(key, value);
	}
	
	public List<String> getValues() {
		List<String> valuesList = new ArrayList<String>();
		for(int i = 0; i < size; i++) {
			valuesList.addAll(map[i].getValues());
		}
		return valuesList;
	}
	
	public boolean exists(String key, String value) {
		int hashedValue = hash(key);
		return map[hashedValue].containsKeyValuePair(key, value);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(HashBucket bucket : map) {
			sb.append(bucket.toString());
		}
		sb.append("]");
		return sb.toString();
	}
}
