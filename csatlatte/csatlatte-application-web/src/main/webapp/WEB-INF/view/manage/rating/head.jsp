<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.manage-rating-col-lg {text-align:center;}
	.manage-rating-btn-align {text-align:right;}
	.manage-rating-icon {float:none;}
	#manage-rating-table {margin-top:15px; text-align:center;}
</style>
<script>
	$(document).ready(function () {
		var csatSequence = 24;
		
		var makeRatingRow = function (list) {
			var html = '';
			html += '<tr class="manage-rating-row-data">';
			html += '	<td>' + list.examSequence + '</td>';
			html += '	<td>' + list.examName + '</td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-detail glyphicon glyphicon-search"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-remove glyphicon glyphicon-remove"></span></button></td>';
			html += '</tr>';
			return html;
		}
		
		$.ajax(contextPath + "/data/manage/rating.json", {
			dataType : "json",
			type : "GET",
			data : {csatSequence : csatSequence},
			success : function (data) {
				if (data.list != null) {
					var list = data.list;
					var listLength = list.length;
					for (var index = 0; index < listLength; index++) {
						$('.manage-rating-row').append(makeRatingRow(list[index]));
					}
					$('.manage-rating-modify').on("click", function () {
						var examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/manage/rating/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							data : {csatSequence : csatSequence},
							success : function (data) {
								if (data.detail != null) {
									var detail = data.detail;
									$('#manage-exam-modify-view-detail').append(makeModifyView(detail));
								}
							}
						});
					});
				}
			}
		});
		
		$('#manage-rating-csat-list').on("change", function () {
			csatSequence = $(this).val();
			$.ajax(contextPath + "/data/manage/rating.json", {
				dataType : "json",
				type : "GET",
				data : {csatSequence : csatSequence},
				success : function (data) {
					if (data.list != null) {
						var list = data.list;
						var listLength = list.length;
						for (var index = 0; index < listLength; index++) {
							$('.manage-rating-row-data').remove();
							$('.manage-rating-row').append(makeRatingRow(list[index]));
						}
					}
				}
			});
		});
		
		var makeModifyView = function (detail) {
			var html = '';
			html += '<div class="modal-content">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">등급컷 수정</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div class="form-group row">';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary">확인</button>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
	});
</script>