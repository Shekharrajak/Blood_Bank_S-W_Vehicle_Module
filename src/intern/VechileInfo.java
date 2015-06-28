package intern;

import java.util.ArrayList;

public class VechileInfo {

	private int id;  				//Id of the vechile
	private String vehicle_name;	//Name of the Vehicle
	private String driver_name;		//Driver Name of that vehicle
	private String chasis_no;		//Chasis no of vehicle
	private String engine_no;		//Engine No of vehicle
	private String necc_items;		//Necessary items in vehicle
	private String vehicle_no;		//Number of Vehicle		//Tehisla in which Vehicle run
	private String orgin_city;		//Starting city of vehicle
	private String end_city;		//Ending city of vehicle
	private String doctor_name;		//Name of doctor in vehicle
	private String doctor_hospital;	//Hospital name in which doctor belong to
	private String doctor_mobile_no;//Mobile No. of doctor
	private String doctor_age;		//Age of doctor
	
	private ArrayList<String> list_cities;
	
	public VechileInfo(String vehicle_name, String driver_name, String chasis_no, String engine_no,
			String necc_items, String vehicle_no, String orgin_city, String end_city,
			String doctor_name, String doctor_hospital, String doctor_mobile_no, String doctor_age/*,
			ArrayList<String> list_cities*/) {
		// TODO Auto-generated constructor stub
		
		this.vehicle_name = vehicle_name;
		this.driver_name = driver_name;
		this.chasis_no = chasis_no;
		this.engine_no = engine_no;
		this.necc_items = necc_items;
		this.vehicle_no = vehicle_no;
		this.orgin_city = orgin_city;
		this.end_city = end_city;
		this.doctor_name = doctor_name;
		this.doctor_hospital = doctor_hospital;
		this.doctor_mobile_no = doctor_mobile_no;
		this.doctor_age = doctor_age;
		//this.list_cities = list_cities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getChasis_no() {
		return chasis_no;
	}

	public void setChasis_no(String chasis_no) {
		this.chasis_no = chasis_no;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public String getNecc_items() {
		return necc_items;
	}

	public void setNecc_items(String necc_items) {
		this.necc_items = necc_items;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getOrgin_city() {
		return orgin_city;
	}

	public void setOrgin_city(String orgin_city) {
		this.orgin_city = orgin_city;
	}

	public String getEnd_city() {
		return end_city;
	}

	public void setEnd_city(String end_city) {
		this.end_city = end_city;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_hospital() {
		return doctor_hospital;
	}

	public void setDoctor_hospital(String doctor_hospital) {
		this.doctor_hospital = doctor_hospital;
	}

	public String getDoctor_mobile_no() {
		return doctor_mobile_no;
	}

	public void setDoctor_mobile_no(String doctor_mobile_no) {
		this.doctor_mobile_no = doctor_mobile_no;
	}

	public String getDoctor_age() {
		return doctor_age;
	}

	public void setDoctor_age(String doctor_age) {
		this.doctor_age = doctor_age;
	}

	public ArrayList<String> getList_cities() {
		return list_cities;
	}

	public void setList_cities(ArrayList<String> list_cities) {
		this.list_cities = list_cities;
	}
}
