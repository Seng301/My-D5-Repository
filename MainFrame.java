
import java.awt.Color;
import javax.swing.JFrame;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MainFrame extends JFrame
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton myProperties;
    private MyButton ToDos;
    private MyButton Financial;
    private MyButton Settings;
    //private JLabel aLabel;
   
    
    
    //used to set up the frame
    public MainFrame()
    {
	initializeControls();
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
	add(myProperties);
	add(ToDos);
        add(Financial);
        add(Settings);

    }

  

    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
	setSize(WIDTH,HEIGHT);
        setTitle("Landlord Property Management");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program
    public void initializeControls()
    {
 
        
	myProperties = new MyButton("My Properties",null,this);
	myProperties.setBounds(150,100,300,50);
        myProperties.addActionListener(new PropertiesButtonListener());
        
	ToDos = new MyButton("To-Do's",null,this);
	ToDos.setBounds(150,200,300,50);
        ToDos.addActionListener(new ToDoButtonListener());
        
        Financial = new MyButton("Financial Overview",null, this);
	Financial.setBounds(150,300,300,50);
        Financial.addActionListener(new FinancialButtonListener());
        
        Settings = new MyButton("Financial Overview",null, this);
	Settings.setBounds(150,400,300,50);
        Settings.addActionListener(new LabelButtonListener());

    }
}
