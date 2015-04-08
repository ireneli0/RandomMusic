package ca.utoronto.ece.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.utoronto.ece.datastore.PlaylistDAO;
import ca.utoronto.ece.entity.Playlist;

import com.google.appengine.api.users.User;

public class DeleteSongFromPlaylistServlet extends HttpServlet {
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
		
		String songId = request.getParameter("songId");
		String currentPlaylistName = request.getParameter("currentPlaylistName");
		String songName = request.getParameter("songName");
		
		User user = (User)request.getSession().getAttribute("user");
		
		PlaylistDAO playlistDao = new PlaylistDAO();
		Playlist currentPlaylist = playlistDao.getPlaylistById(user.getEmail(), currentPlaylistName);
		
		//delete
		//..
		//
        response.setContentType("text/plain");
        response.getWriter().write("Delete "+songName+" from playlist "+currentPlaylistName+"...");

	}
}
