<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<style>
	.grade-message {margin-bottom:20px;}
	.grade-menu {text-align:left; width:60px;}
	.grade-menu-title {font-size:13px; width:60px; text-align:center; margin-top:3px; display:inline-block;}
	.grade-menu img {display:block;}
	.grade-synopsis {margin-top:10px;}
	.grade-synopsis .grade-score {display:inline-block; width:400px;}
	.grade-synopsis .grade-score .grade-standardscore {display:inline-block;}
	.grade-synopsis .dropdown {display:inline-block; vertical-align:top; margin-top:5px;}
	.table {font-size:13px; width:576px; margin-left:20px; margin-bottom:0px;}
	.table tr {border-bottom:1px solid #DDDDDD;}
	.table tr td {text-align:center; width:96px;}
	.table tr th {text-align:center;}
	.grade-transcript {text-align:right;}
	.grade-transcript h5 {text-align:left;}
	.grade-btn-add-score {cursor:pointer; margin-top:5px; margin-bottom:15px;}
	.grade-btn-delete-score {cursor:pointer;}
	.grade-btn-modify-score {cursor:pointer;}
	.grade-btn-cancel {cursor:pointer; margin-right:10px;}
	.grade-btn-accept {cursor:pointer;}
	.grade-select-subject {font-size:13px; margin-top:5px; margin-left:10px; margin-bottom:15px;}
	.grade-insert-score {font-size:14px; margin-top:5px; margin-left:10px;}
	.grade-insert-score .form-control {float:none; width:100px; height:25px;}
	.modal-body {font-size:13px;}
</style>
<script>
	$(document).ready(function () {
		
		$(function () {
			$('[data-toggle="tooltip"]').tooltip();
		});
		
		var examList = null;
		
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
		
		$("#grade-yearstudent").on("change", function() {
			makeExamSelectOption($(this).val());
		});
		
		$("#grade-exam").on("change", function() {
			/*
			$.ajax(contextPath + "/data/grade/" + $(this).val() + ".json", function(data) {
				
			});
			*/
		});
		
	});
</script>