
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class FinancialButtonListener implements ActionListener {
    
    //t and t2 used for shortning reasons t = text and t2 = text2
 
    public void actionPerformed (ActionEvent e)
    {
   
      MyFinancialFrame frame = new MyFinancialFrame();
      frame.setSize(620, 700);
      frame.setVisible(true);
        
        
     

    }
}
