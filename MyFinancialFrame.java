
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
        ImageIcon LPM = new ImageIcon("LPM.gif");
        ImageIcon Ledgend =  new ImageIcon("ledgend.gif");
        
        aLabel = new JLabel(LPM);
	aLabel.setBounds(0,0,75,58);
        
        maintLabel = new JLabel("1200");
	maintLabel.setBounds(475,200,75,58);
        
        taxLabel = new JLabel("290");
	taxLabel.setBounds(475,200,75,58);
        
        utilLabel = new JLabel("456");
	utilLabel.setBounds(475,200,75,58);
        
        legalLabel = new JLabel("567");
	legalLabel.setBounds(475,200,75,58);
        
        insuranceLabel = new JLabel("690");
	insuranceLabel.setBounds(475,200,75,58);
        
        
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
  


}
