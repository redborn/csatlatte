<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<div id="grade-analysis-chart">
	<h4>등급 평균</h4>
	<div id="grade-analysis-rating-average-chart"></div>
	<h4>표준점수 합계</h4>
	<div id="grade-analysis-standard-score-chart"></div>
</div>
<div id="grade-analysis-nograde">
	<h3>등록하신 성적이 없습니다.</h3>
	<p>분석을 하기 위해선 등록된 성적이 있어야 합니다.</p>
	<p><session:nickname/>님! 성적을 입력하고 성적 분석을 해보세요.</p>
	<br/>
	<p>성적을 입력하려면 <a href="<c:url value="/grade"/>">여기</a>를 누르세요.</p>
	<div>
		<img src="<c:url value="/resources/csatlatte/images/img/img_logo2.png"/>" title="수능라떼" alt="수능라떼"/>
	</div>
</div>