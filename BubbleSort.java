import java.lang.Thread;
import javax.swing.JLabel;
import java.awt.Color;

public class BubbleSort extends Thread{
	//Declaration of class attributes
	private BuildGUI gui;
	private Rank rank;
	private JLabel label;
	private int[] array;
	private final int sortNum = 1;
	
	//Class Constructor
	public BubbleSort(int[] array, BuildGUI gui, Rank rank) {
		this.gui = gui;
		this.rank = rank;
		this.array = array;
		this.label = gui.getSortLabel(1);
	}
	
	public void run() {
		long startTime, endTime, duration;
		int temp;
		
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - 1 - i; j++) {
				if(array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		
		label.setText(Long.toString(duration));
		setRank();
	}
	
	public void setRank() {
		int place = rank.getPlacement();
		Color color ;
		
		rank.incrementPlacement();
		
		if(place == 1) {
			color = new Color(255, 215, 0);
		}
		else if(place == 2) {
			color = new Color(192, 192, 192);
		}
		else if(place == 3) {
			color = new Color(205, 127, 50);
		}
		else {
			color = new Color(255, 255, 255);
		}
		
		gui.setSortColor(sortNum, color);
	}
}
