<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.randomsolving-question-text {margin-bottom:15px;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var imageCount = $(".solving-list-image").length;
	for (var index = 0; index < imageCount; index++) {
		$(".solving-list-image").eq(index).attr("src", contextPath + $(".solving-list-image").eq(index).attr("src"));
	}
	
	$("#randomsolving-question-refresh").on("click", function () {
		location.reload();
	});
});
</script>