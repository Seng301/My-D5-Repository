//Author: David Lian 10135918 
//Version: April 03,2014

/*  Features:
    Sets the size and the components on the Frame for the users
    info. Adds two buttons for the saving and clearing of data in the text area and
    text field in addition to adding the images to the buttons. Adds three labels for the
    logo, address, and name labels in addition to the logo's icon. MyFrame contains the method
    to add widgets to its frame in order to save space. MyFrame also is responsible for containing 
    the methods for saving and clearing for the buttons. 
*/
    
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.io.*;

public class MyFrame extends JFrame
{
    private String filename;
    private JButton save;
    private JButton clear;
    private TextField name_field;
    private JTextArea address_field;
    private JLabel logo;
    private JLabel name_label;
    private JLabel address_label;
    private GridBagLayout aLayout;
    private MySaveButtonListener saveListener;
    private MyClearButtonListener clearListener;
    private MyWindowListener aWindowListener;
    GridBagConstraints aConstraint;

    /*sets the size and title of the frame as well as creating the required components
      for the frame. Also positions the widgets properly on the JFrame. */
    public MyFrame()
    {
        filename = "userInfo.txt";
        this.setSize(395,315);
        this.setTitle("Order information");
        aWindowListener = new MyWindowListener();
        this.addWindowListener(aWindowListener);
        
        aConstraint = new GridBagConstraints();
        aConstraint.insets = new Insets(10,10,5,5);
        aLayout = new GridBagLayout();
        
        ImageIcon logo_icon = new ImageIcon("Logo.jpg");
        ImageIcon save_icon = new ImageIcon("add.gif");
        ImageIcon clear_icon = new ImageIcon("clear.gif");
        
        logo = new JLabel("DAVE CO",logo_icon,JLabel.CENTER);
        name_label = new JLabel("Name");
        address_label = new JLabel("Address");
        
        name_field = new TextField(10);
        address_field = new JTextArea(5,10);
        
        saveListener = new MySaveButtonListener();
        save = new JButton("Save",save_icon);
        save.addActionListener(saveListener);
 
        clearListener = new MyClearButtonListener();
        clear = new JButton("Clear",clear_icon);
        clear.addActionListener(clearListener);
        
        this.setLayout(aLayout);
		addWidget(logo,0,0,1,1);
		addWidget(name_label,0,1,1,1);
		addWidget(address_label,3,1,1,1);
		addWidget(name_field,0,2,1,1);
		addWidget(address_field,3,2,1,1);
		addWidget(save,0,3,1,1);
		addWidget(clear,3,3,1,1);
        this.setVisible(true); 
    }
    
    //Instantiates the file writer and print writer in order to write to a file. Uses the text field
    //and text areas getText() method to obtain the user obtain, then writes the input onto the 
    //user info text file. 
    public void saveInfo()
    {
        String userName = name_field.getText();
        String userAddress = address_field.getText();
        try
        {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("username: " + userName);
            pw.println("user address: " + userAddress);
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("the file " + filename + "does not exist in this directory");
        }
    }
    
    //uses the text field and text area setText() method to set the text fields values to 
    //empty strings to clear the input boxes.
    public void clearInfo()
    {
        String clear = " ";
        name_field.setText(clear);
        address_field.setText(clear);
    }
    
    //adds widgets to the frame using the grid bag constraints. 
    public void addWidget(Component widget,int x,int y,int w,int h)
    {
        aConstraint.gridx = x;
        aConstraint.gridy = y;
        aConstraint.gridwidth = w;
        aConstraint.gridheight = h;
        aConstraint.fill = GridBagConstraints.HORIZONTAL;
        aLayout.setConstraints(widget,aConstraint);
        add(widget);
    }
}