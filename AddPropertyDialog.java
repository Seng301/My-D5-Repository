

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class AddPropertyDialog extends JDialog implements ActionListener{
	
	private JDialog addPropDialog;
	private JLabel header;
	private TextField address;
	private TextArea description;
	private JButton addProperty;
	private String filename = "userInfo.txt";
	
	public AddPropertyDialog()
	{
		this.setSize(400,400);	
		setTitle("enter a property address and description");
		header = new JLabel("Add Propery");
		header.setBounds(150,10,100,20);
		address = new TextField();
		address.setBounds(50,50,300,25);
		address.addActionListener(this);
		description = new TextArea();
		description.setBounds(50,100,300,150);
		//description.addActionListener(this);
		addProperty = new JButton();
		addProperty.setBounds(150,275,125,50);
		addProperty.setText("add property");
		addProperty.addActionListener(this);
        setLayout(null);
		
		addControls();
		
		header.setVisible(true);
		address.setVisible(true);
		description.setVisible(true);
		addProperty.setVisible(true);
	}
	
    public void addControls()
    {
        add(header);
        add(addProperty);
        add(address);
        add(description);
        
    }
	
	 public void actionPerformed(ActionEvent e)
	    {
		 Component aComponent = (Component) address;
         if (aComponent instanceof TextField)
         {
        	 address = (TextField) aComponent;
             String newAddress = new String(address.getText());
              if(newAddress != null || newAddress != "")
             {
            	//  String filename = newAddress + ".txt";
            	  
            	 // File file = new File(filename);
                      
                     try
                     {
                    	 //file.createNewFile();
                    	 BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
                    	 System.out.println(newAddress);
                    	 newAddress = newAddress + "\n";
                         output.append(newAddress);
                         String descrip = description.getText();
                         System.out.println(descrip);
                         output.append(descrip);
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
         
         	MyPropertiesFrame todo = new MyPropertiesFrame();
     		todo.setTitle("ToDo's");
     		todo.setSize(620,700);
     		todo.setVisible(true);
            this.dispose();
	    }
}
