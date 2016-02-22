<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="random" class="java.util.Random"/>
<div class="banner-250x250">
	<img src="${pageContext.request.contextPath}/resources/csatlatte/images/ad_csat_250x250${random.nextInt(3) % 3 + 1}.png"/>
</div>