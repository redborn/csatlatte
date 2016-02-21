<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<h4>비밀번호 변경이 무엇인가요?</h4>
<p>로그인에 필요한 비밀번호를 바꿀 수 있습니다.</p>
<p>비밀번호를 자주 변경하면 아이디가 더 안전합니다.</p>
<p id="profile-password-return"><a href="${pageContext.request.contextPath}/<session:id/>">내 정보로 돌아가기</a></p>