<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/form.jsp" %>
<style>
	.grade-message {margin-bottom:20px;}
	.grade-menu {text-align:left; width:60px;}
	.grade-menu-title {font-size:13px; width:60px; text-align:center; margin-top:3px; display:inline-block;}
	.grade-menu img {display:block;}
	.grade-synopsis {margin-top:10px;}
	.table {font-size:13px; width:576px; margin-left:20px; margin-bottom:0px;}
	.table tr {border-bottom:1px solid #DDDDDD;}
	.table tr td {text-align:center; width:96px;}
	.table tr th {text-align:center;}
	.grade-transcript {text-align:right;}
	.grade-transcript h5 {text-align:left;}
	.grade-btn-add-score {cursor:pointer; margin-top:5px; margin-bottom:15px;}
	.grade-btn-delete-score {cursor:pointer;}
	.grade-btn-modify-score {cursor:pointer;}
	.grade-select-subject {font-size:13px; margin-top:5px; margin-left:10px; margin-bottom:15px;}
	.grade-insert-score {font-size:14px; margin-top:5px; margin-left:10px;}
	.grade-insert-score .form-control {float:none; width:100px; height:25px;}
	.modal-body {font-size:13px;}
	
	.grade-add-score-message {color:#d9534f; padding-top:7px;}
</style>
<script>
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
			html += '					<th width="96px">과목명</th>';
			html += '					<th width="96px">원점수</th>';
			html += '					<th width="96px">등급</th>';
			html += '					<th width="96px">표준점수</th>';
			html += '					<th width="96px"></th>';
			html += '					<th width="96px"></th>';
			html += '				</tr>';
			html += '			</thead>';
			html += '			<tbody>';
			html += '			</tbody>';
			html += '		</table>';
			html += '		<img alt="성적추가" data-toggle="modal" data-target="#grade-add" data-section="' + section.sectionSequence + '" class="grade-btn-add-score" src="' + contextPath + '/resources/csatlatte/images/btn/btn_add.png"/>';
			html += '	</div>';
			return html;
		};
		
		$("#grade-yearstudent").on("change", function() {
			makeExamSelectOption($(this).val());
		});
		
		$("#grade-exam").on("change", function() {
			var examSequence = $(this).val();
			$.ajax(contextPath + "/data/section/" + csatSequence + "/" + examSequence + ".json", {
				success : function(data) {
					$(".grade-transcript .grade-section").remove();
					var sectionList = data.list;
					if (sectionList != null) {
						var sectionListLength = sectionList.length;
						for (var index = 0; index < sectionListLength; index++) {
							$(".grade-transcript").append(makeSectionTable(sectionList[index]));
						}
						$.ajax(contextPath + "/data/subject/" + csatSequence + "/" + examSequence + ".json", {
							success : function(data) {
								subjectList = data.list;
								$.ajax(contextPath + "/data/grade/" + examSequence + ".json", {
									success : function(data) {
										// 내 성적 뿌리기..
										console.log(data);
									}
								});
							}
						});
					}
				}
			});
			var action = $("#grade-add-form").attr("action");
			$("#grade-add-form").attr("action", action.substring(0, action.lastIndexOf("/") + 1) + examSequence + ".json");
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
							$modal.find("#grade-add-subject").append('<button type="button" data-subject="' + subject.subjectSequence + '" data-maxscore="' + subject.maxScore + '" class="btn btn-default">' + subject.subjectName + '</button>');
						}
					}
					$modal.find("#grade-add-subject button").on("click", function() {
						$(this).addClass("active").siblings().removeClass("active");
						$("#grade-add-form input[name='subjectSequence']").val($(this).data("subject"));
						$("#grade-add .form-group:not(:first)").slideDown("fast");
					});
				}
			}
			$("#grade-add-form input[name='sectionSequence']").val(section);
			$("#grade-add-score").val("");
			$(".grade-add-score-message").text("");
			$("#grade-add .form-group:not(:first)").hide();
		});
		
		$("#grade-add").on("shown.bs.modal", function(event) {
			$("#grade-add-score").focus();
		});
		
		$("#grade-add-score").on("keyup", function(event) {
			var score = $(this).val();
			if (score != null && /^[0-9]+$/.test(score)) {
				var maxScore = $("#grade-add-form #grade-add-subject button.active").data("maxscore");
				if (maxScore >= score) {
					$(".grade-add-score-message").text("");
					$("#grade-add-submit").attr("disabled", false);
				} else {
					$(".grade-add-score-message").text("최대 " + maxScore + "점까지 입력 가능합니다.");
					$("#grade-add-submit").attr("disabled", true);
				}
			} else if (score == "") {
				$(".grade-add-score-message").text("");
				$("#grade-add-submit").attr("disabled", true);
			} else {
				$(".grade-add-score-message").text("원점수는 정수로만 입력이 가능합니다.");
				$("#grade-add-submit").attr("disabled", true);
			}
		});
		
		$("#grade-add-form").ajaxForm({
			dataType : "json",
			success : function(data) {
				if (data.result) {
					$("#grade-add").modal("hide");
				}
			}
		});
		
		$("#grade-yearstudent").trigger("change");
		
	});
</script>