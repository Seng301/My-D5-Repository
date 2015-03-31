

/**
 *
 * @author Brendan
 */

import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;

//Used to set up and run the dialog menu which includes a password and a button
public class MyDialog extends JDialog implements ActionListener
{
    private static final int MATCH = 0;
    private JPasswordField aPasswordField;
    private final JLabel aLabel;
    private final JLabel aLabel2;
    private final JButton submit;
    private int x = 0;
    private static String temp = "";
    private static String password = "";

    public MyDialog()
    {
        //read and decrypt the password
        String filename = "password.txt";
	BufferedReader br = null;
	FileReader fr = null; 
	

	try
	{
	    fr = new FileReader(filename);
	    br = new BufferedReader(fr);
	    temp = br.readLine ();
	    
	}
	catch (FileNotFoundException e)
        {
	    System.out.println("File called " + filename + 
			       " not in the current  directory");
	}
	catch (IOException e)
        {
	    System.out.println("General file input error occured.");
	    e.printStackTrace();
	}
        
        //set up a loop for each character in pwd
        int y = 0;
        while (y < temp.length())
        {
           char letter = temp.charAt(y);
           if (letter =='z')
               letter = 'a';
           else
             letter++;
           
           password = password + letter;
           y++;
        }
        
        //set up the labels buttons and password field
        ImageIcon anIcon = new ImageIcon("key.gif");
        aLabel2 = new JLabel(anIcon);
        aLabel2.setBounds(35,10,125,70);
        aLabel = new JLabel("Enter password:");
        aLabel.setBounds(50,80,100,20);
        submit = new JButton();
        submit.setBounds(50,135,100,35);
        submit.setText("Submit");
        submit.addActionListener(this);
        aPasswordField = new JPasswordField();
        aPasswordField.setBounds(50,100,100,20);
        aPasswordField.addActionListener(this);
        setLayout(null);
        addControls();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
               
    }

    //used to add the parts of the dialog
    public void addControls()
    {
        add(aLabel);
        add(aLabel2);
        add(submit);
        add(aPasswordField);
        
    }

    //used to wait till enter or button has been presesed and then 
    //compare passwords
    public void actionPerformed(ActionEvent e)
    {
        
            Component aComponent = (Component) aPasswordField;
            if (aComponent instanceof JPasswordField)
            {
                aPasswordField = (JPasswordField) aComponent;
                String passWordEntered = new String(aPasswordField.getPassword());
                if (passWordEntered.compareTo(password) == MATCH)
                {
                    loginSuccess();
                    
                }
                else
                {
                    loginFailed();
 
                } 
        }
    }

    //used to free up memory
    public void cleanUp(JDialog popup, int delay)
    {
	try {
	    Thread.sleep(delay); 
	}
	catch (InterruptedException ex)  { 
	    System.out.println("Not Responding");
	}
	popup.setVisible(false);
	popup.dispose();
     
    }
    
    //used after determining the password is correct 
    //creates the frame of the program
    public void loginSuccess()
    {
	JDialog success = new JDialog();
	success.setTitle("Login successful!");
	success.setSize(200,100);
	success.setVisible(true);
	cleanUp(success,1000);
        cleanUp(this, 10);
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,1000);
        aFrame.setVisible(true);
    }

    //loops used to have a certain amount of password attempts
    public void loginFailed()
    {
        x++; 
        if (x==3)
          {
                JDialog failed = new JDialog();
                failed.setTitle("Login failed!");
                failed.setSize(200,100);
                failed.setVisible(true);
                cleanUp(failed, 2000);
                cleanUp(this, 10);
          }
        
        else
        {
          JDialog failed = new JDialog();
	  failed.setTitle("WRONG: Attempt" + x + "/3");
	  failed.setSize(300,100);
	  failed.setVisible(true);
	  cleanUp(failed, 2000);
        }     
    }
}

