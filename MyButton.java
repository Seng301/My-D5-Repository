package standalone;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;

//used to allow picture attatchment to button
public class MyButton extends JButton
{
    private Component aComponent;
   
    public MyButton(String a, ImageIcon pic, Component aComponent)
    {
	super(a,pic);
	this.aComponent = aComponent;
    }
    public Component getComponent()
    {
	return(aComponent);
    }
}
