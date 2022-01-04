import java.awt.Color;
import java.lang.Thread;
import javax.swing.JLabel;

public class PartitionSort extends Thread{
	private BuildGUI gui;
	private Rank rank;
	private JLabel label;
	private int[] array;
	private final int sortNum = 4;
	
	public PartitionSort(int[] array, BuildGUI gui, Rank rank) { 
		this.gui = gui;
		this.rank = rank;
		this.array = array;
		this.label = gui.getSortLabel(sortNum);
	}
	
	public void run() {
		long startTime, endTime, duration;
		
		startTime = System.currentTimeMillis();
		partitionSort(array);
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		
		label.setText(Long.toString(duration));
		setRank();
	}
	
	public static void partitionSort(int[] array) {
		partitionSort(array, 0, array.length - 1);
	}
	
	public static void partitionSort(int[] array, int low, int high) {	
		if(low < high) {
			int pivot, left = low, right = high;
			pivot = array[left];
			
			while(left < right) {
				while(pivot < array[right] && left < right) {
					right--;
				}
			
				array[left] = array[right];
			
				while(pivot >= array[left] && left < right) {
					left++;
				}
			
				array[right] = array[left];
			}
			
			array[left] = pivot;
			
			partitionSort(array, low, left - 1);
			partitionSort(array, right + 1, high);
		}
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
