

/**
 *
 * @author Brendan
 */

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
        
        filename = "todos.txt";
        aLabel = new JLabel("Enter New To-Do:");
        aLabel.setBounds(150,10,100,20);
        submit = new JButton();
        submit.setBounds(150,100,100,35);
        submit.setText("Submit");
        submit.addActionListener(this);
        ToDo = new JTextField();
        ToDo.setBounds(50,50,300,25);
        ToDo.addActionListener(this);
        setLayout(null);
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

    //used to wait till enter or button has been presesed and then 
    //compare passwords
    public void actionPerformed(ActionEvent e)
    {
        
            Component aComponent = (Component) ToDo;
            if (aComponent instanceof JTextField)
            {
                ToDo = (JTextField) aComponent;
                String NewToDo = new String(ToDo.getText());
                 if(NewToDo != null || NewToDo != "")
                {
                         
                        try
                        {
                        	BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
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
            
            	ToDoFrame todo = new ToDoFrame();
        		todo.setTitle("ToDo's");
        		todo.setSize(620,700);
        		todo.setVisible(true);
                this.dispose();
            }
    }
    




