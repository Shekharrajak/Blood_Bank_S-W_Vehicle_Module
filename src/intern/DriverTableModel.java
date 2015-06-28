package intern;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DriverTableModel extends AbstractTableModel{

	public static final int OBJECT_COL = -1;
	private static final int  NAME_COL = 0;
	private static final int EMAIL_COL = 1;
	private static final int ADDRESS_COL = 2;
	private static final int DOB_COL = 3;
	private static final int MOBILE_NO_COL = 4;
	
	private String[] columnNames = {"Name", "Email", "Address", "DOB", "Mobile No."};
	private List<DriverInfo> driver_list = new ArrayList<DriverInfo>();
	
	public DriverTableModel(List<DriverInfo> list) {
		// TODO Auto-generated constructor stub
		this.driver_list = list;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return driver_list.size();
	}

	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		DriverInfo driver = driver_list.get(row);
		
		switch(col){
		case NAME_COL :
			return driver.getName();
		case EMAIL_COL:
			return driver.getEmail();
		case ADDRESS_COL:
			return driver.getAddress();
		case DOB_COL:
			return driver.getDob();
		case MOBILE_NO_COL:
			return driver.getMobile_no();
		case OBJECT_COL:
			return driver;
		default:
			return driver.getName();
		}
	}
	
	@Override
	public java.lang.Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}

}
