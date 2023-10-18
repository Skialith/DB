package testweb1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb1.dao.UserDAO;
import testweb1.dao.impl.UserDAOImpl;
import testweb1.vo.UserInfo;
import testweb1.vo.UpdatedUserInfo;

public class UserupdatedUsername extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse resp) throws IOException,ServletException {

		
		UserInfo userinfo = new UserInfo();
		HttpSession session = req.getSession();
		String username =(String) session.getAttribute("username");

		
		userinfo.setUsername(username);
		System.out.println(userinfo.getUsername());

		UpdatedUserInfo updateduserinfo = new UpdatedUserInfo();

		updateduserinfo.setUpdatedUsername(req.getParameter("updatedUsername")); 
		UserDAO dao = new UserDAOImpl();
		int flag = 0;
		try {
			flag = dao.updatedUsernameByUserInfo(userinfo, updateduserinfo);
		}catch(Exception e) {
			e.getStackTrace();
		}if(flag==0) {
			resp.getWriter().println("<script>window.alert('You have updated user name successfully!');window.location.href ='./welcome.jsp';</script>");
		}else {
			resp.sendRedirect("./error.jsp");
		}
}
	
}
