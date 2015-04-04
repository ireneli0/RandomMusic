package ca.utoronto.ece.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginCheckOnLoadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException, ServletException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException, ServletException{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String loginURL;
		String logoutURL;
		
		if(user!=null){
			logoutURL = userService.createLogoutURL("/");
			request.getSession().setAttribute("logoutURL", logoutURL);
			request.getSession().setAttribute("user", user);
			System.out.println("logout_set attribute User");
			
			request.getSession().getServletContext().getRequestDispatcher("/RandomMusic.jsp").forward(request, response);
		}
		else{
			loginURL = userService.createLoginURL("/");
			request.getSession().setAttribute("loginURL", loginURL);
			System.out.println("login_");
			System.out.println(loginURL);
			
			request.getSession().getServletContext().getRequestDispatcher(loginURL).forward(request, response);
		}
		
		//request.getSession().getServletContext().getRequestDispatcher("/RandomMusic.jsp").forward(request, response);
		//response.setContentType("text/html");
		//request.getSession().getServletContext().getRequestDispatcher("/RandomMusic.jsp").forward(request, response);
		
	}
}
