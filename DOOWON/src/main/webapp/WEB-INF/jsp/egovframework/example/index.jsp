 <!DOCTYPE html>
 <html lang="kr" dir="">

 <head>


 </head>
<body class="text-left" id="dash">
  <div class="app-admin-wrap layout-sidebar-large">



    <div class="main-content-wrap d-flex flex-column">
      <!-- ============ Body content start ============= -->
      <div class="main-content">
        <div class="breadcrumb">
          <h1 class="mr-2">Dashboard</h1>

          <span>
            <div class="btn-group">
              <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                업체선택
              </button>
              <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-start" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 27px, 0px);">
                <a class="dropdown-item" href="#">업체 이름 샘플1</a>
                <a class="dropdown-item" href="#">업체 이름 샘플2</a>
                <a class="dropdown-item" href="#">업체 이름 샘플3</a>
                <a class="dropdown-item" href="#">샘플4(텍스트오른쪽 정렬)</a>
              </div>
            </div>
          </span>

          <span>
            <div class="btn-group">
              <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                대시보드 항목 선택
              </button>
              <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-start" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 27px, 0px);">
                <a class="dropdown-item" href="#">항목1</a>
                <a class="dropdown-item" href="#">항목2</a>
                <a class="dropdown-item" href="#">항목3</a>
              </div>
            </div>
          </span>



          <span>
            <div class="input-group">
              <div class="input-group-prepend"><span class="input-group-text" id="basic-addon3" >종료일</span></div>
              <input class="form-control" id="basic-url" type="text" aria-describedby="basic-addon3" >
            </div>

            <script>
              $(function(){
                $("#basic-url").datepicker();
              });
            </script>
          </span>

          <span>~</span>

          <span>
            <div class="input-group">
              <div class="input-group-prepend"><span class="input-group-text" id="basic-addon1" >시작일</span></div>
              <input class="form-control" id="basic-url-end" type="text" aria-describedby="basic-addon1" >
            </div>

            <script>
              $(function(){
                $("#basic-url, #basic-url-end").datepicker();
              });
            </script>
          </span>

        </div>
        <div class="separator-breadcrumb border-top"></div>




      </div><!-- Footer Start -->

      <p style="display:block; margin:1rem;"><a href="component.html">Component</a></p>
      <p style="display:block; margin:1rem;"><a href="login.html">Login</a></p>

      <!-- fotter end -->
    </div>
  </div>



</body>

</html>
