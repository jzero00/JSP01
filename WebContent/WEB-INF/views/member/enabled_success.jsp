<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('${member.id}님을 활성화처리하였습니다.');
	location.href="/member/detail?id=${member.id}";
</script>
