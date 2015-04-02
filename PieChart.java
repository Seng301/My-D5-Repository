//used as a reference http://www.tutorialspoint.com/javaexamples/gui_piechart.htm

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import javax.swing.JComponent;
import javax.swing.JFrame;

class  PieChart{
   double amount;
   Color color;
   public PieChart(double amount, Color color) {  
      this.amount = amount;
      this.color = color;
   }
}
class FinancialValue extends JComponent {

    public int maint = 1890;
    public int tax = 2034;
    public int util = 7000;
    public int legal = 1233;
    public int insurance = 665;
    
   PieChart[] slices = { 
       new PieChart(maint, Color.GRAY), 
       new PieChart(tax, Color.green),
       new PieChart(util, Color.yellow),
       new PieChart(insurance, Color.blue),
       new PieChart(legal, Color.red) };
   FinancialValue() {}
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
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
