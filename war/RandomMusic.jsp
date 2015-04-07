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
  	
    <script>
        //initialize the EventListner on progress bar
/*         var audio = document.getElementById("myplayer");
        audio.addEventListener("timeupdate", updateProgress, false); */
        //update progress bar while song is played
        function updateProgress() {
            var progress = document.getElementById("progress");
            var value = 0;
            var position = document.getElementById("position").innerHTML;
            if (position > 0) {
                value = Math.floor((100 / 180) * position);
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
        <input type="button" id="addList" value="+" style="margin-left:160px;border:0px;background:#ffffff;font-size:19px;" onClick="addList()">
        <p style="line-height:0.1pt">____________________________________</p>       
        <form action="" id="form1">
        <input type="text" id="listName" placeholder="ListName" style="width:195px">
        <input type="submit" id="btn_confirm" style="margin-left:5px;background:#ffffff;border-size:1px;" value="Add" onClick="confirm()" ><!--  -->
        </form>
        <br>
        
      <li ><span class="list"><a href="">My Favorite</a></span>
          <a href="#"><input type="image" id="MyFavorite" class=someClass src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Relax</a></span>
          <a href="#"><input type="image" id="RL" class=someClass src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Study</a></span>
          <a href="#"><input type="image" id="ST" class=someClass src="Resource/line_heart.png"  height="40"  align="absmiddle"></a>
      </li>
      <br>
      <li ><span class="list"><a href="">Work</a></span>
          <a href="#"><input type="image" id="WK" class=someClass src="Resource/line_heart.png" height="40"  align="absmiddle"></a>
      </li>
      <br>
    </ui>
  </div>
 <%} %>
 <!-- end of Menu settings --> 
 
 <script type="text/javascript">
 function addList(){
     var overlay = document.getElementById("form1");
      
     overlay.style.display = "block";    
       
   }
function confirm(){
    var overlay = document.getElementById("form1");
    
    overlay.style.display = "none";  
}
   
   </script>
   
  <br><br>
  
    <div id="ajaxGetUserServletResponse"></div>
    
  <div class="musicplayer">
      
      <img style="float:left" src="Resource/logo.png" alt="Logo" height="240" width="240" id="art">
          <div style="float:right">
              
              <p style="font-size:23px;font-style:bold;line-height:0.01;margin-left:6px;margin-top:26px" id="track">Song Name</p>
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
    
        <input id="play_key" class="form-control" value="a239111">

        <div class="col-md-6">
          <h3 id=""></h3>
          <h4>Playstate <p id="playState"></p></h4>
          <h4>Position <p id="position" onchange="updateProgress()"></p></h4>
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