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
	if ($("#solving-list-listening-file-size").size() != 0) {
		var fileSize = $("#solving-list-listening-file-size").val();
		$("#solving-list-listening-file-size-view").text("파일 크기 : " + Math.round((fileSize / 1048576) * 100) / 100 + " MB (" + fileSize + " byte)");
		$("#solving-list-listening-button").on("click", function() {
			$("#solving-list-listening").get(0).play();
			$(this).attr("disabled", true);
		});
	}
	
	if ($("#solving-list-exam-time").size() != 0) {
		var updateExamTime = function(examTimeSecond) {
			setTimeout(function() {
				if (examTimeSecond > 0) {
					updateExamTime(--examTimeSecond); 
					$("#solving-list-exam-time-text").text("남은 시험 시간 : " + (Math.floor(examTimeSecond / 60)) + "분 " + (examTimeSecond % 60) + "초");
					$("#solving-list-result-exam-second").val(examTimeSecond);
					if (examTimeSecond === 4740 || examTimeSecond === 300 || examTimeSecond === 60) {
						$("#solving-list-exam-time-alert").text("시험 종료까지 " + parseInt((examTimeSecond / 60), 10) + "분 남았습니다.");
						$("#solving-list-exam-time-alert").fadeIn(600);
						setTimeout(function () {
							$("#solving-list-exam-time-alert").fadeOut(600);
						}, 5000);
					}
				} else {
					$("#solving-list-result-exam-second").val(examTimeSecond);
					$("#solving-list-form").submit();
				}
			}, 1000);
		};
		updateExamTime($("#solving-list-exam-time").val() * 60);
	}
});
</script>