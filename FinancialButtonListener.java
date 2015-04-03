//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class FinancialButtonListener implements ActionListener {
 
    public void actionPerformed (ActionEvent e)
    {
   
    	//create new instance of financial frame and set its size and visibility
      MyFinancialFrame frame = new MyFinancialFrame();
      frame.setSize(620, 700);
      frame.setVisible(true);
        
        
     

    }
}
