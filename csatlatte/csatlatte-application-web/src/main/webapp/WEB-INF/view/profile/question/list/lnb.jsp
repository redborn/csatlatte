<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4>문의하신 사항이 있으세요?</h4>
<p>답변이 필요없는 문의사항은 삭제를 통해</p>
<p>문의를 취소할 수도 있습니다.</p>
<p id="profile-question-return"><a href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a></p>
<%@ include file="/WEB-INF/layout/attribute/banner/250x250.jsp" %>