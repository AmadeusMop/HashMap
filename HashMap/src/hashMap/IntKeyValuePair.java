package hashMap;

public class IntKeyValuePair implements Comparable<IntKeyValuePair> {
	private String key;
	private int value;
	
	public IntKeyValuePair(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return key + ", " + Integer.toString(value);
	}
	
	public int compareTo(IntKeyValuePair other) {
		return value - other.getValue();
	}
}
