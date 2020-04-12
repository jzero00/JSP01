<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function formCheck(){
	var f=$('form#form')

	// id 정규식
	idvalue = f.id.value;
	idlen = idvalue.trim().length;
	
	id(idlen == 0){
		alert("ID를 입력하세요");
		return false;
	}
	if(idlen<5 || idlen>12){
		alert("5~12자리 사이의 ID를 입력하세요");
		return false;
	}
	idreg = /^[0-9a-zA-z]{5,12}$/;
	if(!idreg.test(idvalue)){
		alert("ID는 영어와 숫자 혼합해서 입력해주세요");
		return false;
	}
}
</script>