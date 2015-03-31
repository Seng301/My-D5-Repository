
import java.awt.Color;
import javax.swing.JFrame;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MyPropertiesFrame extends JFrame
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    //private JLabel aLabel;
   
    
    
    //used to set up the frame
    public MyPropertiesFrame()
    {
	initializeControls();
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
	add(New);

    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
	setSize(WIDTH,HEIGHT);
        setTitle("My Properties");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(MyPropertiesFrame.EXIT_ON_CLOSE);
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program
    public void initializeControls()
    {
 
        
	New = new MyButton("Add House",null,this);
	New.setBounds(0,0,50,50);
        //New.addActionListener(new FrameButtonListener());
        


    }
}
