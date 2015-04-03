//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//these are the imports that we require for this method
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This method is used as a button listener which checks if the password is 
//correct it also checks if the username is correct
public class MyButtonListener implements ActionListener
{	
    //initialize the variables
    private int counter = 3;
        //this is when the button is pressed and this method is called
	public void actionPerformed (ActionEvent a)
	{      
		JButton aButton = (JButton) a.getSource();
		MyDialog aDialog = (MyDialog) aButton.getRootPane().getParent();
                //checks if the password is correct and if the user hasn't used up all their attempts.
		if(aDialog.verifyPassword(aDialog.getUserPassword()) == true && counter > 0)
                {
                        //make sure that the user name is the same
			if(aDialog.verifyUsername(aDialog.getUsername()) == true)
			{	
				aDialog.setTitle("Correct password, logging you in...");
                        try
                        {
                                Thread.sleep(2000);
                        }
                        catch(InterruptedException ex)
                        {
                                //print a error message
                                System.out.println("Program interrupted");
                        }
                        
                        aDialog.setVisible(false);
                        aDialog.dispose();
                        aDialog.openOrderInfo();
                }
                else
                {
	            counter = counter - 1;
	            aDialog.setTitle("incorrect username, number of tries remaining: " + counter);
	            
	            if(counter == 0)
	            {
                        //this is if the user trys to hack the account
	                aDialog.setTitle("to many incorrect attempts, closing program...");
	                try
	                {
	                    Thread.sleep(2000);
	                }
	                catch(InterruptedException ex)
	                {
	                    System.out.println("Program interrupted");
	                }
	                aDialog.setVisible(false);
	                System.exit(0);
	            }
                }
                }
                
        //if the user inputs an incorrect password the button counts that incorrect event.
        //also displaying the number of tries left and changes the title to that.
        else
        {
            counter = counter - 1;
            aDialog.setTitle("incorrect password, number of tries remaining: " + counter);
            
            if(counter == 0)
            {
                //hacking alert shut them down
                aDialog.setTitle("to many incorrect attempts, closing program...");
                try
                {
                    //wait to let the user read the message
                    Thread.sleep(2000);
                }
                catch(InterruptedException ex)
                {
                    //print a error message
                    System.out.println("Program interrupted");
                }
                
                aDialog.setVisible(false);
                System.exit(0);
            }
        }
	}
}
