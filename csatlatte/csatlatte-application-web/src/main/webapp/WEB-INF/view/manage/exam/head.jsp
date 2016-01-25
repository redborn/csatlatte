<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<style>
	.manage-exam-label {text-align:right; margin-top:6px;}
	#manage-exam-nav {text-align:center;}
	#manage-exam-table {margin-top:15px; text-align:center;}
	.manage-exam-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-exam-info-content-value {margin-left:10px; display:inline-block; margin-top:5px;}
	.manage-exam-info-content-value .form-control {width:auto;}
	.manage-exam-title {display:inline-block; width:380px;}
	.manage-exam-modify {cursor:pointer;}
	.manage-exam-delete {cursor:pointer;}
	.manage-exam-btn-align {text-align:right;}
	.manage-exam-add {width:100px; display:inline-block;}
	.modal-footer {text-align:right;}
	.manage-exam-icon {float:none;}
	.manage-exam-input-group-addon {width:auto;}
</style>
<script>
	$(document).ready(function () {
		
		var target;
		var csatSequence = 24;
		var examSequence;
		var institutionList;
		var yearStudentList;
		var check;
		
		var makeExamRow = function (exam) {
			html = '';
			html += '<tr class="manage-exam-row-data" id="manage-exam-row-data-' + exam.examSequence + '">';
			html += '	<td>' + exam.examSequence + '</td>';
			html += '	<td id="manage-exam-row-td-year-' + exam.examSequence + '"><div id="manage-exam-row-data-year-' + exam.examSequence + '">' + exam.year + '</div></td>';
			html += '	<td id="manage-exam-row-td-name-' + exam.examSequence + '"><div id="manage-exam-row-data-name-' + exam.examSequence + '">' + exam.examName + '</div></td>';
			html += '	<td id="manage-exam-row-td-institution-' + exam.examSequence + '"><div id="manage-exam-row-data-institution-' + exam.examSequence + '">' + exam.institutionName + '</div></td>';
			html += '	<td id="manage-exam-row-td-year-student-' + exam.examSequence + '"><div id="manage-exam-row-data-year-student-' + exam.examSequence + '">' + exam.yearStudentSequence + '</div></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="' + exam.examSequence + '" data-toggle="modal" data-target="#manage-exam-modify-view" class="manage-exam-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-exam-icon"><span id="' + exam.examSequence + '" data-toggle="modal" data-target="#manage-exam-delete-view" class="manage-exam-delete glyphicon glyphicon-remove"></span></button></td>';
			html += '</tr>';
			return html;
		}
		
		var makeExamRowDataYear = function (year) {
			var html = '';
			html += '<div id="manage-exam-row-data-year-' + examSequence + '">' + year + '</div>';
			return html;
		}
		
		var makeExamRowDataName = function (examName) {
			var html = '';
			html += '<div id="manage-exam-row-data-name-' + examSequence + '">' + examName + '</div>';
			return html;
		}
		
		var makeExamRowDataInstitution = function (institutionName) {
			var html = '';
			html += '<div id="manage-exam-row-data-institution-' + examSequence + '">' + institutionName + '</div>';
			return html;
		}
		
		var makeExamRowDataYearStudent = function (yearStudentSequence) {
			var html = '';
			html += '<div id="manage-exam-row-data-year-student-' + examSequence + '">' + yearStudentSequence + '</div>';
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
		
		$.ajax(contextPath + "/data/exam/" + csatSequence + ".json", {
			dataType : "json",
			type : "GET",
			success : function (data) {
				if (data.list != null) {
					var examList = data.list;
					var examListLength = examList.length;
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
								$.ajax(contextPath + "/data/exam.json", {
									dataType : "json",
									type : "POST",
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
													$('#manage-exam-row-data-year-' + examSequence).remove();
													$('#manage-exam-row-data-name-' + examSequence).remove();
													$('#manage-exam-row-data-institution-' + examSequence).remove();
													$('#manage-exam-row-data-year-student-' + examSequence).remove();
													$('#manage-exam-row-td-year-' + examSequence).append(makeExamRowDataYear(ymd.substring(0, 4)));
													$('#manage-exam-row-td-name-' + examSequence).append(makeExamRowDataName(examName));
													$('#manage-exam-row-td-institution-' + examSequence).append(makeExamRowDataInstitution(exam[0].institutionName));
													$('#manage-exam-row-td-year-student-' + examSequence).append(makeExamRowDataYearStudent(yearStudentSequence));
												}
											}
										});
									}
								});
							});
						}
					});
				});
				$('.manage-exam-delete').on("click", function () {
					examSequence = $(this).attr("id");
					$.ajax(contextPath + "/data/exam/average/" + csatSequence + "/" + examSequence + ".json", {
						dataType : "json",
						type : "GET",
						success : function (data1) {
							if (data1.listAverage != null) {
								$.ajax(contextPath + "/data/exam/section/" + csatSequence + "/" + examSequence + ".json", {
									dataType : "json",
									type : "GET",
									success : function (data2) {
										if (data2.listSection != null) {
											$.ajax(contextPath + "/data/exam/subject/" + csatSequence + "/" + examSequence + ".json", {
												dataType : "json",
												type : "GET",
												success : function (data3) {
													if (data3.listSubject != null) {
														if (data1.listAverage.length != 0 || data2.listSection != 0 || data3.listSubject != 0) {
															check = true;
														} else {
															check = false;
														}
														$('.manage-exam-delete-content').remove();
														$('#manage-exam-delete-view-detail').append(makeExamDeleteMessage(check));
														$('.manage-exam-delete-accept').on("click", function () {
															$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
																dataType : "json",
																type : "DELETE",
																data : {_method : "DELETE"},
																success : function () {
																	$('#manage-exam-row-data-' + examSequence).remove();
																	$('#manage-exam-delete-view').modal("hide");
																}
															});
														});
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
									$.ajax(contextPath + "/data/exam.json", {
										dataType : "json",
										type : "POST",
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
														$('#manage-exam-row-data-year-' + examSequence).remove();
														$('#manage-exam-row-data-name-' + examSequence).remove();
														$('#manage-exam-row-data-institution-' + examSequence).remove();
														$('#manage-exam-row-data-year-student-' + examSequence).remove();
														$('#manage-exam-row-td-year-' + examSequence).append(makeExamRowDataYear(ymd.substring(0, 4)));
														$('#manage-exam-row-td-name-' + examSequence).append(makeExamRowDataName(examName));
														$('#manage-exam-row-td-institution-' + examSequence).append(makeExamRowDataInstitution(exam[0].institutionName));
														$('#manage-exam-row-td-year-student-' + examSequence).append(makeExamRowDataYearStudent(yearStudentSequence));
													}
												}
											});
										}
									});
								});
							}
						});
					});
					$('.manage-exam-delete').on("click", function () {
						examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/exam/average/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data1) {
								if (data1.listAverage != null) {
									$.ajax(contextPath + "/data/exam/section/" + csatSequence + "/" + examSequence + ".json", {
										dataType : "json",
										type : "GET",
										success : function (data2) {
											if (data2.listSection != null) {
												$.ajax(contextPath + "/data/exam/subject/" + csatSequence + "/" + examSequence + ".json", {
													dataType : "json",
													type : "GET",
													success : function (data3) {
														if (data3.listSubject != null) {
															if (data1.listAverage.length != 0 || data2.listSection != 0 || data3.listSubject != 0) {
																check = true;
															} else {
																check = false;
															}
															$('.manage-exam-delete-content').remove();
															$('#manage-exam-delete-view-detail').append(makeExamDeleteMessage(check));
															$('.manage-exam-delete-accept').on("click", function () {
																$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
																	dataType : "json",
																	type : "DELETE",
																	data : {_method : "DELETE"},
																	success : function () {
																		$('#manage-exam-row-data-' + examSequence).remove();
																		$('#manage-exam-delete-view').modal("hide");
																	}
																});
															});
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
			html += '			<div class="col-lg-6"><input type="text" maxlength="26" class="form-control" id="manage-exam-modify-name" value="' + exam.examName + '"></div>';
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
			html += '					<input type="text" class="form-control" id="manage-exam-modify-ymd" value="' + exam.ymd + '">';
			html += '					<div class="input-group-addon manage-exam-input-group-addon">';
			html += '						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="modal-footer">';
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
			html += '	<div class="modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			if (!check) {
				html += '<button type="button" class="btn btn-primary manage-exam-delete-accept">확인</button>';
			}
			html += '	</div>';
			html += '</div>';
			return html;
		}
	});
</script>