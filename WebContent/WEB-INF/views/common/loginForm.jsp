<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>로그인 페이지</title>
<!-- icheck bootstrap -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<style>
body{
	background-image:url('<%=request.getContextPath()%>/resources/images/intro.jpg');
	background-position:center;
	background-size:cover;
	background-repeat:no-repeat;
}
</style>
</head>
<body>
<div class="wrapper">
  <div class="row">
	  <div class="col-sm-4">
	  </div>
	  <div class="col-sm-4">
	  <!-- card card-primary start -->
	  <div class="card card-primary">
		 <div class="card-header">
		   <h3 class="card-title">로그인</h3>
		 </div>
		 <!-- /.card-header -->
		 <!-- form start -->
		 <form role="form" action="login" method="post">
		   <div class="card-body">
		     <div class="form-group">
		       <label for="exampleInputEmail1">아이디</label>
		       <input type="text" class="form-control" name="id" value="${param.id}" placeholder="ID">
		     </div>
		     <div class="form-group">
		       <label for="exampleInputPassword1">비밀번호</label>
		       <input type="password" class="form-control" name="pwd" value="${param.pwd}" placeholder="PASSWORD">
		     </div>
		   </div>
		   <!-- /.card-body -->
		    <div class="card-footer">
		      <input type="submit" class="btn btn-primary" value="로그인" />
		      <input type="button" onclick="OpenWindow('member/regist','회원등록',800,600);" class="btn btn-primary float-right" value="회원가입" />
		    </div>
		  </form>
		</div>
		<!-- card card-primary end -->
	  </div>
  </div>
</div>
<!-- ./wrapper -->
<!-- REQUIRED SCRIPTS -->
</body>
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>

<script>
	if("${param.id}" != ""){
		alert("아이디 혹은 패스워드가 일치하지 않습니다.");
	}
	
	function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight)	{
		winleft = (screen.width - WinWidth) / 2;
		wintop = (screen.height - WinHeight) / 2;
		var win = window.open(UrlStr, WinTitle, "scrollbars=yes,width="+ WinWidth 
								+", height=" + WinHeight + ", top=" + wintop
								+", left = " + winleft + ", resizable=yes, status=yes");
		win.focus();
	}
</script>
</html>