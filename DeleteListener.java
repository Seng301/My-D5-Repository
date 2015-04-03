package standalone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DeleteListener implements ActionListener{
	
	public void actionPerformed (ActionEvent a)
	{
		JButton aButton = (JButton) a.getSource();
		ToDoFrame aFrame = (ToDoFrame) aButton.getRootPane().getParent();
		int ycor = aButton.getLocation().y;
		aFrame.deleteTodo(ycor);
	}
	
}
