<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/banner/250x250.jsp" %>
<style>
	#profile-security-return {margin-left:15px; margin-top:5px;}
	.profile-security-button-group {text-align:right; width:auto; margin-top:230px;}
	#profile-security-answer-message-area {padding-top:7px;}
	.profile-security-answer-message-negative {color:#d9534f;}
	.profile-security-answer-message-positive {color:#5cb85c;}
</style>
<script>
	$(document).ready(function () {
		var patternSpace = /\s/g;
		var patternEnglishNumber = /^[A-Za-z0-9+]*$/;
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/; // 8~15자리 영문, 숫자, 특수문자 최소 1개 포함
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		$('#profile-security-btn-success').attr("disabled", true);
		
		var answerNegativeMessage = function () {
			var html = '';
			html += '<div class="profile-security-answer-message-negative">';
			html += '	3~8자 이내 띄어쓰기없이 작성하세요.';
			html += '</div>';
			return html;
		}
		
		var answerPositiveMessage = function () {
			var html = '';
			html += '<div class="profile-security-answer-message-positive">';
			html += '	올바른 답변입니다.';
			html += '</div>';
			return html;
		}
		
		$('#profile-security-answer').on("keyup", function () {
			$('.profile-security-answer-message-negative').remove();
			$('.profile-security-answer-message-positive').remove();
			if ($(this).val().length < 3 || $(this).val().match(patternSpace)) {
				$('#profile-security-answer-message-area').append(answerNegativeMessage());
				$('#profile-security-btn-success').attr("disabled", true);
			} else {
				$('#profile-security-answer-message-area').append(answerPositiveMessage());
				$('#profile-security-btn-success').attr("disabled", false);
			}
		});
	});
</script>