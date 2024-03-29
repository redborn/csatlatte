<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.manage-user-label {display:inline-block; width:80px; text-align:right; display:inline-block;}
	#manage-user-nav {text-align:center;}
	#manage-user-table {margin-top:15px; text-align:center;}
	.manage-user-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-user-search {text-align:right;}
	.manage-user-id {cursor:pointer;}
	#manage-user-id .modal-body {text-align:center;}
	.manage-user-picture {width:100px; height:100px; border-radius:5px; border:1px solid #7a6253;}
	.manage-user-info {margin-top:10px;}
	.manage-user-info-content {text-align:left; margin-left:40px; margin-top:5px;}
	.manage-user-info-content-value {margin-left:10px; display:inline-block;}
	.manage-user-blind {cursor:pointer;}
	.manage-user-recovery {cursor:pointer;}
	.manage-user-icon {float:none;}
	@media screen and (max-width:500px) {
		#manage-user-table .manage-user-sequence {display:none;}
	}
</style>
<script>
	$(document).ready(function () {
		
		var blindTarget;
		var recoveryTarget;
		
		var makeStudentInformation = function (student) {
			var html = '';
			html += '<div class="manage-user-student-information">';
			html += '	<img class="manage-user-picture" alt="회원사진" src="' + contextPath + '/file/student/' + student.studentSequence + '">';
			html += '	<div class="manage-user-info">';
			html +=	'		<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">아이디</label>';
			html += '			<div class="manage-user-info-content-value">' + student.studentId + '</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">닉네임</label>';
			html += '			<div class="manage-user-info-content-value">' + student.nickname + '</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">가입일</label>';
			html += '			<div class="manage-user-info-content-value">' + student.createDate + '</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">최근 접속일</label>';
			if (student.lastConnection == null) {
				html += '			<div class="manage-user-info-content-value">로그인 기록이 없습니다.</div>';
			} else {
				html += '			<div class="manage-user-info-content-value">' + student.lastConnection + '</div>';	
			}
			html += '		</div>';
			html += '			<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">활동점수 내역</label>';
			html += '			<div class="manage-user-info-content-value">게시글 ' + student.countCommunity + '개, 댓글 ' + student.countComment + '개</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label class="manage-user-label">성적평균</label>';
			html += '			<div class="manage-user-info-content-value">' + student.averageScore + '</div>';
			html += '		</div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeRecoveryButton = function (studentSequence) {
			var html = '';
			html += '<div id="recovery-' + studentSequence + '">';
			html += '	<button type="button" class="btn btn-default close manage-user-icon"><div id="' + studentSequence + '" data-toggle="modal" data-target="#manage-user-recovery" class="glyphicon glyphicon-refresh manage-user-recovery"></div></button>';
			html += '</div>';
			return html;
		}
		
		var makeBlindButton = function (studentSequence) {
			var html = '';
			html += '<div id="blind-' + studentSequence + '">';
			html += '	<button type="button" class="btn btn-default close manage-user-icon"><div id="' + studentSequence + '" data-toggle="modal" data-target="#manage-user-blind" class="glyphicon glyphicon-lock manage-user-blind"></div></button>';
			html += '</div>';
			return html;
		}
		
		$('.manage-user-id').on("click", function() {
			var target = $(this).attr("id");
			$.ajax(contextPath + "/data/student/" + target + ".json", {
				dataType : "json",
				type : "GET",
				success : function(data) {
					if (data.information != null) {
						var student = data.information;
						$('.manage-user-modal-content').append(makeStudentInformation(student));
					}
				}
			});
		});
		
		$('.manage-user-blind').on("click", function () {
			blindTarget = $(this).attr("id");
		});
		
		$('.manage-user-blind-apply').on("click", function () {
			var studentSequence = blindTarget;
			if (studentSequence != null) {
				$.ajax(contextPath + "/data/student/lock/" + studentSequence + ".json", {
					dataType : "json",
					type : "POST",
					success : function(data) {
						if (data.result) {
							$('#manage-user-blind').modal("hide");
							$('#blind-' + studentSequence).remove();
							$('#manage-user-blind-button-area-' + studentSequence).append(makeRecoveryButton(studentSequence));
							$('.manage-user-recovery').on("click", function () {
								recoveryTarget = $(this).attr("id");
							});
						}
					}
				});
			}
		});
		
		$('#manage-user-id').on('hidden.bs.modal', function () {
			$('.manage-user-student-information').remove();
		});
		
		$('.manage-user-recovery').on("click", function () {
			recoveryTarget = $(this).attr("id");
		});
		
		$('.manage-user-recovery-apply').on("click", function () {
			var studentSequence = recoveryTarget;
			if (studentSequence != null) {
				$.ajax(contextPath + "/data/student/lock/" + studentSequence + ".json", {
					dataType : "json",
					type : "DELETE",
					success : function (data) {
						if (data.result) {
							$('#manage-user-recovery').modal("hide");
							$('#recovery-' + studentSequence).remove();
							$('#manage-user-blind-button-area-' + studentSequence).append(makeBlindButton(studentSequence));
							$('.manage-user-blind').on("click", function () {
								blindTarget = $(this).attr("id");
							});
						}
					}
				});
			}
		});
	});
</script>