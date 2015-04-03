//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian

//these are the imports that are required for this class
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

//this calss is a component to initialize the pie chart pieces
public class FinancialValue extends JComponent {
    
    //initialize the variables
    public int tax = 2034;
    public int util = 7000;
    public int legal = 1233;
    public int insurance = 665;
    PieChart [] slices;

    //this method is created so that we can pass in the pie chart values
   FinancialValue( PieChart[] aChart) {
       slices = aChart;
   }
   
   
   //This is to paint/draw the acctual pie chart
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
   
   //This is to draw the complete pie on the frame
   void drawPie(Graphics2D g, Rectangle area, PieChart[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].amount;
      }
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].amount * 360 / total);
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, 
         startAngle, arcAngle);
         curValue += slices[i].amount;
      }
   }
   
}