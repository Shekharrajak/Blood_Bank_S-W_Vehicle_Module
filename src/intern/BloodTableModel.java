package intern;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BloodTableModel extends AbstractTableModel{

	public static final int OBJECT_COL = -1;
	private static final int BLOOD_GRP_COL = 0;
	private static final int DONOR_NAME_COL = 1;
	private static final int DONOR_ADDRESS_COL = 2;
	private static final int DONOR_MOBILE_NO_COL = 3;
	private static final int QUANTITY_COL = 4;
	private static final int BLOOD_HOSPITAL_COL = 5;
	
	private String[] columnNames = {"Blood Group", "Donor Name", "Donor Address", "Donor Mobile No", "Quantity", "Blood Hospital"};
	private List<BloodInfo> blood_list = new ArrayList<BloodInfo>();
	
	public BloodTableModel(List<BloodInfo> blood_list) {
		// TODO Auto-generated constructor stub
		this.blood_list = blood_list;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return blood_list.size();
	}
	
	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		BloodInfo blood = blood_list.get(row);
		
		switch(col){
		case BLOOD_GRP_COL :
			return blood.getBlood_grp();
		case DONOR_NAME_COL:
			return blood.getDonor_name();
		case DONOR_ADDRESS_COL:
			return blood.getDonor_address();
		case DONOR_MOBILE_NO_COL:
			return blood.getDonor_mobile_no();
		case QUANTITY_COL:
			return blood.getQuantity();
		case BLOOD_HOSPITAL_COL:
			return blood.getBlood_hospital();
		case OBJECT_COL:
			return blood;
		default:
			return blood.getBlood_grp();
		}
	}
	
	@Override
	public java.lang.Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}

}
