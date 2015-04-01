
import javax.swing.JPasswordField;
import javax.swing.JDialog;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.io.*;

public class RegDialog extends JDialog
{
	private JDialog regDialog;
	private JLabel userLabel;
	private JLabel passLabel;
	private TextField newUser;
	private JPasswordField newPass;
	private String filename;
	private JButton compReg;
	private CompleteButtonListener completeListener;
	private MyWindowListener aWindowListener;
	private TextField outcome;
	
	public RegDialog()
	{
		this.setSize(350,300);
        aWindowListener = new MyWindowListener();
        this.addWindowListener(aWindowListener);
		setTitle("Enter Registration Information");
		filename = "user_login_info.txt";
		
		userLabel = new JLabel("Enter new username");
        userLabel.setBounds(95,25,150,20);
       
        newUser = new TextField(20);
        newUser.setBounds(95,45, 150,20); 
            
		passLabel = new JLabel("Enter new password");
		passLabel.setBounds(95,65,150,40);
			
		newPass = new JPasswordField(1);
		newPass.setBounds(95,100,150,20);
		
		compReg = new JButton("Complete");
		compReg.setBounds(125,160, 120, 25);
		completeListener = new CompleteButtonListener();
		compReg.addActionListener(completeListener);
		
		outcome = new TextField(50);
		outcome.setBounds(125,190,120,60);
		
		add(userLabel);
		add(newUser);
		add(passLabel);
		add(newPass);
		add(compReg);
		
		compReg.setVisible(true);
		userLabel.setVisible(true);
		newUser.setVisible(true);
		passLabel.setVisible(true);
		newPass.setVisible(true);
		this.setLayout(null);
        this.setVisible(true);
	}

    public boolean CompleteRegistration()
    {
    	boolean validRegistration = true;
        String username = newUser.getText();
        char[] userPassword = newPass.getPassword();
        
        if(username == null || username == "")
        {
			outcome.setText("Registration failed");
			validRegistration = false;
		}
        
        if(userPassword.length == 0)
        {
        	outcome.setText("Registration failed");
        	validRegistration = false;
        }
        else
        {
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
                char passChar = (char)userASCII;
                userPassword[a] = passChar;
        	}
        	
        	try
        	{
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
