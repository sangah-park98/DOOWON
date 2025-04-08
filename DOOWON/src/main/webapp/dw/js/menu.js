/***************************************/
/*    1. 초기화 및 이벤트 정의           */
/***************************************/
$(document).ready(function() {

  //side menu 클릭 시 Content 영역
  $('#MenuBtn').on('click', function() {
    $('#sideNavigation').animate({ left: '0' }, 200);
    $('#MenuBtn').hide();
    $('#MenuBtn02').show();
    $(".container").animate({ marginLeft: "276px" }, 670);
    // $(".container").css({ marginLeft: "276px" }, 100);

    // $("#toggle-open".css({"background":"url(../img/toggle_m_c.png)"});
  });

  $('#MenuBtn02').on('click', function() {

    $('#sideNavigation').animate({ left: '-276px' }, 200);
    $('#MenuBtn02').hide();
    $('#MenuBtn').show();
    // $(".container").css({ marginLeft: "0" }, 100);
    $(".container").animate({ marginLeft: "0" }, 650);
  });


  $('#search_toggle').on('click', function() {
    $('#searchCon').toggle('slow');
  });


  $("#popOpenBtn").click(function(event){  //팝업 Open 버튼 클릭 시

            $("#popupDiv").css({
               "top": (($(window).height()-$("#popupDiv").outerHeight())/2+$(window).scrollTop())+"px",
               "left": (($(window).width()-$("#popupDiv").outerWidth())/2+$(window).scrollLeft())+"px"
               //팝업창을 가운데로 띄우기 위해 현재 화면의 가운데 값과 스크롤 값을 계산하여 팝업창 CSS 설정

            });

           $("#popup_mask").css("display","block"); //팝업 뒷배경 display block
           $("#popupDiv").css("display","block"); //팝업창 display block

           // $("body").css("overflow","hidden");//body 스크롤바 없애기
       });

       /*$("#popCloseBtn").click(function(event){
           $("#popup_mask").css("display","none"); //팝업창 뒷배경 display none
           $("#popupDiv").css("display","none"); //팝업창 display none
           // $("body").css("overflow","auto");//body 스크롤바 생성
       });
*/
       $("#popCancleBtn").click(function(event){
           $("#popup_mask").css("display","none"); //팝업창 뒷배경 display none
           $("#popupDiv").css("display","none"); //팝업창 display none
           // $("body").css("overflow","auto");//body 스크롤바 생성
       });


});
