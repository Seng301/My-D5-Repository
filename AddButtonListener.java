
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class AddButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent e)
    {
        AddTodoDialog todo = new AddTodoDialog();
	todo.setTitle("ToDo's");
	todo.setSize(400,200);
	todo.setVisible(true);
    }
}
