package hashMap;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	private static final int SIZE = 10;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new File(".").getAbsolutePath());
		Scanner inputFile = new Scanner(new File(".\\src\\hashMap\\inputFile.txt"));
		HashMap2 hashMap = new HashMap2(SIZE);
		JFrame frame = new JFrame("Hash Map");
		JPanel grid = new JPanel(new GridLayout(2, 0));
		String[] inputLines;
		for(int i = 0; i < SIZE; i++) {
			grid.add(new JLabel(Integer.toString(i)));
		}
		JPanel[] buckets = addBucketsToPanel(grid);
		grid.validate();
		
		while(inputFile.hasNextLine()) {
			inputLines = inputFile.nextLine().split(" ");
			if(inputLines.length < 2) {
				continue;
			}
			System.out.println(inputLines[0]);
			addToBucketsAndHashMap(inputLines[0], inputLines[1], hashMap, buckets);
		}
		inputFile.close();
		
		frame.setPreferredSize(new Dimension(640, 480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(grid);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void addToBucketsAndHashMap(String key, String val, HashMap2 hashMap, JPanel[] buckets) {
		hashMap.add(key, val);
		JPanel p = buckets[hashMap.getBucket(key)];
		p.add(new JLabel("<html>" + key + "<br>" + hashMap.get(key)));
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