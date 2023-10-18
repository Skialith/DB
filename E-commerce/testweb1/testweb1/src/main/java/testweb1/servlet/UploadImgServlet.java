package testweb1.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import testweb1.dao.UserDAO;
import testweb1.dao.impl.UserDAOImpl;
import testweb1.vo.RobotInfo;

import testweb1.check.CheckForm;

public class UploadImgServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String robotname = (String)session.getAttribute("robotname");
		System.out.println("The shared robotname: " + robotname);
		RobotInfo robotinfo = new RobotInfo();
		robotinfo.setRobotname(robotname);
		UserDAO dao = new UserDAOImpl();
		// Get File Upload field: Used to get the request body of the http request passed using the multipart/form-data format, usually used to get the uploaded file. (enctype in html)
		Part picture = req.getPart("picture");
		int flag = 0;
		// The input stream accepts the image
	      InputStream is = picture.getInputStream();;
	      try {
			  flag = dao.uploadImg(robotinfo, is);
			  System.out.println("决定上传是否成功的flag = " + flag);
		  }catch(Exception e) {
		      e.printStackTrace();
		  }
	      
	      if(flag > 0) {
		      resp.getWriter().println("<script>window.alert('Successfully upload!');window.location.href ='./uploadImg.jsp'; </script>");
		  }else if(flag == -1){
		    	  //not image
			  resp.getWriter().println("<script>window.alert('No image selected!');window.location.href ='./uploadImg.jsp'; </script>"); 
		  }/*else if(flag == -2) {
			  resp.getWriter().println("<script>window.alert('The uploaded file type is not a picture!');window.location.href ='./uploadImg.jsp'; </script>");
	      }*/else{
	    	  resp.getWriter().println("<script>window.alert('Upload error!');window.location.href ='./uploadImg.jsp'; </script>");
	      }
	      req.getRequestDispatcher("/showImg").forward(req, resp);
	}

}
