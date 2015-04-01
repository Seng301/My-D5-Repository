//Author: David Lian 10135918 
//Version: April 03,2014

/*  Features:
    Saves the information in the text fields by calling the method from the MyFrame class
    then changes the title of the frame so the user knows that it has saved their information.
*/ 

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySaveButtonListener implements ActionListener
{	 
	public void actionPerformed (ActionEvent a)
	{      
		JButton aButton = (JButton) a.getSource();
		MyFrame aFrame = (MyFrame) aButton.getRootPane().getParent();
        aFrame.saveInfo();
        aFrame.setTitle("Saved order information");
	}
}