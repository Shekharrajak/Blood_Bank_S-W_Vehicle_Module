package intern;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BloodSearch extends Screen1{

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField lastNameTextField;
	
	private JButton btnSearch;
	private JButton addEmp;
	private JButton updEmp;
	private JButton delEmp;
	private JButton history;
	
	private JScrollPane scrollPane;
	private JTable table;

	private JPanel loggedPanel;
	private JPanel searchPanel;
	private JLabel lblLoggedIn;
	private JLabel loggedInUserLabel;

	private JComboBox<String> comboBox;
	Connections conn;
	
	public void setLoggedInuserName(String fName, String lName){
		loggedInUserLabel.setText(fName + " " + lName);
	}
	
	public BloodSearch() {
		super("Blood_Info");
		// TODO Auto-generated constructor stub
		
		conn = new Connections();
		comboBox = new JComboBox<String>();
		
		comboBox.addItem("donor_name");
		comboBox.addItem("blood_grp");
		comboBox.addItem("donor_city");
		comboBox.addItem("donor_hospital");
		
		setTitle("Blood Search");
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
		
		lastNameTextField = new JTextField();
		searchPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		panel.add(searchPanel);
		
		panel.add(comboBox);
		
		btnSearch = new JButton("Search");
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		
		addEmp = new JButton("Add");
		panel_1.add(addEmp);
		
		updEmp = new JButton("Update");
		panel_1.add(updEmp);
		
		delEmp = new JButton("Delete");
		panel_1.add(delEmp);
		
		history = new JButton("View");
		panel_1.add(history);
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					searchBlood(comboBox.getSelectedItem().toString(), lastNameTextField.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		addEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addBlood();
			}
		});
		
		updEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				updateBlood();
			}
		});
		
		delEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteBlood();
			}
		});
	}
	
	public void searchBlood(String key, String value) throws SQLException{
		
		List<BloodInfo> list_blood = new ArrayList<BloodInfo>();
		BloodInfo blood;
		
		if(value != null){
			list_blood = conn.searchBlood(key, value);
		}
		else
			list_blood = conn.getAllBlood();
		
		BloodTableModel model = new BloodTableModel(list_blood);
		table.setModel(model);
	}
	
	public void addBlood(){
		BloodForm form = new BloodForm(BloodSearch.this, null, false, false);
		form.setVisible(true);
	}
	
	public void updateBlood(){
		BloodForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(BloodSearch.this, "Please select any blood object first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		BloodInfo blood =  (BloodInfo) table.getValueAt(row, BloodTableModel.OBJECT_COL);
		form = new BloodForm(BloodSearch.this, blood, true, false);
		form.setVisible(true);
		
	}
	
	public void deleteBlood(){
		BloodForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(BloodSearch.this, "Please select any blood object first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		BloodInfo blood =  (BloodInfo) table.getValueAt(row, BloodTableModel.OBJECT_COL);
		form = new BloodForm(BloodSearch.this, blood, false, true);
		form.setVisible(true);
	}
	
	public void refreshBloodView() throws SQLException{
		
		List<BloodInfo> list_blood = conn.getAllBlood();
		
		BloodTableModel model = new BloodTableModel(list_blood);
		table.setModel(model);
		
	}

}
