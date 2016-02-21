<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4>보안변경이란 무엇인가요?</h4>
<p>아이디 혹은 비밀번호를 분실한 경우</p>
<p>다시 되찾을때 필요한 정보를 수정할 수 있습니다.</p>
<p id="profile-security-return"><a href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a></p>