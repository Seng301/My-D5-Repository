package standalone;

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
    int x = 1200;
    
    //used to set up the frame
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
    	String filename = "finances.txt";
    	String i = "";
    	String j = "";
    	String k = "";
    	String l = "";
    	String m = "";
    	
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
        catch (IOException e)
        {
            e.printStackTrace();
        }
    	
        ImageIcon LPM = new ImageIcon("LPM.gif");
        ImageIcon Ledgend =  new ImageIcon("ledgend.gif");
        
        aLabel = new JLabel(LPM);
        aLabel.setBounds(0,0,75,58);
        
        
        String maint = "$" + i;
        maintLabel = new JLabel(maint);
        maintLabel.setBounds(450,205,150,58);
        maintLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        String tax = "$" + j;
        taxLabel = new JLabel(tax);
        taxLabel.setBounds(450,240,150,58);
        taxLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        String util = "$" + k;
        utilLabel = new JLabel(util);
        utilLabel.setBounds(450,273,150,58);
        utilLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        String legal = "$" + l;
        legalLabel = new JLabel(legal);
        legalLabel.setBounds(450,303,150,58);
        legalLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        String ins = "$" + m;
        insuranceLabel = new JLabel(ins);
        insuranceLabel.setBounds(450,338,150,58);
        insuranceLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        infoLabel = new JLabel(Ledgend);
        infoLabel.setBounds(0,200,450,200);
        
        Title = new JLabel("Financial Overview");
        Title.setBounds(160, 65, 300,40);
        Title.setFont(new Font("Serif", Font.BOLD, 30));
        
        setSize(WIDTH,HEIGHT);
        setTitle("My Properties");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        addControls();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void initializeControls()
    {  
	Pie = new JButton("HOME");
	Pie.setBounds(260,600,100,50);
        Pie.addActionListener(this);
        
        home = new JButton("Pie Chart");
	home.setBounds(260,500,100,50);
        home.addActionListener(new PieChartListener());
        
    }
    
    
    public void actionPerformed (ActionEvent e)
    {
        MainFrame aFrame = new MainFrame ();
        aFrame.setSize(620,700);
        aFrame.setVisible(true);
        this.dispose();  
    }
  
    public void initialize ()
    {
        
    }

    
}
