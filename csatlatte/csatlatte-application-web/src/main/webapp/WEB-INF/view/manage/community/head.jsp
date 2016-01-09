<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}

	.table {margin-top:15px;}
	.manage-community-title {display:inline-block; width:380px;}
	.manage-community-delete {cursor:pointer;}
	
	.col-lg-5 {float:none; display:inline-block;}
	.manage-community-search {text-align:right;}
	
	.manage-community-btn-align {text-align:right;}
	.manage-community-apply {width:50px; display:inline-block;}
	
	.modal-dialog-user-info {width:400px;}
	.modal-dialog-user-info .modal-body {text-align:center;}
	.manage-community-picture {width:100px; border-radius:5px; border:1px solid #7a6253;}
	.manage-community-info {margin-top:10px;}
	.manage-community-info-content {text-align:left; margin-left:40px; margin-top:5px;}
	.manage-community-info-content-value {margin-left:10px; display:inline-block;}
	
	.manage-community-id {cursor:pointer;}
	.manage-community-text-detail {cursor:pointer;}
	
	.dropdown {display:inline-block; vertical-align:top; text-align:right;}
	.modal-header .community-text .community-user-info {width:470px;}
	.community-profile-picture {width:40px; height:40px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-text {text-align:left;}
	.community-text .community-name {font-size:13px; display:inline;}
	.community-text .community-calender {font-size:13px; color:gray;}
	.community-text .community-user-info {display:inline-block; margin-left:3px; width:500px;}
	.community-text .community-comment-content {font-size:13px; display:inline;}
	.dropdown-menu-resource {cursor:pointer; margin-top:8px;}
	.community-comment {position:relative; margin-top:5px; height:40px; text-align:left;}
	.community-comment img {width:40px; height:40px; display:inline-block; border-radius:5px; border:1px solid #7a6253;}
	.community-comment .form-control {margin-top:3px; width:500px; display:inline-block; float:none;}
	
	.manage-exam-btn-cancel {cursor:pointer;}
	.manage-exam-btn-accept {cursor:pointer;}
	
	.community-comment {margin-bottom:5px;}
	.manage-community-text-detail xmp {white-space:pre-wrap; word-break:break-all; margin-top:0px; margin-bottom:0px;}
	.community-content xmp {white-space:pre-wrap; word-break:break-all; margin-top:0px; margin-bottom:0px;}
	.community-comment-content xmp {white-space:pre-wrap; word-break:break-all; display:inline-block; margin-top:0px; margin-bottom:0px;}
	
	#manage-community-blind .modal-body {text-align:left;}
	
	.manage-community-blind {cursor:pointer;}
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
		
		var getUrlParameter = function getUrlParameter(sParam) {
			var sPageURL = decodeURIComponent(window.location.search.substring(1)),
			sURLVariables = sPageURL.split('&'),
			sParameterName,
			i;

			for (i = 0; i < sURLVariables.length; i++) {
				sParameterName = sURLVariables[i].split('=');
				
				if (sParameterName[0] === sParam) {
					return sParameterName[1] === undefined ? true : sParameterName[1];	
				}	
			}	
		};
		
		$('#manage-community-search').val(getUrlParameter("search"));
		
		var makeCommunityDetail = function(community) {
			var html = '';
			html += '		<div class="modal-content" id="manage-community-text-content">';
			html += '			<div class="modal-header">';
			html += '				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '				<div class="community-text">';
			html += '					<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">';
			html += '					<div class="community-user-info">';
			html += '						<div class="community-name"><strong>' + community.nickname + '</strong></div>';
			html += '						<div class="community-calender">' + format(community.writeYmdhms) + '</div>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="modal-body">';
			html += '				<div class="community-content"><xmp>' + community.content + '</xmp></div>';
			html += '			</div>';
			html += '			<div id="comment-area" class="modal-footer">';
			html += '			</div>';
			html += '		</div>';
			return html;
		}
		
		var makeCommunityDetailComment = function(comment) {
			var html = '';
			html += '<div class="community-text community-comment">';
			html += '	<img alt="프로필사진" class="community-profile-picture" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">';
			html += '	<div class="community-user-info">';
			html += '		<div class="community-name"><strong>' + comment.nickname + '</strong></div>';
			html += '		<div class="community-comment-content"><xmp>' + comment.content + '</xmp></div>';
			html += '		<div class="community-calender">' + format(comment.writeYmdhms) + '</div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeStudentInformation = function (student) {
			var html = '';
			html += '<div class="manage-community-student-information">';
			html += '	<img class="manage-community-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">';
			html += '	<div class="manage-community-info">';
			html +=	'		<div class="manage-community-info-content">';
			html += '			<label>아이디</label>';
			html += '			<div class="manage-community-info-content-value">' + student.studentId + '</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label>가입일</label>';
			html += '			<div class="manage-community-info-content-value">' + student.createDate + '</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label>최근 접속일</label>';
			if (student.lastConnection == null) {
				html += '			<div class="manage-community-info-content-value">로그인 기록이 없습니다.</div>';
			} else {
				html += '			<div class="manage-community-info-content-value">' + student.lastConnection + '</div>';	
			}
			html += '		</div>';
			html += '			<div class="manage-community-info-content">';
			html += '			<label>활동점수 내역</label>';
			html += '			<div class="manage-community-info-content-value">게시글 ' + student.countCommunity + '개, 댓글 ' + student.countComment + '개</div>';
			html += '		</div>';
			html += '		<div class="manage-community-info-content">';
			html += '			<label>성적평균</label>';
			html += '			<div class="manage-community-info-content-value">' + student.averageScore + '</div>';
			html += '		</div>';
			html += '	</div>'; 
			html += '</div>';
			return html;
		}
		
		$('.manage-community-id').on("click", function () {
			var target = $(this).attr("id");
			if (target != null) {
				$.ajax("<c:url value="/data/student.json"/>", {
					dataType : "json",
					type : "GET",
					data : {studentSequence : target},
					success : function(data) {
						var student = data.information;
						console.log(student.lastConnection);
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
		
		$('.radio').change(function () {
			$('.manage-community-accept').attr('disabled',false);
		});
		
		$('.manage-community-accept').on("click", function () {
			var reason = $(':radio[name="optionsRadios"]:checked').val();
			if (blindTarget != null) {
				$.ajax("<c:url value="/data/community/blind.json"/>", {
					dataType : "json",
					type : "GET",
					data : {communitySequence : blindTarget},
					success : function(data) {
						if (data.check == true) {
							$.ajax("<c:url value="/data/manage/community.json"/>", {
								dataType : "json",
								type : "POST",
								data : {communitySequence : blindTarget, blindTypeSequence : reason},
								success : function() {
									$('#blind' + blindTarget).remove();
								}
							});
						}
					}
				});
			}
			$('#manage-community-blind').modal('hide');
		});
		
		$('.manage-community-text-detail').on("click", function() {
			var target = $(this).attr("id");
			if (target != null) {
				$.ajax("<c:url value="/data/manage/community.json"/>", {
					dataType : "json",
					type : "GET",
					data : {communitySequence : target},
					success : function(data) {
						var community = data.detail;
						$("#manage-community-text-dialog").append(makeCommunityDetail(community));
						$.ajax("<c:url value="/data/community/comment.json"/>", {
							dataType : "json",
							type : "GET",
							data : {communitySequence : target},
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
			}
		});
		
		$('#manage-community-text-detail').on('hidden.bs.modal', function () {
			$('#manage-community-text-content').remove();
		});
		
		$('#manage-community-blind').on('hidden.bs.modal', function () {
			$('input:radio[name="optionsRadios"]').attr('checked',false);
			$('.manage-community-accept').attr('disabled',true);
		});
		
		$('#manage-community-search').on("keyup", function (event) {
			if (event.which == 13) {
				var search = $('#manage-community-search').val();
				$(location).attr('href', '<c:url value="/manage/community?search="/>' + search);
			}
		});
		
	});
</script>