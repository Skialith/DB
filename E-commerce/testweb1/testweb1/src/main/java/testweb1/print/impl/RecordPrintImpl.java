package testweb1.print.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import testweb1.db.DBConnect;
import testweb1.print.RecordPrint;
import testweb1.vo.ExplorRecords;
import testweb1.vo.RobotInfo;

public class RecordPrintImpl implements RecordPrint {

	@Override
	public ArrayList printByRecord(RobotInfo robotinfo,int image_num) throws Exception {
		// TODO Auto-generated method stub
		  String sql = "select * from explorecords where robotname=?";
		  PreparedStatement pstmt = null;
		  ExplorRecords record = null;
		  
		  DBConnect dbc = null;
		  ArrayList list = null;
		 
		
		  
		  try {
			  //连接数据库，并写sql模板，与Preparedstatement绑定
			  dbc = new DBConnect();
			  list = new ArrayList();
			  
			  pstmt = dbc.getConnection().prepareStatement(sql);
			  pstmt.setString(1,robotinfo.getRobotname());
			  //数据库查询，存到结果集里
			  ResultSet rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  record = new ExplorRecords();
				  
				  //将读取到的数据存入该对象中，对于每一行使用getString\getInt
				  record.setCount(image_num);
				  record.setLogin_time(rs.getString("login_time"));
				  record.setStart_time(rs.getString("start_time"));
				  record.setEnd_time(rs.getString("end_time"));
				 
				  //test
			       
				  System.out.println("numbers of record = " + record.getCount());
				  System.out.println("date of record = " + record.getLogin_time());
				  System.out.println("start time= " + record.getStart_time());
				  System.out.println("end time= " + record.getEnd_time());
				  //将赋好值的对象添加入动态数组中
				  list.add(record);
			  }
				  

		      rs.close();
			  pstmt.close();
			 
		  }catch(SQLException e) {
			  System.out.println(e.getMessage());
		  }finally {
			  dbc.close();
		  }

		  return list;
	}

}
