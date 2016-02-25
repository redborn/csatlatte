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
			<div class="row">
				<div class="col-xs-8">
					<tiles:insertAttribute name="content"/>
					<br/>
					<p><a href="<c:url value="/main"/>">홈으로 돌아가기</a></p>
				</div>
				<div class="col-xs-4">
					<img alt="수능라떼" src="<c:url value="/resources/csatlatte/images/img/img_logo2.png"/>"/>
				</div>
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>