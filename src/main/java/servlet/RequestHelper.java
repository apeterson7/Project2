package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.util.*;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getRequestURI());
		
		String uri = request.getRequestURI();
		if(uri.equals("/Project2/hello.do")) {
			response.getWriter().append("{\"alex\":\"test\"}");
		}
		if(uri.equals("/Project2/chomp.do")) {
				//TestListenerAdapter tla = new TestListenerAdapter();
				TestNG testng = new TestNG();
				List<String> suites = new ArrayList<String>();
				suites.add("testng.xml");
				testng.setTestSuites(suites);
				testng.run();
				
			    //response.getWriter().append("{\"test\":\"success\"}");
		}
		if(uri.equals("/Project2/awesome.do")) {
			response.getWriter().append("You completed a post");
			System.out.println(request.getParameter("name"));
		}
	}
	
}
