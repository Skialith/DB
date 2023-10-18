package testweb1.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb1.print.ImgPrint;
import testweb1.print.impl.ImgPrintImpl;
import testweb1.vo.RobotInfo;
import testweb1.vo.UserInfo;
import testweb1.dao.impl.*;
import testweb1.dao.UserDAO;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class WelcomeRefreshServlet extends HttpServlet {
 

@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
}

@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");   
    resp.setCharacterEncoding("UTF-8");
    
    UserDAO dao = new UserDAOImpl();
    
    HttpSession session = req.getSession();
    int id = (int)session.getAttribute("id");
    
    String robotname = null;

    try {
        //Query the corresponding user information and save it to the user object
    	UserInfo new_userinfo = dao.queryUserById(id);
    	//Name of the queried robot
    	robotname = dao.queryRobotById(id);
		    
		System.out.println("robotname = " + robotname);
		ImgPrint imgPrint = new ImgPrintImpl();
		String base64 = imgPrint.query_getImgBlob(robotname);
	
		session.setAttribute("username", new_userinfo.getUsername());
		session.setAttribute("sex", new_userinfo.getGender());
		session.setAttribute("robotname", robotname);
		session.setAttribute("base64str", base64);
		session.setAttribute("id", id);
		    
		resp.sendRedirect("./welcome.jsp");
   

	        	
	     
     } catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
     }
}
}
