//Author: David Lian 10135918 
//Version: April 03,2014

/*  Features: 
    Clears the text fields by setting their text in their fields to a empty string by calling the method
    from the MyFrame class 
*/

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClearButtonListener implements ActionListener
{
	public void actionPerformed (ActionEvent a)
    {
        JButton aButton = (JButton) a.getSource();
		MyFrame aFrame = (MyFrame) aButton.getRootPane().getParent();
        aFrame.clearInfo();
    }
}