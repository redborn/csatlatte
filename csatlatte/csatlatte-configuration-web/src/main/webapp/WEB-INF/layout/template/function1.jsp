<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/layout/include/csatlatte.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery.jsp" %>
<%@ include file="/WEB-INF/layout/include/bootstrap.jsp" %>
<%@ include file="/WEB-INF/layout/include/header/function.jsp" %>
<%@ include file="/WEB-INF/layout/include/container/function1.jsp" %>
<%@ include file="/WEB-INF/layout/include/footer.jsp" %>
<tiles:insertAttribute name="head"/>
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div class="container">
		<div class="lnb"><tiles:insertAttribute name="lnb"/></div><div class="content"><tiles:insertAttribute name="content"/></div>
	</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>