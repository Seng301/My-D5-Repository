
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

//main frame in program holds buttons and labels and text areas
//that are required for the program
public class ToDoFrame extends JFrame
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    //private JLabel aLabel;
   
    
    
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
	//add(aLabel);
        //add(text);
        //add(name);
        //add(text2);
        //add(scrollPane);
        //add(adress);
    }

    //get*() methods used to allow return and update of other controlls   
   // public JTextField getText()
   // {
   //     return(text);
    //}
   // public JTextArea getText2()
    //{
    //    return(text2);
    //}

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
 
        
	New = new MyButton("Add a ToDo",null,this);
	New.setBounds(550,300,100,100);
        New.addActionListener(new FrameButtonListener());
        


    }
}
