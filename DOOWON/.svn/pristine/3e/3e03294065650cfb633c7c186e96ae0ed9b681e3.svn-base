$(document).ready(function(){
  $('.customDropdown .dropdown-menu > a').bind('click', function(e) {
    var html = $(this).html();
    console.log(this)
    // $('.customDropdown button.dropdown-toggle').html(html + ' <span class="caret"></span>');
    $(this).parents().siblings("button").html(html)
  });
  jQuery(".chosen-select").chosen();
  $( ".datepicker" ).datepicker({
	  format: "YYYY/MM/DD hh:mm A",
	    keepOpen: false,
	    useCurrent: false,
	    keepInvalid: true,
	    useStrict: true
  });
})
