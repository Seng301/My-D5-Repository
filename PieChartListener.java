/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brendan
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


//used to respond to save button being pressed which writes information to
//a file in the same directory
public class PieChartListener implements ActionListener {
    
    //t and t2 used for shortning reasons t = text and t2 = text2
 
    public void actionPerformed (ActionEvent e)
    {
   
      JDialog Piechart = new JDialog();
      Piechart.getContentPane().add(new FinancialValue());
      Piechart.setSize(300, 200);
      Piechart.setVisible(true);
        
        
     

    }
}

