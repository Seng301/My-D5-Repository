//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this is the listener for when the reg is complete
public class CompleteButtonListener implements ActionListener
{
	public void actionPerformed (ActionEvent a)
	{
		JButton aButton = (JButton) a.getSource();
		RegDialog aDialog = (RegDialog) aButton.getRootPane().getParent();
		if(aDialog.CompleteRegistration() == true)
		{
			aDialog.setVisible(false);
	        aDialog.dispose();
			aDialog.returnLogin();
		}
	}
}
