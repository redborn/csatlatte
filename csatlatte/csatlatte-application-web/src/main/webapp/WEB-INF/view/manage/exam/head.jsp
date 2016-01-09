<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}
	.table {margin-top:15px;}
	label {width:80px; text-align:right; display:inline-block; margin-left:10px;}
	
	.col-lg-5 {float:none; display:inline-block;}
	.manage-exam-search {text-align:right;}
	
	.manage-exam-info-content-value {margin-left:10px; display:inline-block; margin-top:5px;}
	.manage-exam-info-content-value .form-control {width:auto;}

	.manage-exam-title {display:inline-block; width:380px;}
	.manage-exam-modify {cursor:pointer;}
	.manage-exam-delete {cursor:pointer;}
	.manage-exam-btn-align {text-align:right;}
	
	.manage-exam-add {width:100px; display:inline-block;}
	
	.modal-footer {text-align:right;}
	.manage-exam-btn-cancel {cursor:pointer; margin-right:10px;}
	.manage-exam-btn-accept {cursor:pointer;}
	td .close {float:none;}
</style>
<script>

	$(document).ready(function () {
		
		var target;
		
		var makeExamModify = function (yearList, istttList, ysList, listOne) {
			var html = '';
			var yearListLength = yearList.length;
			var istttListLength = istttList.length;
			var ysListLength = ysList.length;
			html += '	<div class="modal-content" id="manage-exam-modify-content">';
			html += '		<div class="modal-header">';
			html += '			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '			<h4 class="modal-title">모의고사 수정</h4>';
			html += '		</div>';
			html += '		<div class="modal-body">';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label for="manage-exam-csat">수능</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<select class="form-control" id="manage-exam-csat">';
			for (var index = 0; index < yearListLength; index++) {
				html += '					<option value="' + yearList[index].csatSequence + '"';
				if (listOne[0].csatSequence == yearList[index].csatSequence) {
					html += ' selected';
				}
				html += '>' + yearList[index].csatName + '</option>';
			}
			html += '					</select>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label for="manage-exam-name">모의고사</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<input type="text" class="form-control" id="manage-exam-name" value="' + listOne[0].examName + '">';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label for="manage-exam-eduoffice">주관 교육청</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<select class="form-control" id="manage-exam-eduoffice">';
			for (var index = 0; index < istttListLength; index++) {
				html += '					<option value="' + istttList[index].istttSequence + '"';
				if (listOne[0].istttSequence == istttList[index].istttSequence) {
					html += ' selected';
				}
				html += '>' + istttList[index].istttName + '</option>';
			}
			html += '					</select>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label for="manage-exam-student-grade">학년</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<select class="form-control" id="manage-exam-student-grade">';
			for (var index = 0; index < ysListLength; index++) {
				html += '					<option value="' + ysList[index].ysSequence + '"';
				if (listOne[0].ysSequence == ysList[index].ysSequence) {
					html += ' selected';
				}
				html += '>' + ysList[index].ysName + '</option>';
			}
			html += '					</select>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label for="manage-exam-file">등급컷 업로드</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<input type="file" id="manage-exam-file">';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<a href="#">등급컷 다운로드</a>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="modal-footer">';
			html += '			<button class="btn btn-default" data-dismiss="modal">닫기</button>';
			html += '			<button class="btn btn-primary manage-exam-modify-accept">확인</button>';
			html += '		</div>';
			html += '	</div>';
			return html;
		}
		
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

		$('.manage-exam-modify').on("click", function () {
			target = $(this).attr("id");
			$.ajax("<c:url value="/data/manage/exam.json"/>", {
				dataType : "json",
				type : "GET",
				data : {examSequence : target},
				success : function(data) {
					if (data.yearList != null && data.istttList != null && data.ysList != null && data.listOne != null) {
						var yearList = data.yearList;
						var istttList = data.istttList;
						var ysList = data.ysList;
						var listOne = data.listOne;
						$('#manage-exam-modify-dialog').append(makeExamModify(yearList, istttList, ysList, listOne));
						$('.manage-exam-modify-accept').on("click", function () {
							var csatSequence = $('#manage-exam-csat option:selected').val();
							var examName = $('#manage-exam-name').val();
							var istttSequence = $('#manage-exam-eduoffice option:selected').val();
							var ysSequence = $('#manage-exam-student-grade option:selected').val();
							$.ajax("<c:url value="/data/manage/exam.json"/>", {
								dataType : "json",
								type : "POST",
								data : {
									examSequence : target,
									csatSequence : csatSequence, 
									examName : examName,
									istttSequence : istttSequence,
									ysSequence : ysSequence
								},
								success : function() {
									// 리플래시
								}
							});
						});
					}
				}
			});
		});
		
		$('#manage-exam-search').val(getUrlParameter("search"));
		
		$('#manage-exam-modify').on('hidden.bs.modal', function () {
			$('#manage-exam-modify-content').remove();
		});
		
		$('#manage-exam-search').on("keyup", function (event) {
			if (event.which == 13) {
				var search = $('#manage-exam-search').val();
				$(location).attr('href', '<c:url value="/manage/exam?search="/>' + search);
			}
		});
		
		$('.manage-exam-delete').on("click", function () {
			target = $(this).attr("id");
		});
		
		$('.manage-exam-delete-accept').on("click", function () {
			var examSequence = target;
			$.ajax(contextPath + "/data/manage/exam/" + examSequence + ".json", {
				dataType : "json",
				type : "DELETE",
				data : {_method : "DELETE"},
				success : function () {
					// 리플래시
				}
			});
		});
	});
	
</script>