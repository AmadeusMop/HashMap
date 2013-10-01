import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HashBucket {
	private List<KeyValuePair> bucket;
	private Iterator<KeyValuePair> iter;
	
	public HashBucket() {
		this.bucket = new ArrayList<KeyValuePair>();
	}
	
	public boolean add(String key, String value) {
		return add(new KeyValuePair(key, value));
	}
	
	private boolean add(KeyValuePair input) {
		if(containsKey(input.getKey())) {
			return false;
		} else {
			bucket.add(input);
			return true;
		}
	}
	
	public boolean set(String key, String value) {
		return set(new KeyValuePair(key, value));
	}
	
	private boolean set(KeyValuePair input) {
		KeyValuePair kvp = getKeyValuePair(input.getKey());
		if(kvp != null) {
			kvp.setValue(input.getValue());
			return false;
		} else {
			bucket.add(input);
			return true;
		}
	}
	
	public String getValue(String key) {
		if(containsKey(key)) {
			return getKeyValuePair(key).getValue();
		} else {
			return null;
		}
	}
		
	private KeyValuePair getKeyValuePair(String key) {
		KeyValuePair kvp;
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
		return getKeyValuePair(key) != null;
	}
	
	public boolean containsKeyValuePair(String key, String value) {
		return containsKeyValuePair(new KeyValuePair(key, value));
	}
	
	private boolean containsKeyValuePair(KeyValuePair input) {
		KeyValuePair kvp = getKeyValuePair(input.getKey());
		if(kvp != null) {
			return input.getValue().equals(kvp.getValue());
		} else {
			return false;
		}
	}
}
