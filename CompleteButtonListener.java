
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
