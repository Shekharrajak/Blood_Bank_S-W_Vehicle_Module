package intern;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BloodForm extends Screen1 {

private final JPanel contentPanel = new JPanel();
	
	private JLabel blood_grp;
	private JLabel city_store;
	private JLabel donated_donor_city;
	private JLabel donor_name;
	private JLabel donor_date; //Date of Journey
	private JLabel donor_email;
	private JLabel dob;
	private JLabel donor_mobile_no;
	private JLabel donor_city;
	private JLabel donor_address;
	private JLabel blood_taker;
	private JLabel quantity;
	private JLabel blood_hospital;
	private JLabel donor_work;
	
	private JTextField text_blood_grp;
	private JTextField text_city_store;
	private JTextField text_donated_donor_city;
	private JTextField text_donor_name;
	private JTextField text_donor_date;
	private JTextField text_donor_email;
	private JTextField text_blood_hospital;
	private JTextArea text_dob;
	private JTextField text_donor_mobile_no;
	private JTextField text_donor_city;
	private JTextField text_donor_address;
	private JTextField text_blood_taker;
	private JTextField text_quantity;
	private JTextField tect_donor_work;
	
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
	
	boolean update;
	boolean delete;
	
	Connections conn;
	
	/**
	 * Create the dialog.
	 */
	public BloodForm(BloodSearch search, BloodInfo blood, boolean update, boolean delete) {
		
		
		super("Blood_Info");
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
				setTitle("Update Blood Information");
			else
				setTitle("Add Blood Information");
		}
		else
			setTitle("Delete Blood Information");
		
		if(!delete){
		
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.gridheight = 1;
			gbc.weighty = 0.125;
			gbc.fill = GridBagConstraints.BOTH;
			
			part1 = new JPanel();
			contentPanel.add(part1, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			donor_name = new JLabel("Donor Name:");
			donor_name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(donor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.weightx = 0.25;
			text_donor_name = new JTextField(10);
			if(update)
				text_donor_name.setText(blood.getDonor_name());
			part1.add(text_donor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			quantity = new JLabel("Quantity: ");
			quantity.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(quantity, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_quantity = new JTextField(10);
			if(update)
				text_quantity.setText(""+blood.getQuantity());
			part1.add(text_quantity, gbc);
			
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
			donated_donor_city = new JLabel("Donor City:");
			donated_donor_city.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(donated_donor_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.weightx = 0.25;
			text_donated_donor_city = new JTextField(10);
			if(update)
				text_donated_donor_city.setText(blood.getDonated_city());
			part1.add(text_donated_donor_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			donor_date = new JLabel("Date of Donor: ");
			donor_date.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part1.add(donor_date, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_donor_date = new JTextField(10);
			if(update)
				text_donor_date.setText(blood.getDonor_date());
			part1.add(text_donor_date, gbc);
			
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
			blood_grp = new JLabel("Blood Group: ");
			blood_grp.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(blood_grp, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_blood_grp = new JTextField(20);
			if(update)
				text_blood_grp.setText(blood.getBlood_grp());
			part2.add(text_blood_grp, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			donor_email = new JLabel("Donor Email:");
			donor_email.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part2.add(donor_email, gbc);
			
			gbc = new GridBagConstraints();
			gbc.weightx = 0.25;
			text_donor_email = new JTextField(10);
			if(update)
				text_donor_email.setText(blood.getDonor_email());
			part2.add(text_donor_email, gbc);
			
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
			city_store = new JLabel("Mobile No:");
			city_store.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(city_store, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_city_store = new JTextField(10);
			if(update)
				text_city_store.setText(blood.getCity_store());
			part3.add(text_city_store, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			donor_mobile_no = new JLabel("E-mail:");
			donor_mobile_no.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part3.add(donor_mobile_no, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_donor_mobile_no = new JTextField(10);
			if(update)
				text_donor_mobile_no.setText(blood.getDonor_mobile_no());
			part3.add(text_donor_mobile_no, gbc);
			
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
			donor_name = new JLabel("Date of Birth:");
			donor_name.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(donor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_donor_name = new JTextField(10);
			if(update)
				text_donor_name.setText(blood.getDonor_name());
			part4.add(text_donor_name, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			blood_hospital = new JLabel("blood_hospital:");
			blood_hospital.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part4.add(blood_hospital, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_blood_hospital = new JTextField(10);
			//if(update)
				//text_blood_hospital.setText(blood.getblood_hospital());
			part4.add(text_blood_hospital, gbc);
			
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
			dob = new JLabel("Address");
			dob.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(dob, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_dob = new JTextArea(3, 20);
			if(update)
				text_dob.setText(blood.getDonor_dob());
			part5.add(text_dob, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			donor_city = new JLabel("donor_city:");
			donor_city.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part5.add(donor_city, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_donor_city = new JTextField(10);
			if(update)
				text_donor_city.setText(blood.getDonor_city());
			part5.add(text_donor_city, gbc);
			
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
			donor_address = new JLabel("donor_address:");
			donor_address.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(donor_address, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_donor_address = new JTextField(10);
			if(update)
				text_donor_address.setText(blood.getDonor_address());
			part6.add(text_donor_address, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			blood_taker = new JLabel("blood_taker:");
			blood_taker.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(blood_taker, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			text_blood_taker = new JTextField(10);
			if(update)
				text_blood_taker.setText(blood.getBlood_taker());
			part6.add(text_blood_taker, gbc);
			
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
			donor_work = new JLabel("Donor Work:");
			donor_work.setFont(new Font("Microsoft Tai Le", Font.BOLD, 11));
			part6.add(donor_work, gbc);
			
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.WEST;
			gbc.weightx = 0.25;
			tect_donor_work = new JTextField(10);
			if(update)
				tect_donor_work.setText(blood.getDonor_work());
			part6.add(tect_donor_work, gbc);
			
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
						saveblood(search, blood.getId(), update, delete);
					else
						saveblood(search, 1, update, delete);
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
	
	private void saveblood(BloodSearch saerch, int id, boolean update, boolean delete) throws SQLException{
		
		if(!delete){
			
			if(update){
				BloodInfo blood = new BloodInfo(text_blood_grp.getText().toString(), Double.parseDouble(text_quantity.getText().toString()),
						text_city_store.getText().toString(), text_donated_donor_city.getText().toString(),
						text_donor_name.getText().toString(), text_donor_date.getText().toString(), 
						text_donor_email.getText().toString(), text_dob.getText().toString(), 
						text_donor_address.getText().toString(), text_donor_city.getText().toString(), 
						text_donor_mobile_no.getText().toString(), tect_donor_work.getText().toString(), 
						text_blood_taker.getText().toString(), text_blood_hospital.getText().toString());
				conn.updateBlood(id, blood);
				dispose();
				JOptionPane.showMessageDialog(BloodForm.this, "Blood Information updated successfully", "Success", JOptionPane.YES_OPTION);
				saerch.refreshBloodView();
			}
			else{
				BloodInfo blood = new BloodInfo(text_blood_grp.getText().toString(), Double.parseDouble(text_quantity.getText().toString()),
						text_city_store.getText().toString(), text_donated_donor_city.getText().toString(),
						text_donor_name.getText().toString(), text_donor_date.getText().toString(), 
						text_donor_email.getText().toString(), text_dob.getText().toString(), 
						text_donor_address.getText().toString(), text_donor_city.getText().toString(), 
						text_donor_mobile_no.getText().toString(), tect_donor_work.getText().toString(), 
						text_blood_taker.getText().toString(), text_blood_hospital.getText().toString());
				conn.addBloodInfo(blood);
				dispose();
				JOptionPane.showMessageDialog(BloodForm.this, "Blood Information added successfully", "Success", JOptionPane.YES_OPTION);
				saerch.refreshBloodView();
			}
		}
		else{
			conn.deleteBlood(id);
			dispose();
			JOptionPane.showMessageDialog(BloodForm.this, "Blood Information deleted successfullt", "Success", JOptionPane.YES_OPTION);
			saerch.refreshBloodView();
		}
	}
}
