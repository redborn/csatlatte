<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<h4 class="manage-question-title">문의 관리</h4>
<div class="row">
	<div class="col-lg-7">
		<div class="manage-question-yn">
			<h5>답변여부</h5>
			<div class="btn-group">
				<button class="btn btn-default">전체</button>
				<button class="btn btn-default">대기</button>
				<button class="btn btn-default">완료</button>
			</div>
		</div>
	</div>
		<div class="col-lg-5">
		<div class="manage-community-search">
			<div class="col-lg-12"><input type="text" class="form-control" placeholder="아이디 혹은 닉네임"></div>
		</div>
	</div>
</div>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>제목</th>
			<th>문의날짜</th>
			<th>완료여부</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>test</td>
			<td>테스트</td>
			<td><div class="manage-question-content" data-toggle="modal" data-target="#manage-question-answer-view">이것은 내용입니다.</div></td>
			<td>2015-03-22</td>
			<td>O</td>
		</tr>
		<tr>
			<td>test</td>
			<td>테스트</td>
			<td><div class="manage-question-content" data-toggle="modal" data-target="#manage-question-answer">이것은 내용입니다.</div></td>
			<td>2015-03-22</td>
			<td>X</td>
		</tr>
	</tbody>
</table>
<nav>
	<ul class="pagination">
		<li>
			<a href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li>
			<a href="#" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
</nav>
<div class="modal fade" id="manage-question-answer-view" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				답변하기
			</div>
			<div class="modal-body">
				<div class="manage-question-qna-title">
					<h5>문의제목</h5>
					<div class="manage-question-qna-title-content">이것은 내용입니다.</div>
				</div>
				<div class="manage-question-qna-content">
					문의내용은 이렇습니다.
				</div>
				<div class="manage-question-qna-answer">
					<h5>답변내용</h5>
				</div>
				<div class="manage-question-qna-answer-content">
					답변내용은 이렇습니다.
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-question-answer" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				답변하기
			</div>
			<div class="modal-body">
				<div class="manage-question-qna-title">
					<h5>문의제목</h5>
					<div class="manage-question-qna-title-content">이것은 내용입니다.</div>
				</div>
				<div class="manage-question-qna-content">
					문의내용은 이렇습니다.
				</div>
				<div class="manage-question-qna-answer">
					<h5>답변내용</h5>
					<textarea rows="5" class="form-control" placeholder="여기에 답변 내용을 입력해주세요."></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<img class="manage-question-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="manage-question-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>