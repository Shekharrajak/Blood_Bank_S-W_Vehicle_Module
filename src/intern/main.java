package intern;
/**
 * main.java
 * OOP Project FCIS second year second semester
 * 
 * fcis Package
 *
 * Purpose: A Library management system that handles the library books, borrowers, vehicles, warnings . 
 * 
 * this class has the main method, makes an object from another class that passes us from a screen to screen using buttons
 *
 * @author Mohamed Habib
 * @version 1.0 5/2013
 */


import java.awt.EventQueue;

public class main {

 public static void main(String[] args) {
  System.out.println();
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     // SearchResults sr=new SearchResults("id","1","books");
     LoginScreen loginScreen = new LoginScreen();

     // WelcomeScreen w = new WelcomeScreen();

    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });

 }

}
