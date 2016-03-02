<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.manage-community-label {display:inline-block; width:80px; text-align:right; display:inline-block;}
	#manage-community-nav {text-align:center;}
	#manage-community-table {margin-top:15px; text-align:center; float:none;}
	.manage-community-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-community-search {text-align:right;}
	.manage-community-user-info-modal .modal-body {text-align:center;}
	.manage-community-picture {width:100px; height:100px; border-radius:5px; border:1px solid #7a6253;}
	.manage-community-info {margin-top:10px;}
	.manage-community-info-content {text-align:left; margin-left:40px; margin-top:5px;}
	.manage-community-info-content-value {margin-left:10px; display:inline-block;}
	.manage-community-id {cursor:pointer;}
	.manage-community-text-detail {cursor:pointer;}
	.manage-community-profile-picture {width:40px; height:40px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.manage-community-text {text-align:left;}
	.manage-community-text .manage-community-name {font-size:13px; display:inline;}
	.manage-community-text .manage-community-calender {font-size:13px; color:gray;}
	.manage-community-text .manage-community-user-info {display:inline-block; margin-left:3px;}
	.manage-community-text .manage-community-comment-content {font-size:13px; display:inline;}
	.manage-community-comment {position:relative; margin-top:5px; height:40px; text-align:left;}
	.manage-community-comment img {width:40px; height:40px; display:inline-block; border-radius:5px; border:1px solid #7a6253;}
	.manage-community-comment .form-control {margin-top:3px; width:500px; display:inline-block; float:none;}
	.manage-community-comment {margin-bottom:5px;}
	.manage-community-content xmp {white-space:pre-wrap; word-break:break-all;}
	.manage-community-comment-content xmp {white-space:pre-wrap; word-break:break-all; display:inline-block; margin-top:0px; margin-bottom:0px;}
	.manage-community-text-detail xmp {white-space:nowrap; width:100px; text-overflow:ellipsis; overflow:hidden;}
	#manage-community-blind .modal-body {text-align:left;}
	.manage-community-blind {cursor:pointer;}
	.manage-community-icon {float:none;}
	@media screen and (max-width:500px) {
		#manage-community-table .manage-community-sequence {display:none;}
		.manage-community-text-detail xmp {width:50px}
	}
</style>
<script>
	$(document).ready(function () {
		
		var blindTarget;
		
		$('.manage-community-accept').attr('disabled',true);
		
		var format = function(ymdhms) {
			var gapTime = new Date().getTime() - new Date(ymdhms.substring(0, 4), parseInt(ymdhms.substring(4, 6)) - 1, ymdhms.substring(6, 8), ymdhms.substring(8, 10), ymdhms.substring(10, 12), ymdhms.substring(12, 14)).getTime(); 
			var result = "";
			if (gapTime >= 1000 * 60 * 60 * 24) {
				result = ymdhms.substring(0, 4) + "-" + ymdhms.substring(4, 6) + "-" + ymdhms.substring(6, 8) + " " + ymdhms.substring(8, 10) + ":" + ymdhms.substring(10, 12) + ":" + ymdhms.substring(12, 14)
			} else if (gapTime >= 1000 * 60 * 60) {
				result = parseInt(gapTime / (1000 * 60 * 60), 10) + "시간 전";
			} else if (gapTime >= 1000 * 60) {
				result = parseInt(gapTime / (1000 * 60), 10) + "분 전";
			} else {
				result = "방금 전";
			}
			return result;
		};
		
		var makeCommunityDetail = function(communitySequence) {
			var nickname = $('#manage-community-nickname-' + communitySequence).val();
			var writeYmdhms = $('#manage-community-writeYmdhms-' + communitySequence).val();
			var content = $('#manage-community-content-' + communitySequence).val();
			var studentSequence = $('#manage-community-studentseq-' + communitySequence).val();
			var html = '';
			html += '		<div class="modal-content" id="manage-community-text-content">';
			html += '			<div class="modal-header">';
			html += '				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '				<div class="manage-community-text">';
			html += '					<img alt="프로필사진" class="manage-community-profile-picture" src="' + contextPath + '/file/student/' + studentSequence + '">';
			html += '					<div class="manage-community-user-info">';
			html += '						<div class="manage-community-name"><strong>' + nickname + '</strong></div>';
			html += '						<div class="manage-community-calender" data-ymdhms="' + writeYmdhms + '">' + format(writeYmdhms) + '</div>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="modal-body">';
			html += '				<div class="community-content"><xmp>' + content + '</xmp></div>';
			html += '			</div>';
			html += '			<div id="comment-area" class="modal-footer">';
			html += '			</div>';
			html += '		</div>';
			return html;
		}
		
		var makeCommunityDetailComment = function(comment) {
			var html = '';
			html += '<div class="manage-community-text manage-community-comment">';
			html += '	<img alt="프로필사진" class="manage-community-profile-picture" src="' + contextPath + '/file/student/' + comment.studentSequence + '">';
			html += '	<div class="manage-community-user-info">';
			html += '		<div class="manage-community-name"><strong>' + comment.nickname + '</strong></div>';
			html += '		<div class="manage-community-comment-content"><xmp>' + comment.content + '</xmp></div>';
			html += '		<div class="manage-community-calender" data-ymdhms="' + comment.writeYmdhms + '">' + format(comment.writeYmdhms) + '</div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeStudentInformation = function (student) {
			var html = '';
			html += '<div class="manage-community-student-information">';
			html += '<div class="modal-body">';
			html += '	<img class="manage-community-picture" alt="회원사진" src="' + contextPath + '/file/student/' + student.studentSequence + '">';
			html += '	<div class="manage-community-info">';
			html +=	'		<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">아이디</label>';
			html += '			<div class="manage-community-info-content-value">' + student.studentId + '</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">닉네임</label>';
			html += '			<div class="manage-community-info-content-value">' + student.nickname + '</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">가입일</label>';
			html += '			<div class="manage-community-info-content-value">' + student.createDate + '</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">최근 접속일</label>';
			if (student.lastConnection == null) {
				html += '			<div class="manage-community-info-content-value">로그인 기록이 없습니다.</div>';
			} else {
				html += '			<div class="manage-community-info-content-value">' + student.lastConnection + '</div>';	
			}
			html += '		</div>';
			html += '			<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">활동점수 내역</label>';
			html += '			<div class="manage-community-info-content-value">게시글 ' + student.countCommunity + '개, 댓글 ' + student.countComment + '개</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label class="manage-community-label">성적평균</label>';
			html += '			<div class="manage-community-info-content-value">' + student.averageScore + '</div>';
			html += '		</div>';
			html += '	</div>'; 
			html += '</div>';
			html += '</div>';
			return html;
		}
		
		$('.manage-community-id').on("click", function () {
			var target = $(this).attr("id");
			if (target != null) {
				$.ajax(contextPath + "/data/student/" + target + ".json", {
					dataType : "json",
					type : "GET",
					success : function(data) {
						var student = data.information;
						$("#manage-community-student-information").append(makeStudentInformation(student));
					}
				});
			}
		});
		
		$('#manage-community-id').on('hidden.bs.modal', function () {
			$('.manage-community-student-information').remove();
		});
		
		$('.manage-community-blind').on("click", function() {
			blindTarget = $(this).attr("id");
		});
		
		$('.radio').on("change", function () {
			$('.manage-community-accept').attr('disabled',false);
		});
		
		$('.manage-community-accept').on("click", function () {
			var reason = $(':radio[name="optionsRadios"]:checked').val();
			if (blindTarget != null) {
				$.ajax(contextPath + "/data/community/blind/" + blindTarget + ".json", {
					dataType : "json",
					type : "POST",
					data : {blindTypeSequence : reason},
					success : function(data) {
						if (data.result) {
							$('#blind-' + blindTarget).remove();
						}
					}
				});
			}
			$('#manage-community-blind').modal('hide');
		});
		
		$('.manage-community-text-detail').on("click", function() {
			var target = $(this).attr("id");
			if (target != null) {
				$("#manage-community-text-dialog").append(makeCommunityDetail(target));
				$.ajax(contextPath + "/data/community/comment/" + target + ".json", {
					dataType : "json",
					type : "GET",
					success : function(commentData) {
						if(commentData.list != null) {
							var commentList = commentData.list;
							var commentListLength = commentList.length;
							for (var index = 0; index < commentListLength; index++) {
								comment = commentList[index];
								$('#comment-area').append(makeCommunityDetailComment(comment));
							}
						}
					}
				});
			}
		});
		
		$('#manage-community-text-detail').on('hidden.bs.modal', function () {
			$('#manage-community-text-content').remove();
		});
		
		$('#manage-community-blind').on('hidden.bs.modal', function () {
			$('input:radio[name="optionsRadios"]').attr('checked',false);
			$('.manage-community-accept').attr('disabled',true);
		});
		
	});
</script>