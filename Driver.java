//used to start the program and create the first dialog
public class Driver
{
    public static void main(String [] args)
    {
     
        MyDialog LoginScreen = new MyDialog();
        LoginScreen.setBounds(500,300,215,225);
        LoginScreen.setTitle("ACCOUNT LOGIN");
        LoginScreen.setVisible(true);
    }
} 
