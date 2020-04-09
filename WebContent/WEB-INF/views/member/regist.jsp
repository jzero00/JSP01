<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/include/open_header.jsp" %>
<title>회원가입 페이지</title>
<body>
<div class="wrapper">
	  <!-- card card-primary start -->
	  <div class="card card-primary">
		 <div class="card-header">
		   <h3 class="card-title">회원가입</h3>
		 </div>
		 <!-- /.card-header -->
		 <!-- form start -->
		 <form role="form" class="form-horizontal" action="regist" method="post">
           <div class="card-body">
             <div class="form-group row">
             <input type="hidden" name="picture" />
				<div class="input-group mb-3">
					<div class="mailbox-attachments clearfix" style="text-align: center;">
						<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
						<div class="mailbox-attachment-info">
							<div class="input-group input-group-sm">
								<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
								<input id="inputFileName" class="form-control" type="text" name="picture" />
								<span class="input-group-append-sm">											
									<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
								</span>
							</div>
						</div>
					</div>
					<br />
				  </div>
             </div>
             <div class="form-group row">
               <label for="inputid" class="col-sm-3 col-form-label">이름</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control"  name="name" placeholder="이름">
               </div>
             </div>
             <div class="form-group row">
               <label for="inputid" class="col-sm-3 col-form-label">ID</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control"  name="id" placeholder="ID">
               </div>
               <div class="col-sm-3">
                 <button type="submit" class="btn btn-info">중복체크</button>
               </div>
             </div>
             <div class="form-group row">
               <label for="pwd" class="col-sm-3 col-form-label">비밀번호</label>
               <div class="col-sm-6">
                 <input type="password" class="form-control"  name="pwd" placeholder="PASSWORD">
               </div>
             </div>
             <div class="form-group row">
               <label for="pwd" class="col-sm-3 col-form-label">비밀번호확인</label>
               <div class="col-sm-6">
                 <input type="password" class="form-control" name="pwdcheck" placeholder="비밀번호확인">
               </div>
             </div>
             <div class="form-group row">
               <label for="phone" class="col-sm-3 col-form-label">전화번호</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control"  name="phone" placeholder="전화번호">
               </div>
             </div>
             <div class="form-group row">
               <label for="address" class="col-sm-3 col-form-label">주소</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" name="address" placeholder="주소">
               </div>
             </div>
             <div class="form-group row">
               <label for="address" class="col-sm-3 col-form-label">이메일</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control"  name="email" placeholder="이메일">
               </div>
             </div>             
           </div>
           <!-- /.card-body -->
           <div class="card-footer">
             <button type="submit" class="btn btn-info">회원가입</button>
             <button type="button" onclick="CloseWindow()" class="btn btn-default float-right">취소</button>
           </div>
           <!-- /.card-footer -->
         </form>
		</div>
		<!-- card card-primary end -->
</div>
<!-- ./wrapper -->
<form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" style="display:none;">
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>
</body>
<script>
	function CloseWindow(){
		var check = confirm("회원가입을 취소하시겠습니까?");
		if(check == true){
			alert("회원가입을 취소합니다.")
			window.close();		
		}
	}
</script>
<%@ include file="/WEB-INF/views/include/open_footer.jsp" %>
<%@ include file="/WEB-INF/views/member/picture_js.jsp" %>