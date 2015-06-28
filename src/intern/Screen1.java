package intern;
/**
 * Screen.java
 * this class is used as a parent to make 4 child Classes from it, 
 * @author Mohamed Habib
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

//table & compoBox 

//import Connection.Connections;

public abstract class Screen1 extends JFrame {
 Connections conn = new Connections();

 protected JMenuBar menuBar;

 protected JMenu screenMenu;
 protected JMenuItem driverItem, vehicleItem, blood_infoItem, warningsItem;

 protected JMenu fileMenu;
 protected JMenuItem aboutItem, exitItem;

 protected JLabel lblhead;

 protected JPanel contentPane;

 protected String head;
 /**
  * Constructor
  * 
  * 
  * @param h
  *            a string contains the header of each screen that inherits from
  *            this parent
  */
 public Screen1(String h) {
  head = h;
  setVisible(true);
  // setBounds(100, 100, 900, 900);

  setBounds(100, 100, 878, 559);

  setResizable(false);

  Init();

  Add();

  Action();

 }

 /**
  * Collects all the Action listeners in the class
  * 
  * 
  * 
  */
 private void Action() {
  driverItem.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {

    if (head != "Driver") {

     dispose();
     Class.drivers();

    }
   }
  });

  vehicleItem.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {

    if (head != "Vehicle") {
     dispose();

     Class.vehicles();
    }
   }
  });

  blood_infoItem.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {

    if (head != "Blood_Info") {
     dispose();

     Class.blood_info();
    }
   }
  });

  aboutItem.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {

    JOptionPane
      .showMessageDialog(
        null,
        " This Project info here. SPR ");
   }
  });

  exitItem.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent event) {

    dispose();
    Class.Exit();
   }
  });

 }


 /**
  * Collects all initialization in the class
  * 
  * 
  * 
  */

 public void Init() {

  menuBar = new JMenuBar();
  setJMenuBar(menuBar);

  screenMenu = new JMenu("Choose Screen");
  screenMenu.setMnemonic('C');

  driverItem = new JMenuItem("Driver");
  driverItem.setMnemonic('B');
  vehicleItem = new JMenuItem("Vehicle");
  vehicleItem.setMnemonic('V');
  blood_infoItem = new JMenuItem("Blood_Info");
  blood_infoItem.setMnemonic('E');
  warningsItem = new JMenuItem("Warnings");
  warningsItem.setMnemonic('W');

  fileMenu = new JMenu("File");
  fileMenu.setMnemonic('F');

  aboutItem = new JMenuItem("About....");
  aboutItem.setMnemonic('A');
  exitItem = new JMenuItem("Exit");
  exitItem.setMnemonic('E');

  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  contentPane.setLayout(null);
  setContentPane(contentPane);// maybe init or add

  lblhead = new JLabel(head);
  lblhead.setBounds(412, 2, 90, 40);
  lblhead.setFont(UIManager.getFont("MenuBar.font"));
 }

 /**
  * Collects all adding methods in the class
  * 
  * 
  * 
  * 
  */
 public void Add() {
  menuBar.add(screenMenu);
  screenMenu.add(driverItem);
  screenMenu.add(vehicleItem);
  screenMenu.add(blood_infoItem);
  screenMenu.add(warningsItem);

  menuBar.add(fileMenu);
  fileMenu.add(aboutItem);
  fileMenu.add(exitItem);
 }

}
