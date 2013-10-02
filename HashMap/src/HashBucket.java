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
	
	public List<String> getKeys() {
		List<String> keysList = new ArrayList<String>();
		iter = bucket.iterator();
		while(iter.hasNext()) {
			keysList.add(iter.next().getKey());
		}
		return keysList;
	}
	
	public List<String> getValues() {
		List<String> valuesArray = new ArrayList<String>();
		iter = bucket.iterator();
		while(iter.hasNext()) {
			valuesArray.add(iter.next().getValue());
		}
		return valuesArray;
	}
	
	public void set(String key, String value) {
		set(new KeyValuePair(key, value));
	}
	
	private void set(KeyValuePair input) {
		KeyValuePair kvp = getKeyValuePair(input.getKey());
		if(kvp != null) {
			kvp.setValue(input.getValue());
		} else {
			bucket.add(input);
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
