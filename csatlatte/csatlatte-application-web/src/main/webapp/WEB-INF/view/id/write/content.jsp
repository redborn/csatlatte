<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="progress">
	<div class="progress-bar progress-bar-success progress-bar-striped active progress-first" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		1단계 닉네임 입력
	</div>
	<div class="progress-bar progress-bar-warning progress-step" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100">
		2단계 보안질문
	</div>
	<div class="progress-bar progress-bar-warning progress-final" role="progressbar" aria-valuenow="34" aria-valuemin="0" aria-valuemax="100">
		3단계 아이디 찾기 완료
	</div>
</div>
<form:form id="id-write-form" method="post" servletRelativeAction="/id" class="form-horizontal">
	<div class="id-write">
		<h4>아이디 정보</h4>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="id-write-content-nickname">닉네임</label>
			<div class="col-sm-6"><input id="id-write-content-nickname" maxlength="8" data-toggle="tooltip-nickname" data-placement="right" title="닉네임을 입력하셔야 합니다." name="nickname" type="text" class="form-control"></div>
		</div>
	</div>
	<div class="id-write-button-group">
		<a class="btn btn-default" href="<c:url value="/main"/>">취소</a>
		<input id="btn-next" type="submit" class="btn btn-success" disabled="disabled" value="다음단계">
	</div>
</form:form>