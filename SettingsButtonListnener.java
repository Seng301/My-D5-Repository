//LPM Landlord Property Management Gui
//Seng 301
//Brendan Dueck and David Lian


//these are the imports that are required
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//used to respond to settings button being pressed which goes to new screen
public class SettingsButtonListnener implements ActionListener {
    
    public void actionPerformed (ActionEvent e)
    {
        
        SettingsFrame todo = new SettingsFrame();
	todo.setTitle("Settings");
	todo.setSize(620,700);
	todo.setVisible(true);
        

    }
}
