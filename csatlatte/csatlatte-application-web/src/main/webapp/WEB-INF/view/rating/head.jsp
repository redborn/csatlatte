<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.rating-panel h5 {margin-top:0px; margin-bottom:10px;}
	.rating-panel h4 {margin-top:2px; margin-bottom:5px;}
	.rating-select-yearstudent-list {margin-left:20px; margin-bottom:20px;}
	.rating-select-year-list {margin-left:20px; margin-bottom:20px;}
	.rating-examcut {position:relative; margin-top:30px; width:100%; min-width:933px; height:auto; background:#EEEEEE; padding-top:15px; padding-bottom:15px; overflow:hidden; display:none;}
	.rating-examcut .rating-animate-panel {position:relative; width:4000px; height:auto; overflow:hidden;}
	.rating-examcut .rating-animate-panel .table {width:900px; display:inline-block;}
	.rating-carousel-caption {position:static; color:black; text-shadow:none;}
	.rating-detail-table thead tr th {text-align:center; vertical-align:middle; width:120px;}
	.rating-detail-table {width:auto; margin:auto; margin-bottom:30px;}
	.rating-select-exam-list {margin-left:20px;}
	.rating-select-year-resource-active {background:#e8e4e1;}
	.rating-select-yearstudent-resource-active {background:#e8e4e1;}
	.rating-select-exam-resource-active {background:#e8e4e1;}
	.rating-select-year-resource {margin-right:10px;}
	.rating-select-yearstudent-resource {margin-right:7px;}
	.rating-select-exam-resource {margin-right:10px;}
	#rating-carousel .carousel-control.right {background-image:none; color:#7a6253;}
	#rating-carousel .carousel-control.left {background-image:none; color:#7a6253;}
	.rating-carousel-indicators .active {background-color:#7a6253;}
	.rating-carousel-indicators li {border:1px solid #7a6253;}
	.rating-detail-table-average thead tr th {height:76px;}
	.rating-table-view {text-align:center;}
</style>
<script>
	
	$(document).ready(function () {
		
		var yearStudentSequence;
		var year;
		
		var examSequence;
		var csatSequence;
		
		$(".rating-select-year").hide();
		$(".rating-select-exam").hide();
		
		$('.rating-title').insertBefore('.container');
		
		var makeYear = function (year) {
			var html = '';
			html += '<button class="rating-select-year-resource btn btn-default" data-loading-text="Loading..." value="' + year + '" id="rating-select-year-resource-' + year + '">' + year + '</button>';
			return html;
		}
		
		var makeExam = function (exam) {
			var html = '';
			html += '<button class="rating-select-exam-resource btn btn-default" data-loading-text="Loading..." id="' + exam.csatSequence + '" value="' + exam.examSequence + '">' + exam.examName + '</button>';
			html += '<input type="hidden" value="' + exam.ratingCutPublicYn + '" id="rating-select-exam-ratingcut-yn-' + exam.csatSequence + '-' + exam.examSequence + '">';
			return html;
		}
		
		$('.rating-select-yearstudent-resource').on("click", function (e) {
			e.preventDefault();
			yearStudentSequence = $(this).val();
			$('.rating-select-year-resource').remove();
			var $btnYearStudent = $(this).button('loading');
			$(this).addClass("rating-select-yearstudent-resource-active").siblings().removeClass("rating-select-yearstudent-resource-active");
			$.ajax(contextPath + "/data/rating/exam/" + yearStudentSequence + ".json", {
				dataType : "json",
				type : "GET",
				success : function (data) {
					if (data.yearList != null) {
						var yearList = data.yearList;
						var yearListLength = yearList.length;
						for (var index = 0; index < yearListLength; index++) {
							$('.rating-select-year-list').append(makeYear(yearList[index]));
						}
						$('.rating-select-year-resource').on("click", function () {
							year = $(this).val();
							$(this).addClass("rating-select-year-resource-active").siblings().removeClass("rating-select-year-resource-active");
							$('.rating-select-exam-resource').remove();
							var $btnYear = $(this).button('loading');
							$.ajax(contextPath + "/data/rating/exam/" + yearStudentSequence + "/" + year + ".json", {
								dataType : "json",
								type : "GET",
								success : function (data) {
									if (data.list != null) {
										var examList = data.list;
										var examListLength = examList.length;
										for (var index = 0; index < examListLength; index++) {
											$('.rating-select-exam-list').append(makeExam(examList[index]));
										}
										$('.rating-select-exam-resource').on("click", function () {
											examSequence = $(this).val();
											csatSequence = $(this).attr("id");
											$(this).addClass("rating-select-exam-resource-active").siblings().removeClass("rating-select-exam-resource-active");
											var $btnExam = $(this).button('loading');
											$('#rating-carousel').fadeTo(200,0);
											$('.rating-alert-danger').fadeTo(200,0);
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
																	setTimeout(function () {
																		$('#rating-carousel').remove();
																		$('.rating-alert-danger').remove();
																		$('.rating-table-view').append(makeRatingCutView(averageList, ratingCutList));
																		$('.rating-table-view').insertBefore('.footer');
																		$('.rating-table-view').fadeTo(0,0);
																		$('.rating-table-view').fadeTo(200,1);
																		setTimeout(function () {
																			$btnExam.button('reset');
																			setTimeout(function () {
																				$('.rating-select-exam-resource').attr("disabled", false);
																				$('.rating-select-exam-resource-active').attr("disabled", true);
																			}, 1);
																		}, 200);
																	}, 200);
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
							$('.rating-select-exam').slideUp("fast");
							$('.rating-select-exam').slideDown("fast");
							$('#rating-carousel').slideUp("steady");
							$('.rating-alert-danger').slideUp("steady");
							$('.rating-select-year-resource').attr("disabled", false);
							setTimeout(function () {
								$btnYear.button('reset');
								setTimeout(function () {
									$('.rating-select-year-resource-active').attr("disabled", true);
								}, 1);
							}, 200);
						});
					}
				}
			});
			$('.rating-select-year').slideUp("fast");
			$('.rating-select-year').slideDown("fast");
			$('.rating-select-exam').slideUp("fast");
			$('#rating-carousel').slideUp("steady");
			$('.rating-alert-danger').slideUp("steady");
			
			$('.rating-select-yearstudent-resource').attr("disabled", false);
			setTimeout(function () {
				$btnYearStudent.button('reset');
				setTimeout(function () {
					$('.rating-select-yearstudent-resource-active').attr("disabled", true);
				}, 1);
			}, 200);
		});
		
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
		
		var makeRatingCut = function (ratingCutList, startGrade) {
			var html = '';
			var index1 = 0;
			var index2 = 0;
			var ratingCutListLength = ratingCutList.length;
			html += '		<div class="item">';
			html += '			<div class="carousel-caption rating-carousel-caption">';
			html += '				<table class="table table-bordered table-striped table-hover rating-detail-table">';
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
		
		var makeAverageTable = function(averageList) {
			var html = '';
			html +=	'				<table class="table table-bordered table-hover table-striped rating-detail-table rating-detail-table-average">';
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
		
		var makeRatingCutView = function (averageList, ratingCutList) {
			var ratingCut1 = makeRatingCutList(ratingCutList, 1);
			var ratingCut2 = makeRatingCutList(ratingCutList, 4);
			var ratingCut3 = makeRatingCutList(ratingCutList, 7);
			var html = '';
			console.log(ratingCutList);
			if (ratingCutList.length == 0) {
				html += '<div class="alert alert-danger rating-alert-danger" role="alert">';
				html += '	<h4><strong>이 시험은 등급컷과 관련된 정보가 부족합니다.</strong></h4>';
				html +=	'	<p>등급컷에 대한 분석이 끝나지 않았거나 등급컷에 관련된 정보를 정리하는 중입니다.<p>';
				html += '	<p>한국교육평가원에서 주관하는 시험인 경우 해당 기관에서 성적과 관련된 자료를 공개하지 않아 예측 등급컷만 제공될 수 있습니다.</p>';
				html += '</div>';
			} else {
				html += '<div id="rating-carousel" class="carousel slide" data-ride="carousel" data-interval="false">';
				if ($('#rating-select-exam-ratingcut-yn-' + csatSequence + '-' + examSequence).val() == 'Y') {
					html += '<div class="alert alert-success rating-alert-danger" role="alert">';
					html += '	<h5>이 등급컷은 시험 주관 교육청에서 발표한 자료에 근거했습니다.</h5>';
					html += '</div>';
				} else {
					html += '<div class="alert alert-success rating-alert-danger" role="alert">';
					html += '	<h5>이 등급컷은 수능라떼에서 예측한 자료입니다.</h5>';
					html += '</div>';
				}
				html += '	<ol class="carousel-indicators rating-carousel-indicators">';
			    html += '		<li data-target="#rating-carousel" data-slide-to="0" class="active"></li>';
			    html += '		<li data-target="#rating-carousel" data-slide-to="1"></li>';
				html += '		<li data-target="#rating-carousel" data-slide-to="2"></li>';
				html += '		<li data-target="#rating-carousel" data-slide-to="3"></li>';
				html += '	</ol>';
				html += '	<div class="carousel-inner" role="listbox">';		
				html += '		<div class="item active">';
				html += '			<div class="carousel-caption rating-carousel-caption">';
				html += makeAverageTable(averageList);
				html += '			</div>';
				html += '		</div>';
				html += makeRatingCut(ratingCut1, 1);
				html += makeRatingCut(ratingCut2, 4);
				html += makeRatingCut(ratingCut3, 7);
				html += '	</div>';
				html += '	<a class="carousel-control left" href="#rating-carousel" role="button" data-slide="prev">';
				html += '		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>';
				html += '		<span class="sr-only">Previous</span>';
				html += '	</a>';
				html += '	<a class="carousel-control right" href="#rating-carousel" role="button" data-slide="next">';
				html += '		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>';
				html += '		<span class="sr-only">Next</span>';
				html += '	</a>';
				html += '</div>';
			}
			return html;
		}
	});
</script>