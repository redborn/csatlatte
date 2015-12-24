<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="row">
	<div class="col-sm-3">
	</div>
	<div class="col-sm-8 community-list">
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
		<div class="panel panel-default">
			<div class="panel-body community-text">
				<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
				<div style="display:inline-block; margin-left:3px;">
					<div class="community-name"><strong>nickname</strong></div>
					<div class="community-calender">2015-12-06 12:12:12</div>
				</div>
				<div style="display:inline-block; vertical-align:top; text-align:right; float:right;">
					<div class="dropdown">
						<a id="community-text-menu" href="#" class="dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-menu-down"></span></a>
						<ul style="margin-left:-150px;" class="dropdown-menu" aria-labelledby="community-text-menu">
							<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 글을 수정하고 싶어요.</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-trash"></span> 글을 삭제할래요.</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-bell"></span> 신고하기</a></li>
						</ul>
					</div>
				</div>
				<div style="padding-top:15px;">
					awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.awgwglnwlgnnlwangknawlgnklanglnr감사합니다.
				</div>
			</div>
			<div class="panel-footer">
				<div>
					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div style="display:inline-block; margin-left:3px;">
						<div class="community-name"><strong>nickname</strong></div>
						<div class="community-calender">2015-12-06 12:12:12</div>
					</div>
				</div>
				<div>
					<img alt="프로필사진" class="community-profile-picture" style="position:absolute;" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>"/>
					<div style="padding-left:44px;">
						<label for="community-comment-write-input" class="sr-only">댓글을 입력하세요.</label>
						<input id="community-comment-write-input" type="text" class="form-control" placeholder="댓글을 입력하세요." maxlength="140"/>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>