<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import ="ca.utoronto.ece.entity.Playlist" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link href="Resource/ece1779A2.css" rel="stylesheet" type="text/css" media="all" />
    <title>Your Playlists</title>
    
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
    <a href="" class="showPlaylists">My Favourites</a>
    <br>
    <a href="" class="showPlaylists">Relax</a>
    <br>
    <a href="" class="showPlaylists">Study</a>
    <br>
    <a href="" class="showPlaylists">Work</a>
  </div>

<br><br>
  <div class="playlists">
      <table class="showContents" cellspacing="0px">
        <tr>
        <div class="showContents_tr"></div>
        </tr>
        <tr>
            <td class="showContents_img">
                <img src="Resource/logo.png" height="80" width="80" style="margin-left:10px;margin-top:25px;">
            </td>
            <td width="500px">
                <br>
               <p style="margin-left:10px;font-size:16px">Song Name</p>
               <p style="margin-left:13px;font-size:13px;line-height:0.01;">Singer Name</p>
               <p style="margin-left:13px;font-size:13px">Album Name</p>
            </td>
            <td>
               <a><img src="Resource/delete.png" alt="delete" height="50" style="margin-left:23px;margin-top:10px;"></a>
            </td>
                
        </tr>
    
  </div>
  
</div>

</body>
</html>