<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="grade-synopsis">
	<div class="grade-score">
		<h5><strong>등급 평균 : 3등급</strong></h5>
		<h5 class="grade-standardscore"><strong>표준점수 : 98점</strong></h5>
		<img alt="표준점수 뜻" src="<c:url value="/resources/csatlatte/images/btn/btn_help.png"/>" data-toggle="tooltip" data-placement="right" title="표준점수란 과목의 상대적 서열로 계산된 입시에 반영되는 점수입니다.">
	</div>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" id="grade-year" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			2015년 <span class="caret"></span>  
		</button>
		<ul class="dropdown-menu" aria-labelledby="grade-year">
			<li><a href="#">test1</a></li>
			<li><a href="#">test1</a></li>	
			<li><a href="#">test1</a></li>
			<li><a href="#">test1</a></li>
		</ul>
	</div>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" id="grade-exam" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			10월 모의고사 <span class="caret"></span>  
		</button>
		<ul class="dropdown-menu" aria-labelledby="grade-exam">
			<li><a href="#">test2</a></li>
			<li><a href="#">test2</a></li>	
			<li><a href="#">test2</a></li>
			<li><a href="#">test2</a></li>
		</ul>
	</div>
</div>
<div class="grade-transcript">
	<div class="grade-important">
		<h5><strong>주요 과목</strong></h5>
		<table class="table">
			<thead>
				<tr>
					<th width="96px">과목명</th>
					<th width="96px">원점수</th>
					<th width="96px">등급</th>
					<th width="96px">표준점수</th>
					<th width="96px"></th>
					<th width="96px"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>국어A</td>
					<td>89</td>
					<td>3</td>
					<td>98</td>
					<td><img alt="성적수정" data-toggle="modal" data-target="#grade-modify-score" class="grade-btn-modify-score" src="<c:url value="/resources/csatlatte/images/btn/btn_modify.png"/>"></td>
					<td><img alt="성적지우기" data-toggle="modal" data-target="#grade-delete-score" class="grade-btn-delete-score" src="<c:url value="/resources/csatlatte/images/btn/btn_delete.png"/>"></td>
				</tr>
			</tbody>
		</table>
		<img alt="성적추가" data-toggle="modal" data-target="#grade-add-score" class="grade-btn-add-score" src="<c:url value="/resources/csatlatte/images/btn/btn_add.png"/>">
	</div>
	<div class="grade-social">
		<h5><strong>사회탐구</strong></h5>
		<table class="table">
			<thead>
				<tr>
					<th width="96px">과목명</th>
					<th width="96px">원점수</th>
					<th width="96px">등급</th>
					<th width="96px">표준점수</th>
					<th width="96px"></th>
					<th width="96px"></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<img alt="성적추가" data-toggle="modal" data-target="#grade-add-score" class="grade-btn-add-score" src="<c:url value="/resources/csatlatte/images/btn/btn_add.png"/>">
	</div>
	<div class="grade-science">
		<h5><strong>과학탐구</strong></h5>
		<table class="table">
			<thead>
				<tr>
					<th width="96px">과목명</th>
					<th width="96px">원점수</th>
					<th width="96px">등급</th>
					<th width="96px">표준점수</th>
					<th width="96px"></th>
					<th width="96px"></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<img alt="성적추가" data-toggle="modal" data-target="#grade-add-score" class="grade-btn-add-score" src="<c:url value="/resources/csatlatte/images/btn/btn_add.png"/>">
	</div>
	<div class="grade-job">
		<h5><strong>직업탐구</strong></h5>
		<table class="table">
			<thead>
				<tr>
					<th width="96px">과목명</th>
					<th width="96px">원점수</th>
					<th width="96px">등급</th>
					<th width="96px">표준점수</th>
					<th width="96px"></th>
					<th width="96px"></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<img alt="성적추가" data-toggle="modal" data-target="#grade-add-score" class="grade-btn-add-score" src="<c:url value="/resources/csatlatte/images/btn/btn_add.png"/>">
	</div>
	<div class="grade-secondlanguage">
		<h5><strong>제2외국어</strong></h5>
		<table class="table">
			<thead>
				<tr>
					<th width="96px">과목명</th>
					<th width="96px">원점수</th>
					<th width="96px">등급</th>
					<th width="96px">표준점수</th>
					<th width="96px"></th>
					<th width="96px"></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<img alt="성적추가" data-toggle="modal" data-target="#grade-add-score" class="grade-btn-add-score" src="<c:url value="/resources/csatlatte/images/btn/btn_add.png"/>">
	</div>
</div>

<div class="modal fade" id="grade-add-score" role="dialog" aria-labelledby="grade-add-score-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="grade-add-score-label">성적 추가</h4>
			</div>
			<div class="modal-body">
				<h5>과목 선택</h5>
				<div class="grade-select-subject">
					<a>국어A</a> | <a>국어B</a> | <a>수학A</a> | <a>수학B</a> | <a>영어</a>
				</div>
				<h5>성적 입력</h5>
				<div class="grade-insert-score">
					원점수 <input type="text" class="form-control"> <small>원점수는 시험에서 받은 성적을 의미합니다.</small>
				</div>
			</div>
			<div class="modal-footer">
				<img class="grade-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="grade-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="grade-delete-score" role="dialog" aria-labelledby="grade-delete-score-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="grade-delete-score-label">성적 삭제</h4>
			</div>
			<div class="modal-body">
				정말로 이 과목 점수를 삭제하실거에요?
			</div>
			<div class="modal-footer">
				<img class="grade-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="grade-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="grade-modify-score" role="dialog" aria-labelledby="grade-modify-score-label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="grade-modify-score-label">성적 수정</h4>
			</div>
			<div class="modal-body">
				<div class="grade-insert-score">
					원점수 <input type="text" class="form-control"> <small>원점수는 시험에서 받은 성적을 의미합니다.</small>
				</div>
			</div>
			<div class="modal-footer">
				<img class="grade-btn-cancel" data-dismiss="modal" src="<c:url value="/resources/csatlatte/images/btn/btn_cancel.png"/>">
				<img class="grade-btn-accept" src="<c:url value="/resources/csatlatte/images/btn/btn_accept.png"/>">
			</div>
		</div>
	</div>
</div>