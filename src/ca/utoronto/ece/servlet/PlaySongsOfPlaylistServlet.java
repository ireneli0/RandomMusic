package ca.utoronto.ece.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.utoronto.ece.datastore.PlaylistDAO;
import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;

import com.google.appengine.api.users.User;

public class PlaySongsOfPlaylistServlet extends HttpServlet {
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
		List<String> songs = new ArrayList<String>();
//		if(lines.size()==0){
//			//empty playlist
//			response.setContentType("text/plain");
//	        response.getWriter().write("This playlist is empty!");
//		}else{
//			for(PlaylistLine l:lines){
//				songs.add(l.getSong().getSongId());
//			}
//		}
		request.getSession().setAttribute("songs", songs);
		response.setContentType("text/plain");
        response.getWriter().write("Now playing "+currentPlaylist.getName()+"...");
	}

}
