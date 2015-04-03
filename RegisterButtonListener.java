package standalone;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
