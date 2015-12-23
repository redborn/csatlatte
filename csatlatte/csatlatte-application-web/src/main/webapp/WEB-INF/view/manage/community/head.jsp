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
	
</style>
<script>
	$(document).ready(function () {
		
		var target;
		var pageNumber;
		var search = null;
		
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
		
		var makeCommunityDataRow = function(community) {
			var html;
			html += '<tr>';
			html += '	<td><div id="'+ community.studentSequence +'"data-toggle="modal" data-target="#manage-community-id" class="manage-community-id">' + community.studentId + '</div></td>';
			html += '	<td>' + community.nickname + '</td>';
			html += '	<td><div id="' + community.communitySequence + '"data-toggle="modal" data-target="#manage-community-text-detail" class="manage-community-text-detail">' + community.content + '</div></td>';
			html += '	<td><input type="checkbox" name="blindCheck" value="'+ community.communitySequence + '"';
			if (community.blind == 1) {
				html += ' checked';
			}
			html += '></td>';
			html += '</tr>';
			return html;
		};
		
		var makeStudentInformation = function (student) {
			var html;
			html += '<div class="manage-community-student-information">';
			html += '<img class="manage-community-picture" alt="회원사진" src="<c:url value="/resources/csatlatte/images/img/img_person.png"/>">';
			html += '<div class="manage-community-info">';
			html +=	'	<div class="manage-community-info-content">';
			html += '		<label>아이디</label>';
			html += '		<div class="manage-community-info-content-value">' + student.studentId + '</div>';
			html += '	</div>';
			html += '	<div class="manage-community-info-content">';
			html += '		<label>가입일</label>';
			html += '		<div class="manage-community-info-content-value">' + student.createDate + '</div>';
			html += '	</div>';
			html += '	<div class="manage-community-info-content">';
			html += '		<label>최근 접속일</label>';
			html += '		<div class="manage-community-info-content-value">' + student.lastConnection + '</div>';
			html += '	</div>';
			html += '		<div class="manage-community-info-content">';
			html += '		<label>활동점수 내역</label>';
			html += '		<div class="manage-community-info-content-value">게시글 ' + student.countCommunity + '개, 댓글 ' + student.countComment + '개</div>';
			html += '	</div>';
			html += '	<div class="manage-community-info-content">';
			html += '		<label>성적평균</label>';
			html += '		<div class="manage-community-info-content-value">' + student.averageScore + '</div>';
			html += '	</div>';
			html += '</div>';
			html += '</div>';
			return html;
		}
		
		pageNumber = getUrlParameter('pageNumber');
		search = getUrlParameter('search');
		
		$.ajax("<c:url value="/data/manage/community.json"/>", {
			dataType : "json",
			type : "GET",
			data : {pageNumber : pageNumber, search : search},
			success : function(data) {
				if (data.list != null) {
					var communityList = data.list;
					var communityListLength = communityList.length;
					for (var index = 0; index < communityListLength; index++) {
						var community = communityList[index];
						$("#table-content").append(makeCommunityDataRow(community));
					}
					$('.manage-community-id').on("click", function () {
						var studentSequence = $(this).attr("id");
						
						$.ajax("<c:url value="/data/manage/student.json"/>", {
							dataType : "json",
							type : "GET",
							data : {studentSequence : studentSequence},
							success : function(data) {
								if (data.information != null) {
									var studentInformation = data.information;
									$('#manage-community-student-information').append(makeStudentInformation(studentInformation));
								}
							}
						});
					});
				}
			}
		});
		
		$('.manage-community-apply').on("click", function () {
			$("input[type=checkbox]:checked").each(function () {
				var target = $(this).val();
				if(target != null) {
					$.ajax("<c:url value="/data/manage/community.json"/>", {
						dataType : "json",
						type : "POST",
						data : {communitySequence : target},
						success : function() {
								
						}
					});
				}
			});
			alert("처리가 완료되었습니다.");
		});
		
		$('#manage-community-id').on('hidden.bs.modal', function () {
			$('.manage-community-student-information').remove();
		});
	});
</script>