package testweb1.print.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Base64;


import javax.imageio.ImageIO;

import testweb1.db.DBConnect;
import testweb1.print.RecordImgPrint;

import testweb1.vo.RobotInfo;

import org.apache.commons.lang3.tuple.Pair;

public class RecordImgPrintImpl implements RecordImgPrint {

	@Override
	public Pair<ArrayList, String> printImgByRecord(RobotInfo robotinfo,String defaultpath) throws Exception {
		System.out.println("Here is ShowImgRecordServlet");
		// TODO Auto-generated method stub
		String sql = "select address from robotinfo where robotname=?";	 
		
		
		File folder = null;
		
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		ResultSet rs = null;
		String base64str = null;
		ArrayList list = null;
		String path = null;
		Pair<ArrayList, String> pair = null;
	
		try {    
			     System.out.println("Here is ShowImgRecordServlet:enter try");
	
			     dbc = new DBConnect();
			     list = new ArrayList();

			     pstmt = dbc.getConnection().prepareStatement(sql);
			     pstmt.setString(1,robotinfo.getRobotname());
			     System.out.println(robotinfo.getRobotname());
			     //数据库查询，存到结果集里
			     rs = pstmt.executeQuery();
                 
			     while(rs.next()) {
			    	 if(rs.getString("address")== null||rs.getString("address")== "") {
				    	 folder = new File(defaultpath);
				    	 path = defaultpath;
				     }else {
				    	 folder = new File(rs.getString("address"));
				    	 path = rs.getString("address");
				     }
			    	 System.out.println(rs.getString("address"));
				     System.out.println("is folder null?" + folder);
				     File[] imageFiles = folder.listFiles(); 
				     System.out.println(imageFiles.length);
				     if (imageFiles != null) {
				           for (File imageFile : imageFiles) {
							    BufferedImage image = ImageIO.read(imageFile);
								//回送字节数据
								ByteArrayOutputStream os = new ByteArrayOutputStream();
								
							    //将图片元数据写到byte array流里
								ImageIO.write(image, "jpg", os);
								//转换成base64编码的字符串
								base64str = Base64.getEncoder().encodeToString(os.toByteArray());
								System.out.println(base64str);
								list.add(base64str);
								pair = Pair.of(list, path);
								os.close();
							    	
									
						   }
							
				     }
							
				     
			     }
			     
			     rs.close();
				 pstmt.close();
			            
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally{
				dbc.close();
			}

			return pair;
	}
	public void updateRecordsByNum (int num)throws Exception{

		  String recordsql = "update explorecords set start_time=?,end_time=? where serialnumber=?";

		  PreparedStatement recordpstmt = null;
		  
		  DBConnect dbc = null;
        
		  try {
			  
			  dbc = new DBConnect();
			  recordpstmt = dbc.getConnection().prepareStatement(recordsql);
		      
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
		            recordpstmt.setString(1, start_time);
		            
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
		            recordpstmt.setString(2, end_time);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		       recordpstmt.setInt(3, num);
			  
			  recordpstmt.executeUpdate();
			  recordpstmt.close();
			 
		  }catch(SQLException e) {
			  System.out.println(e.getMessage());
		  }finally {
			  dbc.close();
		  }
	  }
}
