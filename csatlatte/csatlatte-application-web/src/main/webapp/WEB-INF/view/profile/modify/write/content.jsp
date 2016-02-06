<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4><strong>프로필 사진 및 닉네임</strong>&nbsp;<small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h4>
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/<session:id/>/modify">
	<div class="form-group">
		<label class="control-label col-sm-3">프로필 사진</label>
		<div class="col-sm-5">
			<img id="profile-modify-content-image" alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		</div>
	</div>
	<div class="form-group">
		<label for="profile-modify-content-nickname" class="control-label col-sm-3">닉네임</label>
		<div class="col-sm-5">
			<input id="profile-modify-content-nickname" type="password" class="form-control" placeholder="닉네임"/>
		</div>
	</div>
	<div class="form-group">
		<label for="profile-modify-content-csat" class="control-label col-sm-3">수능 선택</label>
		<div class="col-sm-5">
			<select id="profile-modify-content-csat" class="form-control">
				<option>2016학년도 대학수학능력시험 (현재 3학년 / N수생)</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2">수능을 변경하면 내 성적 관리에 등록한 정보가 변경됩니다.</div>
		<div class="col-sm-offset-2">다시 이전 수능으로 변경하면 기존 정보를 다시 이용하실 수 있습니다.</div>
	</div>
	<div class="profile-modify-button-group">
		<a id="profile-modify-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-modify-btn-success" type="submit" class="btn btn-default" value="변경 완료">
	</div>
</form>