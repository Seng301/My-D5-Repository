
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class FinancialButtonListener implements ActionListener {
    
    //t and t2 used for shortning reasons t = text and t2 = text2
    private String t;
    private String t2;
    public void actionPerformed (ActionEvent e)
    {
        MyFinancialFrame myProp = new MyFinancialFrame();
	myProp.setTitle("Financial Overview");
	myProp.setSize(620,880);
	myProp.setVisible(true);

    }
}
