package ca.utoronto.ece.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
         
        response.setContentType("text/plain");
        response.getWriter().write(songId+" "+name+" "+singer+" "+album+" "+image+"\n"+playlistName);
		
	}
}
