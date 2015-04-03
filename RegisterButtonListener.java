//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//these are the imports that the class requires
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//this class waits and listens for when the register button is pressed and 
//opens a new dialog
public class RegisterButtonListener implements ActionListener
{
	public void actionPerformed (ActionEvent a)
	{
		JButton aButton = (JButton) a.getSource();
		MyDialog aDialog = (MyDialog) aButton.getRootPane().getParent();
		aDialog.setVisible(false);
		aDialog.dispose();
		aDialog.openRegistration();		
	}
}
