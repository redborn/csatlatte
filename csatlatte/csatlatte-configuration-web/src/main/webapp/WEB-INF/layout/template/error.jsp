<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<%@ include file="/WEB-INF/layout/include/csatlatte.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery.jsp" %>
<%@ include file="/WEB-INF/layout/include/bootstrap.jsp" %>
<%@ include file="/WEB-INF/layout/include/header/function.jsp" %>
<%@ include file="/WEB-INF/layout/include/footer.jsp" %>
<%@ include file="/WEB-INF/layout/include/error.jsp" %>
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div class="error">
		<div class="error-message">
			<tiles:insertAttribute name="content"/>
			<p><a href="<c:url value="/main"/>">홈으로 돌아가기</a></p>
		</div>
		<div class="error-logo">
			<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_logo2.png"/>">
		</div>
	</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>