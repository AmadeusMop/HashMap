package hashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IntegerHashBucket {
	private List<IntKeyValuePair> bucket;
	private Iterator<IntKeyValuePair> iter;
	
	public IntegerHashBucket() {
		this.bucket = new ArrayList<IntKeyValuePair>();
	}
	
	public boolean add(String key, int value) {
		return add(new IntKeyValuePair(key, value));
	}
	
	private boolean add(IntKeyValuePair input) {
		if(containsKey(input.getKey())) {
			return false;
		} else {
			bucket.add(input);
			return true;
		}
	}
	
	List<IntKeyValuePair> getKeyValuePairs() {
		List<IntKeyValuePair> kvpList = new ArrayList<IntKeyValuePair>();
		iter = bucket.iterator();
		while(iter.hasNext()) {
			kvpList.add(iter.next());
		}
		return kvpList;
	}
	
	public List<String> getKeys() {
		List<String> keysList = new ArrayList<String>();
		iter = bucket.iterator();
		while(iter.hasNext()) {
			keysList.add(iter.next().getKey());
		}
		return keysList;
	}
	
	public List<Integer> getValues() {
		List<Integer> valuesArray = new ArrayList<Integer>();
		iter = bucket.iterator();
		while(iter.hasNext()) {
			valuesArray.add(iter.next().getValue());
		}
		return valuesArray;
	}
	
	public void set(String key, int value) {
		set(new IntKeyValuePair(key, value));
	}
	
	private void set(IntKeyValuePair input) {
		IntKeyValuePair kvp = getIntKeyValuePair(input.getKey());
		if(kvp != null) {
			kvp.setValue(input.getValue());
		} else {
			bucket.add(input);
		}
	}
	
	public int getValue(String key) {
		if(containsKey(key)) {
			return getIntKeyValuePair(key).getValue();
		} else {
			return 0;
		}
	}
		
	private IntKeyValuePair getIntKeyValuePair(String key) {
		IntKeyValuePair kvp;
		iter = bucket.iterator();
		while(iter.hasNext()) {
			kvp = iter.next();
			if(kvp.getKey().equals(key)) {
				return kvp;
			}
		}
		return null;
	}
	
	public boolean containsKey(String key) {
		return getIntKeyValuePair(key) != null;
	}
	
	public boolean containsKeyValuePair(String key, int value) {
		return containsKeyValuePair(new IntKeyValuePair(key, value));
	}
	
	private boolean containsKeyValuePair(IntKeyValuePair input) {
		IntKeyValuePair kvp = getIntKeyValuePair(input.getKey());
		if(kvp != null) {
			return input.getValue() == kvp.getValue();
		} else {
			return false;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		iter = bucket.iterator();
		while(iter.hasNext()) {
			sb.append("(");
			sb.append(iter.next().toString());
			sb.append(")");
			if(iter.hasNext()) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
