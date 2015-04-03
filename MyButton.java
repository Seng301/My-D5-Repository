//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//These are the imports that are required for the class
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;

//
public class MyButton extends JButton
{
    //initialize the variable
    private Component aComponent;
    
    //create the main method
    public MyButton(String a, ImageIcon pic, Component aComponent)
    {
	super(a,pic);
	this.aComponent = aComponent;
    }
    
    //this is the component part
    public Component getComponent()
    {
	return(aComponent);
    }
}
