<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h5><strong>프로필 사진 및 닉네임</strong>&nbsp;<small>커뮤니티를 이용 시에 사용되는 정보입니다.</small></h5>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/<session:id/>/modify">
	<div class="form-group">
		<label class="control-label col-sm-2">프로필 사진</label>
		<div class="col-sm-5">
			<img id="profile-modify-content-image" alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
		</div>
	</div>
	<div class="form-group">
		<label for="profile-modify-nickname" class="control-label col-sm-2">닉네임</label>
		<div class="col-sm-5"><input id="profile-modify-nickname" type="text" class="form-control" placeholder="닉네임" value="<session:nickname/>" name="nickname"/></div>
		<div class="col-sm-5"><div id="profile-nickname-check-message-area"></div></div>
		<input type="hidden" id="profile-modify-before-nickname" value="<session:nickname/>">
	</div>
	<div class="form-group">
		<label for="profile-modify-content-csat" class="control-label col-sm-2">수능 선택</label>
		<div class="col-sm-5">
			<select id="profile-modify-content-csat" class="form-control" name="csatSequence">
				<c:forEach items="${csatList}" var="csat">
					<option value="${csat.csatSequence}" <c:if test="${studentCsat eq csat.csatSequence}">selected</c:if>>${csat.csatName}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2">수능을 변경하면 내 성적 관리에 등록한 정보가 변경됩니다.</div>
		<div class="col-sm-offset-2">다시 이전 수능으로 변경하면 기존 정보를 다시 이용하실 수 있습니다.</div>
	</div>
	<div class="profile-modify-button-group">
		<a id="profile-modify-btn-cancel" class="btn btn-default" href="${pageContext.request.contextPath}/<session:id/>">취소</a>
		<input id="profile-modify-btn-success" type="submit" class="btn btn-primary" value="변경 완료">
	</div>
</form>