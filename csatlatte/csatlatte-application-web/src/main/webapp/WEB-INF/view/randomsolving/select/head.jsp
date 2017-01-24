<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#randomsolving-select-title {margin-top:0px;}
	.checkbox {display:inline-block; margin-left:10px;}
</style>
<script>
$(document).ready(function () {
	var buttonEnabled = function () {
		if ($(".randomsolving-select-year-student:checked").length > 0 && $(".randomsolving-select-subject:checked").length > 0) {
			$("#randomsolving-select-start").attr("disabled", false);
		} else {
			$("#randomsolving-select-start").attr("disabled", true);
		}
	}
	
	buttonEnabled();
	
	$(".randomsolving-select-year-student").on("click", function () {
		buttonEnabled();
	});
	
	$(".randomsolving-select-subject").on("click", function () {
		buttonEnabled();
	})
});
</script>