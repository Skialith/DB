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

public class UpdatedAddressServlet extends HttpServlet {
public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException {
	RobotInfo robotinfo = new RobotInfo();
	HttpSession session = req.getSession();
	String robotname =(String) session.getAttribute("robotname");
	robotinfo.setRobotname(robotname);
	if(req.getParameter("updatedAddress")== null) {
		res.getWriter().println("<script>window.alert('You haven't input a file name!');window.location.href ='./updatedAddress.jsp';</script>");
	}else {
		UpdatedAddress updatedaddress = new UpdatedAddress();
		updatedaddress.setAddress(req.getParameter("updatedAddress"));
		UserDAO dao = new UserDAOImpl();
		try {
			
			dao.updatedAddress(robotinfo, updatedaddress);
		} catch (Exception e) {
		e.printStackTrace();
		}
			session = req.getSession();
			res.getWriter().println("<script>window.alert('You have updated image_record address successfully!');window.location.href ='./welcome.jsp';</script>");
	}
}

}
