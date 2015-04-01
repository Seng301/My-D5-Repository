
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MyFinancialFrame extends JFrame
{
    private JLabel aLabel;
    
    //used to set up the frame
    public MyFinancialFrame()
    {
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
	
        add(aLabel);
    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
	setSize(WIDTH,HEIGHT);
        setTitle("My Properties");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program

}
