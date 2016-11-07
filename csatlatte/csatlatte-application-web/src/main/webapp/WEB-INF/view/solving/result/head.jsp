<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.solving-result-title {margin-top:0px;}
	.solving-result-fail {color:red;}
	.solving-result-question {margin-top:20px;}
	.solving-result-wrong-answer {position:absolute; margin-left:-35px; margin-top:-35px;}
	.solving-result-correct-answer {position:absolute; margin-left:-35px; margin-top:-25px;}
	.solving-result-solution {border:1px solid black; padding:10px;}
	.solving-result-reply {margin-top:5px; margin-bottom:5px;}
	.solving-result-reply-select {color:#337ab7;}
	.solving-result-reply-correct-answer {color:#a94442;}
	.solving-result-text {margin-top:30px;}
</style>
<script>
$(document).ready(function() {
	if ($("#solving-result-exam-time").val != undefined) {
		var examTime = $("#solving-result-exam-time").val();
		var resultExamTime = $("#solving-result-result-exam-time").val();
		var costTime = examTime * 60 - resultExamTime;
		$("#solving-result-cost-time").text("소요시간 / 시험시간 : " + (Math.floor(costTime / 60)) + "분 " + (costTime % 60) + "초 / " + examTime + "분");
		$("#solving-result-remain-time").text("잔여시간 : " + (Math.floor(resultExamTime / 60)) + "분 " + (resultExamTime % 60) + "초");
	}
	
	$("a").on("click", function (event) {
		event.stopPropagation();
		event.preventDefault();
		var link = $(this).attr("href");
		$("#solving-result-modal").modal('show');
		$("#solving-result-modal-accept").on("click", function () {
			$(location).attr("href", link);
		});
	});
});
</script>