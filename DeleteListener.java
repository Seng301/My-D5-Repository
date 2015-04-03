//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//this is called when we press the delete button and acts appropriately
public class DeleteListener implements ActionListener{
	
	public void actionPerformed (ActionEvent a)
	{
		JButton aButton = (JButton) a.getSource();
		ToDoFrame aFrame = (ToDoFrame) aButton.getRootPane().getParent();
		int ycor = aButton.getLocation().y;
		aFrame.deleteTodo(ycor);
	}
	
}
