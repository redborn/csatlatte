<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="community-profile">
	<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
	<div class="community-menu-title"><strong>사용자 닉네임</strong></div>
</div>
<div class="community-icon">
	<div class="dropdown">
		<div class="dropdown-toggle" id="community-alert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			<div class="community-icon-menu">
				<span><img alt="알림" src="<c:url value="/resources/csatlatte/images/btn/btn_alert.png"/>"></span>
				<span class="community-menu-title"><strong>알림</strong></span>
			</div>
		</div>
		<ul class="dropdown-menu" aria-labelledby="community-alert">
			<li>
				<div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-detail"><img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<div class="dropdown-menu-message">닉네임님이 1개 댓글을 남기셨습니다.</div>
				</div>
			</li>
		</ul>
	</div>
	<div class="community-icon-menu">
		<span><img alt="내가쓴글" src="<c:url value="/resources/csatlatte/images/btn/btn_my_text.png"/>"></span>
		<span class="community-menu-title"><strong>내가쓴글</strong></span>
	</div>
	<div class="community-icon-menu">
		<a href="<c:url value="/myinfo/modify"/>">
			<span><img alt="프로필수정" src="<c:url value="/resources/csatlatte/images/btn/btn_profile_modify.png"/>"></span>
			<span class="community-menu-title"><strong>프로필수정</strong></span>
		</a>
	</div>
</div>