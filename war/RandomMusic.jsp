<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import ="ca.utoronto.ece.entity.Playlist" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link href="Resource/ece1779A2.css" rel="stylesheet" type="text/css" media="all" />
    <title>Shuffle Music Player</title>
	<script src="js/jquery-1.5.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
  	<script src="js/token.js"></script>
  	<script src="js/hello.js"></script>
  	<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  	<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  	<link rel="stylesheet" type="text/css" href="stylesheets/global.css">
  	

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
            		<span class="bar">Welcome <%=user.getNickname() %>><a href="manage_lists.jsp" >Your Playlists</a></span>
            	<%}
               		%>
               		


<%if(user==null) {%>
  <br><br>
<img style="margin-left:30px" src="Resource/logo.png" alt="Logo" height="160" width="260">

<br><br><br>
<!-- Main Content -->
<div>
  <!-- Menu -->
  <div class="menu">
    <ui>
        <li ><span class="shuffleplaylist" ><a>Shuffle Play</a></span>
        </li>
      <br>
    </ui>
  </div>
 <%}else{
  %>
<br>
<!-- Main Content -->
<div>

  <!-- Menu -->
  <div class="menu">
    <img style="margin-left:0px" src="Resource/logo.png" alt="Logo" height="190" width="300">
    <ui>
        <li ><span class="shuffleplaylist"><a>Shuffle Play</a></span>
        </li>
     
        <h4 style="display:inline-block">PlayLists</h4>
        <input type="button" id="addList" value="+" style="margin-left:160px;border:0px;background:#ffffff;font-size:19px;">
        <p style="line-height:0.1pt">____________________________________</p>       
        <!-- <form id="form1" > -->
        <div style="display:none" id="addNewPlaylistInfo">
        <input type="text" id="listName" name="listName" placeholder="Playlist Name" style="width:195px">
        <input type="submit" id="btn_confirm" style="margin-left:5px;background:#ffffff;border-size:1px;" value="Add" >
        <!-- </form> -->
        </div>
        <br>
        
      <%
      	List<Playlist> playlists  = (List<Playlist>)request.getSession().getAttribute("playlists");
      if(playlists==null){
    	  
      }else{
    	  for(Playlist p: playlists){
      %>
       <li ><span class="list"><a href="#" class= playClass ><%=p.getName() %></a></span>
          <a href="#"><input type="image" id=<%=p.getName() %> class= someClass src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <%  
    	  }
      }
      %>
      
    </ui>
  </div>
 <%} %>
 <!-- end of Menu settings --> 
   
  <br><br>
  
    <div id ="ajaxGetUserServletResponse" style="text-align:center;font-size:13px;display:none;border:1px #f0ffff solid;border-radius:10px;background:#f0ffff;width:350px;height:25px;margin-left:550px;padding-top:3px;margin-top:30px;"></div>
    <div id = "ajaxAddPlaylistResponse" style="text-align:center;font-size:13px;display:none;border:1px #f0ffff solid;border-radius:10px;background:#f0ffff;width:350px;height:25px;margin-left:550px;padding-top:3px;margin-top:30px;"></div>
    
  <div class="musicplayer">
      
      <img style="float:left" src="Resource/logo.png" alt="Logo" height="240" width="240" id="art">
          <div style="float:right">
              <br><br>
             <!-- displaying frequency  -->
            <div id="freq" class="frequency">
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          
      <!-- end of frequency -->
            <br><br><br>
            
              <!-- Progress Bar-->
              <div id="progressBar">
                  <div id="progress"></div>
              </div>
          
          
          <br>
          <!-- Control Components-->
         <div id="apiswf"></div>               
          <div class="playsong" id="playsong" >
              <input type="image" id="play" onclick="" src="Resource/play.png" height="42" style="margin-left:56px" >
                  </div>
          <div class="pausesong" id="pausesong">
              <input type="image" id="stop" onclick="" src="Resource/pause.png" height="42" >
                  </div>
          <div class="nextsong">
              <input type="image" id="next" onclick="" src="Resource/next.png" height="42" >       
          </div>
        </div>    

        <br><br>
        <div style="background-color:#FFEFD5"> 
          <p style="visibility:hidden">1</p>
          <p style="font-size:21px;font-style:bold;line-height:0.01;margin-left:8px;margin-top:10px" id="track">Song Name</p>
          <br>
          <p style="font-size:16px;line-height:1;margin-left:10px;"id="artist">Singer Name</p>
          <p style="font-size:16px;line-height:0.01;margin-left:10px;"id="album">Album Name</p>
          <br>
        </div>

      
               <input id="play_key" class="form-control" value="a239111"><!--style="visibility:hidden"-->
      
    </div>

</div>
  

</body>
</html>
