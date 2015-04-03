package standalone;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class MyPropertiesFrame extends JFrame implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    private JLabel aLabel;
    private JLabel Title;
    private JButton home;
    private AddPropListener aListener;
    private String filename = "userinfo.txt";
    private JLabel Prop1;
    private JLabel Descrip1;

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
        add(home);
        add(Prop1);
        add(Descrip1);
    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        
        aLabel = new JLabel(LPM);
        aLabel.setBounds(0,0,75,58);
        
        //create new title and set bounds
        Title = new JLabel("My Properties");
        Title.setBounds(200, 65, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        Prop1 = new JLabel("here");
        Prop1.setBounds(200,150, 100, 35);
        Prop1.setVisible(true);
        
        Descrip1 = new JLabel("here");
        Descrip1.setBounds(150,150,400,100);
        Descrip1.setVisible(true);
        
        displayProperties();
        
       //set the size attributes, controls, and components.     
        setSize(WIDTH,HEIGHT);
        setTitle("My Properties");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        addControls();
        setDefaultCloseOperation(MyPropertiesFrame.EXIT_ON_CLOSE);
    }
    
    // create new AddPropertyDialog to add a new property 
    public void openAddProperty()
    {
    	AddPropertyDialog pd = new AddPropertyDialog();
    	pd.setVisible(true);
    	pd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program
    public void initializeControls()
    {
    	New = new MyButton("+",null,this);
		New.setBounds(450,100,50,50);
        aListener = new AddPropListener();
        New.addActionListener(aListener);
        
        home = new JButton("HOME");
        home.setBounds(260,600,100,50);
        home.addActionListener(this);
       
    }
    /*Action listener that causes the home button to make a new home frame, used to go 
     *back to the main menu
     */
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();  
    }
    
    public void displayProperties()
    {
    	String todo = "";
    	try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String control = br.readLine();
            String descr = "";
            String address = control;
            control = br.readLine();
            
            while(control != null)
            {
            	descr = descr + control;
            	control = br.readLine();
            }
            
            Prop1.setText(address);
            Descrip1.setText(descr);

            fr.close();
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
