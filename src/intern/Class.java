package intern;
/**
 * Class.java
 * @author Mohamed Habib
 * contains method that calls a screen  
 * 
 * 
 * 
 */

import javax.swing.JOptionPane;

public class Class {

 private static DriverSearch driver;

 public static DriverSearch getDriver() {
  return driver;
 }

 public static void setDriver(DriverSearch driver) {
  Class.driver = driver;
 }

 private static VehicleSearch vehicle;
 private static BloodSearch blood_info;

 private static WelcomeScreen welcomeScreen;
 private static LoginScreen loginScreen;

 static void drivers() {
  driver = new DriverSearch();
 }

 static void vehicles() {
  vehicle = new VehicleSearch();
 }

 static void blood_info() {
  blood_info = new BloodSearch();
 }


 static void Exit() {
  JOptionPane.showMessageDialog(null, "Good Bye");
  System.exit(0);
 }

 static void Logout() {
  JOptionPane.showMessageDialog(null, "Good Bye");
  loginScreen = new LoginScreen();
 }

 static void Back() {
  welcomeScreen = new WelcomeScreen();
 }
}
