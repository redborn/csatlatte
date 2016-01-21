<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.password-new-write {font-size:13px; height:290px;}
	.password-new-write-button-group {text-align:right; width:auto;}
	.progress-bar {width:25%;}
	.progress-step {border-left:2px solid white;}
	.progress-bar-warning {background-image:linear-gradient(to bottom,#dddddd 0,#dddddd 100%);}
	#password-new-write-message-area {padding-top:7px;}
	.password-new-write-message-negative {color:#d9534f;}
	.password-new-write-message-positive {color:#5cb85c;}
	#password-new-write-check-message-area {padding-top:7px;}
	.password-new-write-check-message-negative {color:#d9534f;}
	.password-new-write-check-message-positive {color:#5cb85c;}
</style>
<script>
	$(document).ready(function () {
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/; // 8~15자리 영문, 숫자, 특수문자 최소 1개 포함
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var successPasswordCheck = false;
		var successPassword = false;
		
		var passwordNegativeMessage = function () {
			var html = '';
			html += '<div class="password-new-write-message-negative">';
			html += '	8~15자 이내, 영문,숫자,특수문자를 포함';
			html +=	'</div>';
			return html;
		}
		
		var passwordPositiveMessage = function () {
			var html = '';
			html += '<div class="password-new-write-message-positive">';
			html += '	올바른 비밀번호입니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckNegativeMessage = function () {
			var html = '';
			html += '<div class="password-new-write-check-message-negative">';
			html += '	비밀번호가 일치하지 않습니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckPositiveMessage = function () {
			var html = '';
			html += '<div class="password-new-write-check-message-positive">';
			html += '	비밀번호가 일치합니다.';
			html += '</div>';
			return html;
		}
		
		$('#password-new-write-password').on("keyup", function() {
			$('.password-new-write-message-negative').remove();
			$('.password-new-write-message-positive').remove();
			if (!patternEnglishNumberSpecial.test($(this).val()) || patternKorean.test($(this).val())) {
				$('#password-new-write-message-area').append(passwordNegativeMessage());
				successPassword = false;
			} else {
				$('#password-new-write-message-area').append(passwordPositiveMessage());
				successPassword = true;
			}
			
			$('.password-new-write-check-message-negative').remove();
			$('.password-new-write-check-message-positive').remove();
			if ($('#password-new-write-password').val() !== $('#password-new-write-password-check').val()) {
				$('#password-new-write-check-message-area').append(passwordCheckNegativeMessage());
				successPasswordCheck = false;
			} else {
				$('#password-new-write-check-message-area').append(passwordCheckPositiveMessage());
				successPasswordCheck = true;
			}
			
			if (successPassword && successPasswordCheck) {
				$('#password-new-write-btn-success').attr("disabled", false);
			} else {
				$('#password-new-write-btn-success').attr("disabled", true);
			}
		});
		
		$('#password-new-write-password-check').on("keyup", function() {
			$('.password-new-write-check-message-negative').remove();
			$('.password-new-write-check-message-positive').remove();
			if ($('#password-new-write-password').val() !== $('#password-new-write-password-check').val()) {
				$('#password-new-write-check-message-area').append(passwordCheckNegativeMessage());
				successPasswordCheck = false;
			} else {
				$('#password-new-write-check-message-area').append(passwordCheckPositiveMessage());
				successPasswordCheck = true;
			}
			
			if (successPassword && successPasswordCheck) {
				$('#password-new-write-btn-success').attr("disabled", false);
			} else {
				$('#password-new-write-btn-success').attr("disabled", true);
			}
		});
		
		$('#password-new-write-form').on("submit", function () {
			var result = false;
			
			if (successPassword && successPasswordCheck) {
				result = true;
			}
			
			return result;
		});
	});
</script>