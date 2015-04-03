//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian


//This is the imports that we need for the class
import javax.swing.JPasswordField;
import javax.swing.JDialog;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.io.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


//This is the method that calls the log in screen and waits for a password and
//a user name
public class MyDialog extends JDialog
{
        //initialize the variables
        private JDialog aDialog;
        private JLabel aLabel;
        private JLabel bLabel;
        private JButton aButton;
        private JButton register;
        private JPasswordField aPassField;
        private MyButtonListener aButtonListener;
        private RegisterButtonListener registerListener;
        private TextField username_field;
        private String password;
        private int password_length;
        private String username;
        private String filename = "user_login_info.txt";
        private MyWindowListener aWindowListener;
		
//sets the size of the dialog box and adds the components need for the
//dialog box. 
public MyDialog()
{
        this.setSize(350,300);		 	
        setUserLoginInfo();
        setTitle("Enter log in information");
        aWindowListener = new MyWindowListener();
        this.addWindowListener(aWindowListener);
            
        //set up the label for username
        bLabel = new JLabel("Enter Username");
        bLabel.setBounds(95,25,150,20);
            
        //set up and create a text field for username
        username_field = new TextField(20);
        username_field.setBounds(95,45, 150,20); 

        //create the password label
        aLabel = new JLabel("Enter Password");
        aLabel.setBounds(95,65,150,40);

        //set up a password field
        aPassField = new JPasswordField(1);
        aPassField.setBounds(95,100,150,20);

        //create a login button that takes the info
        aButton = new JButton("Login");
        aButton.setBounds(125,130,90,25);
        aButtonListener = new MyButtonListener();
        aButton.addActionListener(aButtonListener);			 

        //create a button that is for the register new usre dialog
        register = new JButton("Register");
        register.setBounds(125,160, 100, 25);
        registerListener = new RegisterButtonListener();
        register.addActionListener(registerListener);

        //add all the components in the dialog
        add(aPassField);
        add(username_field);
        add(aLabel);
        add(bLabel);
        add(aButton);
        add(register);
        aLabel.getRootPane().setDefaultButton(aButton);
	
        //set the parts to visible to appear on the dialog
        aButton.setVisible(true);
        register.setVisible(true);
        bLabel.setVisible(true);
        aLabel.setVisible(true);
        aPassField.setVisible(true);
        username_field.setVisible(true);
        this.setLayout(null);
        this.setVisible(true);
    }
        

    //sets the password from the file where the encrypted password is located.
    public boolean verifyUsername(String aUsername)
    {
            //create a boolean variable
            boolean userValid = false;

        //make sure that the username is not empty or null
        if(username != null || username == "")
            {
                    userValid = username.equals(aUsername);
            }

            //print the username
            System.out.println(username);
            System.out.println(aUsername);
            System.out.println(userValid);
                    return userValid;
    }
		
    //this sets the users username from a file
    public void setUserLoginInfo()
    {
            try
            {
                //call the frame and buffer reader
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);

                 username = br.readLine();
                 password = br.readLine();

                 
                if(password != null)
                {
                    password_length = password.length();
                }
                
                //print the user and password in file
                System.out.println(username);
                System.out.println(password);

                //close the buffers
                fr.close();
                br.close();
            }
            
            //catch the exception
            catch (IOException e)
            {
                //print error message
                e.printStackTrace();
            }
    }
        
    
    //this method returns the username
    public String getUsername()
    {
            return username_field.getText();
    }
	
    
    //uses the text fields method getPassword() to get the users 
    //input password
    public char[] getUserPassword()
    {
            return aPassField.getPassword();
    }
	
    
    /*checks the validity of the users input password. If the input password is a different
      length of the actual password then the user password is automatically false and the 
      method returns false. However if they're the same length the the method checks every
      character in each string to see if they're the same, if the two match then the method
      returns true. */
    public boolean verifyPassword(char[] aPassword)
    {
	boolean passwordValid = true;
            
	if(aPassword.length > password_length || aPassword.length < password_length)
            {
                passwordValid = false;
            }
                        
        else if(password == null || password == "")
            {
                passwordValid = false;
            }
        else
            {
            for(int a = 0; a < aPassword.length; a++)
                {
                    int userASCII = (int) aPassword[a];
                    int passASCII = (int) password.charAt(a);
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
                    
                    //if the two characters don't match then the method returns false.
                    if(passASCII != userASCII)
                    {
                        passwordValid = false;
                    }
                }
            }
            return passwordValid;
    }
        
    
    //this method returns the dialog
    public JDialog getDialog()
    {
        return aDialog;
    }
      
    
    //instantiates the order frame for the input of order information. 
    public void openOrderInfo()
    {
        MainFrame aFrame = new MainFrame();
        aFrame.setSize(680,700);
        aFrame.setVisible(true);
        aFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
      
    
    //this opens the other frame
    public void openRegistration()
    {
                    RegDialog reg = new RegDialog();
    }
}
