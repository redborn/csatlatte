<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/jquery/fileupload.jsp" %>
<style>
	#profile-modify-return {margin-left:15px; margin-top:5px;}
	#profile-modify-image {width:100px; height:100px; margin-bottom:5px; border:1px solid #7a6253; border-radius:4px;}
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
		var patternEnglishNumberSpecial = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[~,!,@,#,$,*,(,),=,+,_,.,|]).*$/;
		var patternKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var successNickname = true;
		
		var inputFile = $("#profile-modify-form input[type='file']");
		$("#profile-modify-form input[type='file']").on("change", function () {
			var data = this;
			if (data) {
				$('#profile-modify-image-delete').val("false");
				var files = data.files;
				if (files && files[0]) {
					var file = files[0];
					if (file.size >= 1000000) {
						$("#profile-modify-image-message").text("파일 크기는 10MB이하만 사용할 수 있습니다.").show();
						$("#profile-modify-photo-minus").trigger("click");
					} else {
						if (!file.name.match(/\.(gif|jpg|jpeg|png)$/i)) {
							$("#profile-modify-photo-message").text("이미지 파일(gif, jpg, jpeg, png)만 사용할 수 있습니다.").show();
							$("#profile-modify-photo-minus").trigger("click");
						} else {
							$("#profile-modify-photo-message").hide();
							var reader = new FileReader();
							reader.onload = function (e) {
								$("#profile-modify-image").attr("src", e.target.result).slideDown("fast");
								$("#profile-modify-photo-minus").fadeIn("fast").css("display", "inline-block");
							}
							reader.readAsDataURL(file);
						}
					}
				}
			}
		});
		$("#profile-modify-photo-minus").on("click", function () {
			inputFile.replaceWith(inputFile = inputFile.clone(true));
			$('#profile-modify-image-delete').val("true");
			$("#profile-modify-image").slideUp("fast");
			$(this).fadeOut("fast");
		});
		
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
				successNickname = true;
			}
			
			if (successNickname) {
				var nickname = $('#profile-modify-nickname').val();
				$.ajax(contextPath + "/data/join.json", {
					dataType : "json",
					type : "GET",
					data : {overlapValue : nickname, item : 2},
					success : function(data) {
						var beforeNickname = $('#profile-modify-before-nickname').val();
						$('.profile-nickname-check-message-positive').remove();
						$('.profile-nickname-check-message-negative').remove();
						if (!data.overlapCheckNickname || nickname === beforeNickname) {
							$('#profile-nickname-check-message-area').append(nicknamePositiveMessageOverlap());
						} else {
							$('#profile-nickname-check-message-area').append(nicknameNegativeMessageOverlap());
							successNickname = false;
						}
					}
				});
			}
			
			if (!successNickname) {
				$('#profile-modify-btn-success').attr("disabled", true);
			} else {
				$('#profile-modify-btn-success').attr("disabled", false);
			}
		});
	});
</script>