package testweb1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb1.dao.UserDAO;
import testweb1.dao.impl.UserDAOImpl;
import testweb1.vo.UpdatedRobotname;
import testweb1.vo.UserInfo;

public class UserupdatedRobotname extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse resp) throws IOException,ServletException {

		
		HttpSession session = req.getSession();
		String robotname =(String) session.getAttribute("robotname");
		UpdatedRobotname updatedrobotname = new UpdatedRobotname();

		updatedrobotname.setUpdatedRobotname(req.getParameter("updatedRobotname"));; 
		UserDAO dao = new UserDAOImpl();
		try {
			dao.updatedRobotname(robotname, updatedrobotname);
			resp.getWriter().println("<script>window.alert('You have updated robot name successfully!');window.location.href ='./welcome.jsp';</script>");
		}catch(Exception e) {
			e.getStackTrace();
			resp.sendRedirect("./error.jsp");
		}
}
	
}
