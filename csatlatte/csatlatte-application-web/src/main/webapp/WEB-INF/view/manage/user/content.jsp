<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h5 class="manage-user-title">회원 관리</h5>
<select class="form-control">
	<option>아이디</option>
	<option>닉네임</option>
</select>
<input type="text" class="form-control" placeholder="검색">
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>접속횟수</th>
			<th>차단</th>
			<th>관리자권한</th>
			<th>활동점수</th>
			<th>성적평균</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><div data-toggle="modal" class="manage-user-id" data-target="#manage-user-id">test</div></td>
			<td>테스트</td>
			<td>7</td>
			<td><input type="checkbox"></td>
			<td><input type="checkbox"></td>
			<td>32</td>
			<td>2</td>
		</tr>
		<tr>
			<td><div data-toggle="modal" class="manage-user-id" data-target="#manage-user-id">test</div></td>
			<td>테스트</td>
			<td>7</td>
			<td><input type="checkbox"></td>
			<td><input type="checkbox"></td>
			<td>32</td>
			<td>2</td>
		</tr>
	</tbody>
</table>
<div class="manage-user-apply-align">
	<input type="submit" class="btn btn-default manage-user-apply" value="적용">
</div>
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
<div class="modal fade" id="manage-user-id" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원정보</h4>
			</div>
			<div class="modal-body">
				<img class="manage-user-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">
				<div class="manage-user-info">
					<div class="manage-user-info-content">
						<label>아이디</label>
						<div class="manage-user-info-content-value">test</div>
					</div>
					<div class="manage-user-info-content">
						<label>가입일</label>
						<div class="manage-user-info-content-value">2013년 12월 21일 08시 22분 16초</div>
					</div>
					<div class="manage-user-info-content">
						<label>최근 접속일</label>
						<div class="manage-user-info-content-value">2015년 3월 7일 12시 37분 03초</div>
					</div>
					<div class="manage-user-info-content">
						<label>활동점수 내역</label>
						<div class="manage-user-info-content-value">게시글 3개, 댓글 15개</div>
					</div>
					<div class="manage-user-info-content">
						<label>성적평균</label>
						<div class="manage-user-info-content-value">3.2등급 / 420점</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>