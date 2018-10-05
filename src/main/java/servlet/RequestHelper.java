package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getRequestURI());
		
		String uri = request.getRequestURI();
		if(uri.equals("/project2/hello.do")) {
			response.getWriter().append("Hello everyone");
		}
		if(uri.equals("/project2/chomp.do")) {
			response.getWriter().append("Gators are great");
		}
		if(uri.equals("/project2/awesome.do")) {
			response.getWriter().append("You completed a post");
			System.out.println(request.getParameter("name"));
		}
	}
	
}
