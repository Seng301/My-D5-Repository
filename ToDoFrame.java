
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.TextField;

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
    public JLabel Todo1;
    public JLabel Todo2;
    public JLabel Todo3;
    private String filename = "todos.txt";
   
    
    
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
	
	Todo1 = new JLabel();
	Todo1.setBounds(200,200,200,25);
	
	Todo2 = new JLabel();
	Todo2.setBounds(200,250,200,25);
	
	Todo3 = new JLabel();
	Todo3.setBounds(200,300,200,25);
	
	
	readToDos();
        
        Title = new JLabel("ToDo's");
        Title.setBounds(200, 100, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
	setSize(WIDTH,HEIGHT);
        setTitle("ToDo's");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(aLabel);
	add(Todo1);
	add(Todo2);
	add(Todo3);
	aLabel.setVisible(true);
	aLabel.setVisible(true);
    }

    //used to create the controls on the frame including labels texts and 
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
    
    public void readToDos()
    {	
    	String todo = "";
    	try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            todo = br.readLine();
        	Todo1.setText(todo);
        	Todo1.setVisible(true);
        	
        	todo = br.readLine();
        	
        	Todo2.setText(todo);
        	Todo2.setVisible(true);
        	
        	todo = br.readLine();
        	
        	Todo3.setText(todo);
        	Todo3.setVisible(true);

            fr.close();
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String test(){
        ToDoFrame todo = new ToDoFrame();
        String h = todo.Todo1.getText();
        return h;
    }
}
