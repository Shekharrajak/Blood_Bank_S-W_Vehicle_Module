package intern;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DriverSearch extends Screen1{

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField txt_username;
	
	private JButton btnSearch;
	private JButton addEmp;
	private JButton updEmp;
	private JButton delEmp;
	private JButton history;
	
	private JScrollPane scrollPane;
	private JTable table;

	private int userId;
	private JPanel loggedPanel;
	private JPanel searchPanel;
	private JLabel lblLoggedIn;
	private JLabel loggedInUserLabel;
	
	Connections conn;
	
	public void setLoggedInuserName(String fName, String lName){
		loggedInUserLabel.setText(fName + " " + lName);
	}
	
	public DriverSearch() {
		super("Driver");
		// TODO Auto-generated constructor stub
		
		conn = new Connections();
		
		setTitle("Driver Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		loggedPanel = new JPanel();
		lblLoggedIn = new JLabel("Logged In:");
		loggedPanel.add(lblLoggedIn);
		
		loggedInUserLabel = new JLabel();
		loggedPanel.add(loggedInUserLabel);
		panel.add(loggedPanel);
		
		searchPanel = new JPanel();
		
		txt_username = new JTextField();
		searchPanel.add(txt_username);
		txt_username.setColumns(10);
		panel.add(searchPanel);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
			
		addEmp = new JButton("Add Employee");
		panel_1.add(addEmp);
		
		updEmp = new JButton("Update Employee");
		panel_1.add(updEmp);
		
		delEmp = new JButton("Delete Employee");
		panel_1.add(delEmp);
		
		history = new JButton("View");
		panel.add(history);
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				searchDriver();
			}
		});
		
		addEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addDriver();
			}
		});
		
		updEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateDriver();
			}
		});
		
		delEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteDriver();
			}
		});
		
		history.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void searchDriver(){
		
		String username = txt_username.getText().toString();
		List<DriverInfo> list_driver = new ArrayList<DriverInfo>();
		DriverInfo driver = null;
		try {
			if(username != null){	
				driver = conn.searchDriver(username);
				list_driver.add(driver);
			}
			else
				list_driver = conn.getAllDrivers();
			
			DriverTableModel model = new DriverTableModel(list_driver);
			table.setModel(model);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(DriverSearch.this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE); 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addDriver() {
		DriverForm form = new DriverForm(DriverSearch.this, null, false, false);
		form.setVisible(true);
	}
	
	private void updateDriver(){
		DriverForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(DriverSearch.this, "Please select any driver first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		DriverInfo driver = (DriverInfo) table.getValueAt(row, DriverTableModel.OBJECT_COL);
		form = new DriverForm(DriverSearch.this, driver, true, false);
		form.setVisible(true);
	}
	
	private void deleteDriver(){
		DriverForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(DriverSearch.this, "Please select any driver first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		DriverInfo driver = (DriverInfo) table.getValueAt(row, DriverTableModel.OBJECT_COL);
		form = new DriverForm(DriverSearch.this, driver, false, true);
		form.setVisible(true);
	}
	
	public void refreshDriverView() throws SQLException{
		
		List<DriverInfo> drivers = conn.getAllDrivers();
		
		DriverTableModel model = new DriverTableModel(drivers);
		table.setModel(model);
	}
}
