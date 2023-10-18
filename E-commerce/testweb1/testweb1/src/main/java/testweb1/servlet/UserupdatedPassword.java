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

public class UserupdatedPassword extends HttpServlet {

	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException {
		UserInfo userinfo = new UserInfo();
		HttpSession session = req.getSession();
		String username =(String) session.getAttribute("username");
		userinfo.setUsername(username);
		userinfo.setPassword(req.getParameter("password"));
		UpdatedUserInfo updateduserinfo = new UpdatedUserInfo();
		updateduserinfo.setUpdatedUsername(req.getParameter("updatedUsername"));
		updateduserinfo.setUpdatedPassword(req.getParameter("updatedPassword"));
		UserDAO dao = new UserDAOImpl();
		try {
			
			dao.updatedPasswordByUserInfo(userinfo, updateduserinfo);
		} catch (Exception e) {
		e.printStackTrace();
		}
			session = req.getSession();
			res.getWriter().println("<script>window.alert('You have updated your password successfully!');window.location.href ='./welcome.jsp';</script>");

	}
}
