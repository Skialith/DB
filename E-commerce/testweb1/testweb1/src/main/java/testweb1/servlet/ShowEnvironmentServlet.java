package testweb1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.tuple.Pair;

import testweb1.print.EnvironmentImgPrint;
import testweb1.print.impl.EnvironmentImgPrintImpl;
import testweb1.vo.RobotInfo;


public class ShowEnvironmentServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList l1 = new ArrayList();
		Pair<ArrayList, String> pair = Pair.of(null, null);
		String path = null;
		
		RobotInfo robotinfo = new RobotInfo();
		HttpSession session = req.getSession();
		EnvironmentImgPrint eip = new EnvironmentImgPrintImpl();
		
		String username = (String)session.getAttribute("username");
		String robotname = (String)session.getAttribute("robotname");
		String defaultpath = "C://Users//13753//Desktop//img";
		
		resp.setIntHeader("Refresh", 1);
        resp.setContentType("text/html;charset=UTF-8");
        
		//test
		System.out.println("Here is ShowEnvironmentServlet");
		System.out.println("The shared username set by the login form: " + username);
		System.out.println("The shared robotname set by the login form: " + robotname);
        
        robotinfo.setRobotname(robotname);
        try {
        	
  		  pair = eip.printEnvironmentByRecord(robotinfo,defaultpath);
  		  l1 = pair.getLeft();
  		  path = pair.getRight();

  	    }catch(Exception e) {
  	      e.printStackTrace();
  	    }

	    session.setAttribute("list1", l1);
	    session.setAttribute("path", path);

		RequestDispatcher rd = req.getRequestDispatcher("/environmentRecord.jsp");
        rd.forward(req, resp);

	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(req, resp);
	}

}
