import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class BuildGUI {
	//Declare global variable
	private JFrame frame;
	private JButton btnStartTimer;
	private JLabel bubbleSortOutput, insertionSortOutput, selectionSortOutput, partitionSortOutput;
	private JTextField txtElementQty, txtMinValue, txtMaxValue;
	
	//Class Constructor
	public BuildGUI() {
		//Declare and Initialize the GUI's frame and panel
		frame = new JFrame("Sorting Algorithm Duration");
		JPanel panel = new JPanel();
		
		//Declare and Initialize the labels for the panel
		JLabel lblQty = new JLabel("Enter the amount of numbers to sort: ");
		JLabel lblRange = new JLabel("Enter the range of values");
		JLabel lblOpenBracket = new JLabel("[");
		JLabel lblComma = new JLabel(",");
		JLabel lblCloseBracket = new JLabel("]");
		JLabel lblMessage = new JLabel("* Measured in milliseconds *");
		JLabel lblBubbleSort = new JLabel("Bubble Sort Duration"), 
			   lblInsertionSort = new JLabel("Insertion Sort Duration"),
			   lblSelectionSort = new JLabel("Selection Sort Duration"),
			   lblPartitionSort = new JLabel("Partition Sort Duration");
		bubbleSortOutput = new JLabel();
		insertionSortOutput = new JLabel();
		selectionSortOutput = new JLabel();
		partitionSortOutput = new JLabel();
		
		//Initialize the font for square brackets
		Font bracketFont = new Font(null, Font.PLAIN, 20);
		
		//Set text label for element quantity input 
		lblQty.setBounds(17, 5, 250, 50);
		panel.add(lblQty);
		
		//Set text field for element quantity input
		txtElementQty = new JTextField();
		txtElementQty.setBounds(255, 17, 75, 30);
		txtElementQty.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtElementQty);
		
		//Set text label for element range input
		lblRange.setBounds(350, 17, 250, 30);
		panel.add(lblRange);
		
		//Set the open square bracket
		lblOpenBracket.setFont(bracketFont);
		lblOpenBracket.setBounds(512, 7, 30, 50);
		panel.add(lblOpenBracket);
		
		//Set the text field for max value
		txtMinValue = new JTextField();
		txtMinValue.setBounds(520, 18, 50, 30);
		txtMinValue.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtMinValue);
		
		//Set the text label for the comma
		lblComma.setBounds(575, 25, 25, 25);
		panel.add(lblComma);
		
		//Set the text field for min value
		txtMaxValue = new JTextField();
		txtMaxValue.setBounds(585, 18, 50, 30);
		txtMaxValue.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtMaxValue);
		
		//Set the open square bracket
		lblCloseBracket.setFont(bracketFont);
		lblCloseBracket.setBounds(637, 7, 30, 50);
		panel.add(lblCloseBracket);
		
		//Create the start button to time the algorithms
		btnStartTimer = new JButton("START");
		btnStartTimer.setBounds(295, 55, 80, 40);
		panel.add(btnStartTimer);
		
		//Set the text label for the message -- measured in in milliseconds
		lblMessage.setBounds(265, 100, 250, 25);
		lblMessage.setFont(new Font(null, Font.ITALIC, 12));
		panel.add(lblMessage);
		
		//Set the text label for bubble sort
		lblBubbleSort.setBounds(20, 115, 200, 50);
		panel.add(lblBubbleSort);
		
		//Set the text label for insertion sort
		lblInsertionSort.setBounds(170, 115, 200, 50);
		panel.add(lblInsertionSort);
		
		//Set the text label for selection sort
		lblSelectionSort.setBounds(335, 115, 200, 50);
		panel.add(lblSelectionSort);
		
		//Set the text label for partition sort
		lblPartitionSort.setBounds(500, 115, 200, 50);
		panel.add(lblPartitionSort);
		
		//Set the output label for bubble sort
		bubbleSortOutput.setBounds(22, 155, 125, 25);
		bubbleSortOutput.setHorizontalAlignment(JLabel.CENTER);
		bubbleSortOutput.setBackground(Color.white);
		bubbleSortOutput.setOpaque(true);
		bubbleSortOutput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(bubbleSortOutput);
		
		//Set the output label for insertion sort
		insertionSortOutput.setBounds(181, 155, 125, 25);
		insertionSortOutput.setHorizontalAlignment(JLabel.CENTER);
		insertionSortOutput.setBackground(Color.white);
		insertionSortOutput.setOpaque(true);
		insertionSortOutput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(insertionSortOutput);
		
		//Set the output label for selection sort
		selectionSortOutput.setBounds(346, 155, 125, 25);
		selectionSortOutput.setHorizontalAlignment(JLabel.CENTER);
		selectionSortOutput.setBackground(Color.white);
		selectionSortOutput.setOpaque(true);
		selectionSortOutput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(selectionSortOutput);
		
		//Set the output label for partition sort
		partitionSortOutput.setBounds(510, 155, 125, 25);
		partitionSortOutput.setHorizontalAlignment(JLabel.CENTER);
		partitionSortOutput.setBackground(Color.white);
		partitionSortOutput.setOpaque(true);
		partitionSortOutput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		panel.add(partitionSortOutput);
		
		//Set parameters for the panel
		setPanelParameters(panel);
				
		//Set parameters for the GUI's frame and add panel
		setFrameParameters(frame, panel);
	}
	
	//Getter Methods
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getButton() {
		return btnStartTimer;
	}
	
	public JTextField getElementQty() {
		return txtElementQty;
	}
	
	public JTextField getMinValue() {
		return txtMinValue;
	}
	
	public JTextField getMaxValue() {
		return txtMaxValue;
	}
	
	public JLabel getSortLabel(int sortNum) {
		if(sortNum == 1) {
			return bubbleSortOutput;
		}
		else if(sortNum == 2) {
			return insertionSortOutput;
		}
		else if(sortNum == 3) {
			return selectionSortOutput;
		}
		else if(sortNum == 4) {
			return partitionSortOutput;
		}
		
		return null;
	}
	
	//Setter Methods
	
	public void setSortColor(int sortNum, Color color) {
		if(sortNum == 1) {
			bubbleSortOutput.setBackground(color);
		}
		else if(sortNum == 2) {
			insertionSortOutput.setBackground(color);
		}
		else if(sortNum == 3) {
			selectionSortOutput.setBackground(color);
		}
		else if(sortNum == 4) {
			partitionSortOutput.setBackground(color);
		}
	}
	
	//Resets components to prepare for next 
	
	public void reset() {
		bubbleSortOutput.setText("");
		insertionSortOutput.setText("");
		selectionSortOutput.setText("");
		partitionSortOutput.setText("");
		
		bubbleSortOutput.setBackground(Color.white);
		insertionSortOutput.setBackground(Color.white);
		selectionSortOutput.setBackground(Color.white);
		partitionSortOutput.setBackground(Color.white);
	}
	
	//Set Frame and Panel parameters
	
	void setFrameParameters(JFrame frame, JPanel panel) {
		frame.setContentPane(panel);
		
		frame.setBounds(0, 0, 660, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void setPanelParameters(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
	}
}

