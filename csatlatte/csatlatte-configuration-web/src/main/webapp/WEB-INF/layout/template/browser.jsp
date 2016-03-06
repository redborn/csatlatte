<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
<style type="text/css">
	body {margin:0px; font-family:'Malgun Gothic';}
	.browser {margin-top:200px;}
	.browser-content {width:800px; margin-left:auto; margin-right:auto; text-align:left; padding:auto;}
	.browser-content h3 {margin-bottom:3px;}
	.browser-content-etc {margin-bottom:40px;}
	.browser-content-etc a {color:#7a6253; text-decoration:none; margin-right:20px;}
	.browser-ie {display:inline-block; padding:10px;}
	.browser-ie-content {display:inline-block;}
	.browser-ie-content p {margin-top:10px; margin-bottom:0px;}
	.browser-ie a {color:#7a6253; text-decoration:none;}
	.browser-firefox {display:inline-block; margin-right:40px; padding:10px;}
	.browser-firefox-content {display:inline-block;}
	.browser-firefox-content p {margin-top:10px; margin-bottom:0px;}
	.browser-firefox a {color:#7a6253; text-decoration:none;}
	.browser-chrome {display:inline-block; margin-right:40px; padding:10px;}
	.browser-chrome-content {display:inline-block;}
	.browser-chrome-content p {margin-top:10px; margin-bottom:0px;}
	.browser-chrome a {color:#7a6253; text-decoration:none;}
	.browser-image {margin-right:10px;}
	.browser-navigation {background:#7a6253; height:50px; width:auto; margin-top:0px;}
	.browser-navigation-brand {padding:7px;}
	.browser-navigation-brand {display:inline-block;}
	.browser-navigation-menu {display:inline-block; margin-top:16px; vertical-align:top; margin-right:20px;}
	.browser-navigation-menu a {color:white; font-size:15px; text-decoration:none;}
	.browser-footer {position:absolute; background:#7a6253; height:50px; bottom:0px; width:100%; text-align:right;}
	.browser-footer-content {font-size:15px; margin-top:14px; margin-right:15px; color:white;}
</style>
</head>
<body>
	<div class="browser-navigation">
		<div class="browser-navigation-brand">
			<a href="<c:url value="/main"/>">
				<img alt="brand" src="<c:url value="/resources/csatlatte/images/header/img_logo.png"/>"/>
			</a>
		</div>
		<div class="browser-navigation-menu">
			<a href="<c:url value="/rating"/>">모의고사 등급컷</a>
		</div>
		<div class="browser-navigation-menu">
			<a href="<c:url value="/grade"/>">내 성적 관리</a>
		</div>
		<div class="browser-navigation-menu">
			<a href="<c:url value="/community"/>">커뮤니티</a>
		</div>
		<div class="browser-navigation-menu">
			<a href="<c:url value="/support"/>">고객지원</a>
		</div>
	</div>
	<div class="browser">
		<div class="browser-content">
			<h2>사용 중인 웹브라우저는 지원 되지 않습니다.</h2>
			<p>수능라떼는 다양한 브라우저에서 지원이 됩니다.</p>
			<p>그러나 수능라떼의 다양한 기능을 사용하시려면 최신 브라우저로 업그레이드해야 합니다.</p>
			<p>Internet Explorer 10이하 버전은 브라우저 보안 취약의 이유로 서비스를 이용하실 수 없습니다.</p>
			<p>보안 취약에 대한 자세한 내용을 보시려면 아래 링크를 참고하세요.</p>
			<p>
			<div class="browser-content-etc">
				<a href="https://www.microsoft.com/ko-kr/WindowsForBusiness/End-of-IE-support">Microsoft 사이트</a> 
				<a href="http://www.hankookilbo.com/m/v/9dc45cd08689459d80db7950060d00d3">관련 기사1</a> 
				<a href="http://www.zdnet.co.kr/news/news_view.asp?artice_id=20140808081326">관련 기사2</a> 
				<a href="http://www.etnews.com/20160112000260">관련 기사3</a>
			</div>
			
			<h3>최신 브라우저 가져오기</h3>
			<div class="browser-chrome">
				<a href="https://www.google.com/intl/ko/chrome/browser/features.html">
					<img class="browser-image" alt="chrome" src="<c:url value="/resources/csatlatte/images/img/img_chrome.png"/>"/>
				</a>
				<div class="browser-chrome-content">
					<a href="https://www.google.com/intl/ko/chrome/browser/features.html">Chrome</a>
					<p>제작자 : Google</p>
				</div>
			</div>
			<div class="browser-firefox">
				<a href="https://www.mozilla.org/ko/firefox/new/">
					<img class="browser-image" alt="firefox" src="<c:url value="/resources/csatlatte/images/img/img_firefox.png"/>"/>
				</a>
				<div class="browser-firefox-content">
					<a href="https://www.mozilla.org/ko/firefox/new/">Firefox</a>
					<p>제작자 : Mozilla</p>
				</div>
			</div>
			<div class="browser-ie">
				<a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie">
					<img class="browser-image" alt="IE" src="<c:url value="/resources/csatlatte/images/img/img_ie.png"/>"/>
				</a>
				<div class="browser-ie-content">
					<a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie">Internet Explorer</a>
					<p>제작자 : Microsoft</p>
				</div>
			</div>
		</div>
	</div>
	<div class="browser-footer">
		<div class="browser-footer-content">
			Copyright 2015. Redborn all rights reserved.
		</div>
	</div>
</body>
</html>