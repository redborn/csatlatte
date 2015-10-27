<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.id-fail {height:340px; font-size:13px;}
	#id-fail-btn-group {text-align:right; width:auto;}
	#id-fail-btn-cancel {background:#ffd0c9; text-shadow:none;}
	#id-fail-btn-success {background:#c9e6ff; text-shadow:none;}
	form {display:inline-block;}
	
	.id-step {width:85px; height:40px; display:inline-block; padding-top:12px; border-radius:4px; border:1px solid #7a6253; text-align:center; margin-bottom:10px;}
	.id-step-active {background:#ffe5cc;}

	.progress-bar {width:33%;}
	.progress-final {width:34%; border-left:2px solid white;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
</style>