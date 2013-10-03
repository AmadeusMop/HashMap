package hashMap;

import java.awt.*;
import javax.swing.*;

public class Main {
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		HashMap2 hashMap = new HashMap2(SIZE);
		JFrame frame = new JFrame("Hash Map");
		JPanel grid = new JPanel(new GridLayout(1, SIZE));
		addEmptyLabelsToPanel(grid);
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		
		grid.add(label);
		grid.add(label2);
		grid.validate();
		System.out.println(grid);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(grid, BorderLayout.CENTER);
		frame.pack();
		label.setText("blueberry");
		label2.setText("raspberry");
		frame.setVisible(true);
	}
	
	public static void addEmptyLabelsToPanel(JPanel panel) {
		JLabel[] labels = createEmptyLabels();
		for(int i = 0; i < SIZE; i++) {
			labels[i].setText(Integer.toString(i));
			panel.add(labels[i]);
		}
	}
	
	public static JLabel[] createEmptyLabels() {
		JLabel[] output = new JLabel[SIZE];
		for(int i = 0; i < SIZE; i++) {
			output[i] = new JLabel();
		}
		return output;
	}
}