package standalone;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.Component;

public class MyWindowListener extends WindowAdapter
{
    public void windowClosing (WindowEvent a)
    {
        Component aComponent = (Component) a.getWindow();
        //check if the component is a instance of MyFrame
        if(aComponent instanceof MainFrame)
        {
            MainFrame aFrame = (MainFrame) aComponent;
            aFrame.setTitle("Terminating program...");
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Closing of the program has been interrupted");
            }
            aFrame.setVisible(false);
            aFrame.dispose();
        }
        //if the component isn't a MyFrame then it must be a MyDialog 
        
        if(aComponent instanceof MyDialog)
        {   
			MyDialog aDialog = (MyDialog) aComponent;
            aDialog.setTitle("Terminating program");
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Closing of the program has been interrupted");
            }
            aDialog.setVisible(false);
            System.exit(0);          
        }
        
        if(aComponent instanceof RegDialog)
        {   
            RegDialog aRegDialog = (RegDialog) aComponent;
            aRegDialog.setTitle("Terminating program");
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                System.out.println("Closing of the program has been interrupted");
            }
            aRegDialog.setVisible(false);
            System.exit(0);          
        }
    }
}
