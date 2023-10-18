package testweb1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb1.dao.UserDAO;
import testweb1.dao.impl.UserDAOImpl;
import testweb1.vo.RobotInfo;
import testweb1.vo.UpdatedAddress;
import testweb1.vo.UpdatedUserInfo;
import testweb1.vo.UserInfo;

public class UpdatedAddressServlet2 extends HttpServlet {
public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException {
	RobotInfo robotinfo = new RobotInfo();
	HttpSession session = req.getSession();
	String robotname =(String) session.getAttribute("robotname");
	robotinfo.setRobotname(robotname);
	if(req.getParameter("updatedAddress2")== null) {
		res.getWriter().println("<script>window.alert('You haven't input a file name!');window.location.href ='./updatedAddress2.jsp';</script>");
	}else {
		UpdatedAddress updatedaddress = new UpdatedAddress();
		
		updatedaddress.setAddress(req.getParameter("updatedAddress2"));
		UserDAO dao = new UserDAOImpl();
		try {
			
			dao.updatedAddress2(robotinfo, updatedaddress);
		} catch (Exception e) {
		e.printStackTrace();
		}
			session = req.getSession();
			res.getWriter().println("<script>window.alert('You have updated environment_image address successfully!');window.location.href ='./welcome.jsp';</script>");
	}
	

}

}
