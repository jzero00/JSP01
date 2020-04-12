<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/views/include/open_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
<body>
<div class="alert alert-success alert-dismissible">
   <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="CloseWindow()">×</button>
   <h2><i class="icon fas fa-check"></i>회원가입 성공</h2>
   <h3><%=request.getAttribute("name") %>님 어서오세요.</h3><br>
   <h3>회원 가입에 성공했습니다.</h3>
</div>
</body>