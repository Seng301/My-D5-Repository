package standalone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddPropListener implements ActionListener {
	
	public void actionPerformed (ActionEvent a)
	{
		// get the the frame component to be able to access its methods
		JButton aButton = (JButton) a.getSource();
		MyPropertiesFrame propFrame = (MyPropertiesFrame) aButton.getRootPane().getParent();
		
		//make the frame invisible, dispose itself, and call openAddProperty to open the addPropertyDialog
		propFrame.setVisible(false);
		propFrame.dispose();
		propFrame.openAddProperty();
	}
}
