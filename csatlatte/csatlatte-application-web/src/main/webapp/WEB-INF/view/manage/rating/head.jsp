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
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-exam-modify glyphicon glyphicon-search"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-exam-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-exam-modify glyphicon glyphicon-remove"></span></button></td>';
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
	});
</script>