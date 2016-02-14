<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.manage-exam-label {text-align:right; margin-top:6px;}
	#manage-exam-nav {text-align:center;}
	#manage-exam-table {margin-top:15px; text-align:center;}
	.manage-exam-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-exam-title {display:inline-block; width:380px;}
	.manage-exam-modify {cursor:pointer;}
	.manage-exam-delete {cursor:pointer;}
	.manage-exam-btn-align {text-align:right;}
	.manage-exam-add {width:100px; display:inline-block;}
	.manage-exam-modal-footer {text-align:right;}
	.manage-exam-icon {float:none;}
	.manage-exam-input-group-addon {width:auto;}
</style>
<script>
	$(document).ready(function () {
		
		var target;
		var csatSequence = $('#manage-exam-csat-list').val();
		var examSequence;
		var institutionList;
		var yearStudentList;
		var check;
		
		var makeExamRow = function (exam) {
			html = '';
			html += '<tr class="manage-exam-row-data" id="manage-exam-row-data-' + exam.examSequence + '">';
			html += '	<td>' + exam.examSequence + '</td>';
			html += '	<td>' + exam.year + '</td>';
			html += '	<td>' + exam.examName + '</td>';
			html += '	<td>' + exam.institutionName + '</td>';
			html += '	<td>' + exam.yearStudentSequence + '</td>';
			html += '	<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="' + exam.examSequence + '" data-toggle="modal" data-target="#manage-exam-modify-view" class="manage-exam-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="' + exam.examSequence + '" data-toggle="modal" data-target="#manage-exam-delete-view" class="manage-exam-delete glyphicon glyphicon-remove"></span></button></td>';
			html += '</tr>';
			return html;
		}
		
		$.ajax(contextPath + "/data/institution.json", {
			dataType : "json",
			type : "GET",
			success : function (data) {
				if (data.institutionList != null) {
					institutionList = data.institutionList;
				}
			}
		});
		
		$.ajax(contextPath + "/data/yearstudent.json", {
			dataType : "json",
			type : "GET",
			success : function (data) {
				if (data.yearStudentList != null) {
					yearStudentList = data.yearStudentList;
				}
			}
		});
		
		$('#manage-exam-csat-list').on("change", function () {
			csatSequence = $('#manage-exam-csat-list').val();
			$.ajax(contextPath + "/data/exam/" + csatSequence + ".json", {
				dataType : "json",
				type : "GET",
				success : function (data) {
					if (data.list != null) {
						var examList = data.list;
						var examListLength = examList.length;
						$('.manage-exam-row-data').remove();
						for (var index = 0; index < examListLength; index++) {
							$('.manage-exam-row').append(makeExamRow(examList[index]));
						}
					}
					$('.manage-exam-modify').on("click", function () {
						examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data) {
								if (data.detail != null) {
									var exam = data.detail;
									$('#manage-exam-modify-view-detail').append(makeExamRowDetail(exam[0], institutionList, yearStudentList));
								}
								$('#manage-exam-modify-ymd').datepicker({
									format:"yyyymmdd",
									startView:0,
									minViewMode:0,
									language:"kr",
									autoclose:true,
									todayHighlight:true,
									setDate:new Date()
								});
								$('.manage-exam-modify-accept').on("click", function () {
									var examName = $('#manage-exam-modify-name').val();
									var institutionSequence = $('#manage-exam-modify-institution').val();
									var yearStudentSequence = $('#manage-exam-modify-year-student').val();
									var ymd = $('#manage-exam-modify-ymd').val();
									if (examName === "") {
										$('#manage-exam-modify-name').tooltip("show");
										setTimeout(function () {
											$('#manage-exam-modify-name').tooltip("destroy");
										}, 1200);
									}
									
									if (ymd === "") {
										$('#manage-exam-modify-ymd').tooltip("show");
										setTimeout(function () {
											$('#manage-exam-modify-ymd').tooltip("destroy");
										}, 1200);
									}
									if (examName !== "" && institutionSequence !== "" && yearStudentSequence !== "" && ymd !== "") {
										$.ajax(contextPath + "/data/exam.json", {
											dataType : "json",
											type : "PUT",
											data : {csatSequence : csatSequence,
													examSequence : examSequence,
													examName : examName,
													institutionSequence : institutionSequence,
													yearStudentSequence : yearStudentSequence,
													ymd : ymd},
											success : function () {
												$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
													dataType : "json",
													type : "GET",
													success : function (data) {
														if (data.detail != null) {
															var exam = data.detail;
															$('#manage-exam-modify-view').modal("hide");
															$('#manage-exam-csat-list').trigger("change");
														}
													}
												});
											}
										});
									}
								});
							}
						});
					});
					$('.manage-exam-delete').on("click", function () {
						$('.manage-exam-delete-content').remove();
						examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/exam/average/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data1) {
								if (data1.averageList != null) {
									$.ajax(contextPath + "/data/exam/section/" + csatSequence + "/" + examSequence + ".json", {
										dataType : "json",
										type : "GET",
										success : function (data2) {
											if (data2.sectionList != null) {
												$.ajax(contextPath + "/data/exam/subject/" + csatSequence + "/" + examSequence + ".json", {
													dataType : "json",
													type : "GET",
													success : function (data3) {
														if (data3.subjectList != null) {
															if (data1.averageList.length != 0 || data2.sectionList != 0 || data3.subjectList != 0) {
																check = true;
															} else {
																check = false;
															}
															makeExamDeleteMessage(check);
														} 
													}
												});
											}
										}
									});
								}
							}
						});
					});
				}
			});
		});
		
		$('#manage-exam-csat-list').trigger("change");
		
		$('.manage-exam-add').on("click", function () {
			$('.manage-exam-register-content').remove();
			$('#manage-exam-register-view-detail').append(makeExamRegister(institutionList, yearStudentList));
			$('#manage-exam-register-ymd').datepicker({
				format:"yyyymmdd",
				startView:0,
				minViewMode:0,
				language:"kr",
				autoclose:true,
				todayHighlight:true,
				setDate:new Date()
			});
			$('.manage-exam-register-accept').on("click", function () {
				var examName = $('#manage-exam-register-name').val();
				var institutionSequence = $('#manage-exam-register-institution').val();
				var yearStudentSequence = $('#manage-exam-register-year-student').val();
				var ymd = $('#manage-exam-register-ymd').val();
				if (examName === "") {
					$('#manage-exam-register-name').tooltip("show");
					setTimeout(function () {
						$('#manage-exam-register-name').tooltip("destroy");
					}, 1200);
				}
				
				if (ymd === "") {
					$('#manage-exam-register-ymd').tooltip("show");
					setTimeout(function () {
						$('#manage-exam-register-ymd').tooltip("destroy");
					}, 1200);
				}
				if (examName !== "" && institutionSequence !== "" && yearStudentSequence !== "" && ymd !== "") {
					$.ajax(contextPath + "/data/exam.json", {
						dataType : "json",
						type : "POST",
						data : {csatSequence : csatSequence,
								examName : examName,
								institutionSequence : institutionSequence,
								yearStudentSequence : yearStudentSequence,
								ymd : ymd},
						success : function (data) {
							if (data.examSequence != null) {
								var examSequence = data.examSequence;
								$('#manage-exam-register-view').modal("hide");
								$('#manage-exam-csat-list').trigger("change");
							}
						}
					});
				}
			});
			
		});
		
		var makeExamRegister = function (institutionList, yearStudentList) {
			var institutionListLength = institutionList.length;
			var yearStudentListLength = yearStudentList.length;
			var html = '';
			html += '<div class="modal-content manage-exam-register-content">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">모의고사 추가</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-register-name">모의고사 이름</label>';
			html += '			<div class="col-lg-6"><input type="text" maxlength="26" class="form-control" id="manage-exam-register-name" data-toggle="tooltip" data-placement="bottom" title="잘못된 모의고사 이름입니다."></div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-register-institution">주관 교육청</label>';
			html += '			<div class="col-lg-4">';
			html += '				<select class="form-control" id="manage-exam-register-institution">';
			for (var index = 0; index < institutionListLength; index++) {
				html += '<option value="' + institutionList[index].institutionSequence + '">' + institutionList[index].institutionName + '</option>';
			}
			html += '				</select>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-register-year-student">학년</label>';
			html += '			<div class="col-lg-2">';
			html += '				<select class="form-control" id="manage-exam-register-year-student">';
			for (var index = 0; index < yearStudentListLength; index++) {
				html += '<option value="' + yearStudentList[index].yearStudentSequence + '">' + yearStudentList[index].yearStudentName + '</option>';
			}
			html += '				</select>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-register-date">시험일자</label>';
			html += '			<div class="col-lg-5">';
			html += '				<div class="input-group">';
			html += '					<input type="text" class="form-control" id="manage-exam-register-ymd" data-toggle="tooltip" data-placement="bottom" title="잘못된 날짜입니다.">';
			html += '					<div class="input-group-addon manage-exam-input-group-addon">';
			html += '						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="modal-footer manage-exam-modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary manage-exam-register-accept">확인</button>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeExamRowDetail = function (exam, institutionList, yearStudentList) {
			var institutionListLength = institutionList.length;
			var yearStudentListLength = yearStudentList.length;
			var html = '';
			html += '<div class="modal-content manage-exam-modify-content">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">모의고사 수정</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-modify-name">모의고사 이름</label>';
			html += '			<div class="col-lg-6"><input type="text" maxlength="26" class="form-control" id="manage-exam-modify-name" value="' + exam.examName + '" data-toggle="tooltip" data-placement="bottom" title="잘못된 모의고사 이름입니다."></div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-modify-institution">주관 교육청</label>';
			html += '			<div class="col-lg-4">';
			html += '				<select class="form-control" id="manage-exam-modify-institution">';
			for (var index = 0; index < institutionListLength; index++) {
				html += '<option value="' + institutionList[index].institutionSequence + '"';
				if (exam.institutionSequence == institutionList[index].institutionSequence) {
					html += ' selected';
				}
				html += '>' + institutionList[index].institutionName + '</option>';
			}
			html += '				</select>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-modify-year-student">학년</label>';
			html += '			<div class="col-lg-2">';
			html += '				<select class="form-control" id="manage-exam-modify-year-student">';
			for (var index = 0; index < yearStudentListLength; index++) {
				html += '<option value="' + yearStudentList[index].yearStudentSequence + '"';
				if (exam.yearStudentSequence == yearStudentList[index].yearStudentSequence) {
					html += ' selected';
				}
				html += '>' + yearStudentList[index].yearStudentName + '</option>';
			}
			html += '				</select>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-exam-label" for="manage-exam-modify-date">시험일자</label>';
			html += '			<div class="col-lg-5">';
			html += '				<div class="input-group">';
			html += '					<input type="text" class="form-control" id="manage-exam-modify-ymd" value="' + exam.ymd + '" data-toggle="tooltip" data-placement="bottom" title="잘못된 날짜입니다.">';
			html += '					<div class="input-group-addon manage-exam-input-group-addon">';
			html += '						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="modal-footer manage-exam-modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary manage-exam-modify-accept">확인</button>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		$('#manage-exam-modify-view').on('hidden.bs.modal', function () {
			$('.manage-exam-modify-content').remove();
		});
		
		var makeExamDeleteMessage = function (check) {
			var html = '';
			html += '<div class="modal-content manage-exam-delete-content">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">모의고사 삭제</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			if (check) {
				html += '<p>해당 모의고사는 등급컷 정보가 등록되어 있습니다.</p>';
				html += '<p>우선 등급컷 정보를 삭제 후 진행할 수 있습니다.</p>';
			} else {
				html += '이 모의고사를 정말로 삭제하시겠습니까?';
			}
			html += '	</div>';
			html += '	<div class="modal-footer manage-exam-modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			if (!check) {
				html += '<button type="button" class="btn btn-primary manage-exam-delete-accept">확인</button>';
			}
			html += '	</div>';
			html += '</div>';
			$('#manage-exam-delete-view-detail').append(html);
			$('.manage-exam-delete-accept').on("click", function () {
				$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
					dataType : "json",
					type : "DELETE",
					data : {_method : "DELETE"},
					success : function () {
						$('#manage-exam-delete-view').modal("hide");
						$('#manage-exam-csat-list').trigger("change");
					}
				});
			});
		}
	});
</script>