//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//This is the main frame that is also known as the main menu
//it contains the buttons for the application
//these are the imports that are required for the program
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//main frame in program holds buttons and labels and text areas
//that are required for the program application
public class MainFrame extends JFrame implements ActionListener
{
    //initialize out variables
    //initialize the buttons
    private JButton myProperties;
    private JButton ToDos;
    private JButton Financial;
    private JButton Settings;
    
    //initialize the label
    private JLabel aLabel;
        
    
    //used to set up the call the initializations
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
        add(aLabel);
    }

  
    //used to initialize the frame and create the basics of it
    //layout and stuff
    public void initializeFrame()
    {
        //set the default properties of the frame
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
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        //create the label with the image
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        //create the my property buttons with specific boundries
	myProperties = new JButton("My Properties");
	myProperties.setBounds(150,100,300,50);
        myProperties.addActionListener(this);
        myProperties.addActionListener(new PropertiesButtonListener());

        //create the todos button with specific boundries
	ToDos = new JButton("To-Do's");
	ToDos.setBounds(150,200,300,50);
        ToDos.addActionListener(this);
        ToDos.addActionListener(new ToDoButtonListener());
        
        //create the financial button with specific boundries
        Financial = new JButton("Financial Overview");
	Financial.setBounds(150,300,300,50);
        Financial.addActionListener(this);
        Financial.addActionListener(new FinancialButtonListener());
        
        //create the settings button with specific boundries
        Settings = new JButton("Settings");
        Settings.addActionListener(this);
        Settings.setBounds(150,400,300,50);
        Settings.addActionListener(new SettingsButtonListnener());
    }
    
    
    //This is to clear the frame after a button 
    //has been pressed
    public void actionPerformed (ActionEvent e)
    {
        //dispose of the screen
        this.dispose();
    }
   
}
