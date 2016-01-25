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
	#manage-rating-detail-view-detail {width:900px; height:1000px;}
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
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-detail-view" class="manage-rating-detail glyphicon glyphicon-search"></span></button></td>';
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
						$.ajax(contextPath + "/data/exam/studentscore/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							success : function (data) {
								if (data.listExamStudent != null) {
									var count = data.listExamStudent.length;
									$('.manage-rating-delete-view').remove();
									$('#manage-rating-delete-view-detail').append(makeDeleteMessage(count));
									$('.manage-rating-delete-accept').on("click", function() {
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
							}
						});
					});
					$('.manage-rating-detail').on("click", function () {
						examSequence = $(this).attr("id");
						var list1, list2, list3;
						$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
							dataType : "json",
							type : "GET",
							data : {lowerRatingCode : 1, upperRatingCode : 3},
							success : function (data) {
								if (data.list != null) {
									list1 = data.list;
									$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
										dataType : "json",
										type : "GET",
										data : {lowerRatingCode : 4, upperRatingCode : 6},
										success : function (data) {
											if (data.list != null) {
												list2 = data.list;
												$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
													dataType : "json",
													type : "GET",
													data : {lowerRatingCode : 7, upperRatingCode : 9},
													success : function (data) {
														if (data.list != null) {
															list3 = data.list;
															$('.manage-rating-detail-view').remove();
															$('#manage-rating-detail-view-detail').append(makeRatingCutView(list1, list2, list3));
														}
													}
												});
											}
										}
									});
								}
							}
						});
					});
				}
			}
		});
		
		$('#manage-rating-csat-list').on("change", function () {
			csatSequence = $('#manage-rating-csat-list').val();
			$('.manage-rating-row-data').remove();
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
							$.ajax(contextPath + "/data/exam/studentscore/" + csatSequence + "/" + examSequence + ".json", {
								dataType : "json",
								type : "GET",
								success : function (data) {
									if (data.listExamStudent != null) {
										var count = data.listExamStudent.length;
										$('.manage-rating-delete-view').remove();
										$('#manage-rating-delete-view-detail').append(makeDeleteMessage(count));
										$('.manage-rating-delete-accept').on("click", function() {
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
								}
							});
						});
						$('.manage-rating-detail').on("click", function () {
							examSequence = $(this).attr("id");
							var list1, list2, list3;
							$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
								dataType : "json",
								type : "GET",
								data : {lowerRatingCode : 1, upperRatingCode : 3},
								success : function (data) {
									if (data.list != null) {
										list1 = data.list;
										$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
											dataType : "json",
											type : "GET",
											data : {lowerRatingCode : 4, upperRatingCode : 6},
											success : function (data) {
												if (data.list != null) {
													list2 = data.list;
													$.ajax(contextPath + "/data/manage/rating/" + csatSequence + "/" + examSequence + ".json", {
														dataType : "json",
														type : "GET",
														data : {lowerRatingCode : 7, upperRatingCode : 9},
														success : function (data) {
															if (data.list != null) {
																list3 = data.list;
																$('.manage-rating-detail-view').remove();
																$('#manage-rating-detail-view-detail').append(makeRatingCutView(list1, list2, list3));
															}
														}
													});
												}
											}
										});
									}
								}
							});
						});
					}
				}
			});
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
			return html;
		}
		
		var makeRatingCutView = function (list1, list2, list3) {
			var html = '';
			var list1Length = list1.length;
			var list2Length = list2.length;
			var list3Length = list3.length;
			html += '<div class="modal-content manage-rating-detail-view">';
			html += '	<div class="modal-header">';
			html += '		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			html += '		<h4 class="modal-title">등급컷 조회</h4>';
			html += '	</div>';
			html += '	<div class="modal-body">';
			html += '		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">';
			html += '			<ol class="carousel-indicators">';
			html += '				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>';
			html += '				<li data-target="#carousel-example-generic" data-slide-to="1"></li>';
			html += '				<li data-target="#carousel-example-generic" data-slide-to="2"></li>';
			html += '			</ol>';
			html += '			<div class="carousel-inner" role="listbox">';
			html += '				<div class="item active">';
			html += '					<img src="' + contextPath + '/resources/csatlatte/images/header/bg_test.png" alt="등급컷 배경사진">';
			html += '					<div class="carousel-caption">';
			html += '						<table class="table table-bordered table-hover">';
			html += '							<thead>';
			html += '								<tr>';
			html += '									<th rowspan="2">과목</th>';
			html += '									<th colspan="2">1등급</th>';
			html += '									<th colspan="2">2등급</th>';
			html += '									<th colspan="2">3등급</th>';
			html += '								</tr>';
			html += '								<tr>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '								</tr>';
			html += '							</thead>';
			html += '							<tbody>';
			var index = 0;
			var index2 = 0;
			while (index < list1Length) {
				html += '<tr>';
				html += '	<td>' + list1[index].subjectName + '</td>';
				while (index2 < index + 3) {
					html += '	<td>' + list1[index2].rawScore + '</td>';
					html += '	<td>' + list1[index2].standardScore + '</td>';
					index2++;
				}
				html += '</tr>'
				index = index + 3;
			}
			html += '							</tbody>';
			html += '						</table>';
			html += '					</div>';
			html += '				</div>';
			html += '				<div class="item">';
			html += '					<img src="' + contextPath + '/resources/csatlatte/images/header/bg_test.png" alt="등급컷 배경사진">';
			html += '					<div class="carousel-caption">';
			html += '						<table class="table table-bordered table-hover">';
			html += '							<thead>';
			html += '								<tr>';
			html += '									<th rowspan="2">과목</th>';
			html += '									<th colspan="2">4등급</th>';
			html += '									<th colspan="2">5등급</th>';
			html += '									<th colspan="2">6등급</th>';
			html += '								</tr>';
			html += '								<tr>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '								</tr>';
			html += '							</thead>';
			html += '							<tbody>';
			index = 0;
			index2 = 0;
			while (index < list1Length) {
				html += '<tr>';
				html += '	<td>' + list2[index].subjectName + '</td>';
				while (index2 < index + 3) {
					html += '	<td>' + list2[index2].rawScore + '</td>';
					html += '	<td>' + list2[index2].standardScore + '</td>';
					index2++;
				}
				html += '</tr>'
				index = index + 3;
			}
			html += '							</tbody>';
			html += '						</table>';
			html += '					</div>';
			html += '				</div>';
			html += '				<div class="item">';
			html += '					<img src="' + contextPath + '/resources/csatlatte/images/header/bg_test.png" alt="등급컷 배경사진">';
			html += '					<div class="carousel-caption">';
			html += '						<table class="table table-bordered table-hover">';
			html += '							<thead>';
			html += '								<tr>';
			html += '									<th rowspan="2">과목</th>';
			html += '									<th colspan="2">7등급</th>';
			html += '									<th colspan="2">8등급</th>';
			html += '									<th colspan="2">9등급</th>';
			html += '								</tr>';
			html += '								<tr>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '									<th>원점수</th>';
			html += '									<th>표준점수</th>';
			html += '								</tr>';
			html += '							</thead>';
			html += '							<tbody>';
			index = 0;
			index2 = 0;
			while (index < list1Length) {
				html += '<tr>';
				html += '	<td>' + list3[index].subjectName + '</td>';
				while (index2 < index + 3) {
					html += '	<td>' + list3[index2].rawScore + '</td>';
					html += '	<td>' + list3[index2].standardScore + '</td>';
					index2++;
				}
				html += '</tr>'
				index = index + 3;
			}
			html += '							</tbody>';
			html += '						</table>';
			html += '					</div>';
			html += '				</div>';
			html += '			</div>';
			html += '			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">';
			html += '				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>';
			html += '				<span class="sr-only">Previous</span>';
			html += '			</a>';
			html += '			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">';
			html += '				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>';
			html += '				<span class="sr-only">Next</span>';
			html += '			</a>';
			html += '		</div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
	});
</script>