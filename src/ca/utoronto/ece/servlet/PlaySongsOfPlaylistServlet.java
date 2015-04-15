package ca.utoronto.ece.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ca.utoronto.ece.datastore.EMF;
import ca.utoronto.ece.datastore.PlaylistDAO;
import ca.utoronto.ece.entity.Playlist;
import ca.utoronto.ece.entity.PlaylistLine;
import ca.utoronto.ece.entity.Song;

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
		Set<Song> songs = new HashSet<Song>();
		Set<String> songIdsSet = new HashSet<String>();
		
		JSONObject obj = new JSONObject();
		JSONObject obj2 = new JSONObject();
		
		if(lines.size()==0){
			//empty playlist
			try {
				obj.put("tagContent","This playlist is empty!");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/plain");
			String bothJson = "["+obj+","+obj2+"]";
			response.getWriter().write(bothJson);
		}else{

			int i = 1;

			for(PlaylistLine l:lines){
				songs.add(l.getSong());
				songIdsSet.add(l.getSong().getSongId());
				try {
					obj2.put("songId"+i,l.getSong().getSongId());
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			
			try {
				obj.put("songsCount", i-1);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				obj.put("tagContent","Now playing "+currentPlaylist.getName()+"...");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setContentType("text/plain");
			
			//Put both objects in an array of 2 elements
			String bothJson = "["+obj+","+obj2+"]";
			response.getWriter().write(bothJson);
		}
		request.getSession().setAttribute("songs", songs);
		request.getSession().setAttribute("songIdsSet", songIdsSet);
	}

}
