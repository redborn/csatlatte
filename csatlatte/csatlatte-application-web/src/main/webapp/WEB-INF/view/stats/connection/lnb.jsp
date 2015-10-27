<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h5>통계</h5>
<a class="btn btn-default" href="<c:url value="/stats/join"/>">가입자</a>
<a class="btn btn-default" href="<c:url value="/stats/connection"/>">접속자</a>
<a class="btn btn-default" href="<c:url value="/stats/community"/>">커뮤니티 활성</a>
<h5>운영</h5>
<a class="btn btn-default" href="<c:url value="/manage/user"/>">회원 관리</a>
<a class="btn btn-default" href="<c:url value="/manage/exam"/>">모의고사 관리</a>
<a class="btn btn-default" href="<c:url value="/manage/community"/>">커뮤니티 관리</a>
<a class="btn btn-default" href="<c:url value="/manage/question"/>">문의 관리</a>