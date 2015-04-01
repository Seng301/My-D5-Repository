
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;





//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MainFrame extends JFrame implements ActionListener
{
    private JButton myProperties;
    private JButton ToDos;
    private JButton Financial;
    //private MyButton Settings;
    private JButton Settings;
    private JLabel aLabel;
    
    
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
        add(aLabel);

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
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        
	myProperties = new JButton("My Properties");
	myProperties.setBounds(150,100,300,50);
        myProperties.addActionListener(this);
        myProperties.addActionListener(new PropertiesButtonListener());

        
	ToDos = new JButton("To-Do's");
	ToDos.setBounds(150,200,300,50);
        ToDos.addActionListener(this);
        ToDos.addActionListener(new ToDoButtonListener());
        
        Financial = new JButton("Financial Overview");
	Financial.setBounds(150,300,300,50);
        Financial.addActionListener(this);
        Financial.addActionListener(new FinancialButtonListener());
        

        
        Settings = new JButton("Settings");
        Settings.addActionListener(this);
        Settings.setBounds(150,400,300,50);
        Settings.addActionListener(new SettingsButtonListnener());

    }
        public void actionPerformed (ActionEvent e)
    {
        this.dispose();
    }
   
}
