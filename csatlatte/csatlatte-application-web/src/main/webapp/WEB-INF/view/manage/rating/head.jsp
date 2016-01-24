<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.manage-rating-col-lg {text-align:center;}
	.manage-rating-btn-align {text-align:right;}
	.manage-rating-icon {float:none;}
	#manage-rating-table {margin-top:15px; text-align:center;}
	.manage-rating-label {text-align:right;}
	.manage-rating-delete-alert {color:#d9534f;}
</style>
<script>
	$(document).ready(function () {
		
		var csatSequence = 24;
		var examSequence;
		
		var makeRatingRow = function (list) {
			var html = '';
			html += '<tr class="manage-rating-row-data" id="manage-rating-row-data-' + list.examSequence + '">';
			html += '	<td>' + list.examSequence + '</td>';
			html += '	<td>' + list.examName + '</td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-detail glyphicon glyphicon-search"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-delete-view" class="manage-rating-delete glyphicon glyphicon-remove"></span></button></td>';
			html += '</tr>';
			return html;
		}
		
		$.ajax(contextPath + "/data/manage/rating/" + csatSequence + ".json", {
			dataType : "json",
			type : "GET",
			success : function (data) {
				if (data.list != null) {
					var list = data.list;
					var listLength = list.length;
					for (var index = 0; index < listLength; index++) {
						$('.manage-rating-row').append(makeRatingRow(list[index]));
					}
					$('.manage-rating-modify').on("click", function () {
						examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/exam/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data) {
								if (data.detail != null) {
									var detail = data.detail;
									$('.manage-rating-modify-view').remove();
									$('#manage-rating-modify-view-detail').append(makeModifyView(detail[0]));
								}
							}
						});
					});
					$('.manage-rating-delete').on("click", function () {
						examSequence = $(this).attr("id");
						$.ajax(contextPath + "/data/rating/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data) {
								var count = data.count;
								$('.manage-rating-delete-view').remove();
								$('#manage-rating-delete-view-detail').append(makeDeleteMessage(count));
								$('.manage-rating-delete-accept').on("click", function() {
									console.log("들어옴");
									$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
										dataType : "json",
										type : "DELETE",
										data : {_method : "DELETE"},
										success : function () {
											$('#manage-rating-row-data-' + examSequence).remove();
											$('#manage-rating-delete-view').modal("hide");
										}
									});
								});
							}
						});
					});
				}
			}
		});
		
		var makeCreateView = function (list) {
			var listLength = list.length;
			var html = '';
			html += '<div class="modal-content manage-rating-create-view">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">등급컷 추가</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-create-rating-cut">모의고사 이름</label>';
			html += '			<div class="col-lg-6">';
			html += '				<select class="form-control" id="manage-rating-create-rating-cut">';
			for (var index = 0; index < listLength; index++) {
				html += '<option value="' + list[index].examSequence + '">' + list[index].examName + '</option>';
			}
			html += '				</select>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-create-file">파일 첨부</label>';
			html += '			<div class="col-lg-6"><input type="file" id="manage-rating-create-file"></div>';
			html += '		</div>';
			html +=	'	</div>';
			html += '	<div class="modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary">확인</button>';
			html += '	</div>';
			html +=	'</div>';
			return html;
		}
		
		$('#manage-rating-create').on("click", function () {
			$.ajax(contextPath + "/data/manage/rating/" + csatSequence + ".json", {
				dataType : "json",
				type : "GET",
				success : function (data) {
					if (data.listForCreate != null) {
						var list = data.listForCreate;
						$('.manage-rating-create-view').remove();
						$('#manage-rating-create-view-detail').append(makeCreateView(list));
					}
				}
			});
		});
		
		var makeModifyView = function (detail) {
			var html = '';
			html += '<div class="modal-content manage-rating-modify-view">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">등급컷 수정</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-rating-label">모의고사 이름</label>';
			html += '			<div class="col-lg-6">' + detail.examName + '</div>';
			html += '		</div>';
			html += '		<div class="form-group row">';
			html += '			<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-modify-file">파일 첨부</label>';
			html += '			<div class="col-lg-6"><input type="file" id="manage-rating-modify-file"></div>';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary">확인</button>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeDeleteMessage = function (count) {
			var html = '';
			html += '<div class="modal-content manage-rating-delete-view">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">등급컷 삭제</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			if (count > 0) {
				html += '<p class="manage-rating-delete-alert"><b>이 등급컷은 ' + count + '명의 학생이 성적을 등록했습니다.</b></p>';
			}
			html += '		<p>정말로 이 등급컷을 삭제하시겠습니까?</p>';
			html += '	</div>';
			html += '	<div class="modal-footer">';
			html += '		<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">닫기</button>';
			html += '		<button type="button" class="btn btn-primary manage-rating-delete-accept">확인</button>';
			html += '	</div>';
			html += '</div>';
			console.log("출력끝남");
			return html;
		}
	});
</script>