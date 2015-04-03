//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//these are the required imports for the class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//used to respond to branch to the todo frameo
public class ToDoButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent e)
    {
        
        ToDoFrame todo = new ToDoFrame();
        todo.setTitle("ToDo's");
        todo.setSize(620,700);
        todo.setVisible(true);
    }
}
