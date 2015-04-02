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
        
        //to turn a string into a int use: int foo = Integer.parseInt("1234");
        
        int maint = 20;
        int ins = 13;
        int tax = 12;
        int util = 11;
        int legal = 3;
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

