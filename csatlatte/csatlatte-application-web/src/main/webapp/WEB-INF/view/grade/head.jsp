<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<%@ include file="/WEB-INF/layout/include/banner/250x250.jsp" %>
<style>
	.table {margin-bottom:0px;}
	.table tr {border-bottom:1px solid #DDDDDD;}
	.table tr td {text-align:center; width:96px;}
	.table tr th {text-align:center;}
	
	.grade-section-add-btn {padding: 10px; height:41px; text-align:right;}
	.grade-synopsis {margin-top:10px;}
	.grade-score-message {color:#d9534f; padding-top:7px;}
	.grade-btn {font-size:14px;}
	.grade-nosection {display:none;}
	.grade-nosection p {color:red;}
	.grade-noexam {display:none;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		
		$(function () {
			$('[data-toggle="tooltip"]').tooltip();
		});
		
		var examList = null;
		var subjectList = null;
		
		var makeExamSelectOption = function(yearStudentSequence) {
			
			var makeOption = function(yearStudentSequence) {
				if (examList != null) {
					var examListLength = examList.length;
					var $gradeExam = $("#grade-exam");
					$gradeExam.find("option").remove();
					for (var index = 0; index < examListLength; index++) {
						var exam = examList[index];
						if (yearStudentSequence == exam.yearStudentSequence) {
							$gradeExam.append("<option value='" + exam.examSequence + "'>" + exam.examName + "</option>");
						}
					}
					$gradeExam.find("option:first").attr("selected", true);
					$gradeExam.trigger("change");
				}
			}
			if (examList == null) {
				$.ajax(contextPath + "/data/exam/" + csatSequence + ".json", {
					success : function(data) {
						examList = data.list;
						makeOption(yearStudentSequence);
					}
				});
			} else {
				makeOption(yearStudentSequence);
			}
		}
		
		var makeSectionTable = function(section) {
			var html = '	<div id="grade-section-' + section.sectionSequence + '" class="grade-section">';
			html += '		<h5><strong>' + section.sectionName + '</strong></h5>';
			html += '		<table class="table">';
			html += '			<thead>';
			html += '				<tr>';
			html += '					<th width="20%">과목명</th>';
			html += '					<th width="20%">원점수</th>';
			html += '					<th width="20%">등급</th>';
			html += '					<th width="20%">표준점수</th>';
			html += '					<th width="10%"></th>';
			html += '					<th width="10%"></th>';
			html += '				</tr>';
			html += '			</thead>';
			html += '			<tbody>';
			html += '			</tbody>';
			html += '		</table>';
			html += '		<div class="grade-section-add-btn"><button class="btn btn-default close" data-toggle="modal" data-target="#grade-add" data-section="' + section.sectionSequence + '" data-select-count="' + section.selectCount + '"><span class="glyphicon glyphicon-plus"></span></button></div>';
			html += '	</div>';
			return html;
		};
		
		var makeGradeTr = function(grade) {
			var html = '				<tr id="grade-section-row-' + grade.sectionSequence + '-' + grade.subjectSequence + '">';
			html += '					<td>' + grade.subjectName + '</td>';
			html += '					<td>' + grade.score + '</td>';
			html += '					<td>' + grade.ratingCode + '</td>';
			html += '					<td>' + grade.standardScore + '</td>';
			html += '					<td><button type="button" class="btn btn-default close grade-btn" data-toggle="modal" data-target="#grade-modify" data-section="' + grade.sectionSequence + '" data-subject="' + grade.subjectSequence + '" data-subject-name="' + grade.subjectName + '" data-score="' + grade.score + '" data-maxscore="' + getMaxScore(grade.sectionSequence, grade.subjectSequence) + '"><span class="glyphicon glyphicon-pencil"></span></button></td>';
			html += '					<td><button type="button" class="btn btn-default close grade-btn" data-toggle="modal" data-target="#grade-delete" data-section="' + grade.sectionSequence + '" data-subject="' + grade.subjectSequence + '" data-subject-name="' + grade.subjectName + '"><span class="glyphicon glyphicon-remove"></span></button></td>';
			html += '				</tr>';
			return html;
		};
		
		var validateScore = function($message, $submit, score, maxScore) {
			var result = false; 
			if (score != null && /^[0-9]+$/.test(score)) {
				if (parseInt(maxScore) >= parseInt(score)) {
					$message.text("");
					$submit.attr("disabled", false);
					result = true;
				} else {
					$message.text("최대 " + maxScore + "점까지 입력 가능합니다.");
					$submit.attr("disabled", true);
				}
			} else if (score == "") {
				$message.text("");
				$submit.attr("disabled", true);
			} else {
				$message.text("원점수는 정수로만 입력이 가능합니다.");
				$submit.attr("disabled", true);
			}
			return result;
		};
		
		var getMaxScore = function(sectionSequence, subjectSequence) {
			var maxScore = 0;
			if (subjectList != null) {
				var subjectListLength = subjectList.length;
				for (var index = 0; index < subjectListLength; index++) {
					var subject = subjectList[index];
					if (subject.sectionSequence == sectionSequence && subject.subjectSequence == subjectSequence) {
						maxScore = subject.maxScore;
						break;
					}
				}
			}
			return maxScore;
		};
		
		$("#grade-yearstudent").on("change", function() {
			makeExamSelectOption($(this).val());
		});
		
		$("#grade-exam").on("change", function() {
			var examSequence = $(this).val();
			if (examSequence == null) {
				$(".grade-nosection").hide();
				$(".grade-transcript").hide();
				$(".grade-noexam").show();
			} else {
				$.ajax(contextPath + "/data/exam/section/" + csatSequence + "/" + examSequence + ".json", {
					success : function(data) {
						$(".grade-transcript .grade-section").remove();
						var sectionList = data.sectionList;
						if (sectionList != null) {
							var sectionListLength = sectionList.length;
							for (var index = 0; index < sectionListLength; index++) {
								$(".grade-transcript").append(makeSectionTable(sectionList[index]));
							}
							$.ajax(contextPath + "/data/exam/subject/" + csatSequence + "/" + examSequence + ".json", {
								success : function(data) {
									subjectList = data.subjectList;
									$.ajax(contextPath + "/data/grade/" + examSequence + ".json", {
										success : function(data) {
											var gradeList = data.list;
											if (gradeList != null) {
												var gradeListLength = gradeList.length;
												if (gradeListLength > 0) {
													var ratingSum = 0;
													var standardScore = 0;
													for (var index = 0; index < gradeListLength; index++) {
														var grade = gradeList[index];
														standardScore += grade.standardScore;
														ratingSum += parseInt(grade.ratingCode);
														$("#grade-section-" + grade.sectionSequence + " tbody").append(makeGradeTr(grade));
													}
													$("#grade-rating").text("등급 평균 : " + Math.round(ratingSum / gradeListLength * 100) / 100 + "등급");
													$("#grade-standardscore").text("표준 점수 : " + standardScore + "점");
													for (var index = 0; index < sectionListLength; index++) {
														if ($("#grade-section-" + sectionList[index].sectionSequence + " tbody tr").size() == $("#grade-section-" + sectionList[index].sectionSequence + " .grade-section-add-btn button").data("select-count")) {
															$("#grade-section-" + sectionList[index].sectionSequence + " .grade-section-add-btn button").hide();
														}
													}
												} else {
													$("#grade-rating").text("등급 평균 : -");
													$("#grade-standardscore").text("표준 점수 : -");
												}
												if (sectionListLength > 0) {
													$(".grade-nosection").hide();
													$(".grade-noexam").hide();
													$(".grade-transcript").show();
												} else {
													$(".grade-transcript").hide();
													$(".grade-noexam").hide();
													$(".grade-nosection").show();
												}
											}
										}
									});
								}
							});
						}
					}
				});
			}
			var addFormAction = $("#grade-add-form").attr("action");
			addFormAction = addFormAction.substring(0, addFormAction.lastIndexOf("/"));
			addFormAction = addFormAction.substring(0, addFormAction.lastIndexOf("/"));
			$("#grade-add-form").attr("action", addFormAction.substring(0, addFormAction.lastIndexOf("/") + 1) + examSequence + "//.json");
			var deleteFormAction = $("#grade-delete-form").attr("action");
			deleteFormAction = deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/"));
			deleteFormAction = deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/"));
			$("#grade-delete-form").attr("action", deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/") + 1) + examSequence + "//.json");
			var modifyFormAction = $("#grade-modify-form").attr("action");
			modifyFormAction = modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/"));
			modifyFormAction = modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/"));
			$("#grade-modify-form").attr("action", modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/") + 1) + examSequence + "//.json");
		});
		
		$("#grade-add").on("show.bs.modal", function(event) {
			var section = $(event.relatedTarget).data("section");
			var $modal = $(this);
			$modal.find("#grade-add-subject").text("");
			$modal.find("#grade-add-subject button").remove();
			if (subjectList != null) {
				var subjectListLength = subjectList.length;
				if (subjectListLength > 0) {
					for (var index = 0; index < subjectListLength; index++) {
						var subject = subjectList[index];
						if (subject.sectionSequence == section) {
							if ($("#grade-section-row-" + subject.sectionSequence + "-" + subject.subjectSequence).size() == 0) {
								$modal.find("#grade-add-subject").append('<button type="button" data-subject="' + subject.subjectSequence + '" data-maxscore="' + subject.maxScore + '" class="btn btn-default">' + subject.subjectName + '</button>');
							}
						}
					}
					$modal.find("#grade-add-subject button").on("click", function() {
						$(this).addClass("active").siblings().removeClass("active");
						var addFormAction = $("#grade-add-form").attr("action");
						$("#grade-add-form").attr("action", addFormAction.substring(0, addFormAction.lastIndexOf("/") + 1) + $(this).data("subject") + ".json");
						$("#grade-add .form-group:not(:first)").slideDown("fast");
					});
				}
			}
			var addFormAction = $("#grade-add-form").attr("action");
			addFormAction = addFormAction.substring(0, addFormAction.lastIndexOf("/"));
			$("#grade-add-form").attr("action", addFormAction.substring(0, addFormAction.lastIndexOf("/") + 1) + section + "/.json");
			$("#grade-add-score").val("");
			$(".grade-add-score-message").text("");
			$("#grade-add .form-group:not(:first)").hide();
		});
		
		$("#grade-add").on("shown.bs.modal", function(event) {
			$("#grade-add-score").focus();
		});
		
		$("#grade-add-score").on("keyup", function(event) {
			validateScore($("#grade-add-score-message"), $("#grade-add-submit"), $(this).val(), $("#grade-add-form #grade-add-subject button.active").data("maxscore"));
		});
		
		$("#grade-add-form").on("submit", function() {
			$.ajax($(this).attr("action"), {
				dataType : "json",
				type : "POST",
				data : {
					score : $("#grade-add-form input[name='score']").val()
				},
				success : function(data) {
					if (data.result) {
						$("#grade-add").modal("hide");
						$("#grade-exam").trigger("change");
					}
				}
			});
			return false;
		});
		
		$("#grade-modify").on("show.bs.modal", function(event) {
			var $button = $(event.relatedTarget);
			$("#grade-modify-subject").text($button.data("subject-name"));
			$("#grade-modify-form input[name='score']").val($button.data("score"));
			$("#grade-modify-form input[name='maxscore']").val($button.data("maxscore"));
			$("#grade-modify-form input[name='sectionSequence']").val($button.data("section"));
			$("#grade-modify-form input[name='subjectSequence']").val($button.data("subject"));
		});
		
		$("#grade-modify-score").on("keyup", function(event) {
			validateScore($("#grade-modify-score-message"), $("#grade-modify-submit"), $(this).val(), $("#grade-modify-form input[name='maxscore']").val());
		});
		
		$("#grade-modify-form").on("submit", function() {
			var modifyFormAction = $("#grade-modify-form").attr("action");
			modifyFormAction = modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/"));
			modifyFormAction = modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/") + 1) + $("#grade-modify-form input[name='sectionSequence']").val() + "/.json";
			$("#grade-modify-form").attr("action", modifyFormAction.substring(0, modifyFormAction.lastIndexOf("/") + 1) + $("#grade-modify-form input[name='subjectSequence']").val() + ".json");
			$.ajax($(this).attr("action"), {
				dataType : "json",
				type : "PUT",
				data : {
					score : $("#grade-modify-form input[name='score']").val()
				},
				success : function(data) {
					if ("data.result") { 
						$("#grade-modify").modal("hide");
						$("#grade-exam").trigger("change");
					}
				}
			});
			return false;
		});
		
		$("#grade-delete").on("show.bs.modal", function(event) {
			var $button = $(event.relatedTarget);
			$("#grade-delete .modal-body").html("정말로 <code>" + $button.data("subject-name") + "</code>을(를) 삭제하시겠습니까?");
			$("#grade-delete-form input[name='sectionSequence']").val($button.data("section"));
			$("#grade-delete-form input[name='subjectSequence']").val($button.data("subject"));
		});
		
		$("#grade-delete-form").on("submit", function() {
			var deleteFormAction = $("#grade-delete-form").attr("action");
			deleteFormAction = deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/"));
			deleteFormAction = deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/") + 1) + $("#grade-delete-form input[name='sectionSequence']").val() + "/.json";
			$("#grade-delete-form").attr("action", deleteFormAction.substring(0, deleteFormAction.lastIndexOf("/") + 1) + $("#grade-delete-form input[name='subjectSequence']").val() + ".json");
			$.ajax($(this).attr("action"), {
				dataType : "json",
				type : "DELETE",
				success : function(data) {
					if (data.result) {
						$("#grade-delete").modal("hide");
						$("#grade-exam").trigger("change");
					}
				}
			});
			return false;
		});
		
		$("#grade-yearstudent").trigger("change");
		
	});
</script>