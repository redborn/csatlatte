<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/banner/250x250.jsp" %>
<style>
	#profile-password-return {margin-left:15px; margin-top:5px;}
	.profile-password-button-group {text-align:right; width:auto; margin-top:140px;}
	#profile-password-message-area {padding-top:7px;}
	#profile-password-check-message-area {padding-top:7px;}
	.profile-password-message-negative {color:#d9534f;}
	.profile-password-message-positive {color:#5cb85c;}
	.profile-password-check-message-negative {color:#d9534f;}
	.profile-password-check-message-positive {color:#5cb85c;}
</style>
<script>
	$(document).ready(function () {
		var patternSpace = /\s/g;
		var patternEnglishNumber = /^[A-Za-z0-9+]*$/;
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/; // 8~15자리 영문, 숫자, 특수문자 최소 1개 포함
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var successBeforePassword = false;
		var successNewPassword = false;
		var successNewPasswordCheck = false;
		
		$('#profile-password-btn-success').attr("disabled", true);
		
		var passwordNegativeMessage = function () {
			var html = '';
			html += '<div class="profile-password-message-negative">';
			html += '	8~15자 이내,영문,숫자,특수문자를 포함';
			html +=	'</div>';
			return html;
		}
		
		var passwordPositiveMessage = function () {
			var html = '';
			html += '<div class="profile-password-message-positive">';
			html += '	올바른 비밀번호입니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckNegativeMessage = function () {
			var html = '';
			html += '<div class="profile-password-check-message-negative">';
			html += '	비밀번호가 일치하지 않습니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckPositiveMessage = function () {
			var html = '';
			html += '<div class="profile-password-check-message-positive">';
			html += '	비밀번호가 일치합니다.';
			html += '</div>';
			return html;
		}
		
		$('#profile-before-password').on("keyup", function() {
			if ($(this).val() != "") {
				successBeforePassword = true;
			} else {
				successBeforePassword = false;
			}
			
			if (successBeforePassword && successNewPassword && successNewPasswordCheck) {
				$('#profile-password-btn-success').attr("disabled", false);
			} else {
				$('#profile-password-btn-success').attr("disabled", true);
			}
		});
		
		$('#profile-password').on("keyup", function() {
			$('.profile-password-message-negative').remove();
			$('.profile-password-message-positive').remove();
			if (!patternEnglishNumberSpecial.test($(this).val()) || patternKorean.test($(this).val())) {
				$('#profile-password-message-area').append(passwordNegativeMessage());
				successNewPassword = false;
			} else {
				$('#profile-password-message-area').append(passwordPositiveMessage());
				successNewPassword = true;
			}
			
			$('.profile-password-check-message-negative').remove();
			$('.profile-password-check-message-positive').remove();
			if ($('#profile-password').val() !== $('#profile-password-check').val() || $('#profile-password').val() === "") {
				$('#profile-password-check-message-area').append(passwordCheckNegativeMessage());
				successNewPasswordCheck = false;
			} else {
				$('#profile-password-check-message-area').append(passwordCheckPositiveMessage());
				successNewPasswordCheck = true;
			}
			
			if (successBeforePassword && successNewPassword && successNewPasswordCheck) {
				$('#profile-password-btn-success').attr("disabled", false);
			} else {
				$('#profile-password-btn-success').attr("disabled", true);
			}
		});
		
		$('#profile-password-check').on("keyup", function() {
			$('.profile-password-check-message-negative').remove();
			$('.profile-password-check-message-positive').remove();
			if ($('#profile-password').val() !== $('#profile-password-check').val() || $('#profile-password').val() === "") {
				$('#profile-password-check-message-area').append(passwordCheckNegativeMessage());
				successNewPasswordCheck = false;
			} else {
				$('#profile-password-check-message-area').append(passwordCheckPositiveMessage());
				successNewPasswordCheck = true;
			}
			
			if (successBeforePassword && successNewPassword && successNewPasswordCheck) {
				$('#profile-password-btn-success').attr("disabled", false);
			} else {
				$('#profile-password-btn-success').attr("disabled", true);
			}
		});
	});
</script>