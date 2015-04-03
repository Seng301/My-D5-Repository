//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//These are the imports that this class requires
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



//used to respond to add button being pressed which writes information to
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
