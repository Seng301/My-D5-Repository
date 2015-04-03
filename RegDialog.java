//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

import javax.swing.JPasswordField;
import javax.swing.JDialog;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Scanner;
import java.io.*;

public class RegDialog extends JDialog
{
	private JDialog regDialog;
	private JLabel userLabel;
	private JLabel passLabel;
	public TextField newUser;
	public JPasswordField newPass;
	private String filename;
	private JButton compReg;
	private CompleteButtonListener completeListener;
	private MyWindowListener aWindowListener;
	private JLabel outcome;
	
	public RegDialog()
	{
		/*set the size and give the window a listener so that when the user closes the window
		 * there is a delay. Also set the title and filename for writing
		 */
		this.setSize(350,300);
        aWindowListener = new MyWindowListener();
        this.addWindowListener(aWindowListener);
		setTitle("Enter Registration Information");
		filename = "user_login_info.txt";
		
		//set the bounds and message for the label for entering the new username
		userLabel = new JLabel("Enter new username");
        userLabel.setBounds(95,25,150,20);
       
        //set the text field bounds for the area the user will input their username
        newUser = new TextField(20);
        newUser.setBounds(95,45, 150,20); 
            
        //set the label bounds for the password field label
		passLabel = new JLabel("Enter new password");
		passLabel.setBounds(95,65,150,40);
			
		//set text field bounds for the area where the user will input their password
		newPass = new JPasswordField(1);
		newPass.setBounds(95,100,150,20);
		
		/*set bounds for the submission button as well as its text and listener */
		compReg = new JButton("Complete");
		compReg.setBounds(125,160, 120, 25);
		completeListener = new CompleteButtonListener();
		compReg.addActionListener(completeListener);
		
		//Label to inform user if their registration was unsuccessful
		outcome = new JLabel();
		outcome.setBounds(125,190,120,60);
		
		//add components to the dialog
		add(outcome);
		add(userLabel);
		add(newUser);
		add(passLabel);
		add(newPass);
		add(compReg);
		
		//set the components visible 
		compReg.setVisible(true);
		userLabel.setVisible(true);
		newUser.setVisible(true);
		passLabel.setVisible(true);
		newPass.setVisible(true);
		this.setLayout(null);
        this.setVisible(true);
	}

	/* CompleteRegistration method is used to see whether or not the user input correct information
	 * and write that login information to a text file for future use
	 */
    public boolean CompleteRegistration()
    {
    	//set the boolean valid registration as true
    	boolean validRegistration = true;
    	
    	//get the text from the username input text field
        String username = newUser.getText();
        
        //get the text from the password input text field
        char[] userPassword = newPass.getPassword();
        
        //invalid username is empty or null
        if((username == null) || ("".equals(username)) || (username.length()>12))
        {
        	//make the label text set as registration failed if user input incorrect info
			outcome.setText("Registration failed");
			validRegistration = false;
                        return validRegistration;
		}
        
        //invalid password is length of zero
        if(userPassword.length == 0)
        {
        	outcome.setText("Registration failed");
        	validRegistration = false;
                return validRegistration;
        }
        if(userPassword.length > 16)
        {
        	outcome.setText("Registration failed");
        	validRegistration = false;
                return validRegistration;
        }
        else
        {
        	//following code handles the decryption and verification of user password
        	for(int a = 0;a<userPassword.length; a++)
        	{
                int userASCII = (int) userPassword[a];
                //subtract one from the user's input password because the stored password is encrypted.
                userASCII = userASCII - 1;
                //the case when the password contains a lower case 'a'.
                if(userASCII == 96)
                {
                    userASCII = 122;
                }
                //the case when the password contains a upper case 'A'.
                else if (userASCII == 64)
                {
                    userASCII = 90;
                }
                
                //get next character to test against
                char passChar = (char)userASCII;
                userPassword[a] = passChar;
        	}
        	
        	try
        	{
        		//if the password and username are valid then write them to the user_login_info.txt
        		FileWriter fw = new FileWriter(filename);
        		PrintWriter pw = new PrintWriter(fw);
        		pw.println(username);
        		pw.println(userPassword);
        		fw.close();
        		
        		validRegistration = true;
        	}
        	catch(IOException e)
        	{
        		System.out.println("the file " + filename + "does not exist in this directory");
        	}
        }
        
        return validRegistration;
    }
    
    public void returnLogin()
	{
		MyDialog returnDialog = new MyDialog();
	}
}
