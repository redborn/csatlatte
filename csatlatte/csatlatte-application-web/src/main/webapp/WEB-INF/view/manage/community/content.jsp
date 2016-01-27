<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/tld/pagination.tld" %>
<h4 class="manage-community-title">커뮤니티 관리</h4>
<div class="manage-community-search">
	<form method="get" action="<c:url value="/manage/community"/>">
		<div class="col-lg-5 manage-community-col-lg"><input type="text" class="form-control" id="manage-community-search" placeholder="아이디 혹은 닉네임" name="search" value="${param.search}"></div>
	</form>
</div>

<table class="table" id="manage-community-table">
	<thead>
		<tr>
			<th class="col-lg-2 manage-community-col-lg">번호</th>
			<th class="col-lg-2 manage-community-col-lg">아이디</th>
			<th class="col-lg-2 manage-community-col-lg">닉네임</th>
			<th class="col-lg-4 manage-community-col-lg">내용</th>
			<th class="col-lg-2 manage-community-col-lg">블라인드</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="community">
		<input type="hidden" id="manage-community-nickname-${community.communitySequence}" value="${community.nickname}">
		<input type="hidden" id="manage-community-writeYmdhms-${community.communitySequence}" value="${community.writeYmdhms}">
		<input type="hidden" id="manage-community-content-${community.communitySequence}" value="${community.content}">
		<tr>
			<td>${community.communitySequence}</td>
			<td><div id="${community.studentSequence}" data-toggle="modal" data-target="#manage-community-id" class="manage-community-id">${community.studentId}</div></td>
			<td>${community.nickname}</td>
			<td><div id="${community.communitySequence}" data-toggle="modal" data-target="#manage-community-text-detail" class="manage-community-text-detail"><xmp>${community.content}</xmp></div></td>
			<td><div id="blind-${community.communitySequence}">
				<button type="button" class="btn btn-default close manage-community-icon"><span id="${community.communitySequence}" data-toggle="modal" data-target="#manage-community-blind" class="<c:if test="${!community.blind}">glyphicon glyphicon glyphicon-lock manage-community-blind</c:if>"></span></button>
			</div></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav id="manage-community-nav">
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