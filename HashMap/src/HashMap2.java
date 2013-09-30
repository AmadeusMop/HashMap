import java.util.ArrayList;
import java.util.List;


public class HashMap2 {
	private List<String>[] map;
	private int size;
	
	@SuppressWarnings("unchecked")
	public HashMap2(int size) {
		this.size = size;
		this.map = (ArrayList<String>[]) new ArrayList[size];
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
	
	public boolean contains(String input) {
		int hashedValue = hash(input);
		return map[hashedValue].contains(input);
	}
}
