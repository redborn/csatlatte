<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/form.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.manage-rating-col-lg {text-align:center;}
	.manage-rating-btn-align {text-align:right;}
	.manage-rating-icon {float:none;}
	#manage-rating-table {margin-top:15px; text-align:center;}
	.manage-rating-label {text-align:right;}
	.manage-rating-delete-alert {color:#d9534f;}
	.manage-rating-detail-table thead tr th {text-align:center; vertical-align:middle;}
	.manage-rating-carousel-caption {position:static; color:black; text-shadow:none;}
	.manage-rating-carousel-left-button {left:0; right:auto;}
	.manage-rating-carousel-right-button {right:0; left:auto;}
	.manage-rating-detail {cursor:pointer;}
</style>
<script>
	$(document).ready(function () {
		
		var csatSequence = $('#manage-rating-csat-list').val();
		var examSequence;
		
		var makeRatingRow = function (list) {
			var html = '';
			html += '<tr class="manage-rating-row-data">';
			html += '	<td>' + list.examSequence + '</td>';
			html += '	<td><div id="' + list.examSequence + '" class="manage-rating-detail">' + list.examName + '</div></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-modify-view" class="manage-rating-modify glyphicon glyphicon-pencil"></span></button></td>';
			html += '	<td><button type="button" class="btn btn-default close manage-rating-icon"><span id="' + list.examSequence + '" data-toggle="modal" data-target="#manage-rating-delete-view" class="manage-rating-delete glyphicon glyphicon-remove"></span></button></td>';
			html += '</tr>';
			return html;
		}
		
		$('#manage-rating-csat-list').on("change", function () {
			csatSequence = $('#manage-rating-csat-list').val();
			$('.manage-rating-row-data').remove();
			$('.manage-rating-cut-info').remove();
			$.ajax(contextPath + "/data/rating/" + csatSequence + ".json", {
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
										
										var $btn;
										$('#manage-rating-modify-accept').on("click", function () {
											$btn = $(this).button('loading');
											$('.manage-rating-modify-cancel').attr("disabled", true);
											var action = $('.manage-rating-modify-form').attr("action");
											$('.manage-rating-modify-form').attr("action", action.substring(0, action.lastIndexOf("rating/") + 7) + csatSequence + "/" + examSequence + ".json");
										});
										$('.manage-rating-modify-form').ajaxForm({
											type : "PUT",
											success : function () {
												$btn.button('reset');
												$('#manage-rating-modify-view').modal('hide');
												$('#manage-rating-csat-list').trigger("change");
											},
											error : function () {
												$btn.button('reset');
												$('.manage-rating-modify-cancel').attr("disabled", false);
												$('#manage-rating-modify-file').tooltip("show");
												setTimeout(function () {
													$('#manage-rating-modify-file').tooltip("destroy");
												}, 1200);
											}
										});
									}
								}
							});
						});
						$('.manage-rating-delete').on("click", function () {
							examSequence = $(this).attr("id");
							$.ajax(contextPath + "/data/exam/student/score/" + csatSequence + "/" + examSequence + ".json", {
								dataType : "json",
								type : "GET",
								success : function (data) {
									if (data.examStudentList != null) {
										var count = data.examStudentList.length;
										$('.manage-rating-delete-view').remove();
										$('#manage-rating-delete-view-detail').append(makeDeleteMessage(count));
										$('.manage-rating-delete-accept').on("click", function() {
											$.ajax(contextPath + "/data/rating/" + csatSequence + "/" + examSequence + ".json", {
												dataType : "json",
												type : "DELETE",
												data : {_method : "DELETE"},
												success : function (data) {
													if (data.result) {
														$('#manage-rating-delete-view').modal("hide");
														$('#manage-rating-csat-list').trigger("change");
													}
												}
											});
										});
									}
								}
							});
						});
						$('.manage-rating-detail').on("click", function () {
							$('.manage-rating-carousel').remove();
							examSequence = $(this).attr("id");
							$.ajax(contextPath + "/data/rating/" + csatSequence + "/" + examSequence + ".json", {
								dataType : "json",
								type : "GET",
								success : function (data) {
									if (data.list != null) {
										var ratingCutList = data.list;
										$.ajax(contextPath + "/data/exam/average/" + csatSequence + "/" + examSequence + ".json", {
											dataType : "json",
											type : "GET",
											success : function (data) {
												if (data.averageList != null) {
													var averageList = data.averageList;
													$.ajax(contextPath + "/data/exam/subject/" + csatSequence + "/" + examSequence + ".json", {
														dataType : "json",
														type : "GET",
														success : function (data) {
															var subjectList = data.subjectList;
															$('.manage-rating-cut-info').remove();
															$('#manage-rating-detail-view-detail').append(makeRatingCutView(averageList, ratingCutList, subjectList));
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
		
		$('#manage-rating-csat-list').trigger("change");
		
		var makeCreateView = function (list) {
			var listLength = list.length;
			var html = '';
			html += '<div class="manage-rating-create-view">';
			html += '	<div class="form-group row">';
			html += '		<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-create-rating-cut">모의고사 이름</label>';
			html += '		<div class="col-lg-6">';
			html += '			<select class="form-control" name="examSequence" id="manage-rating-create-rating-cut">';
			for (var index = 0; index < listLength; index++) {
				html += '<option value="' + list[index].examSequence + '" name="examSequence">' + list[index].examName + '</option>';
			}
			html += '			</select>';
			html += '		</div>';
			html += '	</div>';
			html += '	<div class="form-group row">';
			html += '		<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-create-file">파일 첨부</label>';
			html += '		<div class="col-lg-6"><input type="file" name="file" id="manage-rating-create-file" data-toggle="tooltip" data-placement="bottom" title="올바르지 않은 파일입니다."></div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		$('#manage-rating-create').on("click", function () {
			$.ajax(contextPath + "/data/rating/" + csatSequence + ".json", {
				dataType : "json",
				type : "GET",
				success : function (data) {
					if (data.listForCreate != null) {
						var list = data.listForCreate;
						$('.manage-rating-create-view').remove();
						$('#manage-rating-create-view-detail').append(makeCreateView(list));
						
						$('#manage-rating-create-accept').on("click", function () {
							$btn = $(this).button('loading');
							$('.manage-rating-create-cancel').attr("disabled", true);
							var action = $('.manage-rating-create-form').attr("action");
							$('.manage-rating-create-form').attr("action", action.substring(0, action.lastIndexOf("rating/") + 7) + csatSequence + ".json");
							
						});
						$('.manage-rating-create-form').ajaxForm({
							success : function () {
								$btn.button('reset');
								$('#manage-rating-create-view').modal("hide");
								$('#manage-rating-csat-list').trigger("change");
							},
							error : function () {
								$btn.button('reset');
								$('.manage-rating-create-cancel').attr("disabled", false);
								$('#manage-rating-create-file').tooltip("show");
								setTimeout(function () {
									$('#manage-rating-create-file').tooltip("destroy");
								}, 1200);
							}
						});
					}
				}
			});
		});
		
		var makeModifyView = function (detail) {
			var html = '';
			html += '<div class="manage-rating-modify-view">';
			html += '	<div class="form-group row">';
			html += '		<label class="col-lg-3 control-label manage-rating-label">모의고사 이름</label>';
			html += '		<div class="col-lg-6">' + detail.examName + '</div>';
			html += '	</div>';
			html += '	<div class="form-group row">';
			html += '		<label class="col-lg-3 control-label manage-rating-label" for="manage-rating-modify-file">파일 첨부</label>';
			html += '		<div class="col-lg-6"><input type="file" name="file" id="manage-rating-modify-file" data-toggle="tooltip" data-placement="bottom" title="올바르지 않은 파일입니다."></div>';
			html += '	</div>';
			html += '</div>';
			return html;
		}
		
		var makeDeleteMessage = function (count) {
			var html = '';
			html += '<div class="manage-rating-delete-view">';
			if (count > 0) {
				html += '<p class="manage-rating-delete-alert"><b>이 등급컷은 ' + count + '명의 학생이 성적을 등록했습니다.</b></p>';
			}
			html += '	<p>정말로 이 등급컷을 삭제하시겠습니까?</p>';
			html += '</div>';
			return html;
		}
		
		var makeRatingCut = function (ratingCutList, startGrade) {
			var html = '';
			var index1 = 0;
			var index2 = 0;
			var ratingCutListLength = ratingCutList.length;
			html += '		<div class="item">';
			html += '			<div class="carousel-caption manage-rating-carousel-caption">';
			html += '				<table class="table table-bordered table-hover manage-rating-detail-table">';
			html += '					<thead>';
			html += '						<tr>';
			html += '							<th rowspan="2">과목</th>';
			html += '							<th colspan="2">' + startGrade + '등급</th>';
			html += '							<th colspan="2">' + (startGrade + 1) + '등급</th>';
			html += '							<th colspan="2">' + (startGrade + 2) + '등급</th>';
			html += '						</tr>';
			html += '						<tr>';
			html += '							<th>원점수</th>';
			html += '							<th>표준점수</th>';
			html += '							<th>원점수</th>';
			html += '							<th>표준점수</th>';
			html += '							<th>원점수</th>';
			html += '							<th>표준점수</th>';
			html += '						</tr>';
			html += '					</thead>';
			html += '					<tbody>';
			while (index1 < ratingCutListLength) {
				html += '<tr>';
				html += '<td>' + ratingCutList[index1].subjectName + '</td>';
				while (index2 < index1 + 3) {
					html += '<td>' + ratingCutList[index2].rawScore + '</td>';
					html += '<td>' + ratingCutList[index2].standardScore + '</td>';
					index2++;
				}
				html += '</tr>';
				index1 += 3;
			}
			html += '					</tbody>';
			html += '				</table>';
			html += '			</div>';
			html += '		</div>';
			return html;
		}
		
		var ratingCutInfo = function () {
			var subjectName;
			var rawScore;
			var standardScore;
		}
		
		var makeRatingCutList = function (ratingCutList, startGrade) {
			var index1 = 0;
			var index2 = startGrade - 1;
			var index3 = startGrade - 1;
			var ratingCutListLength = ratingCutList.length;
			var resultList = new Array();
			while (index2 < ratingCutListLength) {
				while (index3 < index2 + 3) {
					resultList[index1] = new ratingCutInfo();
					resultList[index1].subjectName = ratingCutList[index3].subjectName;
					resultList[index1].rawScore = ratingCutList[index3].rawScore;
					resultList[index1].standardScore = ratingCutList[index3].standardScore;
					index1++;
					index3++;
				}
				index2 += 9;
				index3 += 6;
			}
			return resultList;
		}
		

		var makeAverageTable = function(averageList) {
			var html = '				<table class="table table-bordered table-hover manage-rating-detail-table">';
			html += '					<thead>';
			html += '						<tr>';
			html += '							<th rowspan="2">과목</th>';
			html += '							<th rowspan="2">평균</th>';
			html += '							<th rowspan="2">표준편차</th>';
			html += '						</tr>';
			html += '					</thead>';
			html += '					<tbody>';
			if (averageList != null) {
				var averageListLength = averageList.length;
				for (var index = 0; index < averageListLength; index++) {
					html += '<tr>';
					html += '	<td>' + averageList[index].subjectName + '</td>';
					html += '	<td>' + averageList[index].average + '</td>';
					html += '	<td>' + averageList[index].standardDeviation + '</td>';
					html += '</tr>';
				}
			}
			html += '					</tbody>';
			html += '				</table>';
			return html;
		}
		
		var makeRatingCutView = function (averageList, ratingCutList, subjectList) {
			var ratingCut1 = makeRatingCutList(ratingCutList, 1);
			var ratingCut2 = makeRatingCutList(ratingCutList, 4);
			var ratingCut3 = makeRatingCutList(ratingCutList, 7);
			var html = '<div id="carousel-example-generic" class="carousel slide manage-rating-carousel manage-rating-cut-info" data-ride="carousel" data-interval="false">';
			html += '	<ol class="carousel-indicators">';
			html += '		<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>';
			html += '		<li data-target="#carousel-example-generic" data-slide-to="1"></li>';
			html += '		<li data-target="#carousel-example-generic" data-slide-to="2"></li>';
			html += '		<li data-target="#carousel-example-generic" data-slide-to="3"></li>';
			html += '		<li data-target="#carousel-example-generic" data-slide-to="4"></li>';
			html += '	</ol>';
			html += '	<div class="carousel-inner manage-rating-detail-carousel-inner" role="listbox">';		
			html += '		<div class="item active">';
			html += '			<div class="carousel-caption manage-rating-carousel-caption">';
			html += makeAverageTable(averageList);
			html += '			</div>';
			html += '		</div>';
			html += makeRatingCut(ratingCut1, 1);
			html += makeRatingCut(ratingCut2, 4);
			html += makeRatingCut(ratingCut3, 7);
			html += makeSubjectTime(subjectList);
			html += '	</div>';
			html += '	<a class="manage-rating-carousel-left-button carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">';
			html += '		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>';
			html += '		<span class="sr-only">Previous</span>';
			html += '	</a>';
			html += '	<a class="manage-rating-carousel-right-button carousel-control" href="#carousel-example-generic" role="button" data-slide="next">';
			html += '		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>';
			html += '		<span class="sr-only">Next</span>';
			html += '	</a>';
			html += '</div>';
			return html;
		}
		
		var makeSubjectTime = function (subjectList) {
			var html = '';
			html += '		<div class="item">';
			html += '			<div class="carousel-caption manage-rating-carousel-caption">';
			html += '				<table class="table table-bordered table-hover manage-rating-detail-table">';
			html += '					<thead>';
			html += '						<tr>';
			html += '							<th rowspan="2">과목</th>';
			html += '							<th rowspan="2">시험시간</th>';
			html += '						</tr>';
			html += '					</thead>';
			html += '					<tbody>';
			if (subjectList != null) {
				var subjectListLength = subjectList.length;
				for (var index = 0; index < subjectListLength; index++) {
					html += '<tr>';
					html += '	<td>' + subjectList[index].subjectName + '</td>';
					html += '	<td>' + subjectList[index].examTime + '</td>';
					html += '</tr>';
				}
			}
			html += '					</tbody>';
			html += '				</table>';
			html += '			</div>';
			html += '		</div>';
			return html;
		}
	});
</script>