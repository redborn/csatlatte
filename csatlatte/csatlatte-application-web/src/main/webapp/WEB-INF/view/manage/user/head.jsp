<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}
	label {display:inline-block; width:80px; text-align:right;}
	.table {margin-top:15px;}
	
	.col-lg-5 {float:none; display:inline-block;}
	.manage-user-search {text-align:right;}
	
	.manage-user-title {display:inline-block; width:380px;}
	.manage-user-apply {width:50px; display:inline-block;}
	.manage-user-apply-align {text-align:right;}
	.manage-user-id {cursor:pointer;}
	
	.modal-body {text-align:center;}
	.modal-dialog {width:400px;}
	.manage-user-picture {width:100px; border-radius:5px; border:1px solid #7a6253;}
	.manage-user-info {margin-top:10px;}
	.manage-user-info-content {text-align:left; margin-left:40px; margin-top:5px;}
	.manage-user-info-content-value {margin-left:10px; display:inline-block;}
</style>
<script>
	$(document).ready(function () {
		
		var makeStudentInformation = function (student) {
			var html = '';
			html += '<div class="manage-user-student-information">';
			html += '	<img class="manage-user-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">';
			html += '	<div class="manage-user-info">';
			html +=	'		<div class="manage-user-info-content">';
			html += '			<label>아이디</label>';
			html += '			<div class="manage-user-info-content-value">' + student.studentId + '</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label>가입일</label>';
			html += '			<div class="manage-user-info-content-value">' + student.createDate + '</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label>최근 접속일</label>';
			html += '			<div class="manage-user-info-content-value">' + student.lastConnection + '</div>';
			html += '		</div>';
			html += '			<div class="manage-user-info-content">';
			html += '			<label>활동점수 내역</label>';
			html += '			<div class="manage-user-info-content-value">게시글 ' + student.countCommunity + '개, 댓글 ' + student.countComment + '개</div>';
			html += '		</div>';
			html += '		<div class="manage-user-info-content">';
			html += '			<label>성적평균</label>';
			html += '			<div class="manage-user-info-content-value">' + student.averageScore + '</div>';
			html += '		</div>';
			html += '	</div>'; 
			html += '</div>';
			return html;
		}
		
		$('.manage-user-id').on("click", function() {
			var target = $(this).attr("id");
			$.ajax("<c:url value="/data/student.json"/>", {
				dataType : "json",
				type : "GET",
				data : {studentSequence : target},
				success : function(data) {
					if (data.information != null) {
						var student = data.information;
						$('#manage-user-student-information').append(makeStudentInformation(student));
					}
				}
			});
		});
		
		$('.manage-user-apply').on("click", function () {
			$("input[type=checkbox]:checked").each(function () {
				var target = $(this).val();
				if (target != null) {
					$.ajax("<c:url value="/data/manage/student.json"/>", {
						dataType : "json",
						type : "PUT",
						data : {studentSequence : target},
						success : function() {
							
						}
					});
				}
			});
			alert("처리가 완료되었습니다.");
		});
		
		$('#manage-user-id').on('hidden.bs.modal', function () {
			$('.manage-user-student-information').remove();
		});
		
		$('#manage-student-search').on("keyup", function (event) {
			if (event.which == 13) {
				var search = $('#manage-student-search').val();
				$(location).attr('href', '<c:url value="/manage/user?search="/>' + search);
			}
		});
	});
</script>