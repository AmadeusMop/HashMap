
public class HashMap2 {
	private HashBucket[] map;
	private int size;
	
	public HashMap2(int size) {
		this.size = size;
		this.map = new HashBucket[size];
		for(int i = 0; i < size; i++) {
			map[i] = new HashBucket();
		}
	}
	
	public HashMap2() {
		this(10);
	}
	
	private int hash(String input) {
		int output = 0;
		for(int i = 0; i < input.length(); i++) {
			output += (int)input.charAt(i);
		}
		output %= this.size;
		return output;
	}
	
	public boolean add(String key, String value) {
		int hashedValue = hash(key);
		return map[hashedValue].add(key, value);
	}
	
	public boolean set(String key, String value) {
		int hashedValue = hash(key);
		return map[hashedValue].set(key, value);
	}
	
	public String getValue(String key) {
		int hashedValue = hash(key);
		return map[hashedValue].getValue(key);
	}
	
	
	public HashBucket getBucket(int index) {
		return map[index];
	}
	
	public boolean contains(String key) {
		int hashedValue = hash(key);
		return map[hashedValue].containsKey(key);
	}
	
	public boolean contains(String key, String value) {
		int hashedValue = hash(key);
		return map[hashedValue].containsKeyValuePair(key, value);
	}
}
