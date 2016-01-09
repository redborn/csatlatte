<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-community-title">커뮤니티 관리</h4>
<div class="manage-community-search">
	<div class="col-lg-5"><input type="text" class="form-control" id="manage-community-search" placeholder="아이디 혹은 닉네임"></div>
</div>

<table class="table">
	<thead>
		<tr>
			<th class="col-lg-2">번호</th>
			<th class="col-lg-2">아이디</th>
			<th class="col-lg-2">닉네임</th>
			<th class="col-lg-4">내용</th>
			<th class="col-lg-2">블라인드</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.communitySequence}</td>
			<td><div id="${list.studentSequence}" data-toggle="modal" data-target="#manage-community-id" class="manage-community-id">${list.studentId}</div></td>
			<td>${list.nickname}</td>
			<td><div id="${list.communitySequence}" data-toggle="modal" data-target="#manage-community-text-detail" class="manage-community-text-detail"><xmp>${list.content}</xmp></div></td>
			<td><div id="blind${list.communitySequence}"><div id="${list.communitySequence}" data-toggle="modal" data-target="#manage-community-blind" class="<c:if test="${list.blind eq false}">glyphicon glyphicon glyphicon-lock manage-community-blind</c:if>"></div></div></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav>
	<pagination:writer value="${paginationWriter}"/>
</nav>
<div class="modal fade" id="manage-community-id" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-user-info" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">회원정보</h4>
			</div>
			<div class="modal-body" id="manage-community-student-information">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="manage-community-text-detail" tabindex="-1" role="dialog">
	<div class="modal-dialog" id="manage-community-text-dialog" role="document">
	</div>
</div>
<div class="modal fade" id="manage-community-blind" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-user-info" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">블라인드</h4>
			</div>
			<div class="modal-body">
				<div class="radio">
					<label>
						<input type="radio" name="optionsRadios" value="1">불쾌한 내용이 포함되어 있습니다.
					</label>
				</div>
				<div class="radio">
					<label>
						<input type="radio" name="optionsRadios" value="2">수능라떼에 올바르지 않은 게시물입니다.
					</label>
				</div>
				<div class="radio">
					<label>
						<input type="radio" name="optionsRadios" value="3">스팸 게시물입니다.
					</label>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default manage-community-accept">완료</button>
			</div>
		</div>
	</div>
</div>