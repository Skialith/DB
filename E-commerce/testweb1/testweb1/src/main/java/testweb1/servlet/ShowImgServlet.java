package testweb1.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb1.print.ImgPrint;
import testweb1.print.impl.ImgPrintImpl;
import testweb1.vo.RobotInfo;


public class ShowImgServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		ImgPrint ip = new ImgPrintImpl();
		ArrayList list = null;
		//Set the file format of the response to the client
		resp.setContentType("image/jpeg");
		
		String username = (String)session.getAttribute("username");
		String robotname = (String)session.getAttribute("robotname");
		//test
		System.out.println("Here is ShowImgServlet");
		System.out.println("The shared username set by the login form: " + username);
		System.out.println("The shared robotname set by the login form: " + robotname);

        
		String base64str = null;
		try {
			base64str = ip.query_getImgBlob(robotname);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		session.setAttribute("base64str", base64str);
		//The page before and after the jump shares a request to pass some data or session information
        resp.sendRedirect("welcome.jsp");
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
