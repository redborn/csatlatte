<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#profile-modify-content-image {width:100px; margin-bottom:5px; border:1px solid #7a6253; border-radius:4px;}
	.profile-modify-button-group {text-align:right; width:auto; margin-top:60px;}
	#profile-nickname-check-message-area {padding-top:7px;}
	.profile-nickname-check-message-negative {color:#d9534f;}
	.profile-nickname-check-message-positive {color:#5cb85c;}
	.profile-nickname-check-message-negative {color:#d9534f;}
	.profile-nickname-check-message-positive {color:#5cb85c;}
</style>
<script>
	$(document).ready(function () {
		var patternSpace = /\s/g;
		var patternEnglishNumber = /^[A-Za-z0-9+]*$/;
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/; // 8~15자리 영문, 숫자, 특수문자 최소 1개 포함
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var successNickname = true;
		
		var nicknameNegativeMessage = function () {
			var html = '';
			html += '<div class="profile-nickname-check-message-negative">';
			html += '	3~8자 이내 띄어쓰기없이 작성하세요.';
			html += '</div>';
			return html;
		}
		
		var nicknamePositiveMessage = function () {
			var html = '';
			html += '<div class="profile-nickname-check-message-positive">';
			html += '	올바른 닉네임입니다.';
			html += '</div>';
			return html;
		}
		
		var nicknameNegativeMessageOverlap = function () {
			var html = '';
			html += '<div class="profile-nickname-check-message-negative">';
			html += '	중복된 닉네임입니다.';
			html += '</div>';
			return html;
		}
		
		var nicknamePositiveMessageOverlap = function () {
			var html = '';
			html += '<div class="profile-nickname-check-message-positive">';
			html += '	이 닉네임을 사용하실 수 있습니다.';
			html += '</div>';
			return html;
		}
		
		$('#profile-modify-nickname').on("keyup", function () {
			$('.profile-nickname-check-message-negative').remove();
			$('.profile-nickname-check-message-positive').remove();
			if ($(this).val().length < 3 || $(this).val().match(patternSpace) || $(this).val() === "") {
				$('#profile-nickname-check-message-area').append(nicknameNegativeMessage());
				successNickname = false;
			} else {
				$('#profile-nickname-check-message-area').append(nicknamePositiveMessage());
				successNickname = true;
			}
			$('#profile-modify-btn-success').attr("disabled", true);
		});
		
		$('#profile-modify-nickname').focusout(function () {
			if (successNickname) {
				$('.profile-nickname-check-message-positive').remove();
				$('.profile-nickname-check-message-negative').remove();
				var nickname = $('#profile-modify-nickname').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : nickname, item : 2},
					success : function(data) {
						var beforeNickname = $('#profile-modify-before-nickname').val();
						if (!data.overlapCheckNickname || nickname === beforeNickname) {
							$('#profile-nickname-check-message-area').append(nicknamePositiveMessageOverlap());
						} else {
							$('#profile-nickname-check-message-area').append(nicknameNegativeMessageOverlap());
							successNickname = false;
						}
						
						if (!successNickname) {
							$('#profile-modify-btn-success').attr("disabled", true);
						} else {
							$('#profile-modify-btn-success').attr("disabled", false);
						}
					}
				});
			}
		});
	});
</script>