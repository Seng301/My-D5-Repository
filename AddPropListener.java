
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

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
