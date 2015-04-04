<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--                                                               -->
    <!-- Consider inlining CSS to reduce the number of requested files -->
    <!--                                                               -->
    <link type="text/css" rel="stylesheet" href="RandomMusic.css" media="all">

    <!--                                           -->
    <!-- Any title is fine                         -->
    <!--                                           -->
    <title>Shuffle Music Player</title>
    
    <!--                                           -->
    <!-- This script loads your compiled module.   -->
    <!-- If you add any GWT meta tags, they must   -->
    <!-- be added before this line.                -->
    <!--                                           -->
      
</head>

<body>
<!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
<!-- Shell -->	
   <div class="shell">
	  <!-- Header -->	
	  <div id="header">
		  <!-- Logout -->
		  <div id="cart">
              <br>    
    
                    <a href='/LoginCheckOnLoadServlet'class="cart-link" id="loginText">Login</a>
                    <a href="#" style="display:none" class="cart-link" id="logoutText">Logout</a>
		  </div>
		  <!-- End Logout -->	
	</div>
	<!-- End Header -->
	
	<!-- Main -->
	<div id="main">
		<div class="cl">&nbsp;</div>
		
		<!-- Content -->
        <br><br>
		<div id="content">
            <br><br><br>	
            <!-- insert player here -->	
            <h3>player inserted here</h3>
		</div>
		<!-- End Content -->
		
		<!-- Sidebar -->
		<div id="sidebar">
		
			<!-- Categories -->
			<div class="box categories">
                <div class="box-content">
                  <ul>
                    <li class="last"><a href="" class = "home">Homepage<span></span></a></li>
                  </ul>
                </div>
                
				<h2>Player<span></span></h2>
				<div class="box-content">
					<ul>
					    <li><a href="">My Shuffle Play</a></li>
					    <li class = "last"><a href="">My Favorite</a></li>
					</ul>
				</div>
				
				<h2>Playlist<span></span></h2>
				<div class="box-content">
					<ul>
					    <li><a href="">Study</a></li>
					    <li class = "last"><a href="">Relax</a></li>
					</ul>
				</div>
			</div>
			<!-- End Categories -->
			
		</div>
	   <!-- End Sidebar -->
		
	</div>
	<!-- End Main -->
	
</div>	
<!-- End Shell -->
</body>
</html>