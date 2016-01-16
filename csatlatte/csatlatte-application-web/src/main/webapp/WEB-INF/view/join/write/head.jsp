<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	label {margin-right:10px; width:13%; text-align:right;}
	.join {font-size:13px;}
	.join-content {margin-left:30px;}
	.join-message {margin-left:70px; margin-top:5px;}
	.form-control {display:inline-block; float:none; width:220px; height:25px; margin-top:10px;}
	.join-security {margin-top:30px;}
	.join-info {margin-top:30px;}
	.join-content img {width:100px; border:1px solid #7a6253; border-radius:4px; margin-bottom:10px;}
	.join-button-group {text-align:right; width:auto; margin-top:20px;}
	.join-button-group #join-btn-cancel {background:#ffd0c9; text-shadow:none;}
	.join-button-group #join-btn-success {background:#c9e6ff; text-shadow:none;}
	#join-password-check-message-area {display:inline-block; margin-left:10px;}
	.join-password-check-message-negative {color:#d9534f;}
	.join-password-check-message-positive {color:#5cb85c;}
	.join-id-check-message-negative {color:#d9534f;}
	.join-id-check-message-positive {color:#5cb85c;}
	#join-id-check-message-area {display:inline-block; margin-left:10px;}
	#join-answer-check-message-area {display:inline-block; margin-left:10px;}
	.join-answer-check-message-negative {color:#d9534f;}
	.join-answer-check-message-positive {color:#5cb85c;}
	#join-nickname-check-message-area {display:inline-block; margin-left:10px;}
	.join-nickname-check-message-negative {color:#d9534f;}
	.join-nickname-check-message-positive {color:#5cb85c;}
	#join-password-message-area {display:inline-block; margin-left:10px;}
	.join-password-message-negative {color:#d9534f;}
	.join-password-message-positive {color:#5cb85c;}
</style>
<script>
	$(document).ready(function () {
		var successPasswordCheck = false;
		var successPassword = false;
		var successId = false;
		var successNickname = false;
		var successAnswer = false;
		var patternSpace = /\s/g;
		var patternEnglishNumber = /^[A-Za-z0-9+]*$/;
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/; // 8~15자리 영문, 숫자, 특수문자 최소 1개 포함
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var RegExpHG = "[ㄱ-ㅎ가-?R]";
		
		var passwordNegativeMessage = function () {
			var html = '';
			html += '<div class="join-password-message-negative">';
			html += '	8자 이상 15자 이하, 영문,숫자,특수문자를 포함';
			html +=	'</div>';
			return html;
		}
		
		var passwordPositiveMessage = function () {
			var html = '';
			html += '<div class="join-password-message-positive">';
			html += '	올바른 비밀번호입니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckNegativeMessage = function () {
			var html = '';
			html += '<div class="join-password-check-message-negative">';
			html += '	비밀번호가 일치하지 않습니다.';
			html += '</div>';
			return html;
		}
		
		var passwordCheckPositiveMessage = function () {
			var html = '';
			html += '<div class="join-password-check-message-positive">';
			html += '	비밀번호가 일치합니다.';
			html += '</div>';
			return html;
		}
		
		var idNegativeMessage = function () {
			var html = '';
			html += '<div class="join-id-check-message-negative">';
			html += '	6글자 이상 영문과 숫자만 사용할 수 있습니다.';
			html += '</div>';
			return html;
		}
		
		var idPositiveMessage = function () {
			var html = '';
			html += '<div class="join-id-check-message-positive">';
			html += '	아이디가 올바릅니다.';
			html += '</div>'; 
			return html;
		}
		
		var idNegativeMessageOverlap = function () {
			var html = '';
			html += '<div class="join-id-check-message-negative">';
			html += '	중복된 아이디입니다.';
			html += '</div>';
			return html;
		}
		
		var idPositiveMessageOverlap = function () {
			var html = '';
			html += '<div class="join-id-check-message-positive">';
			html += '	이 아이디를 사용하실 수 있습니다.';
			html += '</div>'; 
			return html;
		}
		
		var answerNegativeMessage = function () {
			var html = '';
			html += '<div class="join-answer-check-message-negative">';
			html += '	2글자 이하 및 띄어쓰기는 불가능합니다.';
			html += '</div>';
			return html;
		}
		
		var answerPositiveMessage = function () {
			var html = '';
			html += '<div class="join-answer-check-message-positive">';
			html += '	올바른 답변입니다.';
			html += '</div>';
			return html;
		}
		
		var nicknameNegativeMessage = function () {
			var html = '';
			html += '<div class="join-nickname-check-message-negative">';
			html += '	2글자 이하 및 띄어쓰기는 불가능합니다.';
			html += '</div>';
			return html;
		}
		
		var nicknamePositiveMessage = function () {
			var html = '';
			html += '<div class="join-nickname-check-message-positive">';
			html += '	올바른 닉네임입니다.';
			html += '</div>';
			return html;
		}
		
		var nicknameNegativeMessageOverlap = function () {
			var html = '';
			html += '<div class="join-nickname-check-message-negative">';
			html += '	중복된 닉네임입니다.';
			html += '</div>';
			return html;
		}
		
		var nicknamePositiveMessageOverlap = function () {
			var html = '';
			html += '<div class="join-nickname-check-message-positive">';
			html += '	이 닉네임을 사용하실 수 있습니다.';
			html += '</div>';
			return html;
		}
		
		$('#join-content-id').on("keyup", function () {
			$('.join-id-check-message-negative').remove();
			$('.join-id-check-message-positive').remove();
			if ($(this).val().length < 5 || $(this).val().match(patternSpace) || !$(this).val().match(patternEnglishNumber)) {
				$('#join-id-check-message-area').append(idNegativeMessage());
				successId = false;
			} else {
				$('#join-id-check-message-area').append(idPositiveMessage());
				successId = true;
			}
		});
		
		$('#join-content-id').focusout(function () {
			if (successId) {
				$('.join-id-check-message-positive').remove();
				var studentId = $('#join-content-id').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : studentId, item : 1},
					success : function (data) {
						if (data.overlapCheckId) {
							$('#join-id-check-message-area').append(idNegativeMessageOverlap());
							successId = false;
						} else {
							$('#join-id-check-message-area').append(idPositiveMessageOverlap());
						}
					}
				});
			}
		});
		
		$('#join-content-answer').on("keyup", function () {
			$('.join-answer-check-message-negative').remove();
			$('.join-answer-check-message-positive').remove();
			if ($(this).val().length < 3 || $(this).val().match(patternSpace)) {
				$('#join-answer-check-message-area').append(answerNegativeMessage());
				successAnswer = false;
			} else {
				$('#join-answer-check-message-area').append(answerPositiveMessage());
				successAnswer = true;
			}
		});
		
		$('#join-content-nickname').on("keyup", function () {
			$('.join-nickname-check-message-negative').remove();
			$('.join-nickname-check-message-positive').remove();
			if ($(this).val().length < 3 || $(this).val().match(patternSpace)) {
				$('#join-nickname-check-message-area').append(nicknameNegativeMessage());
				successNickname = false;
			} else {
				$('#join-nickname-check-message-area').append(nicknamePositiveMessage());
				successNickname = true;
			}
		});
		
		$('#join-content-nickname').focusout(function () {
			if (successNickname) {
				$('.join-nickname-check-message-positive').remove();
				var nickname = $('#join-content-nickname').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : nickname, item : 2},
					success : function(data) {
						if (data.overlapCheckNickname) {
							$('#join-nickname-check-message-area').append(nicknameNegativeMessageOverlap());
							successNickname = false;
						} else {
							$('#join-nickname-check-message-area').append(nicknamePositiveMessageOverlap());
						}
					}
				});
			}
		});
		
		$('#join-content-password').on("keyup", function() {
			$('.join-password-message-negative').remove();
			$('.join-password-message-positive').remove();
			if (!patternEnglishNumberSpecial.test($(this).val()) || patternKorean.test($(this).val())) {
				$('#join-password-message-area').append(passwordNegativeMessage());
				successPassword = false;
			} else {
				$('#join-password-message-area').append(passwordPositiveMessage());
				successPassword = true;
			}
		});
		
		$('#join-content-password-check').on("keyup", function() {
			$('.join-password-check-message-negative').remove();
			$('.join-password-check-message-positive').remove();
			if ($('#join-content-password').val() !== $('#join-content-password-check').val()) {
				$('#join-password-check-message-area').append(passwordCheckNegativeMessage());
				successPasswordCheck = false;
			} else {
				$('#join-password-check-message-area').append(passwordCheckPositiveMessage());
				successPasswordCheck = true;
			}
		});
		
		$("#join-write-form").on("submit", function() {
			var result = false;
			
			if (!successId) {
				$('[data-toggle="tooltip-id"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-id"]').tooltip('destroy');
				}, 2000);
			}
			
			if (!successPassword) {
				$('[data-toggle="tooltip-password"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-password"]').tooltip('destroy');
				}, 2000);
			}
			
			if (!successPasswordCheck) {
				$('[data-toggle="tooltip-password-check"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-password-check"]').tooltip('destroy');
				}, 2000);
			}
			
			if (!successAnswer) {
				$('[data-toggle="tooltip-answer"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-answer"]').tooltip('destroy');
				}, 2000);
			}
			
			if (!successNickname) {
				$('[data-toggle="tooltip-nickname"]').tooltip('show');
				setTimeout(function () {
					$('[data-toggle="tooltip-nickname"]').tooltip('destroy');
				}, 2000);
			}
			
			if ($('#join-content-id').val() !== "" && $('#join-content-password').val() !== "" &&
					successPassword && $('#join-content-answer').val() !== "" && $('#join-content-nickname').val() !== "") {
				result = true;
			}
			
			return result;
		});		
	});
</script>