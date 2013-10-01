
public class HashMap2 {
	private HashBucket[] map;
	private int size;
	
	public HashMap2(int size) {
		this.size = size;
		this.map = new HashBucket[size];
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
	
	public boolean add(String input) {
		//boolean because that's what List.add() returns.
		//It seems bad to throw away data like that.
		int hashedValue = hash(input);
		return map[hashedValue].add(input);
	}
	
	public boolean remove(String input) { 
		//boolean because that's what List.remove() returns.
		//It seems bad to throw away data like that.
		int hashedValue = hash(input);
		return map[hashedValue].remove(input);
	}
	
	public HashBucket getBucket(int index) {
		return map[index];
	}
	
	public boolean exists(String input) {
		int hashedValue = hash(input);
		return map[hashedValue].contains(input);
	}
}
