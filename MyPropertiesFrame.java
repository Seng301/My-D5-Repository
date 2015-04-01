
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MyPropertiesFrame extends JFrame
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    private JLabel aLabel;
    private JLabel Title;

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
        add(aLabel);
        add(Title);

    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        Title = new JLabel("My Properties");
        Title.setBounds(200, 65, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        
            
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
 
        
	New = new MyButton("+",null,this);
	New.setBounds(450,100,50,50);
        //New.addActionListener(new FrameButtonListener());
        


    }
}
