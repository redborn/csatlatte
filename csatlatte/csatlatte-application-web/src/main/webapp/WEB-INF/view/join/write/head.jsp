<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/fileupload.jsp" %>
<style>
	.join {font-size:13px;}
	.join-id {margin-left:20px; margin-bottom:35px;}
	.join-security {margin-left:20px; margin-bottom:35px;}
	.join-info {margin-left:20px; margin-bottom:35px;}
	.join-content-label {text-align:right; width:120px; margin-right:5px;}
	#join-content-photo-img {width: 100px; height: 100px; border: 1px solid #7a6253; border-radius: 4px; margin-bottom: 10px; display:none;}
	#join-content-photo-minus {display:none;}
	#join-content-photo-message {color:#d9534f; line-height:34px;}
	.join-message {margin-left:70px; margin-top:5px;}
	.join-image {width:100px; border:1px solid #7a6253; border-radius:4px; margin-left:15px;}
	.join-button-group {text-align:right; width:auto; margin-top:20px;}
	#join-password-check-message-area {padding-top:7px;}
	.join-password-check-message-negative {color:#d9534f;}
	.join-password-check-message-positive {color:#5cb85c;}
	.join-id-check-message-negative {color:#d9534f;}
	.join-id-check-message-positive {color:#5cb85c;}
	#join-id-check-message-area {padding-top:7px;}
	#join-answer-check-message-area {padding-top:7px;}
	.join-answer-check-message-negative {color:#d9534f;}
	.join-answer-check-message-positive {color:#5cb85c;}
	#join-nickname-check-message-area {padding-top:7px;}
	.join-nickname-check-message-negative {color:#d9534f;}
	.join-nickname-check-message-positive {color:#5cb85c;}
	#join-password-message-area {padding-top:7px;}
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
		var inputFile = $("#join-write-form input[type='file']");
		
		$('#join-btn-success').attr("disabled", true);
		
		var checkSuccess = function() {
			if (successPasswordCheck && successPassword && successId && successNickname && successAnswer) {
				$('#join-btn-success').attr("disabled", false);
			} else {
				$('#join-btn-success').attr("disabled", true);
			}
		}
		
		var passwordNegativeMessage = function () {
			var html = '';
			html += '<div class="join-password-message-negative">';
			html += '	8~15자 이내, 영문,숫자,특수문자를 포함';
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
			html += '	6~10자 이내 영문,숫자만 사용 가능';
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
			html += '	3~8자 이내 띄어쓰기없이 작성하세요.';
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
			html += '	3~8자 이내 띄어쓰기없이 작성하세요.';
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
		
		$("#join-write-form input[type='file']").on("change", function() {
			var data = this;
			if (data) {
				var files = data.files;
				if (files && files[0]) {
					var file = files[0];
					if (file.size >= 1000000) {
						$("#join-content-photo-message").text("파일 크기는 10MB 이하만 사용 할 수 있습니다.").show();
						$("#join-content-photo-minus").trigger("click");
					} else {
						if (!file.name.match(/\.(gif|jpg|jpeg|png)$/i)) {
							$("#join-content-photo-message").text("이미지 파일(gif, jpg, jpeg, png)만 사용 할 수 있습니다.").show();
							$("#join-content-photo-minus").trigger("click");
						} else {
							$("#join-content-photo-message").hide();
							var reader = new FileReader();
							reader.onload = function(e) {
								$("#join-content-photo-img").attr("src", e.target.result).slideDown("fast");
								$("#join-content-photo-minus").fadeIn("fast").css("display", "inline-block");
							}
							reader.readAsDataURL(file);
						}
					}
				}
			}
		});
		
		$("#join-content-photo-minus").on("click", function() {
			inputFile.replaceWith(inputFile = inputFile.clone(true));
			$("#join-content-photo-img").slideUp("fast");
			$(this).fadeOut("fast");
		});
		
		$('#join-content-id').on("keyup", function () {
			$('.join-id-check-message-negative').remove();
			$('.join-id-check-message-positive').remove();
			if ($(this).val().length < 6 || $(this).val().match(patternSpace) || !$(this).val().match(patternEnglishNumber)) {
				$('#join-id-check-message-area').append(idNegativeMessage());
				successId = false;
			} else {
				var studentId = $('#join-content-id').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : studentId, item : 1},
					success : function (data) {
						$('.join-id-check-message-negative').remove();
						$('.join-id-check-message-positive').remove();
						if (data.overlapCheckId) {
							$('#join-id-check-message-area').append(idNegativeMessageOverlap());
							successId = false;
						} else {
							$('#join-id-check-message-area').append(idPositiveMessageOverlap());
							successId = true;
						}
						checkSuccess();
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
			checkSuccess();
		});
		
		$('#join-content-nickname').on("keyup", function () {
			$('.join-nickname-check-message-negative').remove();
			$('.join-nickname-check-message-positive').remove();
			if ($(this).val().length < 3 || $(this).val().match(patternSpace)) {
				$('#join-nickname-check-message-area').append(nicknameNegativeMessage());
				successNickname = false;
			} else {
				var nickname = $('#join-content-nickname').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : nickname, item : 2},
					success : function(data) {
						$('.join-nickname-check-message-negative').remove();
						$('.join-nickname-check-message-positive').remove();
						if (data.overlapCheckNickname) {
							$('#join-nickname-check-message-area').append(nicknameNegativeMessageOverlap());
							successNickname = false;
						} else {
							$('#join-nickname-check-message-area').append(nicknamePositiveMessageOverlap());
							successNickname = true;
						}
						checkSuccess();
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
			
			$('.join-password-check-message-negative').remove();
			$('.join-password-check-message-positive').remove();
			if ($('#join-content-password').val() !== $('#join-content-password-check').val() || $('#join-content-password').val() === "") {
				$('#join-password-check-message-area').append(passwordCheckNegativeMessage());
				successPasswordCheck = false;
			} else {
				$('#join-password-check-message-area').append(passwordCheckPositiveMessage());
				successPasswordCheck = true;
			}
			checkSuccess();
		});
		
		$('#join-content-password-check').on("keyup", function() {
			$('.join-password-check-message-negative').remove();
			$('.join-password-check-message-positive').remove();
			if ($('#join-content-password').val() !== $('#join-content-password-check').val() || $('#join-content-password').val() === "") {
				$('#join-password-check-message-area').append(passwordCheckNegativeMessage());
				successPasswordCheck = false;
			} else {
				$('#join-password-check-message-area').append(passwordCheckPositiveMessage());
				successPasswordCheck = true;
			}
			checkSuccess();
		});
	});
</script>