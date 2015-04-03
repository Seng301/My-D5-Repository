//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//thise are the imports
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JDialog;


//used to initialize the pie chart
public class PieChartListener implements ActionListener {
		PieChart[] aChart = { 
        new PieChart(5, Color.black), 
        new PieChart(33, Color.green),
        new PieChart(20, Color.yellow), 
        new PieChart(15, Color.red) };
		
    
    //branch to a non static method to add # to pie
    public void actionPerformed (ActionEvent e)
    {
      branch();
    }
    
    //used to pass in the #'s
    public void branch(){
    	String filename = "finances.txt";
        int maint = 0;
        int ins = 0;
        int tax = 0;
        int util = 0;
        int legal = 0;
        String strToInt;
        
        //read the text file and convirt to a int to be added in pie
    	try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
     
            strToInt = br.readLine();
            maint = Integer.parseInt(strToInt);
            
            strToInt = br.readLine();
            ins = Integer.parseInt(strToInt);
            
            strToInt = br.readLine();
            tax = Integer.parseInt(strToInt);
            
            strToInt = br.readLine();
            util = Integer.parseInt(strToInt);
            
            strToInt = br.readLine();
            legal = Integer.parseInt(strToInt);

            fr.close();
            br.close();
        }
        //exception
        catch (IOException e)
        {
            e.printStackTrace();
        }
    	
        //pass in the values to the coresponding slice
        PieChart[] aChart = { 
        new PieChart(maint, Color.GRAY), 
        new PieChart(ins, Color.blue),
        new PieChart(tax, Color.green), 
        new PieChart(util, Color.yellow),
        new PieChart(legal, Color.red)};
    	
        //create the pie chart dialog
    	JDialog Piechart = new JDialog();
    	Piechart.getContentPane().add(new FinancialValue(aChart));
    	Piechart.setSize(300, 200);
    	Piechart.setVisible(true); 
    }
}

