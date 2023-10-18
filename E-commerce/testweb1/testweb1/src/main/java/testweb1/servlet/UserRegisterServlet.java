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
import testweb1.vo.UserInfo;

public class UserRegisterServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");   
      resp.setCharacterEncoding("UTF-8");
		
	  UserInfo userinfo = new UserInfo();
	  RobotInfo robotinfo = new RobotInfo();
	  
	  userinfo.setUsername(req.getParameter("username"));
	  userinfo.setPassword(req.getParameter("password"));
	  userinfo.setConfirmpassword(req.getParameter("confirmpassword"));
	  userinfo.setGender(req.getParameter("gender"));
	  userinfo.setPhonenum(req.getParameter("phonenum"));
	 
	  robotinfo.setRobotname(req.getParameter("robotname"));
	  
	  HttpSession session = req.getSession();
	  session.setAttribute("username", req.getParameter("username"));
	  session.setAttribute("password", req.getParameter("password"));
	  session.setAttribute("confirmpassword", req.getParameter("confirmpassword"));
	  session.setAttribute("gender", req.getParameter("gender"));
	  session.setAttribute("phonenum", req.getParameter("phonenum"));
	  session.setAttribute("robotname", req.getParameter("robotname"));
	  
	  UserDAO dao = new UserDAOImpl();
	  //test
	  System.out.println("regist-username： " + req.getParameter("username"));
	  System.out.println("regist-password： " + req.getParameter("password"));
	  System.out.println("regist-confirmpassword： " + req.getParameter("confirmpassword"));
	  System.out.println("regist-gender： " + req.getParameter("gender"));
	  System.out.println("regist-phonenum： " + req.getParameter("phonenum"));
	  System.out.println("regist-robotname： " + req.getParameter("robotname"));

	  
	  int flag = 0;
	  
	  try {
		  flag = dao.insertByRegister(userinfo, robotinfo);
		  System.out.println("Deside whether it have successfully regist or not: flag = " + flag);
	  }catch(Exception e) {
	      e.printStackTrace();
	  }
	  
	  if(flag == -1) {
		  resp.getWriter().println("<script>window.alert('User exists！');window.location.href ='./login.jsp';</script>");
		  //refresh
		  //resp.setHeader("refresh", "0;url=register.jsp");
	  }else if(flag == -2){
		  
		  resp.getWriter().println("<script>window.alert('Password entered incorrectly!');window.location.href ='./login.jsp';</script>");
		  //resp.setHeader("refresh", "0;url=register.jsp");
		  
	  }
	   else if(flag == -3){ 
		  resp.getWriter().println("<script>window.alert('Phonenumber entered incorrectly!');window.location.href ='./login.jsp';</script>");
		  //resp.setHeader("refresh", "0;url=register.jsp");
	  
	  }else if(flag == -4){ 
		  resp.getWriter().println("<script>window.alert('Entered incorrectly!please check your input!');window.location.href ='./login.jsp';</script>");
		  //resp.setHeader("refresh", "0;url=register.jsp");
	  }else if(flag == -5) {
		  resp.getWriter().println("<script>window.alert('Two passwords are inconsistent!please check your input!');window.location.href ='./login.jsp';</script>");
		  //resp.setHeader("refresh", "0;url=register.jsp");
	  }else if(flag == -6) {
		  resp.getWriter().println("<script>window.alert('Robot name can not repeat');window.location.href ='./login.jsp';</script>");
		  //resp.setHeader("refresh", "0;url=register.jsp");
	  }else if(flag == -7) {
		  resp.getWriter().println("<script>window.alert('Robot name can not be null');window.location.href ='./login.jsp';</script>");
	  }
	  else if(flag > 0) {
		  resp.getWriter().println("<script>window.alert('Successfully regist!');window.location.href ='./login.jsp'; </script>");
		  
	  }else {
		  resp.sendRedirect("./error.jsp");
	  }
	}

}
