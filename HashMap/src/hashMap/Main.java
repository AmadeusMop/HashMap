package hashMap;

import java.awt.*;
import javax.swing.*;

public class Main {
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		HashMap2 hashMap = new HashMap2(SIZE);
		JFrame frame = new JFrame("Hash Map");
		JPanel grid = new JPanel(new GridLayout(2, 0)), p;
		for(int i = 0; i < SIZE; i++) {
			grid.add(new JLabel(Integer.toString(i)));
		}
		JPanel[] buckets = addBucketsToPanel(grid);
		grid.validate();
		
		String str1 = "hello";
		hashMap.add(str1, "goodbye");
		p = buckets[hashMap.getBucket(str1)];
		p.add(new JLabel("<html>" + str1 + "<br>" + hashMap.get(str1)));
		
		frame.setPreferredSize(new Dimension(640, 480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(grid);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static JPanel[] addBucketsToPanel(JPanel panel) {
		JPanel[] panels = createEmptyBuckets();
		for(int i = 0; i < SIZE; i++) {
			panel.add(panels[i]);
		}
		return panels;
	}
	
	private static JPanel[] createEmptyBuckets() {
		JPanel[] output = new JPanel[SIZE];
		for(int i = 0; i < SIZE; i++) {
			output[i] = new JPanel(new GridLayout(0, 1));
		}
		return output;
	}
}