package intern;
/**
 * WelcomeScreen.java
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame {

 /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
private JLabel lblWelcome;
 private JButton btnDriver, btnBlood_Info, btnVehicle, btnWarnings, btnExit,
   btnLogout;
 private JLabel lblFor, lblForInsertingModifying,
   lblForInsertingModifying_1, lblForInsertingModifying_2;

 private JPanel contentPane;

 private String userName = LoginScreen.userName;

 public WelcomeScreen() {

  setVisible(true);
  setBounds(100, 100, 642, 490);
  setResizable(false);

  Init();

  Add();

  Action();

 }

 private void Init() {

  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);

  lblWelcome = new JLabel("Welcome " + userName);
  lblWelcome.setBounds(10, 11, 200, 20);

  btnDriver = new JButton("Driver");
  btnDriver.setBounds(345, 95, 89, 23);

  btnBlood_Info = new JButton("Blood_Info");
  btnBlood_Info.setBounds(345, 145, 189, 23);

  btnVehicle = new JButton("Vehicle");
  btnVehicle.setBounds(345, 206, 89, 23);

  btnWarnings = new JButton("Warnings");
  btnWarnings.setBounds(345, 269, 89, 23);

  btnExit = new JButton("Exit");
  btnExit.setBounds(527, 405, 89, 23);

  btnLogout = new JButton("Logout");
  btnLogout.setBounds(527, 10, 89, 23);

  lblFor = new JLabel(
    "For Inserting, Modifying, Retrieving, Driver Data: ");
  lblFor.setBounds(10, 99, 300, 14);

  lblForInsertingModifying = new JLabel(
    "For Inserting, Modifying, Retrieving, Blood_Info Data: ");
  lblForInsertingModifying.setBounds(10, 149, 300, 14);

  lblForInsertingModifying_1 = new JLabel(
    "For Inserting, Modifying, Retrieving, Vehicle Data: ");
  lblForInsertingModifying_1.setBounds(10, 210, 300, 14);

  lblForInsertingModifying_2 = new JLabel(
    "For Inserting, Modifying, Retrieving, Warnings: ");
  lblForInsertingModifying_2.setBounds(10, 273, 300, 14);

 }

 private void Add() {
  contentPane.add(lblWelcome);
  contentPane.add(btnDriver);
  contentPane.add(btnBlood_Info);
  contentPane.add(btnVehicle);
  contentPane.add(btnWarnings);
  contentPane.add(btnExit);
  contentPane.add(btnLogout);
  contentPane.add(lblFor);
  contentPane.add(lblForInsertingModifying);
  contentPane.add(lblForInsertingModifying_1);
  contentPane.add(lblForInsertingModifying_2);

 }

 private void Action() {
  btnDriver.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent arg0) {

    dispose();
    Class.drivers();
   }
  });

  btnVehicle.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent arg0) {

    dispose();
    Class.vehicles();

   }
  });

  btnBlood_Info.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent arg0) {

    dispose();
    Class.blood_info();

   }
  });

  btnLogout.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

    dispose();
    Class.Logout();
   }
  });

  btnExit.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent arg0) {

    dispose();
    Class.Exit();
   }
  });

 }

}
