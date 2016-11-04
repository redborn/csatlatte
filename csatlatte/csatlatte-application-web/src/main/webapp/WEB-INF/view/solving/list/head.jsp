<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#solving-list-exam-time-text {text-align:right;}
.solving-list-question {margin:20px 0;}
.solving-list-question label {font-weight: normal;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var answer = new Array();
	for (var index = 0; index < $("#question-list-size").attr("value"); index++) {
		answer[index] = "";
	}
	$(".answer").on("click", function() {
		answer[$(this).attr("name") - 1] = $(this).attr("value");
	});
	
	if ($("#solving-list-exam-time").val() != undefined) {
		var updateExamTime = function(examTimeSecond) {
			setTimeout(function() {
				if (examTimeSecond > 0) {
					updateExamTime(--examTimeSecond); 
					$("#solving-list-exam-time-text").text("남은 시험 시간 : " + (Math.floor(examTimeSecond / 60)) + "분 " + (examTimeSecond % 60) + "초");
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