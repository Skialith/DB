package testweb1.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import testweb1.check.CheckForm;
import testweb1.dao.UserDAO;
import testweb1.vo.RobotInfo;
import testweb1.vo.UpdatedAddress;
import testweb1.vo.UpdatedRobotname;
import testweb1.vo.UpdatedUserInfo;
import testweb1.vo.UserInfo;
import testweb1.db.DBConnect;


public class UserDAOImpl implements UserDAO {
  public UserInfo queryUserById (int id)throws Exception{
		  String sql = "select * from userinfo where userinfoid=? ";
		  PreparedStatement pstmt = null;
		  DBConnect dbc = null;
		  UserInfo userinfo = new UserInfo();
		
		  try {
			  dbc = new DBConnect();
			  
			  pstmt = dbc.getConnection().prepareStatement(sql);
			  pstmt.setInt(1,id);

			  ResultSet rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  userinfo.setUsername(rs.getString("usernameId"));
				  if(rs.getString("sex").equals("0")) {
						 userinfo.setGender("man");
					  }else {
						 userinfo.setGender("woman");
					  }
			
			  }
			      rs.close();
			      pstmt.close();
		   }catch(SQLException e) {
			      System.out.println(e.getMessage());
		   }finally {
			      dbc.close();
			  
		   }
		      
