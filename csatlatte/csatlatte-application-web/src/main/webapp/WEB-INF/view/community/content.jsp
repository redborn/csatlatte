<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="panel panel-default">
	<div class="panel-heading">
		<h5 class="community-write-title"><strong>글 작성</strong></h5>
	</div>
	<div class="panel-body community-write-text">
		<textarea rows="5" class="form-control" placeholder="무슨일이 있으셨나요?"></textarea>
	</div>
	<div class="panel-footer community-btn-align-right">
		<input type="submit" class="btn btn-default" value="게시">
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="community-text">
			<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			<div class="community-user-info">
				<div class="community-name"><strong>닉네임</strong></div>
				<div class="community-calender">2015-09-20 11:52:37</div>
			</div>
			<div class="dropdown">
				<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
				<ul class="dropdown-menu" aria-labelledby="community-text-menu">
					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-modify"><img alt="글수정" src="<c:url value="/resources/csatlatte/images/ico/ico_text_modify.png"/>"> | 글을 수정하고 싶어요.</div></li>	
					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-delete"><img alt="글삭제" src="<c:url value="/resources/csatlatte/images/ico/ico_text_delete.png"/>"> | 글을 삭제할레요.</div></li>
					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-report"><img alt="신고하기" src="<c:url value="/resources/csatlatte/images/ico/ico_report.png"/>"> | 신고하기</div></li>
				</ul>
			</div>
		</div>
		<div class="community-content">글 내용</div>
	</div>
	<div class="panel-footer panel-comment">
		<div class="community-text">
			<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			<div class="community-user-info">
				<div class="community-name"><strong>닉네임</strong></div>
				<div class="community-comment-content">내용</div>
				<div class="community-calender">2015-09-20 12:00:12</div>
			</div>
			<div class="dropdown">
				<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
				<ul class="dropdown-menu" aria-labelledby="community-text-menu">
					<li><div class="dropdown-menu-resource">test1</div></li>
					<li><div class="dropdown-menu-resource">test1</div></li>	
					<li><div class="dropdown-menu-resource">test1</div></li>
					<li><div class="dropdown-menu-resource">test1</div></li>
				</ul>
			</div>
		</div>
		<div class="community-comment">
			<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
			<input type="text" class="form-control" placeholder="댓글을 입력해주세요.">
		</div>
	</div>
</div>

<div class="modal fade" id="community-text-detail" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<div class="community-text">
					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<div class="community-user-info">
						<div class="community-name"><strong>닉네임</strong></div>
						<div class="community-calender">2015-09-20 11:52:37</div>
					</div>
				<div class="dropdown">
					<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
					<ul class="dropdown-menu" aria-labelledby="community-text-menu">
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-modify"><img alt="글수정" src="<c:url value="/resources/csatlatte/images/ico/ico_text_modify.png"/>"> | 글을 수정하고 싶어요.</div></li>	
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-delete"><img alt="글삭제" src="<c:url value="/resources/csatlatte/images/ico/ico_text_delete.png"/>"> | 글을 삭제할레요.</div></li>
						<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-report"><img alt="신고하기" src="<c:url value="/resources/csatlatte/images/ico/ico_report.png"/>"> | 신고하기</div></li>
					</ul>
				</div>
				</div>
			</div>
			<div class="modal-body">
				<div class="community-content">글 내용</div>
			</div>
			<div class="modal-footer">
				<div class="community-text">
					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<div class="community-user-info">
						<div class="community-name"><strong>닉네임</strong></div>
						<div class="community-comment-content">내용</div>
						<div class="community-calender">2015-09-20 12:00:12</div>
					</div>
					<div class="dropdown">
						<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="<c:url value="/resources/csatlatte/images/btn/btn_menu.png"/>">
						<ul class="dropdown-menu" aria-labelledby="community-text-menu">
							<li><div class="dropdown-menu-resource">test1</div></li>
							<li><div class="dropdown-menu-resource">test1</div></li>	
							<li><div class="dropdown-menu-resource">test1</div></li>
							<li><div class="dropdown-menu-resource">test1</div></li>
						</ul>
					</div>
				</div>
				<div class="community-comment">
					<img alt="프로필사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
					<input type="text" class="form-control" placeholder="댓글을 입력해주세요.">
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="community-text-delete" role="dialog" aria-labelledby="community-text-delete-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="community-text-delete-label">글 삭제</h4>
			</div>
			<div class="modal-body">
				<p>글을 정말 삭제하시겠어요?</p>
			</div>
			<div class="modal-footer">
				<img class="community-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="community-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="community-text-modify" role="dialog" aria-labelledby="community-text-delete-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="community-text-delete-label">글 수정</h4>
			</div>
			<div class="modal-body community-write-text">
				<textarea rows="5" class="form-control"></textarea>
			</div>
			<div class="modal-footer">
				<img class="community-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="community-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="community-text-report" role="dialog" aria-labelledby="community-text-report-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="community-text-report-label">신고하기</h4>
			</div>
			<div class="modal-body community-report-body">
				<div class="community-report-reason"><input type="radio" name="community-report-reason" value="1"> 불쾌한 내용이 포함되어 있습니다.</div>
				<div class="community-report-reason"><input type="radio" name="community-report-reason" value="2"> 수능라떼에 올바르지 않은 게시물입니다.</div>
				<div class="community-report-reason"><input type="radio" name="community-report-reason" value="3"> 스팸 게시물입니다.</div>
			</div>
			<div class="modal-footer">
				<img class="community-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="community-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>