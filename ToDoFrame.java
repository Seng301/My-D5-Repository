
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class ToDoFrame extends JFrame implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    private JLabel Title;
    private JButton home;
    private JLabel aLabel;
    
   
    
    
    //used to set up the frame
    public ToDoFrame()
    {
	initializeControls();
	initializeFrame();
    }

    //adds the parts of the frame
    public void addControls()
    {
	add(New);
	add(Title);
        add(home);
        add(aLabel);
    }

   

    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        
        ImageIcon LPM = new ImageIcon("LPM.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        Title = new JLabel("ToDo's");
        Title.setBounds(200, 65, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
	setSize(WIDTH,HEIGHT);
        setTitle("ToDo's");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //used to create the controlls on the frame includiong labels texts and 
    //buttons that are used in the program
    public void initializeControls()
    {
 
        New = new MyButton("+",null,this);
	New.setBounds(450,100,50,50);
        New.addActionListener(new AddButtonListener());
                
        home = new JButton("HOME");
	home.setBounds(260,600,100,50);
        home.addActionListener(this);
        
	
        ;
    }
    
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();  
    }
}
