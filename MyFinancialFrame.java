
import java.awt.Color;
import javax.swing.JFrame;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MyFinancialFrame extends JFrame
{
    
    //used to set up the frame
    public MyFinancialFrame()
    {
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
	

    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
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
