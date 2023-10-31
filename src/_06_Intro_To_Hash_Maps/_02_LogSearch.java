package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> logs = new HashMap<Integer, String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Entry");
	JButton button2 = new JButton("Search by ID");
	JButton button3 = new JButton("View List");
	JButton button4 = new JButton("Remove Entry");
	
	
	
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.setUp();
		
	
	}
	
	public void setUp() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(500, 500));
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setSize(new Dimension(500, 500));
		button1.setPreferredSize(new Dimension(100, 100));
		button2.setPreferredSize(new Dimension(100, 100));
		button3.setPreferredSize(new Dimension(100, 100));
		button4.setPreferredSize(new Dimension(100, 100));
		
		frame.add(panel);
		panel.add(button1);
		button1.addActionListener(this);
		panel.add(button2);
		button2.addActionListener(this);
		panel.add(button3);
		button3.addActionListener(this);
		panel.add(button4);
		button4.addActionListener(this);
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public Integer inputID() {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Enter a new ID:"));
//		String name = JOptionPane.showInputDialog("Enter a new Name");
		
		return id;
//		
//		logs.put(id, name);
	}
	
	public String inputName() {
		String name = JOptionPane.showInputDialog("Enter a new Name");
		
		return name;
	}
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		
		if (buttonPressed == button1) {
			Integer id = Integer.valueOf(JOptionPane.showInputDialog("Enter a new ID:"));
			String name = JOptionPane.showInputDialog("Enter a new Name");
//			
//			Integer id = inputID();
//			String name = inputName();
			logs.put(id, name);
//			input();
			System.out.println("UGH");
			
		} 
		
		if (buttonPressed == button2) {
			Integer id = Integer.valueOf(JOptionPane.showInputDialog("Enter a new ID:"));
			try {
				JOptionPane.showMessageDialog(null, logs.get(id));
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "ID " + id + " Does not exist");
			}
				
			
			
		} 
		
		if (buttonPressed == button3) {
			String list = "";
			for (Integer i : logs.keySet()) {
				list += "ID: " + i + " Name: " + logs.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		} 
		
		if (buttonPressed == button4) {
			
			
		}
		
	}

}
