//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//imports for the class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//used toopen up a different frame
public class PropertiesButtonListener implements ActionListener {
   
    public void actionPerformed (ActionEvent e)
    {    
        MyPropertiesFrame myProp = new MyPropertiesFrame();
	myProp.setTitle("My Properties");
	myProp.setSize(620,700);
	myProp.setVisible(true);
    }
}
