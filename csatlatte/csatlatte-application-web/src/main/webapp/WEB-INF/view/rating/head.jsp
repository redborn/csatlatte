<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<style>
	.rating-panel h5 {margin-top:0px; margin-bottom:10px;}
	.rating-select-yearstudent-list {margin-left:20px; margin-bottom:20px;}
	.rating-select-year-list {margin-left:20px; margin-bottom:20px;}
	.rating-select-exam-list img {margin-left:20px; width:100px;}
	.rating-examcut {position:relative; margin-top:30px; width:100%; min-width:933px; height:auto; background:#EEEEEE; padding-top:15px; padding-bottom:15px; overflow:hidden; display:none;}
	.rating-examcut .rating-animate-panel {position:relative; width:4000px; height:auto; overflow:hidden;}
	.rating-examcut .rating-animate-panel .table {width:900px; display:inline-block;}
	.rating-select-year-resource {background:none; border:none;}
	.rating-select-yearstudent-resource {background:none; border:none;}
	.rating-select-exam-resource {background:none; border:none;}
	.rating-carousel-caption {position:static; color:black; text-shadow:none;}
	.rating-detail-table thead tr th {text-align:center; vertical-align:middle; width:120px;}
	.rating-detail-table {width:auto; margin:auto;}
	#rating-carousel {background:rgba(245,245,245,1);}
	.rating-select-exam-list {margin-left:20px;}
	.rating-select-year-resource-active {background:#e8e4e1;}
	.rating-select-yearstudent-resource-active {background:#e8e4e1;}
	.rating-select-exam-resource-active {background:#e8e4e1;}
</style>
<script>
	$(document).ready(function () {
		
		var yearStudentSequence;
		var year;
		
		$(".rating-select-year").hide();
		$(".rating-select-exam").hide();
		
		$('.rating-select-yearstudent-resource').on("click", function () {
			yearStudentSequence = $(this).val();
			$(this).addClass("rating-select-yearstudent-resource-active").siblings().removeClass("rating-select-yearstudent-resource-active");
			$('.rating-select-year').slideDown("fast");
			if($('.rating-select-exam').not(":hidden")) {
				$('.rating-select-exam').slideUp("fast");
			}
			$('#rating-carousel').fadeTo(200,0);
			$('.rating-select-year-resource').removeClass("rating-select-year-resource-active");
			setTimeout(function () {
				$('#rating-carousel').remove();
			}, 200);
		});
		
		var makeExam = function (exam) {
			var html = '';
			html += '<button class="rating-select-exam-resource" id="' + exam.csatSequence + '" value="' + exam.examSequence + '">' + exam.examName + '</button>';
			return html;
		}
		
		$('.rating-select-year-resource').on("click", function () {
			year = $(this).val();
			$(this).addClass("rating-select-year-resource-active").siblings().removeClass("rating-select-year-resource-active");
			$('.rating-select-exam-resource').remove();
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
							var examSequence = $(this).val();
							var csatSequence = $(this).attr("id");
							$(this).addClass("rating-select-exam-resource-active").siblings().removeClass("rating-select-exam-resource-active");
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
													$('#rating-carousel').remove();
													$('.rating-table-view').append(makeRatingCutView(averageList, ratingCutList));
													$('.rating-table-view').insertBefore('.footer');
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
			$('.rating-select-exam').slideDown("fast");
			$('#rating-carousel').remove();
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
			html += '				<table class="table table-bordered table-hover rating-detail-table">';
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
			html +=	'				<table class="table table-bordered table-hover rating-detail-table">';
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
			var html = '<div id="rating-carousel" class="carousel slide" data-ride="carousel" data-interval="false">';
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
			return html;
		}
	});
</script>