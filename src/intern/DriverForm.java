package intern;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class DriverForm extends Screen1 {

	private final JPanel contentPanel = new JPanel();
	
	private JLabel name;
	private JLabel mobile_no;
	private JLabel dl_no;
	private JLabel dob;
	private JLabel doj; //Date of Journey
	private JLabel sex;
	private JLabel add;
	private JLabel email;
	private JLabel city;
	private JLabel state;
	private JLabel country;
	private JLabel pincode;
	private JLabel age;
	
	private JTextField text_name;
	private JFormattedTextField text_mobile_no;
	private JTextField text_dl_no;
	private JTextField text_dob;
	private JTextField text_doj;
	private JTextField text_sex;
	private JFormattedTextField text_age;
	private JTextArea text_add;
	private JTextField text_email;
	private JTextField text_city;
	private JTextField text_state;
	private JTextField text_country;
	private JFormattedTextField text_pincode;
	
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
	GridBagConstraints gbc;
	
	boolean update;
	boolean delete;
	
	Connections conn;
	/**
	 * Create the dialog.
	 */
	public DriverForm(DriverSearch search, DriverInfo driver, boolean update, boolean delete) {
		
		super("Driver");
		
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
				setTitle("Update Driver Information");
			else
				setTitle("Add Driver Information");
		}
		else
			setTitle("Delete Driver Information");
		
		if(!delete){
		
			gbc = new GridBagConstraints();
			
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
			dl_no = new JLabel("Driving license No:");
			dl_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(dl_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.weightx = 0.25;
			text_dl_no = new JTextField(10);
			if(update)
				text_dl_no.setText(driver.getDl_no());
			part1.add(text_dl_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			doj = new JLabel("Date of Joining");
			doj.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(doj, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_doj = new JTextField(10);
			if(update)
				text_doj.setText(driver.getDoj());
			part1.add(text_doj, gbc);
			
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
			name = new JLabel("Name:");
			name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_name = new JTextField(20);
			if(update)
				text_name.setText(driver.getName());
			part2.add(text_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			sex = new JLabel("Sex:");
			sex.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(sex, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_sex = new JTextField(10);
			if(update)
				text_sex.setText(driver.getSex());
			part2.add(text_sex, gbc);
			
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
			mobile_no = new JLabel("Mobile No:");
			mobile_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(mobile_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			
			NumberFormat longFormat = NumberFormat.getIntegerInstance();

			NumberFormatter numberFormatter = new NumberFormatter(longFormat);
			numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
			numberFormatter.setAllowsInvalid(false); //this is the key!!
			numberFormatter.setMinimum(0l); //Optional
			
			text_mobile_no = new JFormattedTextField(numberFormatter);
			text_mobile_no.setColumns(13);
			if(update)
				text_mobile_no.setText(driver.getMobile_no());
			part3.add(text_mobile_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			email = new JLabel("E-mail:");
			email.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(email, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_email = new JTextField(10);
			if(update)
				text_email.setText(driver.getEmail());
			part3.add(text_email, gbc);
			
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
			dob = new JLabel("Date of Birth:");
			dob.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(dob, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_dob = new JTextField(10);
			if(update)
				text_dob.setText(driver.getDob());
			part4.add(text_dob, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			age = new JLabel("Age:");
			age.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(age, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			
			longFormat = NumberFormat.getIntegerInstance();

			numberFormatter = new NumberFormatter(longFormat);
			numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
			numberFormatter.setAllowsInvalid(false); //this is the key!!
			numberFormatter.setMinimum(0l); //Optional
			
			text_age = new JFormattedTextField(numberFormatter);
			text_age.setColumns(10);
			if(update)
				text_age.setText(""+ driver.getAge());
			part4.add(text_age, gbc);
			
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
			add = new JLabel("Address");
			add.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(add, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_add = new JTextArea(3, 20);
			if(update)
				text_add.setText(driver.getAddress());
			part5.add(text_add, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			city = new JLabel("City:");
			city.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_city = new JTextField(10);
			if(update)
				text_city.setText(driver.getCity());
			part5.add(text_city, gbc);
			
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
			state = new JLabel("State:");
			state.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(state, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_state = new JTextField(10);
			if(update)
				text_state.setText(driver.getState());
			part6.add(text_state, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			country = new JLabel("Country:");
			country.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(country, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_country = new JTextField(10);
			if(update)
				text_country.setText(driver.getCountry());
			part6.add(text_country, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.LAST_LINE_END;
			gbc.gridx = 0;
			gbc.gridy = 7;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			part8 = new JPanel();
			contentPanel.add(part8, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			pincode = new JLabel("Pincode:");
			pincode.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part8.add(pincode, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			
			longFormat = NumberFormat.getIntegerInstance();

			numberFormatter = new NumberFormatter(longFormat);
			numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
			numberFormatter.setAllowsInvalid(false); //this is the key!!
			numberFormatter.setMinimum(0l); //Optional
			text_pincode = new JFormattedTextField(numberFormatter);
			text_pincode.setColumns(10);
			if(update)
				text_pincode.setText(driver.getPincode());
			part8.add(text_pincode, gbc);
		}
		
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.weighty = 0.125;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		part7 = new JPanel();
		contentPanel.add(part7, gbc);
		
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
		
		part7.add(saveButton, gbc);
		
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 0.20;
		if(!delete)
			cancelButton = new JButton("Cancel");
		else
			cancelButton = new JButton("No");
		
		part7.add(cancelButton, gbc);

		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(update || delete)
						saveDriver(search, driver.getId(), update, delete);
					else
						saveDriver(search, 1, update, delete);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
	
	private void saveDriver(DriverSearch search, int id, boolean update, boolean delete) throws SQLException{
		
		if(!delete){
			
			if(update){
				DriverInfo driver = new DriverInfo(text_name.getText().toString(), text_mobile_no.getText().toString(),
						text_sex.getText().toString(), text_add.getText().toString(), text_city.getText().toString(), 
						text_state.getText().toString(), text_country.getText().toString(), text_pincode.getText().toString(), 
						text_email.getText().toString(), text_dl_no.getText().toString(), text_dob.getText().toString(),
						text_doj.getText().toString(), Integer.parseInt(text_age.getText().toString()));
				conn.updateDriver(id, driver);
				dispose();
				JOptionPane.showMessageDialog(DriverForm.this, "Driver Information updated successfully", "Success", JOptionPane.YES_OPTION);
				search.refreshDriverView();
			}
			else{
				if(conn.checkDriver(text_email.getText().toString())){
					DriverInfo driver = new DriverInfo(text_name.getText().toString(), text_mobile_no.getText().toString(),
							text_sex.getText().toString(), text_add.getText().toString(), text_city.getText().toString(), 
							text_state.getText().toString(), text_country.getText().toString(), text_pincode.getText().toString(), 
							text_email.getText().toString(), text_dl_no.getText().toString(), text_dob.getText().toString(),
							text_doj.getText().toString(), Integer.parseInt(text_age.getText().toString()));
					
					conn.AddDriver(driver);
					dispose();
					JOptionPane.showMessageDialog(DriverForm.this, "Driver added successfully", "Success", JOptionPane.YES_OPTION);
					search.refreshDriverView();
				}
				else{
					dispose();
					JOptionPane.showMessageDialog(DriverForm.this, "User already Exist", "Error", JOptionPane.ERROR_MESSAGE);
	 				return;
				}
			}
		}
		else{
			conn.deleteDriver(id);
			dispose();
			JOptionPane.showMessageDialog(DriverForm.this, "Driver Information deleted successfully", "Success", JOptionPane.YES_OPTION);
			search.refreshDriverView();
		}
	}
}
