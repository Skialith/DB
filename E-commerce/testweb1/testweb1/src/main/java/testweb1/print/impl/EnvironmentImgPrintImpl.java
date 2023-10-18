package testweb1.print.impl;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;

import testweb1.db.DBConnect;
import testweb1.print.EnvironmentImgPrint;

import testweb1.vo.RobotInfo;

import org.apache.commons.lang3.tuple.Pair;

public class EnvironmentImgPrintImpl implements EnvironmentImgPrint {

	@Override
	public Pair<ArrayList, String> printEnvironmentByRecord(RobotInfo robotinfo,String defaultpath) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select address2 from robotinfo where robotname=?";	 
		
		File folder = null;
		
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		ResultSet rs = null;
		String base64str = null;
		ArrayList list = null;
		String path = null;
		Pair<ArrayList, String> pair = null;
	
		try {    
			
			     dbc = new DBConnect();
			     list = new ArrayList();

			     pstmt = dbc.getConnection().prepareStatement(sql);
			     pstmt.setString(1,robotinfo.getRobotname());
			     System.out.println(robotinfo.getRobotname());
	
			     rs = pstmt.executeQuery();
                 
			     while(rs.next()) {
			    	 if(rs.getString("address2")== null||rs.getString("address2")== "") {
				    	 folder = new File(defaultpath);
				    	 path = defaultpath;
				     }else {
				    	 folder = new File(rs.getString("address2"));
				    	 path = rs.getString("address2");
				     }
			    	 System.out.println(rs.getString("address2"));
				     System.out.println("is folder null?" + folder);
				     File[] imageFiles = folder.listFiles(); 
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

}
