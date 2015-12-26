<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/layout/include/contextpath.jsp" %>
<%@ include file="/WEB-INF/layout/include/csatlatte.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery.jsp" %>
<%@ include file="/WEB-INF/layout/include/bootstrap.jsp" %>
<%@ include file="/WEB-INF/layout/include/header/function.jsp" %>
<%@ include file="/WEB-INF/layout/include/container/function3.jsp" %>
<%@ include file="/WEB-INF/layout/include/footer.jsp" %>
<tiles:insertAttribute name="head"/>
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="content"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>