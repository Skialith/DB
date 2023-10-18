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


public class UserLoginServlet extends HttpServlet {
 

@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
}

@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html");   
    resp.setCharacterEncoding("UTF-8");


    UserInfo userinfo = new UserInfo();
    userinfo.setUsername(req.getParameter("username"));
    userinfo.setPassword(req.getParameter("password"));
  
    UserDAO dao = new UserDAOImpl();
    UserInfo user;
    String robotname;


    try {
	    user = dao.queryByUserInfo(userinfo); //object

	    if(user == null){
		    //If us is empty, the entered user name cannot be queried
		    resp.getWriter().println("<script>window.alert(\"User doesn't exists!\")</script>");
		    //refresh
		    System.out.println("User doesn't exists！");
		    resp.setHeader("refresh", "0;url=login.jsp"); 
	   	
	    }else {
		
		    if(!(user.getPassword().equals(userinfo.getPassword()))){
			    resp.getWriter().println("<script>window.alert('The user password does not match!')</script>");
			    resp.setHeader("refresh", "0;url=login.jsp");
	        }else {
	        	//Find out the user id and save it
	        	int id = dao.queryIdByUser(user);
                //Query the corresponding user information and save it to the user object
	        	UserInfo new_userinfo = dao.queryUserById(id);
	        	//Name of the queried robot
	        	robotname = dao.queryRobotById(id);
	    	    //Insert data into the robot probe
	    	    dao.insertRecordsByRobotInfo(robotname);
	    	    int serialnumber = dao.queryNumByRobot(robotname);
	   		    System.out.println("robotname = " + robotname);
	   		    System.out.println("serialnumber = " + serialnumber);
	   		    ImgPrint imgPrint = new ImgPrintImpl();
	   		    String base64 = imgPrint.query_getImgBlob(robotname);
	   		    
	   		    HttpSession session = req.getSession();
	   		    session.setAttribute("username", new_userinfo.getUsername());
	   		    session.setAttribute("sex", new_userinfo.getGender());
	   		    session.setAttribute("robotname", robotname);
	   		    session.setAttribute("base64str", base64);
	   		    session.setAttribute("id", id);
	   		    session.setAttribute("serialnumber", serialnumber);
	   		    resp.sendRedirect("./welcome.jsp");
	        }
	     }
     } catch (Exception e) {
	// TODO Auto-generated catch block
	    e.printStackTrace();
     }
}
}
