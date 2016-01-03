<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
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
					<textarea id="community-write-content" rows="5" class="form-control" placeholder="<session:isManager>관리자님 어떤 정보를 알려줄까요?</session:isManager><session:isStudent>무슨일이 있으셨나요?</session:isStudent><session:isGuest>로그인 후 작성 할 수 있습니다.</session:isGuest>" maxlength="140"<session:isGuest> disabled="disabled"</session:isGuest>></textarea>
				</div>
				<div class="panel-footer community-write-btn">
					<span id="community-write-count">140</span>
					<input id="community-write-submit" type="submit" class="btn btn-default" value="게시" disabled="disabled"/>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="community-report" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<form id="community-report-form" action="<c:url value="/data/community/report/"/>" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">신고하기</h4>
				</div>
				<div class="modal-body">
				<c:forEach items="${reportTypeList}" var="reportType">
					<div class="radio">
						<label>
							<input type="radio" name="reportTypeSequence" value="${reportType.typeSequence}"/>
							${reportType.description}
						</label>
					</div>
				</c:forEach>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="community-comment-report" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<form id="community-comment-report-form" action="<c:url value="/data/community/comment/report/"/>" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">신고하기</h4>
				</div>
				<div class="modal-body">
				<c:forEach items="${reportTypeList}" var="reportType">
					<div class="radio">
						<label>
							<input type="radio" name="reportTypeSequence" value="${reportType.typeSequence}"/>
							${reportType.description}
						</label>
					</div>
				</c:forEach>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<session:isManager>
<div id="community-blind" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<form id="community-blind-form" action="<c:url value="/data/community/blind/"/>" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">블라인드</h4>
				</div>
				<div class="modal-body">
				<c:forEach items="${blindTypeList}" var="blindType">
					<div class="radio">
						<label>
							<input type="radio" name="blindTypeSequence" value="${blindType.typeSequence}"/>
							${blindType.description}
						</label>
					</div>
				</c:forEach>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="community-comment-blind" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<form id="community-comment-blind-form" action="<c:url value="/data/community/comment/blind/"/>" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">블라인드</h4>
				</div>
				<div class="modal-body">
				<c:forEach items="${blindTypeList}" var="blindType">
					<div class="radio">
						<label>
							<input type="radio" name="blindTypeSequence" value="${blindType.typeSequence}"/>
							${blindType.description}
						</label>
					</div>
				</c:forEach>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
</session:isManager>