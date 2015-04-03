package standalone;

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
public class SettingsFrame extends JFrame implements ActionListener
{
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
	add(aLabel);
        add(home);
        add(Title);

    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
         Title = new JLabel("Settings");
        Title.setBounds(210, 65, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
	setSize(WIDTH,HEIGHT);
        setTitle("Settings");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public void initializeControls()
    {  
	home = new JButton("HOME");
	home.setBounds(260,600,100,50);
        home.addActionListener(this);
        
    }
    
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();
        
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program

}
