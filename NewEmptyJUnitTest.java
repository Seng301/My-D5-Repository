/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brendan
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testNullTodoLabel1() {
         ToDoFrame todo = new ToDoFrame();
         String expected = todo.Todo1.getText();
         String notEmpty = null;
         
         Assert.assertNotSame(expected, notEmpty);
     }
     @Test
     public void testNullTodoLabe2() {
         ToDoFrame todo = new ToDoFrame();
         String expected = todo.Todo2.getText();
         String notEmpty = null;
         
         Assert.assertNotSame(expected, notEmpty);
     }
     @Test
     public void testNullTodoLabe3() {
         ToDoFrame todo = new ToDoFrame();
         String expected = todo.Todo3.getText();
         String notEmpty = null;
         
         Assert.assertNotSame(expected, notEmpty);
     }
     
     
     @Test
     public void testNewInvalidUserInvalidPassword() {
         RegDialog test = new RegDialog();
         boolean input = test.CompleteRegistration();
         boolean expected = false;
         
         Assert.assertEquals(input, expected);
     }
     
     
     @Test
     public void testNewValidUserInvalidPassword() {
         RegDialog test = new RegDialog();
         test.newUser.setText("David");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testNewValidUserValidPassword() {
         RegDialog test = new RegDialog();
         test.newUser.setText("David");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = true; 
         Assert.assertEquals(input, expected);
     }
     
     
     @Test
     public void testNewInvalidUserValidPassword() {
         RegDialog test = new RegDialog();
         test.newUser.setText("");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testNullUser() {
         RegDialog test = new RegDialog();
         test.newUser.setText(null);
         test.newPass.setText("Test");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testNullPassword() {
         RegDialog test = new RegDialog();
         test.newUser.setText("test");
         test.newPass.setText(null);
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testNullUserNullPassword() {
         RegDialog test = new RegDialog();
         test.newUser.setText(null);
         test.newPass.setText(null);
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     
     @Test
     public void test12charUser() {
         RegDialog test = new RegDialog();
         test.newUser.setText("123456789012");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = true; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void test13charUser() {
         RegDialog test = new RegDialog();
         test.newUser.setText("1234567890123");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testLongCharUser() {
         RegDialog test = new RegDialog();
         test.newUser.setText("1234234242312313323456789012");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void test16CharPWord() {
         RegDialog test = new RegDialog();
         test.newUser.setText("test");
         test.newPass.setText("1234567890123456");
         boolean input = test.CompleteRegistration();
         boolean expected = true; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void test17CharPWord() {
         RegDialog test = new RegDialog();
         test.newUser.setText("test");
         test.newPass.setText("12345678901234567");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void testLongCharPWord() {
         RegDialog test = new RegDialog();
         test.newUser.setText("test");
         test.newPass.setText("1234567890123453434242344524221457");
         boolean input = test.CompleteRegistration();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void SpecialCharPWord() {
         RegDialog test = new RegDialog();
         test.newUser.setText("test");
         test.newPass.setText("@$^**");
         boolean input = test.CompleteRegistration();
         boolean expected = true; 
         Assert.assertEquals(input, expected);
     }
     
     @Test
     public void SpecialCharUser() {
         RegDialog test = new RegDialog();
         test.newUser.setText("#@%^&#^%@#$");
         test.newPass.setText("test");
         boolean input = test.CompleteRegistration();
         boolean expected = true; 
         Assert.assertEquals(input, expected);
     }    
     
     @Test
     public void FinancialFrameCloses() {
         MyFinancialFrame test = new MyFinancialFrame();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);
                
     }    
     
     @Test
     public void MainFrameCloses() {
         MainFrame test = new MainFrame();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void MyPropertiesFrameCloses() {
         MyPropertiesFrame test = new MyPropertiesFrame();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void SettingsFrameCloses() {
         SettingsFrame test = new SettingsFrame();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void ToDoFrameCloses() {
         ToDoFrame test = new ToDoFrame();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
      @Test
     public void AddPropDialogCloses() {
         AddPropertyDialog test = new AddPropertyDialog();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
      @Test
     public void AddTODODialogCloses() {
         AddTodoDialog test = new AddTodoDialog();
         test.actionPerformed(null);
         boolean input = test.isVisible();
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     
     @Test
     public void LoginUsernameisNull() {
         MyDialog test = new MyDialog();
         boolean input = test.verifyUsername(null);
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void LoginUsernameisEmpty() {
         MyDialog test = new MyDialog();
         boolean input = test.verifyUsername("");
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void LoginUsernameisdifferent() {
         MyDialog test = new MyDialog();
         boolean input = test.verifyUsername("019><:{P:");
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void PasswordNotEqual() {
         MyDialog test = new MyDialog();
         char[] t = test.getUserPassword();
         boolean input = test.verifyPassword(t);
         boolean expected = false; 
         Assert.assertEquals(input, expected);         
     }
     
     @Test
     public void PiChartWorking() {
         PieChartListener test = new PieChartListener();
         test.actionPerformed(null);
         PieChart[] input = test.aChart;
         PieChart[] expected =  { 
        new PieChart(0, Color.orange)};
         Assert.assertNotSame(expected, input);
     }    
       
}
