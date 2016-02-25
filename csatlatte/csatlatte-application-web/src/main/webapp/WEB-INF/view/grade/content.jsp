<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="grade-synopsis">
	<div class="row">
		<div class="col-md-4">
			<h5><strong id="grade-rating">등급 평균 : -</strong></h5>
			<h5><strong id="grade-standardscore">표준 점수 : -</strong> <img alt="표준점수 뜻" src="<c:url value="/resources/csatlatte/images/btn/btn_help.png"/>" data-toggle="tooltip" data-placement="bottom" title="표준점수란 과목의 상대적 서열로 계산된 입시에 반영되는 점수입니다."></h5>
		</div>
		<div class="col-md-8" style="text-align:right;">
			<div class="col-sm-3">
				<select id="grade-yearstudent" class="form-control">
				<c:forEach items="${yearStudentList}" var="yearStudent">
					<option value="${yearStudent.yearStudentSequence}">${yearStudent.yearStudentName}</option>
				</c:forEach>
				</select>
			</div>
			<div class="col-sm-9">
				<select id="grade-exam" class="form-control">
				</select>
			</div>
		</div>
	</div>
</div>
<div class="grade-transcript">
</div>
<div class="grade-nosection">
	<h4>이 시험은 성적과 관련된 정보가 부족합니다.</h4>
	<h5>기관에서 자료 공개를 하지 않았거나 성적에 관련된 정보를 정리하는 중 입니다.</h5>
	<p>한국교육평가원에서 주관하는 시험인 경우 해당 기관에서 성적과 관련된 자료를 공개하지 않아 수능라떼에서 성적 관리를 할 수 가 없습니다.</p>
</div>
<div class="modal fade" id="grade-add" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form id="grade-add-form" class="form-horizontal" action="<c:url value="/data/grade///"/>" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">성적 추가</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">과목 선택</label>
						<div class="col-sm-10">
							<div id="grade-add-subject" class="btn-group">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="grade-add-score">성적 입력</label>
						<div class="col-sm-4">
							<input id="grade-add-score" name="score" type="text" class="form-control" placeholder="원점수"/>
						</div>
						<div id="grade-add-score-message" class="col-sm-6 grade-score-message"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10"><small>원점수(원점수는 시험에서 받은 성적을 의미합니다.)</small></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" id="grade-add-submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal fade" id="grade-modify" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form id="grade-modify-form" class="form-horizontal" action="<c:url value="/data/grade///"/>">
				<input name="sectionSequence" type="hidden"/>
				<input name="subjectSequence" type="hidden"/>
				<input name="maxscore" type="hidden"/>
				<input name="_method" value="PUT" type="hidden"/>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">성적 수정</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">과목</label>
						<div id="grade-modify-subject" class="col-sm-10"></div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="grade-modify-score">성적 입력</label>
						<div class="col-sm-4">
							<input id="grade-modify-score" name="score" type="text" class="form-control" placeholder="원점수"/>
						</div>
						<div id="grade-modify-score-message" class="col-sm-6 grade-score-message"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10"><small>원점수(원점수는 시험에서 받은 성적을 의미합니다.)</small></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" id="grade-modify-submit" class="btn btn-primary" disabled="disabled">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="modal fade" id="grade-delete" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form id="grade-delete-form" action="<c:url value="/data/grade///"/>">
				<input name="sectionSequence" type="hidden"/>
				<input name="subjectSequence" type="hidden"/>
				<input name="_method" value="DELETE" type="hidden"/>
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<h4 class="modal-title">성적 삭제</h4>
				</div>
				<div class="modal-body">
					정말로 이 과목 점수를 삭제하실거에요?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary">확인</button>
				</div>
			</form>
		</div>
	</div>
</div>