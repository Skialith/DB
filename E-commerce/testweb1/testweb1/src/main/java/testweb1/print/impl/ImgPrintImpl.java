package testweb1.print.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import testweb1.db.DBConnect;
import testweb1.print.ImgPrint;
import testweb1.vo.RobotInfo;

import javax.imageio.ImageIO;

public class ImgPrintImpl implements ImgPrint {

	@Override
	public String query_getImgBlob(String robotname) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select picture from robotinfo where robotname=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		ResultSet rs = null;
		InputStream is = null;
		//设置默认显示图片，只是展示了默认图片，没有将图片存入数据库（为null）
		String path = "C:\\Users\\13753\\eclipse-workspace\\testweb1\\OIP-C.jpg";

		try {

		     //连接数据库，并写sql模板，与Preparedstatement绑定
		     dbc = new DBConnect();

		     pstmt = dbc.getConnection().prepareStatement(sql);
		     pstmt.setString(1,robotname);
		     //数据库查询，存到结果集里
		     rs = pstmt.executeQuery();
		     
		     //System.out.println("rs.getBlob(1)=" + rs.getBlob(1));
		     if(rs.next()) {
		    	 if(rs.getBlob(1)== null) {
		    		is = new FileInputStream(path);
		    		 //System.out.println("enter");
		    	 }else {
		    		 //System.out.println("enter2");
		            is = rs.getBlob(1).getBinaryStream();
		    	 }
		     }
		     rs.close();
			 pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			dbc.close();
		}
		BufferedImage bi = ImageIO.read(is);
		//test
		if(bi!= null) {
			System.out.println("bi is not null!");
		}else {
			return null;
		}
		//回送字节数据
		ByteArrayOutputStream os = new ByteArrayOutputStream();
	//将图片元数据写到byte array流里
		ImageIO.write(bi, "jpg", os);
		//转换成base64编码的字符串
		String base64str = Base64.getEncoder().encodeToString(os.toByteArray());
		is.close();
		os.close();
		return base64str;
	}

}
