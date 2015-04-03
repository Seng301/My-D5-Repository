//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//these are the imports that the class requires
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class AddPropListener implements ActionListener {
	
	public void actionPerformed (ActionEvent a)
	{
		JButton aButton = (JButton) a.getSource();
		MyPropertiesFrame propFrame = (MyPropertiesFrame) aButton.getRootPane().getParent();
		propFrame.setVisible(false);
		propFrame.dispose();
		propFrame.openAddProperty();
	}
}
