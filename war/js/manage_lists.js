
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
	  
      $.ajax({
          url : '/DeleteSongFromPlaylistServlet?songId='+songId,
          data : {
        	  currentPlaylistName:$('#currentPlaylistName').text(),
        	  songName:$('#songName').text()
          },
          success : function(responseText) {
        	  location.reload();
        	  $('#ajaxGetSongsOfPlaylist').text(responseText);
          }
      });
  }); 
  


});





