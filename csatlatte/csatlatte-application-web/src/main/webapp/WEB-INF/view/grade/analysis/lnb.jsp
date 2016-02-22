<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="grade-analysis-message">
	<h4>이 분석은 어떻게 활용하나요?</h4>
	<p>모의고사별 성적 변화율을 알 수 있습니다.</p><br/>
	<p>모든 과목의 성적을 입력하면</p>
	<p>더 정확한 정보를 알 수 있습니다.</p>
	<div class="grade-analysis-add-score">
		<a href="<c:url value="/grade"/>">내 성적 등록하러 가기</a>
	</div>
</div>
<%@ include file="/WEB-INF/layout/attribute/banner/250x250.jsp" %>