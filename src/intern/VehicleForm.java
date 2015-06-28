package intern;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VehicleForm extends Screen1 {

private final JPanel contentPanel = new JPanel();
	
	private JLabel vehicle_name;
	private JLabel driver_name;
	private JLabel chasis_no;
	private JLabel engine_no;
	private JLabel necess_items; //Date of Journey
	private JLabel vehicle_no;
	private JLabel origin_city;
	private JLabel end_city;
	private JLabel doctor_name;
	private JLabel doctor_hospital;
	private JLabel doctor_age;
	private JLabel doctor_mobile_no;
	
	private JTextField text_vehicle_name;
	private JTextField text_driver_name;
	private JTextField text_chasis_no;
	private JTextField text_engine_no;
	private JTextField text_necess_items;
	private JTextField text_vehicle_no;
	private JTextField text_origin_city;
	private JTextField text_end_city;
	private JTextField text_doctor_name;
	private JTextField text_doctor_hospital;
	private JTextField text_doctor_age;
	private JTextField text_doctor_mobile_no;
	
	private JPanel part1;
	private JPanel part2;
	private JPanel part3;
	private JPanel part4;
	private JPanel part5;
	private JPanel part6;
	private JPanel part7;
	private JPanel part8;
	private JPanel part9;
	
	JPanel buttonPane;
	
	JButton saveButton;
	JButton cancelButton;
	
	GridBagLayout layout;
	
	Connections conn;
	
	boolean update;
	boolean delete;
	/**
	 * Create the dialog.
	 */
	public VehicleForm(VehicleSearch search, VechileInfo vehicle, boolean update, boolean delete) {
		
		super("Vehicle");
		
		conn = new Connections();
		
		setBounds(100, 100, 700, 500);
		layout = new GridBagLayout();
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridBagLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		if(!delete){
			if(update)
				setTitle("Update Vehicle Information");
			else
				setTitle("Add Vehicle Information");
		}
		else
			setTitle("Delete Vehicle Information");
		
		if(!delete){
		
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.BOTH;
			
			part1 = new JPanel();
			contentPanel.add(part1, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			vehicle_name = new JLabel("Vehicle Name:");
			vehicle_name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(vehicle_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.weightx = 0.25;
			text_vehicle_name = new JTextField(10);
			if(update)
				text_vehicle_name.setText(vehicle.getVehicle_name());
			part1.add(vehicle_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			driver_name = new JLabel("Driver Name:");
			driver_name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(driver_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_driver_name = new JTextField(10);
			if(update)
				text_driver_name.setText(vehicle.getDriver_name());
			part1.add(text_driver_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part2 = new JPanel();
			contentPanel.add(part2, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			engine_no = new JLabel("Engine No:");
			engine_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(engine_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_engine_no = new JTextField(20);
			if(update)
				text_engine_no.setText(vehicle.getEngine_no());
			part2.add(text_engine_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			chasis_no = new JLabel("Chasis No:");
			chasis_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(chasis_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_chasis_no = new JTextField(10);
			if(update)
				text_chasis_no.setText(vehicle.getChasis_no());
			part2.add(text_chasis_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part3 = new JPanel();
			contentPanel.add(part3, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			necess_items = new JLabel("Necessary Items:");
			necess_items.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(necess_items, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_necess_items = new JTextField(10);
			if(update)
				text_necess_items.setText(vehicle.getNecc_items());
			part3.add(text_necess_items, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			vehicle_no = new JLabel("Vehicle No:");
			vehicle_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(vehicle_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_vehicle_no = new JTextField(10);
			if(update)
				text_vehicle_no.setText(vehicle.getVehicle_no());
			part3.add(text_vehicle_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 4;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part4 = new JPanel();
			contentPanel.add(part4, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			origin_city = new JLabel("Origin City:");
			origin_city.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(origin_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_origin_city = new JTextField(10);
			if(update)
				text_origin_city.setText(vehicle.getOrgin_city());
			part4.add(text_origin_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			end_city = new JLabel("End City:");
			end_city.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(end_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_end_city = new JTextField(10);
			if(update)
				text_end_city.setText(vehicle.getEnd_city());
			part4.add(text_end_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 5;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part5 = new JPanel();
			contentPanel.add(part5, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			doctor_name = new JLabel("Doctor Name:");
			doctor_name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(doctor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_doctor_name = new JTextField(10);
			if(update)
				text_doctor_name.setText(vehicle.getDoctor_name());
			part5.add(text_doctor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			doctor_hospital = new JLabel("Doctor Hospita;:");
			doctor_hospital.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(doctor_hospital, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_doctor_hospital = new JTextField(10);
			if(update)
				text_doctor_hospital.setText(vehicle.getDoctor_hospital());
			part5.add(text_doctor_hospital, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 6;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part6 = new JPanel();
			contentPanel.add(part6, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			doctor_age = new JLabel("Doctor Age:");
			doctor_age.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(doctor_age, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_doctor_age = new JTextField(10);
			if(update)
				text_doctor_age.setText(vehicle.getDoctor_age());
			part6.add(text_doctor_age, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			doctor_mobile_no = new JLabel("Mobile No:");
			doctor_mobile_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(doctor_mobile_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_doctor_mobile_no = new JTextField(10);
			if(update)
				text_doctor_mobile_no.setText(vehicle.getDoctor_mobile_no());
			part6.add(text_doctor_mobile_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 7;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 8;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part9 = new JPanel();
			contentPanel.add(part9, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.20;
			if(!delete){
				if(update)
					saveButton = new JButton("Update");
				else
					saveButton = new JButton("Add");
			}
			else
				saveButton = new JButton("Yes");
			
			part9.add(saveButton, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.20;
			if(!delete)
				cancelButton = new JButton("Cancel");
			else
				cancelButton = new JButton("No");
			
			part9.add(cancelButton, gbc);
		}

		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try{
					if(update || delete)
						saveVehicle(search, vehicle.getId(), update, delete);
					else
						saveVehicle(search, 1, update, delete);
					}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
			}
		});
		
	}
	
	private void saveVehicle(VehicleSearch search, int id, boolean update, boolean delete) throws SQLException{
		
		if(!delete){
			if(update){
				VechileInfo vehicle = new VechileInfo(text_vehicle_name.getText().toString(), text_driver_name.getText().toString(),
						text_chasis_no.getText().toString(), text_engine_no.getText().toString(), text_necess_items.getText().toString(),
						text_vehicle_no.getText().toString(), text_origin_city.getText().toString(), text_end_city.getText().toString(), 
						text_doctor_name.getText().toString(), text_doctor_hospital.getText().toString(), text_doctor_mobile_no.getText().toString(), text_doctor_age.getText().toString());
				conn.updateVehicle(id, vehicle);
				dispose();
				JOptionPane.showMessageDialog(VehicleForm.this, "Vehicle Information updated successfully", "Success", JOptionPane.YES_OPTION);
				search.refreshvehicleView();
			}
			else{
				VechileInfo vehicle = new VechileInfo(text_vehicle_name.getText().toString(), text_driver_name.getText().toString(),
						text_chasis_no.getText().toString(), text_engine_no.getText().toString(), text_necess_items.getText().toString(),
						text_vehicle_no.getText().toString(), text_origin_city.getText().toString(), text_end_city.getText().toString(), 
						text_doctor_name.getText().toString(), text_doctor_hospital.getText().toString(), text_doctor_mobile_no.getText().toString(), text_doctor_age.getText().toString());
				conn.addVehicleInfo(vehicle);
				dispose();
				JOptionPane.showMessageDialog(VehicleForm.this, "Vehicle Information added successfully", "Success", JOptionPane.YES_OPTION);
				search.refreshvehicleView();
			}
		}
		else{
			conn.deleteVehicle(id);
			dispose();
			JOptionPane.showMessageDialog(VehicleForm.this, "Vehicle Information deleted successfully", "Success", JOptionPane.YES_OPTION);
			search.refreshvehicleView();
		}
	}
}
