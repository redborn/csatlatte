<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="login-login" class="center-block" <c:if test="${logoutSuccess or loginFail}">style="margin-top: 46px;"</c:if>>
	<div>
		<div>
			<form:form id="login-form" servletRelativeAction="/login" method="POST">
				<div class="form-group">
					<label for="login-input-id" class="sr-only">수능라떼 아이디</label>
					<input type="text" name="id" class="form-control" placeholder="수능라떼 아이디" id="login-input-id"/>
				</div>
				<div class="form-group">
					<label for="login-input-password" class="sr-only">수능라떼 비밀번호</label>
					<input type="password" name="password" class="form-control" placeholder="수능라떼 비밀번호" id="login-input-password"/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="로그인" style="width:100%;">
				</div>
				<div class="login-account">
					<div class="login-join">
						<a href="<c:url value="/join"/>" class="main-link">회원가입</a>
					</div>
					<div class="login-find">
						<a href="<c:url value="/id"/>" class="main-link">아이디 찾기</a> |
						<a href="<c:url value="/password"/>" class="main-link">비밀번호 찾기</a>
					</div>
				</div>
			</form:form>
			<c:if test="${logoutSuccess}">
				<div class="alert alert-success" role="alert" style="margin-top:20px;">정상적으로 로그아웃 되었습니다.</div>
			</c:if>
			<c:if test="${loginFail}">
				<div class="alert alert-danger" role="alert" style="margin-top:20px;">아이디 또는 비밀번호가 틀렸습니다.</div>
			</c:if>
		</div>
	</div>
</div>