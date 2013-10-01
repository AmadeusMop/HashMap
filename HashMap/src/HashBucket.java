import java.util.ArrayList;
import java.util.List;


public class HashBucket {
	private List<String> bucket;
	
	public HashBucket() {
		this.bucket = new ArrayList<String>();
	}
	
	public boolean add(String input) {
		return bucket.add(input);
	}
	
	public boolean remove(String input) {
		return bucket.remove(input);
	}
	
	public boolean contains(String input) {
		return bucket.contains(input);
	}
}
