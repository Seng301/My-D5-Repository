/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brendan
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class PieChartListener implements ActionListener {
    
    //t and t2 used for shortning reasons t = text and t2 = text2
		PieChart[] aChart = { 
        new PieChart(5, Color.black), 
        new PieChart(33, Color.green),
        new PieChart(20, Color.yellow), 
        new PieChart(15, Color.red) };
		
    
    public void actionPerformed (ActionEvent e)
    {
      branch();
    }
    
    public void branch(){
    	String filename = "finances.txt";
        int maint = 0;
        int ins = 0;
        int tax = 0;
        int util = 0;
        int legal = 0;
        String strToInt;
        
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
        catch (IOException e)
        {
            e.printStackTrace();
        }
    	
        PieChart[] aChart = { 
        new PieChart(maint, Color.GRAY), 
        new PieChart(ins, Color.blue),
        new PieChart(tax, Color.green), 
        new PieChart(util, Color.yellow),
        new PieChart(legal, Color.red)};
    	
    	JDialog Piechart = new JDialog();
    	Piechart.getContentPane().add(new FinancialValue(aChart));
    	Piechart.setSize(300, 200);
    	Piechart.setVisible(true); 
    }
}

