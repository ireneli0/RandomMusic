<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import ="ca.utoronto.ece.entity.Playlist" %>
<%@ page import ="ca.utoronto.ece.entity.Song" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link href="Resource/ece1779A2.css" rel="stylesheet" type="text/css" media="all" />
    <title>Your Playlists</title>
    <script src="js/jquery-1.5.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
    <script src="js/manage_lists.js"></script>
    
</head>

<body>
<br>

<%
            		User user = (User)request.getSession().getAttribute("user");
               		if(user==null){
               		
               		String loginURL = (String)request.getSession().getAttribute("loginURL");
            		%>
            		<a href="/LoginServlet" class="login" id="loginText">Login</a>
            	<%}else{
            			
            			String logoutURL = (String)request.getSession().getAttribute("logoutURL");
            		%>
            		<a href="/LogoutServlet" class="login" id="logoutText">Logout</a>
            		<span class="bar">Welcome <%=user.getNickname() %>><a href="RandomMusic.jsp" >Your Music Player</a></span>
            	<%}
               		%>


    <img style="margin-left:10px" src="Resource/logo.png" alt="Logo" height="150" width="250">



<br>
<!-- Main Content -->
<div>
  <!-- Menu -->
  <div class="menu">
    <h2 style="line-height:0.1px;color:#666666">My PlayLists</h2>
    <p style="color:#cccccc">___________________</p>
    
    <div style="margin-right:50px;">
    <%
      	List<Playlist> playlists  = (List<Playlist>)request.getSession().getAttribute("playlists");
      if(playlists==null){
    	  
      }else{
    	  for(Playlist p: playlists){
      %>
    	<a href="" class="showPlaylists"><%=p.getName() %></a>
    	<br>
    	<br>
      <%  
    	  }
      }
      %>
    </div>
  </div>

<br><br>
  <div class="playlists">
      <table class="showContents" cellspacing="0px">
        <tr>
        <div class="showContents_tr"></div>
        </tr>

            
    <%
      	Set<Song> songs  = (HashSet<Song>)request.getSession().getAttribute("songs");
      if(songs==null){
    	  
      }else{
    	  for(Song s: songs){
      %>
		<tr>
            <td class="showContents_img">
                <img src=<%=s.getImage() %> height="80" width="80" style="margin-left:10px;margin-top:25px;">
            </td>
            <td width="500px">
                <br>
               <p style="margin-left:10px;font-size:16px"><%=s.getName() %></p>
               <p style="margin-left:13px;font-size:13px;line-height:0.01;"><%=s.getSinger() %></p>
               <p style="margin-left:13px;font-size:13px"><%=s.getAlbum() %></p>
            </td>
            <td>
               <a><img src="Resource/delete.png" alt="delete" height="50" style="margin-left:23px;margin-top:10px;"></a>
            </td>
        </tr>
      <%  
    	  }
      }
      %>
         <div id="ajaxGetSongsOfPlaylist"></div>
  </div>
  
</div>

</body>
</html>