/*
    Assignment 4
    Created By Brendan Dueck
    Based off of Examples Provided by James Tam
    CPSC 233 U of C T6
    Date Created: March 26, 2014
    Date Last Modified: April 3, 2014
    Version 1.8
*/

/*
    Limitations: Password is preset and cannot be created from program. 
        Program is basic GUI introduction and does not incorporate
        higher levels of language. Program Password can only handle lowercase 
        characters. The program encryption is not strong. 

    Images:  Clip art
             http://www.clker.com/cliparts/a/6/e/8/119498563188281957tasto
             _8_architetto_franc_01.svg.hi.png
             http://www.vectorimages.org/09/0920100516125801178.jpg
             http://mhdcca.org/farm-animals-cartoon-pictures-212.jpg             
*/


//used to start the program and create the first dialog
public class Driver
{
    public static void main(String [] args)
    {
     
        MyDialog aDialog = new MyDialog();
        aDialog.setBounds(500,300,215,225);
        aDialog.setTitle("ACCOUNT LOGIN");
        aDialog.setVisible(true);
    }
} 
