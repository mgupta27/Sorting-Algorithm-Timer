import java.awt.Color;
import java.lang.Thread;
import javax.swing.JLabel;

public class InsertionSort extends Thread{
	private BuildGUI gui;
	private Rank rank;
	private JLabel label;
	private int[] array;
	private final int sortNum = 2;
	
	public InsertionSort(int[] array, BuildGUI gui, Rank rank) {
		this.gui = gui;
		this.rank = rank;
		this.array = array;
		this.label = gui.getSortLabel(sortNum);
	}
	
	public void run() {
		long startTime, endTime, duration;
		int temp, j;
		
		startTime = System.currentTimeMillis();
		
		for(int i = 1; i < array.length - 1; i++) {
			temp = array[i];
			
			for(j = i - 1; j >= 0; j--) {
				if(temp < array[j]) {
					array[j + 1] = array[j];
				}
				else {
					break;
				}
			}
			
			array[j + 1] = temp;
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
