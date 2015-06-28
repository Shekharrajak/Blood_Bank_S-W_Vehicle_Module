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

public class VehicleSearch extends Screen1{

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

	private int userId;
	private JPanel loggedPanel;
	private JPanel searchPanel;
	private JLabel lblLoggedIn;
	private JLabel loggedInUserLabel;
	
	private JComboBox<String> comboBox;
	
	String descriptions[] = {"vehicle_no", "chasis_no", "vehicle_no", "driver_name", "vehicle_name"};
	
	public void setLoggedInuserName(String fName, String lName){
		loggedInUserLabel.setText(fName + " " + lName);
	}
	
	public VehicleSearch() {
		super("Vehicle_Info");
		// TODO Auto-generated constructor stub
		
		setTitle("Vehicle Search");
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
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("Vehicle No");
		comboBox.addItem("Chasis No");
		comboBox.addItem("Vehicle No");
		comboBox.addItem("Driver Name");
		comboBox.addItem("Vehicle Name");
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
				searchVehicle(descriptions[comboBox.getSelectedIndex()], lastNameTextField.getText().toString());
			}
		});
		
		addEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addVehicle();
			}
		});
		
		updEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateVehicle();
			}
		});
		
		delEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteVehicle();
			}
		});
	}
	
	private void searchVehicle(String key, String value){
	
		List<VechileInfo> list_vehicle = new ArrayList<VechileInfo>();
		VechileInfo vehicle;
		
		if(value != null){
			list_vehicle = conn.searchVehicle(key, value);
		}
		else{
			list_vehicle = conn.getAllVehicle();
		}
		
		VehicleTableModel model = new VehicleTableModel(list_vehicle);
		table.setModel(model);
	}
	
	private void addVehicle(){
		
		VehicleForm form = new VehicleForm(VehicleSearch.this, null, false, false);
		form.setVisible(true);
	}
	
	private void updateVehicle(){
		VehicleForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(VehicleSearch.this, "Please select any vehicle object first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		VechileInfo vehicle =  (VechileInfo) table.getValueAt(row, VehicleTableModel.OBJECT_COL);
		form = new VehicleForm(VehicleSearch.this, vehicle, true, false);
		form.setVisible(true);
	}
	
	private void deleteVehicle(){
		VehicleForm form;
		int row = table.getSelectedRow();
		
		if(row < 0){
			JOptionPane.showMessageDialog(VehicleSearch.this, "Please select any vehicle object first", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		VechileInfo vehicle =  (VechileInfo) table.getValueAt(row, VehicleTableModel.OBJECT_COL);
		form = new VehicleForm(VehicleSearch.this, vehicle, false, true);
		form.setVisible(true);
	}
	
	public void refreshvehicleView() throws SQLException{
		
		List<VechileInfo> list_vehicle = conn.getAllVehicle();
		
		VehicleTableModel model = new VehicleTableModel(list_vehicle);
		table.setModel(model);
		
	}
}