              return userinfo;
   }
  public int queryIdByUser (UserInfo userinfo)throws Exception{
	  String sql = "select userinfoid from userinfo where usernameId=? ";
	  PreparedStatement pstmt = null;
	  DBConnect dbc = null;
	  int id = 0;
	
	  try {
		  dbc = new DBConnect();
		  
		  pstmt = dbc.getConnection().prepareStatement(sql);
		  pstmt.setString(1,userinfo.getUsername());
		  
		  ResultSet rs = pstmt.executeQuery();
		  
		  while(rs.next()) {
			  id = rs.getInt("userinfoid");
		  }
		 
		  rs.close();
		  
		  pstmt.close();
	  }catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }finally {
		  dbc.close();
		  
	  }

	  return id;
  }
	//Register method
  @Override
  public int insertByRegister(UserInfo userinfo, RobotInfo robotinfo)throws Exception{

	  String robotsql = "insert into robotinfo(robotname) values(?)";
	  String rsql = "insert into userinfo(usernameId,password,sex,phonenum,robotname) values(?,?,?,?,?)";
	  
	  PreparedStatement rpstmt = null;
	  PreparedStatement robotpstmt = null;
	  
	  DBConnect dbc = null;

	  int flag1 = 0;
	  int flag2 = 0;
	  try {
		  //Connect to a database, write an sql template, and bind it to a Preparedstatement
		  dbc = new DBConnect();
		  robotpstmt = dbc.getConnection().prepareStatement(robotsql);
		  rpstmt = dbc.getConnection().prepareStatement(rsql);
		  //Set the template "?" value
		  
		  robotpstmt.setString(1,robotinfo.getRobotname());

		  rpstmt.setString(1,userinfo.getUsername());
		  rpstmt.setString(2,userinfo.getPassword());
		  rpstmt.setString(3,userinfo.getGender());
		  rpstmt.setString(4,userinfo.getPhonenum());
		  rpstmt.setString(5,robotinfo.getRobotname());

		  
  
		  //Database query, use the login inside the query method
		  UserInfo u = queryByUserInfo(userinfo);
		  RobotInfo r = queryByRobotInfo(robotinfo);
		  //Create an object for the check function java file
          CheckForm check = new CheckForm();
		  //Register functions
		  if(u!=null) {
			  //If the user content is displayed, the user already exists
			  //System.out.println("User exists！");
			  flag1 = -1;
		  }else {
			  //The user does not exist, registers and returns the number of rows registered for updates
			  //Fault tolerance during registration
			  System.out.println("regist-password of " + userinfo.getUsername() + " is " + userinfo.getPassword());		  
			  if(userinfo.getPassword().length()!=8&&userinfo.getPhonenum().length()!=11){
				  flag1 = -4;
				  
			  }else if(userinfo.getPassword().length()!=8) {
				  //Determine password format (whether it is 8 digits)
				  flag1 = -2;
				  
			  }else if(userinfo.getPhonenum().length()!=11||(check.isNotNumeric(userinfo.getPhonenum()))){
				  //Determine the phone number format (not equal to 11 digits && if it is not a number, an error is reported)
				  flag1 = -3;
			 
			  }else if(!(userinfo.getPassword().equals(userinfo.getConfirmpassword()))) {
				  //Check whether the confirmed password is the same as the password
				  flag1 = -5;
  
			  }else if(r!=null) {
				  //robot name can not be repeat
				  flag1 = -6;
			  }else if(robotinfo.getRobotname()== null) {
				  flag1 = -7;
			  }
			  else {
				
				  flag1 = robotpstmt.executeUpdate();//Returns a positive number of rows
			      flag2 = rpstmt.executeUpdate();
			      if((flag1>0)&&(flag2>0)) {
			    	  flag1 = 1;
			      }
			 
			  }
		  }

		  rpstmt.close();
		  robotpstmt.close();

	  }catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }finally {
		  dbc.close();
	  }
	  
	  return flag1;

  }
  public RobotInfo queryByRobotInfo (RobotInfo robotinfo)throws Exception{
	  String checksql = "select * from robotinfo where robotname=? ";
	  PreparedStatement checkpstmt = null;
	  DBConnect dbc = null;
	  RobotInfo r = null;
	
	  try {
		  
		  dbc = new DBConnect();
		  checkpstmt = dbc.getConnection().prepareStatement(checksql);

		  checkpstmt.setString(1,robotinfo.getRobotname());

		  ResultSet rs = checkpstmt.executeQuery();

		  while(rs.next()) {
			  //test
			  System.out.println("Here is UserDAOimpl (queryByRobotInfo)");
			  System.out.println("Data set queried from the robotinfo table (unique):" + rs);
			  System.out.println("The value of robotname in the data set queried from the robotinfo table:" + rs.getString("robotname"));
			
			  r = new RobotInfo();
			  r.setRobotname("robotname");;

		  }
		 
		  rs.close();
		  
		  checkpstmt.close();
	  }catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }finally {
		  dbc.close();
		  
	  }

	  return r;

  }
  
  //Look up the robotname from userInfo and save it to robotInfo
  public String queryRobotById (int id)throws Exception{
	  String findsql = "select * from userinfo where userinfoid=? ";
	  PreparedStatement findpstmt = null;
	  DBConnect dbc = null;
	  String robotname = null;
	
	  try {
		  dbc = new DBConnect();
		  findpstmt = dbc.getConnection().prepareStatement(findsql);
		 
		  findpstmt.setInt(1,id);

		  ResultSet rs = findpstmt.executeQuery();
		  while(rs.next()) {
			  //test
			  System.out.println("Here is UserDAOimpl (queryRobotByUser)");
			  System.out.println("Data set queried from the userinfo table: " + rs);
			  System.out.println("The value of the corresponding foreign key robotname in the dataset queried from the userinfo table: " + rs.getString("robotname"));
		      
			  robotname = rs.getString("robotname");
			  System.out.println("robotname stored = " + robotname);
	 	  }
		 
		  rs.close();
		  
		  findpstmt.close();
	  }catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }finally {
		  dbc.close();
		  
	  }

	  return robotname;

  }
  //login method
  @Override
  public UserInfo queryByUserInfo (UserInfo userinfo)throws Exception{
	  String lsql = "select * from userinfo where usernameId=? ";
	  PreparedStatement lpstmt = null;
	  DBConnect dbc = null;
	  UserInfo us = null;
	
	  try {
	
		  dbc = new DBConnect();
		  lpstmt = dbc.getConnection().prepareStatement(lsql);
		  lpstmt.setString(1,userinfo.getUsername());
		  
		  //There can only be one item in the database query (login)
		  ResultSet rs = lpstmt.executeQuery();

		  //Login part of the function implementation
		  //If there is data in it, save the data to us; If not, us is empty and left to the Servlet for judgment
		  while(rs.next()) {
			  //test
			  System.out.println("Here is UserDAOimpl (queryByUserInfo)");
			  System.out.println("The value of the password in the dataset (login) queried from the userinfo table: " + rs.getString("password"));
			
			  us = new UserInfo();
			  us.setUserinfoid(rs.getInt("userinfoid"));
			  us.setUsername(rs.getString("usernameId"));
			  us.setPassword(rs.getString("password"));
			  if(rs.getString("sex").equals("0")) {
				 userinfo.setGender("man");
			  }else {
				 userinfo.setGender("woman");
			  }
			  us.setPhonenum(rs.getString("phonenum"));

		  }
		 
		  rs.close();
		  
		  lpstmt.close();
	  }catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }finally {
		  dbc.close();
		  
	  }

	  return us;

  }
  public int updatedUsernameByUserInfo(UserInfo userinfo, UpdatedUserInfo updateduserinfo) throws Exception {
		int flag = 0;
		String sql1 = "update userinfo set usernameId=? where usernameId=? ";
		String sql2 = "select * from userinfo ";

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);		
			
			pstmt2=dbc.getConnection().prepareStatement(sql2);
			String s = updateduserinfo.getUpdatedUsername();
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				if(rs.getString("usernameId").equals(updateduserinfo.getUpdatedUsername()) || rs.getString("usernameId") == null ) {
					flag=1;
					return flag;
				}			
			}
			
			
			pstmt1= dbc.getConnection().prepareStatement(sql1);
			pstmt1.setString(1, updateduserinfo.getUpdatedUsername());
			pstmt1.setString(2, userinfo.getUsername());
			
			int eu = pstmt1.executeUpdate();
			System.out.println(eu+"...ddddd");

			conn.commit();

			pstmt1.close();
			pstmt2.close();
			rs.close();
		}catch(SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
			
		}finally {
			dbc.close();
		}
		return flag;	
}
	@Override
  public void updatedPasswordByUserInfo(UserInfo userinfo, UpdatedUserInfo updateduserinfo) throws Exception {
		Connection conn = null;
		String sql = "update userinfo set password=? where usernameId=? ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);
			pstmt= dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, updateduserinfo.getUpdatedPassword());
			pstmt.setString(2, updateduserinfo.getUpdatedUsername());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}finally {
			conn.close();
			dbc.close();
		}
	}
  public int deleteByUserInfo (UserInfo userinfo)throws Exception{
		Connection conn = null;
		int flag = 0;
		String sql1 = "delete from userinfo where usernameId =?";
		String sql2 = "select * from userinfo ";
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);
			pstmt2= dbc.getConnection().prepareStatement(sql2);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				if(rs.getString("usernameId").equals(userinfo.getUsername())){
					
					pstmt1= dbc.getConnection().prepareStatement(sql1);
					pstmt1.setString(1, userinfo.getUsername());
					int eu = pstmt1.executeUpdate();
					System.out.println(eu+"..dbc");
					pstmt1.close();
					flag=1;
					
				}			
			}
		
			pstmt1.close();
			pstmt2.close();
			rs.close();
			conn.commit();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			conn.rollback();
			
		}finally {
			conn.close();
			dbc.close();
		}	
		return flag;	
	}
	@Override
  public int uploadImg(RobotInfo robotinfo, InputStream is) throws Exception {
		// TODO Auto-generated method stub
		String imgsql = "update robotinfo set picture=? where robotname=? ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
        CheckForm check = new CheckForm();
		int flag = 0;
		  try {

			  dbc = new DBConnect();
			  pstmt = dbc.getConnection().prepareStatement(imgsql);

			  pstmt.setBinaryStream(1, is ,is.available());//用二进制流存储
			  pstmt.setString(2, robotinfo.getRobotname());
              if(is.available()==0) {
            	  //Check whether files are selected
            	  flag = -1;
              }/*else if(!(check.isImage(file))){
            	 
            	  flag = -2;
              }*/
              else {
              
			      flag = pstmt.executeUpdate();//Returns a positive number of rows
              }
              
			  pstmt.close();
			
			 
		  }catch(SQLException e) {
			  System.out.println(e.getMessage());
		  }finally {
			  dbc.close();
		  }
		  
		  return flag;
	
	}
	@Override
  public void insertRecordsByRobotInfo (String robotname)throws Exception{

		  String recordsql = "insert into explorecords(robotname,login_time,start_time,end_time) values(?,?,?,?)";

		  PreparedStatement recordpstmt = null;
		  
		  DBConnect dbc = null;
          
		  try {
			  
			  dbc = new DBConnect();
			  recordpstmt = dbc.getConnection().prepareStatement(recordsql);
			  
			  recordpstmt.setString(1, robotname);
			  
			  Date date = new Date();
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      String dateTime = df.format(date); // Formats a Date into a date/time string.
		      recordpstmt.setString(2, dateTime);
		      
		      String start_filePath = "E:\\Design_and_Build\\start_time.txt";
		      String end_filePath = "E:\\Design_and_Build\\end_time.txt";

		        try (BufferedReader reader = new BufferedReader(new FileReader(start_filePath))) {
		            StringBuilder start_content = new StringBuilder();
		            String line;

		            // 逐行读取文件内容
		            while ((line = reader.readLine()) != null) {
		            	start_content.append(line).append("\n");
		            }

		            // 输出读取的字符串
		            System.out.println("File start_Content:\n" + start_content.toString());
		            String start_time = start_content.substring("Start Time: ".length());
		            recordpstmt.setString(3, start_time);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        try (BufferedReader reader = new BufferedReader(new FileReader(end_filePath))) {
		            StringBuilder end_content = new StringBuilder();
		            String line;

		            // 逐行读取文件内容
		            while ((line = reader.readLine()) != null) {
		            	end_content.append(line).append("\n");
		            }

		            // 输出读取的字符串
		            System.out.println("File end_Content:\n" + end_content.toString());
		            String end_time = end_content.substring("End Time: ".length());
		            recordpstmt.setString(4, end_time);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		      
			  

			  recordpstmt.executeUpdate();
			  recordpstmt.close();
			 
		  }catch(SQLException e) {
			  System.out.println(e.getMessage());
		  }finally {
			  dbc.close();
		  }
	  }
  public void updatedAddress(RobotInfo robotinfo, UpdatedAddress updatedAddress) throws Exception {
		Connection conn = null;
		String sql = "update robotinfo set address=? where robotname=? ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);
			
			pstmt= dbc.getConnection().prepareStatement(sql);
			pstmt.setString(2, robotinfo.getRobotname());
			pstmt.setString(1, updatedAddress.getAddress());
			System.out.println(updatedAddress.getAddress());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}finally {
			conn.close();
			dbc.close();
		}
	}
  public void updatedAddress2(RobotInfo robotinfo, UpdatedAddress updatedAddress) throws Exception {
		Connection conn = null;
		String sql = "update robotinfo set address2=? where robotname=? ";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);
			
			pstmt= dbc.getConnection().prepareStatement(sql);
			pstmt.setString(2, robotinfo.getRobotname());
			pstmt.setString(1, updatedAddress.getAddress());
			System.out.println(updatedAddress.getAddress());
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}finally {
			conn.close();
			dbc.close();
		}
	}
	 public void updatedRobotname(String robotname,UpdatedRobotname updatedrobotname)throws Exception{
		String sql = "update robotinfo set robotname=? where robotname=? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc=new DBConnect();
			conn=dbc.getConnection();
			conn.setAutoCommit(false);		
			
			pstmt= dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, updatedrobotname.getUpdatedRobotname());
			pstmt.setString(2, robotname);
			System.out.println(robotname);
			System.out.println(updatedrobotname.getUpdatedRobotname());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.commit();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			conn.close();
			dbc.close();
		}
		
}
	 public int queryNumByRobot (String robotname)throws Exception{
		  String sql = "select serialnumber from explorecords where robotname=? ";
		  PreparedStatement pstmt = null;
		  DBConnect dbc = null;
		  int serialnumber = 0;
		
		  try {
			  dbc = new DBConnect();
			  
			  pstmt = dbc.getConnection().prepareStatement(sql);
			  pstmt.setString(1,robotname);
			  
			  ResultSet rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  serialnumber = rs.getInt("serialnumber");
			  }
			 
			  rs.close();
			  pstmt.close();
		  }catch(SQLException e) {
			  System.out.println(e.getMessage());
		  }finally {
			  dbc.close();
			  
		  }

		  return serialnumber;
	  }
}
