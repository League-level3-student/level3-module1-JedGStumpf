package _00_Intro_To_ArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class _02_GuestBook implements ActionListener{
	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addName = new JButton("Add Name");
	JButton viewNames = new JButton("View Names");
	
	
	public void setup() {

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.add(panel);
		panel.setPreferredSize(new Dimension(400, 400));
		
		panel.add(addName);
		panel.add(viewNames);
		
	}
	
	public void addNames() {
		String newName = JOptionPane.showInputDialog("Add Name Here");
		nameList.add(newName);
	}
	
	public String showName() {
		String names = "";
		
		for (String name : nameList) {
			names += name + "\n";
		}
		return names;
	}
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton)e.getSource();
		
		if (buttonClicked == addName) {
			addNames();
		}
		if (buttonClicked == viewNames) {
			JOptionPane.showMessageDialog(null, showName());
		}
	}

}
