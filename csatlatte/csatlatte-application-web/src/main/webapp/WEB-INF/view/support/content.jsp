<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="panel panel-default">
	<div class="panel-heading">
		<h4>환영합니다.<br/><small>궁금하신 사항을 아래 분류를 선택하면 쉽게 찾을 수 있습니다.</small><br/></h4>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button" id="support-category-first" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				카테고리1 <span class="caret"></span>  
			</button>
			<ul class="dropdown-menu" aria-labelledby="support-category-first">
				<li><a href="#">test1</a></li>
				<li><a href="#">test1</a></li>	
				<li><a href="#">test1</a></li>
				<li><a href="#">test1</a></li>
			</ul>
		</div>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button" id="support-category-second" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				카테고리2 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="support-category-second">
				<li><a href="#">test2</a></li>	
				<li><a href="#">test2</a></li>
				<li><a href="#">test2</a></li>
				<li><a href="#">test2</a></li>
			</ul>
		</div>
	</div>
	<div class="panel-body">
		<div class="support-question"><p><strong>아이디 혹은 비밀번호를 분실했어요. 어떻게 되찾을 수 있나요?</strong></p></div>
		<div class="support-answer">
			<p>아이디 링크를 참고하셔서 아이디 또는 비밀번호를 찾을 수 있습니다.</p><br/>
			<p>아이디 또는 비밀번호를 찾기 위해서는 회원가입할 때 등록한 보안 설정의 질문 / 답변을 알고 계셔야 합니다.</p>
			<p>질문 / 답변이 기억나지 않는 경우 아이디 정보를 되찾을 수 없습니다.</p><br/>
			<p>아이디 찾기는 앞 4자리만 공개되며, 비밀번호 찾기는 새로운 비밀번호를 설정할 수 있도록 도와드립니다.</p>
		</div>
		<div class="support-question"><p><strong>보안 확인에 필요한 질문 / 답변이 기억나지 않아요.</strong></p></div>
		<div class="support-answer">
			<p>보안 질문/답변은 조회할 수 없습니다.</p><br/>
			<p>내 정보에서 보안 질문/답변을 변경할 수 있으니 해당 기능을 이용하셔서 변경하시기 바랍니다.</p><br/>
			<p>만일 아이디, 비밀번호도 분실한 상태이고 보안 질문/답변을 모르는 상태이면</p>
			<p>아이디 혹은 비밀번호를 되찾을 수 없습니다.</p>
		</div>
	</div>
	<div class="panel-footer">
		<div class="support-guide">
			<div class="support-guide-message">
				<strong>필요한 답을 얻지 못했나요?</strong><br/>
				궁금한 항목에 대한 정보를 찾지 못했다면 수능라떼팀으로 문의해주세요.
			</div>
			<div class="support-btn-align-right">
				<a class="btn btn-default" href="<c:url value="/support/question"/>">문의하기</a>
			</div>
		</div>
	</div>
</div>