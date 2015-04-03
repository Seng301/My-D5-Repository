//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian


//these are the imports that are required for the class
import java.awt.Color;
import java.awt.Font;
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
public class MyFinancialFrame extends JFrame  implements ActionListener
{
    //initializwe the variables for this class
    private JLabel aLabel;
    private JLabel infoLabel;
    private JLabel maintLabel;
    private JLabel taxLabel;
    private JLabel utilLabel;
    private JLabel legalLabel;
    private JLabel insuranceLabel;
    private JButton home;
    private JButton Pie;
    private JLabel Title;
    
    
    //used to set up the frame by branching to the initialize functions
    public MyFinancialFrame()
    {
        initializeControls();
        initializeFrame();  
    }

    //adds the parts of the frame
    public void addControls()
    {
        add(aLabel);
        add(infoLabel);
        add(maintLabel);
        add(taxLabel);
        add(utilLabel);
        add(legalLabel);
        add(insuranceLabel);
        add(home);
        add(Pie);
        add(Title);
    }

    
    //used to initialize the frame and create the basics of it
    public void initializeFrame()
    {	
        //create the strings for later reading
    	String filename = "finances.txt";
    	String i = "";
    	String j = "";
    	String k = "";
    	String l = "";
    	String m = "";
    	
        //try reading the file
    	try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
     
            i = br.readLine();
            
            j = br.readLine();
            
            k = br.readLine();
            
            l = br.readLine();
           
            m = br.readLine();
            
            fr.close();
            br.close();
        }
        
        //catch the exception
        catch (IOException e)
        {
            e.printStackTrace();
        }
    	
        //load the main logo
        ImageIcon LPM = new ImageIcon("LPM.gif");
        ImageIcon Ledgend =  new ImageIcon("ledgend.gif");
        
        //load the label for the title
        aLabel = new JLabel(LPM);
        aLabel.setBounds(0,0,75,58);
        
        //create the dollar sign for the string for the finances
        String maint = "$" + i;
        maintLabel = new JLabel(maint);
        maintLabel.setBounds(450,205,150,58);
        maintLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        //create the string for tax
        String tax = "$" + j;
        taxLabel = new JLabel(tax);
        taxLabel.setBounds(450,240,150,58);
        taxLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        //create the string for utilities
        String util = "$" + k;
        utilLabel = new JLabel(util);
        utilLabel.setBounds(450,273,150,58);
        utilLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        //create the string for legal
        String legal = "$" + l;
        legalLabel = new JLabel(legal);
        legalLabel.setBounds(450,303,150,58);
        legalLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        //create the string for insurance
        String ins = "$" + m;
        insuranceLabel = new JLabel(ins);
        insuranceLabel.setBounds(450,338,150,58);
        insuranceLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        //create the label with the ledgend image that shows which is which
        infoLabel = new JLabel(Ledgend);
        infoLabel.setBounds(0,200,450,200);
        
        //set the title for the frame
        Title = new JLabel("Financial Overview");
        Title.setBounds(160, 65, 300,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        //set the default size for the frame
        setSize(WIDTH,HEIGHT);
        setTitle("My Properties");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        addControls();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    //this is the to initialize the controls 
    public void initializeControls()
    {  
        //create the new pie button
	Pie = new JButton("HOME");
	Pie.setBounds(260,600,100,50);
        Pie.addActionListener(this);
        
        //create the home button
        home = new JButton("Pie Chart");
	home.setBounds(260,500,100,50);
        home.addActionListener(new PieChartListener());
    }
    
    //this is what happens if a button (home ) button has been pressed
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();  
    } 
}
