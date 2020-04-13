<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
</body>
<script>
	alert('${member.id}님의 정보가 수정되었습니다.');
	location.href="/member/detail?id=${member.id}";
	opener.location.reload();
</script>