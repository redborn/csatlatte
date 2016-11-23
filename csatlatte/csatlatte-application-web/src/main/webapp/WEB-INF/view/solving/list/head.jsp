<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#solving-list-exam-time-text {text-align:right;}
.solving-list-question {margin:20px 0;}
.solving-list-question label {font-weight:normal;}
#solving-list-listening-button {background:transparent; border:0; -webkit-appearance:none;}
#solving-list-exam-time-alert {display:none; position:fixed; left:0; width:100%; text-align:center; top:65px; z-index:10;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var answer = new Array();
	for (var index = 0; index < $("#question-list-size").attr("value"); index++) {
		answer[index] = 0;
	}
	$(".answer").on("click", function() {
		answer[$(this).attr("name") - 1] = $(this).attr("value");
	});
	
	if ($("#solving-list-listening-file-size").val() != undefined) {
		var fileSize = $("#solving-list-listening-file-size").val();
		$("#solving-list-listening-file-size-view").text("파일 크기 : " + Math.round((fileSize / 1048576) * 100) / 100 + " MB (" + fileSize + " byte)");
		$("#solving-list-listening-button").on("click", function() {
			$("#solving-list-listening").get(0).play();
			$(this).attr("disabled", true);
		});
	}
	
	if ($("#solving-list-exam-time").val() != undefined) {
		var updateExamTime = function(examTimeSecond) {
			setTimeout(function() {
				if (examTimeSecond > 0) {
					updateExamTime(--examTimeSecond); 
					$("#solving-list-exam-time-text").text("남은 시험 시간 : " + (Math.floor(examTimeSecond / 60)) + "분 " + (examTimeSecond % 60) + "초");
					$("#solving-list-result-exam-time").val(examTimeSecond);
					if (examTimeSecond == 600) {
						$("#solving-list-exam-time-alert").text("시험 종료까지 10분 남았습니다.");
						$("#solving-list-exam-time-alert").fadeIn(600);
						setTimeout(function () {
							$("#solving-list-exam-time-alert").fadeOut(600);
						}, 5000);
					} else if (examTimeSecond == 300) {
						$("#solving-list-exam-time-alert").text("시험 종료까지 5분 남았습니다.");
						$("#solving-list-exam-time-alert").fadeIn(600);
						setTimeout(function () {
							$("#solving-list-exam-time-alert").fadeOut(600);
						}, 5000);
					} else if (examTimeSecond == 60) {
						$("#solving-list-exam-time-alert").text("시험 종료까지 1분 남았습니다.");
						$("#solving-list-exam-time-alert").fadeIn(600);
						setTimeout(function () {
							$("#solving-list-exam-time-alert").fadeOut(600);
						}, 5000);
					}
				} else {
					$("#solving-list-form").submit();
				}
			}, 1000);
		};
		updateExamTime($("#solving-list-exam-time").val() * 60);
	}
	
	$("#submit").on("click", function () {
		$("#question-answer-result").val(answer);
	});
});
</script>