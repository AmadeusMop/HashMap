package leaderboard;

public class Entry implements Comparable<Entry> {
	private int score;
	private String name;
	
	public Entry(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public Entry(int score, String name) {
		this.score = score;
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " " + score;
	}
	
	public int compareTo(Entry e) {
		int i = score - e.getScore();
		if(i == 0) return name.compareTo(e.getName());
		return i;
	}
	
	public boolean equals(Entry e) {
		return (score == e.getScore()) && (name.equals(e.getName()));
	}
	
	public boolean equals(Object o) {
		if(o instanceof Entry) {
			return equals((Entry)o);
		} else {
			return false;
		}
	}
}
