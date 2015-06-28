package intern;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VehicleTableModel extends AbstractTableModel{

	public static final int OBJECT_COL = -1;
	private static final int VECHILE_NAME_COL = 0;
	private static final int DRIVER_NAME_COL = 1;
	private static final int CHASIS_NO_COL = 2;
	private static final int DOCTOR_NAME_COL = 3;
	private static final int NECC_ITEMS_COL = 4;
	
	private String[] columnNames = {"Vehicle Name", "Driver Name", "Chasis NO", "Doctor Name", "Tehsila", "Neccessary Items"};
	private List<VechileInfo> vehicle_list = new ArrayList<VechileInfo>();
	
	public VehicleTableModel(List<VechileInfo> vehicle_list) {
		// TODO Auto-generated constructor stub
		this.vehicle_list = vehicle_list;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vehicle_list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		VechileInfo vehicle = vehicle_list.get(row);
		
		switch(col){
		case VECHILE_NAME_COL :
			return vehicle.getVehicle_name();
		case DRIVER_NAME_COL:
			return vehicle.getDriver_name();
		case CHASIS_NO_COL:
			return vehicle.getChasis_no();
		case DOCTOR_NAME_COL:
			return vehicle.getDoctor_name();
		case NECC_ITEMS_COL:
			return vehicle.getNecc_items();
		case OBJECT_COL:
			return vehicle;
		default:
			return vehicle.getVehicle_name();
		}
	}

	@Override
	public java.lang.Class getColumnClass(int c){
		return getValueAt(0, c).getClass();
	}
}
