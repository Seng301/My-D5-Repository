//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian


import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class AddPropertyDialog extends JDialog implements ActionListener{

	private JLabel header;
	private TextField address;
	private TextArea description;
	private JButton addProperty;
	private String filename = "userInfo.txt";
	
	public AddPropertyDialog()
	{
		this.setSize(400,400);	
		
		//set the header of the window to "Add Property" and set its bounds
		setTitle("enter a property address and description");
		header = new JLabel("Add Propery");
		header.setBounds(150,10,100,20);
		
		//create new text field, set its bounds.
		address = new TextField();
		address.setBounds(50,50,300,25);
		address.addActionListener(this);
		
		//create new text Area, set its bounds.
		description = new TextArea();
		description.setBounds(50,100,300,150);
		
		
		/* initialize the button to complete the addition of the new property */
		addProperty = new JButton();	
		addProperty.setBounds(150,275,125,50);	// set bounds of new button
		addProperty.setText("add property");	// add button label
		addProperty.addActionListener(this);	// add the action listener 
		
		//no layout so it's null
        setLayout(null);
		
        //add components to the frame.
		addControls();
			
		/* set the components in the frame visible */
		header.setVisible(true);
		address.setVisible(true);
		description.setVisible(true);
		addProperty.setVisible(true);
	}
	
	/* adds the components to the frame */
    public void addControls()
    {
        add(header);
        add(addProperty);
        add(address);
        add(description);
        
    }
	
    /* Action listener for the add properties button. Gets the text from address text field and
       writes it to a file. It then gets the text from the description text area and writes it to the 
       same file on the next line. All write operations are appended so subsequent properties will
       be located in the same file.
     */
	 public void actionPerformed(ActionEvent e)
	    {
		 Component aComponent = (Component) address;
         if (aComponent instanceof TextField)	//check if the component is a text field
         {
        	 address = (TextField) aComponent;	
             String newAddress = new String(address.getText()); 	// get the new address from the text area
              if(newAddress != null || newAddress != "")		//make sure input is not null or empty
             {
                
                     try
                     {
                    	 //file.createNewFile();
                    	 BufferedWriter output = new BufferedWriter(new FileWriter(filename, true)); 	//new buffered writer and append set true
                    	 newAddress = newAddress + "\n"; 	//append a new line symbol so that the description is written on a new line
                         output.append(newAddress); 	//append new address
                         String descrip = description.getText(); //get description from text area
                         descrip = descrip + "\n"; 	//append a new line symbol so that the the next property is on a new line
                         output.append(descrip);	//write description to the file
                         output.close();		//close the buffered writer
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
         	
         	/* reopen the myproperties frame set its title, size and visibility, then close 
         	 * the add property dialog.
         	 */
         	MyPropertiesFrame todo = new MyPropertiesFrame();
     		todo.setTitle("ToDo's");
     		todo.setSize(620,700);
     		todo.setVisible(true);
            this.dispose();
	    }
}
