//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian


//these are the imports that are required for the class
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//main frame in program holds buttons and labels and text areas
//that are required for the program
//this function was supposed to hold various settings for the webpage
public class SettingsFrame extends JFrame implements ActionListener
{
    //initialize the variables
    private JLabel aLabel;
    private JButton home;
    private JLabel Title;
    
    //used to set up the frame
    public SettingsFrame()
    {
        initializeControls();
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
        //add the components
	add(aLabel);
        add(home);
        add(Title);

    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        //Add the LPM logo
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        //Add the title to the frame
        Title = new JLabel("Settings");
        Title.setBounds(210, 65, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        //set default frame size
	setSize(WIDTH,HEIGHT);
        setTitle("Settings");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //initialize the button to go home
    public void initializeControls()
    {  
	home = new JButton("HOME");
	home.setBounds(260,600,100,50);
        home.addActionListener(this);   
    }
    
    //when the button is pressed this is where we branch to which disposes frame
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();   
    }
}
