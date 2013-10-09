package leaderboard;

public class Entry {
	private int score;
	private String name;
	
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
}
