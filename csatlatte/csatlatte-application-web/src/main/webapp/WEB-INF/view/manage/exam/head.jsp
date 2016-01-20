<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.manage-exam-label {width:80px; text-align:right; display:inline-block; margin-left:10px;}
	#manage-exam-nav {text-align:center;}
	#manage-exam-table {margin-top:15px; text-align:center;}
	.manage-exam-col-lg {float:none; display:inline-block; text-align:center;}
	.manage-exam-search {text-align:right;}
	.manage-exam-info-content-value {margin-left:10px; display:inline-block; margin-top:5px;}
	.manage-exam-info-content-value .form-control {width:auto;}
	.manage-exam-title {display:inline-block; width:380px;}
	.manage-exam-modify {cursor:pointer;}
	.manage-exam-delete {cursor:pointer;}
	.manage-exam-btn-align {text-align:right;}
	.manage-exam-add {width:100px; display:inline-block;}
	.modal-footer {text-align:right;}
	.manage-exam-icon {float:none;}
</style>
<script>

	$(document).ready(function () {
		
		var target;
		
		var makeExamName = function (exam) {
			var html = '';
			html += '<div class="manage-exam-modal-body-name">';
			html += exam[0].examName + '를 삭제하시겠습니까?';
			html += '</div>';
			return html;
		}
		
		var makeExamModify = function (yearList, institutionList, ysList, listOne) {
			var html = '';
			var yearListLength = yearList.length;
			var institutionListLength = institutionList.length;
			var ysListLength = ysList.length;
			html += '	<div class="modal-content" id="manage-exam-modify-content">';
			html += '		<div class="modal-header">';
			html += '			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '			<h4 class="modal-title">모의고사 수정</h4>';
			html += '		</div>';
			html += '		<div class="modal-body">';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label class="manage-exam-label" for="manage-exam-csat">수능</label>';
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
			html += '				<label class="manage-exam-label" for="manage-exam-name">모의고사</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<input type="text" class="form-control" id="manage-exam-name" value="' + listOne[0].examName + '">';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label class="manage-exam-label" for="manage-exam-eduoffice">주관 교육청</label>';
			html += '				<div class="manage-exam-info-content-value">';
			html += '					<select class="form-control" id="manage-exam-eduoffice">';
			for (var index = 0; index < institutionListLength; index++) {
				html += '					<option value="' + institutionList[index].institutionSequence + '"';
				if (listOne[0].institutionSequence == institutionList[index].institutionSequence) {
					html += ' selected';
				}
				html += '>' + institutionList[index].institutionName + '</option>';
			}
			html += '					</select>';
			html += '				</div>';
			html += '			</div>';
			html += '			<div class="manage-exam-info-content">';
			html += '				<label class="manage-exam-label" for="manage-exam-student-grade">학년</label>';
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
			html += '				<label class="manage-exam-label" for="manage-exam-file">등급컷 업로드</label>';
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
		
		$('.manage-exam-modify').on("click", function () {
			target = $(this).attr("id");
			$.ajax("<c:url value="/data/manage/exam.json"/>", {
				dataType : "json",
				type : "GET",
				data : {examSequence : target},
				success : function(data) {
					if (data.yearList != null && data.institutionList != null && data.ysList != null && data.listOne != null) {
						var yearList = data.yearList;
						var institutionList = data.institutionList;
						var ysList = data.ysList;
						var listOne = data.listOne;
						$('#manage-exam-modify-dialog').append(makeExamModify(yearList, institutionList, ysList, listOne));
						$('.manage-exam-modify-accept').on("click", function () {
							var csatSequence = $('#manage-exam-csat option:selected').val();
							var examName = $('#manage-exam-name').val();
							var institutionSequence = $('#manage-exam-eduoffice option:selected').val();
							var ysSequence = $('#manage-exam-student-grade option:selected').val();
							$.ajax("<c:url value="/data/manage/exam.json"/>", {
								dataType : "json",
								type : "POST",
								data : {
									examSequence : target,
									csatSequence : csatSequence, 
									examName : examName,
									institutionSequence : institutionSequence,
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
			$.ajax(contextPath + "/data/manage/exam", {
				dataType : "json",
				type : "GET",
				data : {examSequence : target},
				success : function (data) {
					if (data.listOne != null) {
						var exam = data.listOne;
						$('#manage-exam-delete-modal-body').append(makeExamName(exam));						
					}
				}
			});
		});
		
		$('#manage-exam-delete').on('hidden.bs.modal', function () {
			$('.manage-exam-modal-body-name').remove();
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