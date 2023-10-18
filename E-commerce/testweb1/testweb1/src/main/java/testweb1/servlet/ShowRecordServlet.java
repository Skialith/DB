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

import testweb1.print.ImgPrint;
import testweb1.print.RecordPrint;
import testweb1.print.RecordImgPrint;
import testweb1.print.impl.ImgPrintImpl;
import testweb1.print.impl.RecordPrintImpl;
import testweb1.print.impl.RecordImgPrintImpl;
import testweb1.vo.ExplorRecords;
import testweb1.vo.RobotInfo;


public class ShowRecordServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
		Pair<ArrayList, String> pair = Pair.of(null, null);
		String path = null;
		
		RobotInfo robotinfo = new RobotInfo();
		HttpSession session = req.getSession();
		RecordImgPrint rip = new RecordImgPrintImpl();
		
		String username = (String)session.getAttribute("username");
		String robotname = (String)session.getAttribute("robotname");
		Integer serialnumber = (Integer)session.getAttribute("serialnumber");
		
		String defaultpath = "C://Users//13753//Desktop//img";
		
		resp.setIntHeader("Refresh", 1);
        resp.setContentType("text/html;charset=UTF-8");
        
		
		//test
		System.out.println("Here is ShowRecordServlet");
		System.out.println("The shared username set by the login form: " + username);
		System.out.println("The shared robotname set by the login form: " + robotname);
		System.out.println("serialnumber"+serialnumber);
		
        RecordPrint rp = new RecordPrintImpl();
        
        robotinfo.setRobotname(robotname);
        try {
        	int number = serialnumber;
          rip.updateRecordsByNum(number);
  		  pair = rip.printImgByRecord(robotinfo,defaultpath);
  		  if(pair == null) {
  			System.out.println("pair is null!");
  		  }
  		  l1 = pair.getLeft();
  		  path = pair.getRight();
  		  int image_num = l1.size();
  		  l2 = rp.printByRecord(robotinfo,image_num);
  		  

  	    }catch(Exception e) {
  	      e.printStackTrace();
  	    }

		session.setAttribute("list2", l2);
	    session.setAttribute("list1", l1);
	    session.setAttribute("path", path);
		RequestDispatcher rd = req.getRequestDispatcher("/reconnaissanceRecord.jsp");
        rd.forward(req, resp);

	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(req, resp);
	}

}
