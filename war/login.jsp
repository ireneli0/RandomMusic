import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")

public class LoginViaGoogleAccount extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
	throws IOException{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		String navBar;
		if(user!=null){
			navBar = "<p>Welcome,"+user.getNickname()+"!You can <a href=\""+userService.createLogoutURL("/")+"\">signout</a>.</p>";
		}
		else{
			navBar = "<p>Welcome!<a href=\""+userService.createLoginURL("/")+"\">Signin or register</a>to customize</p>";			    
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(navBar);
	}
}