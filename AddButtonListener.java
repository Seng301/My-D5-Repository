

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class AddButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent e)
    {   
		JButton aButton = (JButton) e.getSource();
		ToDoFrame toDoFrame = (ToDoFrame) aButton.getRootPane().getParent();
		toDoFrame.setVisible(false);
		toDoFrame.dispose();
		
		AddTodoDialog todoDialog = new AddTodoDialog();
		todoDialog.setSize(400,250);
		todoDialog.setVisible(true);
    }
}
