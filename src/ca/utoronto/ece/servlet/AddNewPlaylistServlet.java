package ca.utoronto.ece.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.utoronto.ece.datastore.PlaylistDAO;

import com.google.appengine.api.users.User;

public class AddNewPlaylistServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException{
		
		User user = (User)request.getSession().getAttribute("user");
		
		String playlistName = request.getParameter("playlistName");
		if(playlistName.isEmpty()||playlistName.length()==0){
			response.setContentType("text/plain");
		    response.getWriter().write("Playlist name cannot be empty, Please input again!");
		}else{
			PlaylistDAO playlistDao = new PlaylistDAO();
			List playlist = playlistDao.checkPlaylistNameExists(playlistName, user.getEmail());
			if(playlist.size()>0){
				response.setContentType("text/plain");
			    response.getWriter().write("You've already had the same "+ playlistName+" playlist!");
			}else{
				playlistDao.addNewPlaylist(playlistName, user.getEmail());
			
				//request.getSession().getServletContext().getRequestDispatcher("/RandomMusic.jsp").forward(request, response);
				response.setContentType("text/plain");
				response.getWriter().write("Added a new playlist "+ playlistName+"!");
		    }
			
		}
	}
}
