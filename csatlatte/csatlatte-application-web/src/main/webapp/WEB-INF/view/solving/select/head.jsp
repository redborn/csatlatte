<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.panel-body button {margin-right:10px;}
#solving-select-year, #solving-select-exam, #solving-select-subject {display:none;}
.solving-select-active {background:#e8e4e1;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	
	var makeYear = function (year) {
		return '<button type="button" class="solving-select-year-resource btn btn-default" data-loading-text="Loading..." id="solving-select-year-resource-' + year + '">' + year + '</button>';
	}
	
	var makeExam = function (exam) {
		return '<button type="button" class="solving-select-exam-resource btn btn-default" data-loading-text="Loading..." id="solving-select-exam-resource-' + exam.csatSequence + '-' + exam.examSequence + '">' + exam.examName + '</button>';
	}
	
	var makeSubject = function(subject) {
		return '<button type="button" class="solving-select-subject-resource btn btn-default" data-loading-text="Loading..." id="solving-select-subject-resource-' + subject.csatSequence + '-' + subject.examSequence + '-' + subject.sectionSequence + '-' + subject.subjectSequence + '">' + subject.subjectName + '</button>';;
	}
	
	$('.solving-select-yearstudent-resource').on("click", function (e) {
		$('.solving-select-year-resource, .solving-select-exam-resource, .solving-select-subject-resource').remove();
		$("#solving-select-submit").attr("disabled", true);
		var yearStudentSequence = $(this).attr("id").substring(36);
		var $btnYearStudent = $(this).button('loading');
		$(this).addClass("solving-select-active").siblings().removeClass("solving-select-active");
		$('#solving-select-year, #solving-select-exam, #solving-select-subject').slideUp("fast");
		$.ajax(contextPath + "/data/solving/year/" + yearStudentSequence + ".json", {
			dataType : "json",
			type : "GET",
			success : function (data) {
				if (data.list != null) {
					var yearList = data.list;
					var yearListLength = yearList.length;
					for (var index = 0; index < yearListLength; index++) {
						$('#solving-select-year-list').append(makeYear(yearList[index]));
					}
					$('.solving-select-yearstudent-resource').attr("disabled", false);
					setTimeout(function () {
						$btnYearStudent.button('reset');
						setTimeout(function () {
							$('.solving-select-active').attr("disabled", true);
						}, 1);
					}, 200);
					$('#solving-select-year').slideDown("fast");
					$('.solving-select-year-resource').on("click", function () {
						$(this).addClass("solving-select-active").siblings().removeClass("solving-select-active");
						$('.solving-select-exam-resource, .solving-select-subject-resource').remove();
						$("#solving-select-submit").attr("disabled", true);
						var year = $(this).attr("id").substring(29);
						var $btnYear = $(this).button('loading');
						$('#solving-select-exam, #solving-select-subject').slideUp("fast");
						$.ajax(contextPath + "/data/solving/exam/" + yearStudentSequence + "/" + year + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data) {
								if (data.list != null) {
									var examList = data.list;
									var examListLength = examList.length;
									for (var index = 0; index < examListLength; index++) {
										$('#solving-select-exam-list').append(makeExam(examList[index]));
									}
									$('.solving-select-year-resource').attr("disabled", false);
									setTimeout(function () {
										$btnYear.button('reset');
										setTimeout(function () {
											$('.solving-select-active').attr("disabled", true);
										}, 1);
									}, 200);
									$("#solving-select-exam").slideDown("fast");
									$(".solving-select-exam-resource").on("click", function() {
										$(this).addClass("solving-select-active").siblings().removeClass("solving-select-active");
										$("#solving-select-submit").attr("disabled", true);
										$('.solving-select-subject-resource').remove();
										var id = $(this).attr("id");
										var $btnExam = $(this).button("loading");
										$('#solving-select-subject').slideUp("fast");
										$.ajax(contextPath + "/data/solving/subject/" + id.substring(29, id.lastIndexOf("-")) + "/" + id.substring(id.lastIndexOf("-") + 1) + ".json", {
											dataType : "json",
											type : "GET",
											success : function(data) {
												if (data.list != null) {
													var subjectList = data.list;
													var subjectListLength = subjectList.length;
													for (var index  = 0; index < subjectListLength; index++) {
														$("#solving-select-subject-list").append(makeSubject(subjectList[index]));
													}
												}
												$(".solving-select-exam-resource").attr("disabled", false);
												setTimeout(function() {
													$btnExam.button("reset");
													setTimeout(function() {
														$('.solving-select-active').attr("disabled", true);
													}, 1);
												}, 200);
												$("#solving-select-subject").slideDown("fast");
												$(".solving-select-subject-resource").on("click", function() {
													var id = $(this).attr("id");
													id = id.substring(32);
													var csatSequence = id.substring(0, id.indexOf("-"));
													id = id.substring(csatSequence.length + 1);
													var examSequence = id.substring(0, id.indexOf("-"));
													id = id.substring(examSequence.length + 1);
													var sectionSequence = id.substring(0, id.indexOf("-"));
													var subjectSequence = id.substring(sectionSequence.length + 1);
													var action = $("#solving-select-form").attr("action");
													$("#solving-select-form").attr("action", action.substring(0, action.lastIndexOf("solving") + 7) + "/" + csatSequence + "/" + examSequence + "/" + sectionSequence + "/" + subjectSequence);
													$(this).addClass("solving-select-active").siblings().removeClass("solving-select-active");
													$(".solving-select-subject-resource").attr("disabled", false);
													$(".solving-select-active").attr("disabled", true);
													$("#solving-select-submit").attr("disabled", false);
												});
											}
										});
									});
								}
							}
						});
					});
				}
			}
		});
	});
});
</script>