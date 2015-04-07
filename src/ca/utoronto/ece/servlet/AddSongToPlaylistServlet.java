package ca.utoronto.ece.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;

import ca.utoronto.ece.datastore.PlaylistDAO;
import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;

public class AddSongToPlaylistServlet extends HttpServlet {
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
		String name = request.getParameter("name");
		String singer = request.getParameter("singer");
		String album = request.getParameter("album");
		String image = request.getParameter("image");
		String playlistName = request.getParameter("playlistName");
		
		User user = (User)request.getSession().getAttribute("user");
		
		//Set <PlaylistLine>playlistLines = new HashSet<PlaylistLine>();
		//Playlist playlist = new Playlist();
		//playlist.setName(plName);
		//playlist.setUserId(user.getEmail());
		//playlist.setPlaylistLines(playlistLines);
		//playlistDao.addNewPlaylist(playlist);
		
		PlaylistDAO playlistDao = new PlaylistDAO();
		
		//playlistDao.addNewPlaylist("Work", user.getEmail());
		Playlist currentPlaylist = playlistDao.getPlaylistById(user.getEmail(), "My Favorite");
		
		playlistDao.addSongToPlaylist(songId,name, singer, image, album, currentPlaylist);
        response.setContentType("text/plain");
        response.getWriter().write(songId+" "+name+" "+singer+" "+album+" "+image+"\n"+playlistName+" "+currentPlaylist.getName()+" " +currentPlaylist.getUserId()+" "+currentPlaylist.getId());
		
	}
}
