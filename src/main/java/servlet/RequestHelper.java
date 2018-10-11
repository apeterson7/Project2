package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.TestNG;

import java.util.*;

public class RequestHelper {
 
	static TestNG testng = new TestNG();
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getRequestURI());
		
		
		String uri = request.getRequestURI();
		if(uri.equals("/Project2/hello.do")) {
			response.getWriter().append("{\"alex\":\"test\"}");
		}
		if(uri.equals("/Project2/chomp.do")) {
				//TestListenerAdapter tla = new TestListenerAdapter();
				System.out.println("hello");
				System.out.println(javax.servlet.http.HttpServletRequest.class.getName());
				//System.out.println(org.testng.TestNG.class.getName());
				
				//testng.setVerbose(10);
				List<String> suites = new ArrayList<String>();
				suites.add("C:\\Users\\Alex Peterson\\Documents\\workspace-sts-3.9.5.RELEASE\\Project2\\src\\main\\resources\\testing.xml");
				testng.setTestSuites(suites);
				testng.run();
				
				response.getWriter().append("{\"test\":\"success\"}");
		}
		if(uri.equals("/Project2/awesome.do")) {
			response.getWriter().append("You completed a post");
			System.out.println(request.getParameter("name"));
		}
	}
	
}
