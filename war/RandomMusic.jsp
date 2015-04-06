<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.google.appengine.api.users.User" %>
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
  	
    <audio id="myplayer">
        <source src="Resource/1.mp3">
            </audio>
    <script>
        //initialize the EventListner on progress bar
        var audio = document.getElementById("myplayer");
        audio.addEventListener("timeupdate", updateProgress, false);
        //update progress bar while song is played
        function updateProgress() {
            var progress = document.getElementById("progress");
            var value = 0;
            if (audio.currentTime > 0) {
                value = Math.floor((100 / audio.duration) * audio.currentTime);
            }
            progress.style.width = value + "%";
        }
    </script>
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
            		<span class="bar">Welcome <%=user.getNickname() %>><a href="" >Your Playlists</a></span>
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
      <li><span class="list2">Shuffle Play</span></a></li>
      <br>
      <li><span class="list2">My Favarite</span></a></li>
      <br>
      <li><span class="list2">Relax</span></a></li>
      <br>
      <li><span class="list2">Study</span></a></li>
      <br>
      <li><span class="list2">Work</span></a></li>
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
        <li ><span class="list"><a href="">Random Play</span></a>
            <a href="#"><input type="image" id="RP"  src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
        </li>
      <br>
      <li ><span class="list"><a href="">My Favourite</span></a>
          <a href="#"><input type="image" id="MF"  src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Relax</span></a>
          <a href="#"><input type="image" id="RL"  src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Study</span></a>
          <a href="#"><input type="image" id="ST"  src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Work</span></a>
          <a href="#"><input type="image" id="WK"  src="Resource/line_heart.png" height="40"  align="absmiddle"></a>
      </li>
      <br>
    </ui>
  </div>
  <%} %>
  
  <br><br>
  
  
  <div class="musicplayer">
      
      <img style="float:left" src="Resource/logo.png" alt="Logo" height="240" width="240" id="art">
          <div style="float:right">
              
              <p style="font-size:23px;font-style:bold;line-height:0.01;margin-left:6px;margin-top:26px" id="track">Song Name</h3>
              <p style="font-size:16px;line-height:1;margin-left:10px;"id="artist">Singer Name</p>
              <p style="font-size:16px;line-height:0.01;margin-left:10px;"id="album">Album Name</p>
              <br><br>
              <!-- Progress Bar-->
              <div id="progressBar">
                  <div id="progress"></div>
              </div>
          </div>
          
          
          <!-- Control Components-->
      <div id="apiswf"></div>               
          <div class="lastsong">
              <input type="image" id="previous" onclick="" src="Resource/last.png" height="42" >
                  </div>
          <div class="playsong" id="playsong">
              <input type="image" id="play" onclick="" src="Resource/play.png" height="42" >
                  </div>
          <div class="pausesong" id="pausesong">
              <input type="image" id="stop" onclick="" src="Resource/pause.png" height="42" >
                  </div>
          <div class="nextsong">
              <input type="image" id="next" onclick="" src="Resource/next.png" height="42" >
                  </div>
    
        <input id="play_key" class="form-control" value="a239851">
<!--  style="display: none;" -->
        <div class="col-md-6">
          <h3 id=""></h3>
          <h4>Playstate <p id="playState"></p></h4>
          <h4>Position <p id="position"></p></h4>
        </div>
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
      
      
      
          <script type="text/javascript">
              function play(){
                  var audio = document.getElementById("myplayer");
                  audio.play();
                  audio.loop=true;
              }
          function pause(){
              var audio = document.getElementById("myplayer");
              audio.pause();
          }
          
              </script>
          
          </div>

</div>
  

</body>
</html>