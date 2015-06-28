package intern;

public class DriverInfo {
	
	private int id;
	private String name;
	private String mobile_no;
	private String sex;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String email;
	private String dl_no;
	private String dob;
	private String doj;
	private int age;
	
	public DriverInfo(String name, String mobile_no,String sex, String address, String city, String state, String country, String pincode,
			String email, String dl_no, String dob, String doj, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.mobile_no = mobile_no;
		this.sex = sex;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.email = email;
		this.dl_no = dl_no;
		this.dob = dob;
		this.doj = doj;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDl_no() {
		return dl_no;
	}

	public void setDl_no(String dl_no) {
		this.dl_no = dl_no;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}

