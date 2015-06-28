package intern;

public class BloodInfo {

	private int id;
	private String blood_grp;   	//Blooad Group of blood
	private Double quantity;  		//Quantity of blood
	private String city_store;   	//City where blooad is currently stored
	private String donated_city;  	//City where blood is donated
	private String donor_name;  	//Name of donor of blood
	private String donor_date; 		//Date at which blood is donated
	private String donor_email; 	//Donor email
	private String donor_dob;       //Date of Birth of Donor
	private String donor_address;			//Address of donor
	private String donor_city;			//City of donor
	private String donor_mobile_no;	//Mobile no. of donor
	private String donor_work;		//Work of donor
	private String blood_taker;     //Doctor who taken the blood from donor
	private String blood_hospital;	//Hospital in which blood is donated by donor
	
	public BloodInfo(String blood_grp, Double quantity, String city_store, String donated_city, String donor_name,
			String donor_date, String donor_email, String donor_dob, String donor_address, String donor_city,
			String donor_mobile_no, String donor_work, String blood_taker, String blood_hospital) {
		// TODO Auto-generated constructor stub
		this.blood_grp = blood_grp;
		this.quantity = quantity;
		this.city_store = city_store;
		this.donated_city = donated_city;
		this.donor_name = donor_name;
		this.donor_date = donor_date;
		this.donor_email = donor_email;
		this.donor_dob = donor_dob;
		this.donor_address = donor_address;
		this.donor_city = donor_city;
		this.donor_mobile_no = donor_mobile_no;
		this.donor_work = donor_work;
		this.blood_taker = blood_taker;
		this.blood_hospital = blood_hospital;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getBlood_grp() {
		return blood_grp;
	}

	public void setBlood_grp(String blood_grp) {
		this.blood_grp = blood_grp;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getCity_store() {
		return city_store;
	}

	public void setCity_store(String city_store) {
		this.city_store = city_store;
	}

	public String getDonated_city() {
		return donated_city;
	}

	public void setDonated_city(String donated_city) {
		this.donated_city = donated_city;
	}

	public String getDonor_name() {
		return donor_name;
	}

	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}

	public String getDonor_date() {
		return donor_date;
	}

	public void setDonor_date(String donor_date) {
		this.donor_date = donor_date;
	}

	public String getDonor_email() {
		return donor_email;
	}

	public void setDonor_email(String donor_email) {
		this.donor_email = donor_email;
	}

	public String getDonor_address() {
		return donor_address;
	}

	public void setDonor_address(String donor_address) {
		this.donor_address = donor_address;
	}

	public String getDonor_city() {
		return donor_city;
	}

	public void setDonor_city(String donor_city) {
		this.donor_city = donor_city;
	}

	public String getDonor_dob() {
		return donor_dob;
	}

	public void setDonor_dob(String donor_dob) {
		this.donor_dob = donor_dob;
	}

	
	public String getDonor_mobile_no() {
		return donor_mobile_no;
	}

	public void setDonor_mobile_no(String donor_mobile_no) {
		this.donor_mobile_no = donor_mobile_no;
	}

	public String getDonor_work() {
		return donor_work;
	}

	public void setDonor_work(String donor_work) {
		this.donor_work = donor_work;
	}

	public String getBlood_taker() {
		return blood_taker;
	}

	public void setBlood_taker(String blood_taker) {
		this.blood_taker = blood_taker;
	}

	public String getBlood_hospital() {
		return blood_hospital;
	}

	public void setBlood_hospital(String blood_hospital) {
		this.blood_hospital = blood_hospital;
	}
}
