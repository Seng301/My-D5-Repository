//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//This is the imports needed to build the class
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


//main frame in program holds buttons and labels and text areas
//that are required for the program
public class ToDoFrame extends JFrame implements ActionListener
{
    //initialize the variables
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private MyButton New;
    private JLabel Title;
    private JButton home;
    private JLabel aLabel;
    public JLabel Todo1;
    public JLabel Todo2;
    public JLabel Todo3;
    private JButton delete1;
    private JButton delete2;
    private JButton delete3;
    private String filename = "todos.txt";
    private ActionListener aListener;
    
    
    //used to initialize the frame
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
    	add(aLabel);
    	add(Todo1);
    	add(Todo2);
    	add(Todo3);
    	add(delete1);
    	add(delete2);
    	add(delete3);
    }

   

    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {
        aListener = new DeleteListener();
    	
    	ImageIcon LPM = new ImageIcon("LPM.gif");
        
        //add the logo
        aLabel = new JLabel(LPM);
        aLabel.setBounds(0,0,75,58);
	
        //add the todo label
        Todo1 = new JLabel();
        Todo1.setBounds(200,200,200,25);
	
        //add the delete button
        delete1 = new JButton();
        delete1.setBounds(150,200,25,25);
        delete1.addActionListener(aListener);
        delete1.setVisible(false);
        
        //add the todo2 label
        Todo2 = new JLabel();
        Todo2.setBounds(200,250,200,25);
	
        //delete button
        delete2 = new JButton();
        delete2.setBounds(150,250,25,25);
        delete2.addActionListener(aListener);
        delete2.setVisible(false);
	
        //3rd todo
        Todo3 = new JLabel();
        Todo3.setBounds(200,300,200,25);
	
        //delete the third todo
        delete3 = new JButton();
        delete3.setBounds(150,300,25,25);
	delete3.addActionListener(aListener);
        delete3.setVisible(false);
	
        readToDos();
        
        //add the title
        Title = new JLabel("ToDo's");
        Title.setBounds(200, 100, 200,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        //initialize the frame to default
	setSize(WIDTH,HEIGHT);
        setTitle("ToDo's");
        getContentPane().setBackground(Color.white);
	setLayout(null);
	addControls();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	aLabel.setVisible(true);
	aLabel.setVisible(true);
    }

    
    //used to create the controls on the frame including labels texts and 
    //buttons that are used in the program
    public void initializeControls()
    {
        //add new button
        New = new MyButton("+",null,this);
        New.setBounds(450,100,50,50);
        New.addActionListener(new AddButtonListener());
          
        //add the home button
        home = new JButton("HOME");
        home.setBounds(260,600,100,50);
        home.addActionListener(this);
    }
    
    //used when the button is hit to close the frame
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();  
    }
    
    
    //this is to read and display the todos
    public void readToDos()
    {	
    	String todo = "";
    	try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
                //set the todos strings
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
        //exception
        catch (IOException e)
        {
            e.printStackTrace();
        }
    	//checl to see if empty then delete
    	if(Todo1.getText() != null || Todo1.getText() == " ")
    	{
    		delete1.setVisible(true);
    	}
    	//checl to see if empty then delete
    	if(Todo2.getText() != null || Todo2.getText() == " ")
    	{
    		delete2.setVisible(true);
    	}
    	//checl to see if empty then delete
    	if(Todo3.getText() != null || Todo3.getText() == " ")
    	{
    		delete3.setVisible(true);
    	}
    	
    }
 
    //used to remove the todo from file
    public void deleteTodo(int py)
    {
    	String clear = " ";	
    	String toDelete = "";
    	boolean result = false;
    	String[] todos = new String[3];
    	todos[0] = Todo1.getText();
    	todos[1] = Todo2.getText();
    	todos[2] = Todo3.getText();
    	
    	if(py == 200)
    	{
    		toDelete = Todo1.getText();
    		Todo1.setText(clear);
    	}
    	if(py == 250)
    	{
    		toDelete = Todo2.getText();
    		Todo2.setText(clear);
    	}
    	if(py == 300)
    	{
    		toDelete = Todo3.getText();
    		Todo3.setText(clear);
    	}
    	
    	try
    	{   
    		FileWriter fw = new FileWriter("todos.txt");
    		PrintWriter pw = new PrintWriter(fw);
    		
            for(int c = 0; c < 3; c++)
            {
            	
            	result = todos[c].equals(toDelete);
            	if(result == true)
            	{
            			todos[c] = "";
            	}
            }
            
            String total = "";
            
            for(int a = 0; a < 3; a++)
            {
            	result = todos[a].equals("");
            	if(result == false)
            	{
            		total = total + "\n" + todos[a];
            	}
            }
            pw.println(total);
            pw.close();
        }
        //exception
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }   
}  

