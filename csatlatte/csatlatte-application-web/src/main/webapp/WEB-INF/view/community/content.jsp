<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="container">
	<h2 style="color:#7a6253;">커뮤니티</h2>
</div>
<div style="border-top: 1px solid #7a6253; border-bottom: 1px solid #7a6253; padding:10px; margin-bottom:10px;">
	<div class="container">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="#">전체 글</a></li>
			<li role="presentation"><a href="#">내가 작성한 글</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-12 community-list">
			<div id="community-write" class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">글 작성</h3>
				</div>
				<div class="panel-body community-write-text">
					<textarea rows="5" class="form-control" placeholder="무슨일이 있으셨나요?" maxlength="140"></textarea>
				</div>
				<div class="panel-footer community-write-btn">
					<input type="submit" class="btn btn-default" value="게시"/>
				</div>
			</div>
			<!-- 
			<div class="panel panel-default community-text">
				<div class="panel-body">
					<div class="community-dropdown">
						<div class="dropdown">
							<a id="community-text-menu" href="#" class="dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-menu-down"></span></a>
							<ul class="dropdown-menu" aria-labelledby="community-text-menu">
								<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 글을 수정하고 싶어요.</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-trash"></span> 글을 삭제할래요.</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-bell"></span> 신고하기</a></li>
							</ul>
						</div>
					</div>
					<img alt="프로필사진" class="community-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div class="communuty-text-info">
						<div class="community-name"><strong>nickname</strong></div>
						<div class="community-calender">2015-12-06 12:12:12</div>
					</div>
					<div class="community-text-content">
						awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.
					</div>
				</div>
				<div class="panel-footer">
					<img alt="프로필사진" class="community-comment-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div class="community-text-comment-info">
						<div class="community-dropdown">
							<div class="dropdown">
								<a id="community-text-menu" href="#" class="dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-menu-down"></span></a>
								<ul class="dropdown-menu" aria-labelledby="community-text-menu">
									<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 글을 수정하고 싶어요.</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-trash"></span> 글을 삭제할래요.</a></li>
									<li><a href="#"><span class="glyphicon glyphicon-bell"></span> 신고하기</a></li>
								</ul>
							</div>
						</div>
						<div class="community-name">
							<strong>nickname</strong> gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.
						</div>
						<div class="community-calender">2015-12-06 12:12:12</div>
					</div>
					
				</div>
				<div class="panel-footer">
					<img alt="프로필사진" class="community-comment-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div class="community-text-comment-info">
						<div class="community-name">
							<strong>nickname</strong> gnklanglnr감사합니다gnklanglnr감사합니다
						</div>
						<div class="community-calender">2015-12-06 12:12:12</div>
					</div>
				</div>
				<div class="panel-footer">
					<img alt="프로필사진" class="community-comment-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div class="community-text-comment-info">
						<div class="community-name">
							<strong>nickname</strong> gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다gnklanglnr감사합니다
						</div>
						<div class="community-calender">2015-12-06 12:12:12</div>
					</div>
				</div>
				<div class="panel-footer community-text-comment-write">
					<img alt="프로필사진" class="community-comment-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div class="community-text-comment-write-div">
						<label for="community-text-comment-write-input" class="sr-only">댓글을 입력하세요.</label>
						<input id="community-text-comment-write-input" type="text" class="form-control" placeholder="댓글을 입력하세요." maxlength="140"/>
					</div>
				</div>
			</div>
			 -->
		</div>
	</div>
</div>