
$(document).ready(function() {



  $('.showPlaylists').click(function(){
	  var playlistName = $(this).text();
      $.ajax({
          url : '/DisplaySongsOfPlaylist?playlistName='+playlistName,
          data : {

          },
          success : function() {
        	  location.reload();
        	  
          }
      });
  }); 
  
  $('.someClass').click(function(){
	  var songId = $(this).attr('id');
	  var playlistName = $('#currentPlaylistName').text();
      $.ajax({
          url : '/DeleteSongFromPlaylistServlet?songId='+songId,
          data : {
        	  currentPlaylistName:$('#currentPlaylistName').text(),
        	  songName:$('#songName').text()
          },
          success : function(responseText) {
        	  
        	  $('#ajaxGetSongsOfPlaylist').text(responseText);
      
		      $.ajax({
		          url : '/DisplaySongsOfPlaylist?playlistName='+playlistName,
		          data : {
		
		          },
		          success : function() {
		        	  location.reload();
		          }
		      })
          }
      });
  }); 
  


});





