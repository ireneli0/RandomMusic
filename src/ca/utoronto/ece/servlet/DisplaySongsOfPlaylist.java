package ca.utoronto.ece.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.utoronto.ece.datastore.PlaylistDAO;
import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;
import ca.utoronto.ece.entity.Song;

import com.google.appengine.api.users.User;

public class DisplaySongsOfPlaylist extends HttpServlet {
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
		String playlistName = request.getParameter("playlistName");
		
		User user = (User)request.getSession().getAttribute("user");
		PlaylistDAO playlistDao = new PlaylistDAO();

		Playlist currentPlaylist = playlistDao.getPlaylistById(user.getEmail(), playlistName);
		
		Set<PlaylistLine> lines= currentPlaylist.getPlaylistLines();
		Set<Song> songs = new HashSet<Song>();
		for(PlaylistLine l:lines){
			songs.add(l.getSong());	
		} 
		request.getSession().setAttribute("songsForDisplay", songs);
		request.getSession().setAttribute("currentPlaylistName", playlistName);

		request.getSession().getServletContext().getRequestDispatcher("/manage_lists.jsp").forward(request, response);
	}
	
}
