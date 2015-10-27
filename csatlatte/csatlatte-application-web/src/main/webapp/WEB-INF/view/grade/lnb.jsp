<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="grade-message">
	<h4>당신의 성적을 등록해주세요.</h4>
	<p>등록된 성적을 바탕으로</p>
	<p>스마트한 분석 결과를 보실 수 있습니다.</p>
</div>
<div class="grade-icon">
	<div class="grade-menu">
		<a href="<c:url value="/grade/analysis"/>">
			<img alt="성적분석" src="<c:url value="/resources/csatlatte/images/btn/btn_chart.png"/>">
			<span class="grade-menu-title"><strong>성적분석</strong></span>
		</a>
	</div>
</div>