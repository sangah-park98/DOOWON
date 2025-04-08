$(document).ready(function(){
  $('.customDropdown .dropdown-menu > a').bind('click', function(e) {
    var html = $(this).html();
    // $('.customDropdown button.dropdown-toggle').html(html + ' <span class="caret"></span>');
    $(this).parents().siblings("button").html(html)
  });
  
  if ( $(".chosen-select") > 0 ) {
	  jQuery(".chosen-select").chosen();
  }
  
  if ( $(".datepicker") > 0 ) {
	  $( ".datepicker" ).datepicker();
  }
 
})
