import java.lang.Thread;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class StartTimer implements ActionListener{
	//Declare global variables
	private BuildGUI gui;
	private JButton btnStartTimer;
	private JTextField elementQty, minValue, maxValue;
	private int[] numberSet;
	
	//Class Constructor
	StartTimer(){
		gui = new BuildGUI();
		
		elementQty = gui.getElementQty();
		minValue = gui.getMinValue();
		maxValue = gui.getMaxValue();
		btnStartTimer = gui.getButton();
		
		btnStartTimer.addActionListener(this);
	}

	//Action Listener inherited method -- code executed when the button is clicked
	public void actionPerformed(ActionEvent e) {
		//Ensures an input exists and is valid
		if( (checkInputs(elementQty)) && (checkInputs(minValue)) && (checkInputs(maxValue)) ) {
			
			//Converts the input to integer type
			int qty = Integer.parseInt(elementQty.getText());
			int min = Integer.parseInt(minValue.getText());
			int max = Integer.parseInt(maxValue.getText());
			
			//Ensures that the inputted integers are valid
			if( (max >= min) && (qty > 1) ) {
				createArray(qty, min, max);
				start();
			}
			else {
				//Sends error message if the max value is less then the min value
				if(max <= min) {
					JOptionPane.showMessageDialog(gui.getFrame(), "The maximum value must be greater than minimum value.", "Invalid Inputs", JOptionPane.ERROR_MESSAGE);
					minValue.setText("");
					minValue.setBackground(Color.pink);
					minValue.requestFocus();
				
					maxValue.setText("");
					maxValue.setBackground(Color.pink);
				}
				//Sends error message if the element quantity is less than 1
				else{
					JOptionPane.showMessageDialog(gui.getFrame(), "The quantity must be greater than 1.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
					elementQty.setText("");
					elementQty.setBackground(Color.pink);
					elementQty.requestFocus();
				}
			}
		}
	}
	
	//Initializes the array and assigns random values within the range to each element
	public void createArray(int qty, int min, int max) {
		numberSet = new int[qty];
		
		for(int element = 0; element < numberSet.length; element++) {
			numberSet[element] = (int)(Math.random() * (max - min + 1) + min);
		}
	}
	
	//Initializes the sorting algorithms objects and starts the timer
	public void start() {
		Rank rank = new Rank();
		
		gui.reset();
		
		Thread bubbleSort = new BubbleSort(numberSet, gui, rank);
		bubbleSort.setDaemon(true);
		Thread insertionSort = new InsertionSort(numberSet, gui, rank);
		insertionSort.setDaemon(true);
		Thread selectionSort = new SelectionSort(numberSet, gui, rank);
		selectionSort.setDaemon(true);
		Thread partitionSort = new PartitionSort(numberSet, gui, rank);
		partitionSort.setDaemon(true);
		
		bubbleSort.start();
		selectionSort.start();
		insertionSort.start();
		partitionSort.start();
	}
	
	//Checks the text fields input to ensure its filled and an integer is entered
	public boolean checkInputs(JTextField field) {
		try {
			Integer.parseInt(field.getText());
			field.setBackground(Color.white);
			return true;
		}
		catch(NumberFormatException nfe) {
			field.setText("");
			field.setBackground(Color.pink);
			field.requestFocus();
			return false;
		}
	}
}
