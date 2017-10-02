package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.HelloBeanInterface;

@WebServlet("/")
public class HelloServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private int counter = 1;
	private static final Logger logger = Logger.getLogger(HelloServlet.class.getName());
	
	@EJB(lookup ="ejb:/myBeanTest/HelloBean!beans.HelloBeanInterface")	
    private HelloBeanInterface bean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		try {			
			resp.setContentType("text/html");
			
			String message = bean.sayHello();			
			
			message += " Called " + counter + " times.";
			logger.info(message);			
			pw.println(message);
			counter++;
		} catch (Exception e) {
			pw.println("Cannot invoke service right now... please try later...");
			e.printStackTrace();
		}
	}
}
