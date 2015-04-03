package standalone;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener
{	
    private int counter = 3;
    
	public void actionPerformed (ActionEvent a)
	{      
		JButton aButton = (JButton) a.getSource();
		MyDialog aDialog = (MyDialog) aButton.getRootPane().getParent();
        //checks if the password is correct and if the user hasn't used up all their attempts.
		if(aDialog.verifyPassword(aDialog.getUserPassword()) == true && counter > 0)
        {
			if(aDialog.verifyUsername(aDialog.getUsername()) == true)
			{	
				aDialog.setTitle("Correct password, logging you in...");
            	try
            	{
            		Thread.sleep(2000);
            	}
            	catch(InterruptedException ex)
            	{
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
}
