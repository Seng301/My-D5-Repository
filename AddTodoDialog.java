//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JTextField;

//Used to set up and run the dialog menu which includes a password and a button
public class AddTodoDialog extends JDialog implements ActionListener
{
    private static final int MATCH = 0;
    private JTextField ToDo;
    private final JLabel aLabel;
    private final JButton submit;
    private String filename;

    public AddTodoDialog()
    {
        //set the name for the text file for the todos
        filename = "todos.txt";
        
        //set the header for the todo dialog and it's bounds
        aLabel = new JLabel("Enter New To-Do:");
        aLabel.setBounds(150,10,100,20);
        
        //create new submission button,set its bounds and add a listener
        submit = new JButton();
        submit.setBounds(150,100,100,35);
        submit.setText("Submit");
        submit.addActionListener(this);
        
        //create a instance of the textfield the users todo will be entered in
        ToDo = new JTextField();
        ToDo.setBounds(50,50,300,25);
        ToDo.addActionListener(this);
        //no layout so it is null
        setLayout(null);
        
        //add all the widgets to the frame
        addControls();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
               
    }

    //used to add the parts of the dialog
    public void addControls()
    {
        add(aLabel);
        add(submit);
        add(ToDo);
        
    }

    /* The submit button listener is located here and will write the to do to the todo text file
     * This method will also close the current dialog and re open the to do's screen
     */
    public void actionPerformed(ActionEvent e)
    {
        	
            Component aComponent = (Component) ToDo;
            if (aComponent instanceof JTextField)
            {
                ToDo = (JTextField) aComponent;
                String NewToDo = new String(ToDo.getText());
                
                //check if the todo is null or empty
                 if(NewToDo != null || NewToDo != " ")
                {
                         
                        try
                        {
                        	BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
                        	
                        	//append a new line at the end so that the next to do will be on the next line
                        	NewToDo = NewToDo + "\n"; 
                            output.append(NewToDo);
                            output.close();
                        }
                        catch(IOException o)
                        {
                        	System.out.println("the file " + filename + "does not exist in this directory");
                        }
                }
                           
                    
                }
                else
                {
                    //igneore();
 
                } 
            	
            	//create a new instance of ToDoFrame to reflect changes
            	ToDoFrame todo = new ToDoFrame();
        		todo.setTitle("ToDo's");
        		todo.setSize(620,700);
        		todo.setVisible(true);
        		//dipose of current dialog
                this.dispose();
            }
    }
    




