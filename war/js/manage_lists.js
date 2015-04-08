
$(document).ready(function() {



  $('.showPlaylists').click(function(){
	  var playlistName = $(this).text();
      $.ajax({
          url : '/DisplaySongsOfPlaylist?playlistName='+playlistName,
          data : {

          },
          success : function(responseText) {
            
          }
      });
  }); 
  


});





