package intern;

/**
 * 
 * Connections.java  
 * @author  Himanshu Garg
 * this class have all functions that get and set and access data base in MYSQL
 * and make all operation on it
 * we make our operation on the data base library
 * 
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connections {

 // JDBC driver name and database URL
 public String pass;

 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 static final String DB_URL = "jdbc:mysql://localhost:3306/blood_donation";
 String dbUrl = "jdbc:mysql://localhost:3306/blood_donation?allowMultiQuery=true";
 Connection conn = null;
 Statement stmt = null;
 // Database credentials
 static final String USER = "root";
 static final String PASS = "";

 /**
  * void connection function that connect to the data base with the user name
  * and password and database url it takes no paramiter
  * 
  */
 public void connectToDB() {

  try {
   //Class.forName("com.mysql.jdbc.Driver");
   conn = DriverManager.getConnection(DB_URL, USER, PASS);
  } catch (SQLException e) {

   e.printStackTrace();
  }
 }

 /**
  * void closeConnection function that close all open connections and other
  * resources it uses to clean the environment
  * 
  * 
  * 
  */
 public void closeConnection()

 {
  try {
   if (stmt != null)
    conn.close();
  } catch (SQLException se) {
   se.printStackTrace();
  }// do nothing
  try {
   if (conn != null)
    conn.close();
  } catch (SQLException se) {
   se.printStackTrace();

  }
 }

 /**
  * String [][] DriverView function that get all informations about any driver
  * and store it in two d array to show them in the table of the drivers
  * 
  * 
  * @return
  */
 public ArrayList<DriverInfo>  getAllDrivers() {
  ArrayList<DriverInfo> list = new ArrayList<DriverInfo>();
  try {

   connectToDB();
   stmt = conn.createStatement();
   // to view the driver quary

   String sql = "SELECT * FROM driver ";
   ResultSet rs = stmt.executeQuery(sql);

   while (rs.next()) {
    int i = 0;
    // Retrieve by column name
    DriverInfo driver = convertRowToDriver(rs);
    list.add(driver);
   } // while
   rs.close();
   return list;
   // to search by driver id

  }// try

  catch (SQLException se) {
   // Handle errors for JDBC
   System.out.println("DataBase Error Please Try Again !");
  } catch (Exception e) {
   // Handle errors for Class.forName
   System.out.println("DataBase Error Please Try Again !");
  }

  finally {
   closeConnection();
  }// end finally

  return list;
 }

 /**
  * getDriverInformation  function to get Detaisl of a particulat Driver
  * from Database.
  */
 
 public DriverInfo searchDriver(String email) throws SQLException{
	 
	 connectToDB();
	
	 PreparedStatement stat = null;
	 ResultSet  rs = null;
	 String sql = "SELECT * FROM driver WHERE email=?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setString(1, email);
		 rs = stat.executeQuery();
		 return convertRowToDriver(rs);
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
		  } finally {
		   closeConnection();
		  }
	 return null;
 }
 
 public DriverInfo convertRowToDriver(ResultSet rs) throws SQLException{
	 int id = rs.getInt("id");
	 String name = rs.getString("name");
	 String mobile_no = rs.getString("mobile_no");
	 String sex = rs.getString("sex");
	 String address = rs.getString("address");
	 String city = rs.getString("city");
	 String state = rs.getString("state");
	 String pincode = rs.getString("pincode");
	 String dob = rs.getString("dob");
	 String country = rs.getString("country");
	 String dl_no = rs.getString("dl_no");
	 String doj = rs.getString("doj");
	 String email = rs.getString("email");
	 int age = rs.getInt("age");
	 
	 DriverInfo driver = new DriverInfo(name, mobile_no, sex, address, city, state, country, pincode, email, dl_no, dob, doj, age);
	 return driver;
 }
 
 
 public boolean checkDriver(String email){
	 
	 connectToDB();
	  PreparedStatement stat = null;
	  ResultSet rs = null;
	  String sql = "SELECT * FROM driver WHERE email = ?";
	  try{
		  stat = conn.prepareStatement(sql);
		  stat.setString(1, email);
		  rs = stat.executeQuery();
		  
		  if(!rs.next())
			  return true;
		  else
			  return false;
	  }
	  catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
		  } finally {
		   closeConnection();
		  }
	  return false;
 }
 
 public void AddDriver(DriverInfo driver) {

  connectToDB();
  PreparedStatement stat = null;
  String sql = "INSERT INTO `driver`(`name`, `mobile_no`, `dl_no`, `doj`, `email`, `country`, `pincode`, "
  		+ "`sex`, `address`, `state`, `city`, `dob`, `age`) "
  		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  try {
	  stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	  stat.setString(1, driver.getName());
	  stat.setString(2, driver.getMobile_no());
	  stat.setString(3, driver.getDl_no());
	  stat.setString(4, driver.getDoj());
	  stat.setString(5, driver.getEmail());
	  stat.setString(6, driver.getCountry());
	  stat.setString(7, driver.getPincode());
	  stat.setString(8, driver.getSex());
	  stat.setString(9, driver.getAddress());
	  stat.setString(10, driver.getState());
	  stat.setString(11, driver.getCity());
	  stat.setString(12, driver.getDob());
	  stat.setInt(13, driver.getAge());
	  stat.executeUpdate();
	  
	  ResultSet generatedKeys = stat.getGeneratedKeys();
		if (generatedKeys.next()) {
			driver.setId(generatedKeys.getInt(1));
		} else {
			throw new SQLException("Error generating key for employee");
		}	
   
   // by clicking save it will be updated from here
  }// try

  catch (SQLException se) {
   // Handle errors for JDBC
   se.printStackTrace();
  } catch (Exception e) {
   // Handle errors for Class.forName
   e.printStackTrace();
  } finally {
   closeConnection();
  }
 }
 
 public void deleteDriver(int id) throws SQLException{
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "DELETE FROM driver WHERE id = ?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setInt(1, id);
		 stat.executeQuery();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
 public void updateDriver(int id, DriverInfo driver){
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "UPDATE driver SET name = ?, mobile_no = ?, dl_no = ?, doj = ?, email = ?, country = ?, pincode = ?,"
	 		+ " sex = ?, address = ?, state = ?, city = ?, dob = ? WHERE id = ?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setString(1, driver.getName());
		 stat.setString(2, driver.getMobile_no());
		 stat.setString(3, driver.getDl_no());
		 stat.setString(4, driver.getDoj());
		 stat.setString(5, driver.getEmail());
		 stat.setString(6, driver.getCountry());
		 stat.setString(8, driver.getPincode());
		 stat.setString(9, driver.getSex());
		 stat.setString(10, driver.getAddress());
		 stat.setString(11, driver.getState());
		 stat.setString(12, driver.getCity());
		 stat.setString(13, driver.getDob());
		 stat.setInt(14, id);
		 stat.executeUpdate();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
 public void addBloodInfo(BloodInfo blood){
	 
	 connectToDB();
	  PreparedStatement stat = null;
	  String sql = "INSERT INTO `blood`(`blood_grp`, `city_store`, `donated_city`, `donor_name`, `donor_date`, "
	  		+ "`donor_email`, `donor_dob`, `donor_mobile_no`, `donor_city`, "
	  		+ "`donor_address`, `blood_taker`, `quantity`, `blood_hospital`, `donor_work`) "
	  		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	  try {
		  stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		  stat.setString(1, blood.getBlood_grp());
		  stat.setString(2, blood.getCity_store());
		  stat.setString(3, blood.getDonated_city());
		  stat.setString(4, blood.getDonor_name());
		  stat.setString(5, blood.getDonor_date());
		  stat.setString(6, blood.getDonor_email());
		  stat.setString(7, blood.getDonor_dob());
		  stat.setString(8, blood.getDonor_mobile_no());
		  stat.setString(9, blood.getDonor_city());
		  stat.setString(10, blood.getDonor_address());
		  stat.setString(11, blood.getBlood_taker());
		  stat.setDouble(12, blood.getQuantity());
		  stat.setString(13, blood.getBlood_hospital());
		  stat.setString(14, blood.getDonor_work());
		  stat.executeUpdate();
		  
		  ResultSet generatedKeys = stat.getGeneratedKeys();
			if (generatedKeys.next()) {
				blood.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Error generating key for employee");
			}	
	   
	   // by clicking save it will be updated from here
	  }// try

	  catch (SQLException se) {
	   // Handle errors for JDBC
	   se.printStackTrace();
	  } catch (Exception e) {
	   // Handle errors for Class.forName
	   e.printStackTrace();
	  } finally {
	   closeConnection();
	  }
 }
 
public ArrayList<BloodInfo> getAllBlood(){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 ResultSet rs = null;
	 ArrayList<BloodInfo> bloodInfo = new ArrayList<BloodInfo>();
	 String sql = "SELECT * FROM blood";
	 try{
		 stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 
		 rs = stat.executeQuery();
		 
		 while(rs.next())
			 bloodInfo.add(convertRowToBloodInfo(rs));
		 return bloodInfo;
		 
	 }
	 catch (SQLException se) {
		   // Handle errors for JDBC
		   System.out.println("DataBase Error Please Try Again !");
	 } catch (Exception e) {
		   // Handle errors for Class.forName
		 System.out.println("DataBase Error Please Try Again !");
	 }

	 finally {
		 closeConnection();
	 }// end finally

	return bloodInfo; 
 }
 
 public ArrayList<BloodInfo> searchBlood(String key, String value){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 ResultSet rs = null;
	 ArrayList<BloodInfo> bloodInfo = new ArrayList<BloodInfo>();
	 String sql = "SELECT * FROM blood WHERE "+ key + "=?";
	 try{
		 stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 stat.setString(1, value);
		 
		 rs = stat.executeQuery();
		 
		 while(rs.next())
			 bloodInfo.add(convertRowToBloodInfo(rs));
		 return bloodInfo;
		 
	 }
	 catch (SQLException se) {
		   // Handle errors for JDBC
		   System.out.println("DataBase Error Please Try Again !");
	 } catch (Exception e) {
		   // Handle errors for Class.forName
		 System.out.println("DataBase Error Please Try Again !");
	 }

	 finally {
		 closeConnection();
	 }// end finally

	return bloodInfo;
	 
 }
 
 private BloodInfo convertRowToBloodInfo(ResultSet rs) throws SQLException{
	 
	 String blood_grp = rs.getString("blod_grp");
	 String city_store = rs.getString("city_store");
	 String donated_city = rs.getString("donated_city");
	 String donor_name = rs.getString("donor_name");
	 String donor_email = rs.getString("donor_email");
	 String donor_dob = rs.getString("donor_dob");
	 String donor_work = rs.getString("donor_work");
	 String donor_date = rs.getString("donor_date");
	 String donor_mobile_no = rs.getString("donor_mobile_no");
	 String donor_address = rs.getString("donor_address");
	 String donor_city = rs.getString("donor_city");
	 String blood_taker = rs.getString("blood_taker");
	 String blood_hospital = rs.getString("blood_hospital");
	 Double quantity = rs.getDouble("quantity");
	 
	 return new BloodInfo(blood_grp, quantity, city_store, donated_city, donor_name, donor_date, donor_email, donor_dob, donor_address, donor_city, donor_mobile_no, donor_work, blood_taker, blood_hospital);
 }
 
 public void deleteBlood(int id){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "DELETE FROM blood WHERE id = ?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setInt(1, id);
		 stat.executeQuery();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
 public void updateBlood(int id, BloodInfo blood){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "UPDATE blood SET blood_grp = ?, city_store = ?, donated_city = ?, donor_name = ?, donor_date = ?, "
	  		+ " donor_email = ?, donor_dob = ?, donor_mobile_no = ?, donor_city = ?, "
	  		+ " donor_address = ?, blood_taker = ?, quantity = ?, blood_hospital = ?, donor_work = ?"
	  		+ " WHERE id = ?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setString(1, blood.getBlood_grp());
		 stat.setString(2, blood.getCity_store());
		 stat.setString(3, blood.getDonated_city());
		 stat.setString(4, blood.getDonor_name());
		 stat.setString(5, blood.getDonor_date());
		 stat.setString(6, blood.getDonor_email());
		 stat.setString(7, blood.getDonor_dob());
		 stat.setString(8, blood.getDonor_mobile_no());
		 stat.setString(9, blood.getDonor_city());
		 stat.setString(10, blood.getDonor_address());
		 stat.setString(11, blood.getBlood_taker());
		 stat.setDouble(12, blood.getQuantity());
		 stat.setString(13, blood.getBlood_hospital());
		 stat.setString(14, blood.getDonor_work());
		 stat.setInt(15, id);
		 stat.executeQuery();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
public void addVehicleInfo(VechileInfo vehicle){
	 
	 connectToDB();
	  PreparedStatement stat = null;
	  String sql = "INSERT INTO `vehicle`(`vehicle_name`, `driver_name`, `chasis_no`, `engine_no`, `necc_items`, "
	  		+ "`vehicle_no`, `origin_city`, `end_city`, "
	  		+ "`doctor_name`, `doctor_hospital`, `doctor_mobile_no`, `age`) "
	  		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	  try {
		  stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		  stat.setString(1, vehicle.getVehicle_name());
		  stat.setString(2, vehicle.getDriver_name());
		  stat.setString(3, vehicle.getChasis_no());
		  stat.setString(4, vehicle.getEngine_no());
		  stat.setString(5, vehicle.getNecc_items());
		  stat.setString(6, vehicle.getVehicle_no());
		  stat.setString(7, vehicle.getOrgin_city());
		  stat.setString(8, vehicle.getEnd_city());
		  stat.setString(9, vehicle.getDoctor_name());
		  stat.setString(10, vehicle.getDoctor_hospital());
		  stat.setString(11, vehicle.getDoctor_mobile_no());
		  stat.setString(12, vehicle.getDoctor_age());
		  stat.executeUpdate();
		  
		  ResultSet generatedKeys = stat.getGeneratedKeys();
			if (generatedKeys.next()) {
				vehicle.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Error generating key for employee");
			}	
	   
	   // by clicking save it will be updated from here
	  }// try

	  catch (SQLException se) {
	   // Handle errors for JDBC
	   se.printStackTrace();
	  } catch (Exception e) {
	   // Handle errors for Class.forName
	   e.printStackTrace();
	  } finally {
	   closeConnection();
	  }
 }

public ArrayList<VechileInfo> getAllVehicle(){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 ResultSet rs = null;
	 ArrayList<VechileInfo> vehicleInfo = new ArrayList<VechileInfo>();
	 String sql = "SELECT * FROM vehicle";
	 
	 try{
		 stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 rs = stat.executeQuery();
		 
		 while(rs.next())
			 vehicleInfo.add(convertRowToVehicleInfo(rs));
		 return vehicleInfo;
		 
	 }
	 catch (SQLException se) {
		   // Handle errors for JDBC
		   System.out.println("DataBase Error Please Try Again !");
	 } catch (Exception e) {
		   // Handle errors for Class.forName
		 System.out.println("DataBase Error Please Try Again !");
	 }

	 finally {
		 closeConnection();
	 }// end finally

	return vehicleInfo;
}

 public ArrayList<VechileInfo> searchVehicle(String key, String value){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 ResultSet rs = null;
	 ArrayList<VechileInfo> vehicleInfo = new ArrayList<VechileInfo>();
	 String sql = "SELECT * FROM vehicle WHERE "+ key + "=?";
	 
	 try{
		 stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		 stat.setString(1, value);
		 
		 rs = stat.executeQuery();
		 
		 while(rs.next())
			 vehicleInfo.add(convertRowToVehicleInfo(rs));
		 return vehicleInfo;
		 
	 }
	 catch (SQLException se) {
		   // Handle errors for JDBC
		   System.out.println("DataBase Error Please Try Again !");
	 } catch (Exception e) {
		   // Handle errors for Class.forName
		 System.out.println("DataBase Error Please Try Again !");
	 }

	 finally {
		 closeConnection();
	 }// end finally

	return vehicleInfo;
 }
 
 private VechileInfo convertRowToVehicleInfo(ResultSet rs) throws SQLException{
	 
	 String vehicle_name = rs.getString("vehicle_name");
	 String driver_name = rs.getString("driver_name");
	 String chasis_no = rs.getString("chasis_no");
	 String engine_no = rs.getString("engine_no");
	 String necc_items = rs.getString("necc_items");
	 String vehicle_no = rs.getString("vehicle_no");
	 String origin_city = rs.getString("origin_city");
	 String end_city = rs.getString("end_city");
	 String doctor_name = rs.getString("doctor_name");
	 String doctor_hospital = rs.getString("doctor_hospital");
	 String doctor_mobile_no = rs.getString("doctor_mobile_no");
	 String age = rs.getString("age");
	 ArrayList<String> list_cities = (ArrayList<String>) rs.getArray("list_cities");
	 
	 return new VechileInfo(vehicle_name, driver_name, chasis_no, engine_no, necc_items, vehicle_no, origin_city, end_city, doctor_name, doctor_hospital, doctor_mobile_no, age/*, list_cities*/);
 }
 
 public void deleteVehicle(int id){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "DELETE FROM vehicle WHERE id = ?";
	 try{
		 stat = conn.prepareStatement(sql);
		 stat.setInt(1, id);
		 stat.executeQuery();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
 public void updateVehicle(int id, VechileInfo vehicle){
	 
	 connectToDB();
	 PreparedStatement stat = null;
	 String sql = "UPDATE vehicle SET vehicle_name = ?, driver_name = ?, chasis_no = ?, engine_no = ?, necc_items = ?, "
	  		+ "vehicle_no = ?, origin_city = ?, end_city = ?, "
	  		+ "doctor_name = ?, doctor_hospital = ?, doctor_mobile_no = ?, age = ?"
	  		+ " WHERE id = ?";
	 
	 try{
		stat = conn.prepareStatement(sql);
		stat.setString(1, vehicle.getVehicle_name());
		stat.setString(2, vehicle.getDriver_name());
		stat.setString(3, vehicle.getChasis_no());
		stat.setString(4, vehicle.getEngine_no());
		stat.setString(5, vehicle.getNecc_items());
		stat.setString(6, vehicle.getVehicle_no());
		stat.setString(7, vehicle.getOrgin_city());
		stat.setString(8, vehicle.getEnd_city());
		stat.setString(9, vehicle.getDoctor_name());
		stat.setString(10, vehicle.getDoctor_hospital());
		stat.setString(11, vehicle.getDoctor_mobile_no());
		stat.setString(12, vehicle.getDoctor_age());
		stat.setInt(13, id);
		stat.executeQuery();
	 }
	 catch (Exception e) {
		   // Handle errors for Class.forName
		   e.printStackTrace();
	 } finally {
		 closeConnection();
	 }
 }
 
 /**
  * 
  it takes the name of the user and its pass word and check the
  * authentication
  * 
  * @param name
  * @return
  */
 
 public String Login(String name) {
  try {

   connectToDB();
   stmt = conn.createStatement();
   String sql = "SELECT password FROM user WHERE username ='" + name
     + "'";
   ResultSet rs = stmt.executeQuery(sql);
   // STEP 5: Extract data from result set
   rs.first();
   rs.next();
   pass = rs.getString("password");
   rs.close();

  } catch (SQLException se) {
   // Handle errors for JDBC
   se.printStackTrace();
  } catch (Exception e) {
   // Handle errors for Class.forName
   e.printStackTrace();
  } finally {

   closeConnection();

  }
  return pass;

 }

}
