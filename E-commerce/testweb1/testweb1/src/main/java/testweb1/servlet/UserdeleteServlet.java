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

public class UserdeleteServlet extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException {
		UserInfo userinfo = new UserInfo();
		userinfo.setUsername(req.getParameter("username"));
		System.out.println(userinfo.getUsername());
		
		UserDAO dao = new UserDAOImpl();
		int flag = 0;
		try {
			flag = dao.deleteByUserInfo(userinfo);
		}catch(Exception e) {
			e.getStackTrace();
		}if(flag==1) {
			HttpSession session = req.getSession();
			session.removeAttribute("id"); 
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.removeAttribute("confirmpassword");
			session.removeAttribute("phonenum");
			session.removeAttribute("gender");
			session.removeAttribute("robotname");
			session.removeAttribute("base64str");
			session.removeAttribute("sex");
			res.getWriter().println("<script>window.alert('You have delete your account successfully!');window.location.href ='./register.jsp';</script>");
			
		}else {
			res.sendRedirect("./error.jsp");
		}
	}
}
