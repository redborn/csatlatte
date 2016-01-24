<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 style="color:#7a6253;">내 성적 관리</h2>
<div class="col-lg-12 panel panel-default grade-guest">
	<h3>내 성적 관리 서비스는 수능라떼 아이디를 가진 학생에게만 제공됩니다.</h3>
	<p>당신의 성적을 체계적으로, 꼼꼼하게 기록해보세요.</p>
	<p>기록된 성적은 당신 이외 아무도 열람 할 수 없습니다.</p>
	<br/>
	<h4>수능라떼를 아직 접속하지 않으셨나요?</h4>
	<a href="<c:url value="/main"/>">로그인하기</a>
	<br/>
	<br/>
	<h4>혹시 수능라떼 아이디가 없으신가요?</h4>
	<p>수능라떼는 당신의 미래와 꿈을 위해 많은 노력을 하고 있습니다.</p>
	<p>수능라떼에서 제공되는 성적 관리 기능을 통해 입학 가능한 대학을 가늠해보세요.</p>
	<p>이러한 기능을 이용한다는 것은 당신의 꿈에 큰 도움이 될 것입니다.</p>
	<a href="<c:url value="/join"/>">가입하기</a>
	<br/>
	<div style="text-align:right; margin-bottom:20px;">
		<img src="<c:url value="/resources/csatlatte/images/img/img_logo2.png"/>" title="수능라떼" alt="수능라떼"/>
	</div>
</div>