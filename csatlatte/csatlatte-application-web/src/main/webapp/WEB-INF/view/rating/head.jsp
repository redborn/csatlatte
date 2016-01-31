<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<style>
	h5 {margin-top:0px; margin-bottom:10px;}
	.panel {width:933px; margin:auto; overflow:hidden;}
	.panel .panel-body {font-size:13px;}
	.rating-select-yearstudent-list {margin-left:20px; margin-bottom:20px;}
	.rating-select-year-list {margin-left:20px; margin-bottom:20px;}
	.rating-select-exam-list img {margin-left:20px; width:100px;}
	.rating-examcut {position:relative; margin-top:30px; width:100%; min-width:933px; height:auto; background:#EEEEEE; padding-top:15px; padding-bottom:15px; overflow:hidden; display:none;}
	.rating-examcut .rating-animate-panel {position:relative; width:4000px; height:auto; overflow:hidden;}
	.rating-examcut .rating-animate-panel .table {width:900px; display:inline-block;}
	.table tr {width:auto;}
	.table tr th {text-align:center; font-size:13px; width:120px;}
	.table tr td {text-align:center; font-size:13px; width:120px;}
	.table thead tr th {vertical-align:middle;}
	.rating-btn-next {cursor:pointer; position:absolute; top:55px; right:50px;}
	.rating-btn-prev {cursor:pointer; position:absolute; top:55px; left:50px;}
	.container-examcut {padding-left:0px; padding-right:0px; text-align:left; margin-bottom:30px;}
	.rating-select-year-resource {background:none; border:none;}
	.rating-select-yearstudent-resource {background:none; border:none;}
	.rating-select-exam-resource {background:none; border:none;}
</style>
<script>
	$(document).ready(function () {
		
		var yearStudentSequence;
		var csatSequence;
		
		$('.rating-select-yearstudent-resource').on("click", function () {
			yearStudentSequence = $(this).val();
			$('.rating-select-year').slideDown("fast");
			if($('.rating-select-exam').not(":hidden")) {
				$('.rating-select-exam').slideUp("fast");
			}
			$('.rating-examcut').fadeTo(200,0);
			setTimeout(function () {
				$('.container-examcut').remove();
			}, 200);
		});
		
		var makeExam = function (exam) {
			var html = '';
			html += '<button class="rating-select-exam-resource" value="' + exam.examSequence + '">' + exam.examName + '</button>';
			return html;
		}
		
		$('.rating-select-year-resource').on("click", function () {
			csatSequence = $(this).val();
			$('.rating-select-exam-resource').remove();
			$.ajax(contextPath + "/data/rating/exam/" + yearStudentSequence + "/" + csatSequence + ".json", {
				dataType : "json",
				type : "GET",
				success : function (data) {
					if (data.list != null) {
						var examList = data.list;
						var examListLength = examList.length;
						for (var index = 0; index < examListLength; index++) {
							$('.rating-select-exam-list').append(makeExam(examList[index]));
						}
					} 
				}
			});
			$('.rating-select-exam').slideDown("fast");
			$('.rating-examcut').fadeTo(200,0);
			setTimeout(function () {
				$('.container-examcut').remove();
			}, 200);
		});
		
		var tableIndex = 0;
		var examcut = '<div class="container-fluid container-examcut">';
		examcut += '	<div class="rating-examcut">';
		examcut += '		<div class="rating-animate-panel">';
		examcut += '			<table class="table table-hover table-bordered">';
		examcut += '				<thead>';
		examcut += '					<tr>';
		examcut += '						<th rowspan="2">과목</th>';
		examcut += '						<th colspan="3">1등급</th>';
		examcut += '						<th colspan="3">2등급</th>';
		examcut += '						<th colspan="3">3등급</th>';
		examcut += '					</tr>';
		examcut += '					<tr>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '					</tr>';
		examcut += '				</thead>';
		examcut += '				<tbody>';
		examcut += '					<tr>';
		examcut += '						<td>국어A</td>';
		examcut += '						<td>98</td>';
		examcut += '						<td>124</td>';
		examcut += '						<td>96</td>';
		examcut += '						<td>94</td>';
		examcut += '						<td>121</td>';
		examcut += '						<td>87</td>';
		examcut += '						<td>89</td>';
		examcut += '						<td>117</td>';
		examcut += '						<td>77</td>';
		examcut += '					</tr>';
		examcut += '				</tbody>';
		examcut += '			</table>';
		examcut += '			<table class="table table-hover table-bordered">';
		examcut += '				<thead>';
		examcut += '					<tr>';
		examcut += '						<th rowspan="2">과목</th>';
		examcut += '						<th colspan="3">4등급</th>';
		examcut += '						<th colspan="3">5등급</th>';
		examcut += '						<th colspan="3">6등급</th>';
		examcut += '					</tr>';
		examcut += '					<tr>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '					</tr>';
		examcut += '				</thead>';
		examcut += '				<tbody>';
		examcut += '					<tr>';
		examcut += '						<td>국어A</td>';
		examcut += '						<td>98</td>';
		examcut += '						<td>124</td>';
		examcut += '						<td>96</td>';
		examcut += '						<td>94</td>';
		examcut += '						<td>121</td>';
		examcut += '						<td>87</td>';
		examcut += '						<td>89</td>';
		examcut += '						<td>117</td>';
		examcut += '						<td>77</td>';
		examcut += '					</tr>';
		examcut += '				</tbody>';
		examcut += '			</table>';
		examcut += '			<table class="table table-hover table-bordered">';
		examcut += '				<thead>';
		examcut += '					<tr>';
		examcut += '						<th rowspan="2">과목</th>';
		examcut += '						<th colspan="3">7등급</th>';
		examcut += '						<th colspan="3">8등급</th>';
		examcut += '						<th colspan="3">9등급</th>';
		examcut += '					</tr>';
		examcut += '					<tr>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '						<th>원점수</th>';
		examcut += '						<th>표준점수</th>';
		examcut += '						<th>백분위</th>';
		examcut += '					</tr>';
		examcut += '				</thead>';
		examcut += '				<tbody>';
		examcut += '					<tr>';
		examcut += '						<td>국어A</td>';
		examcut += '						<td>98</td>';
		examcut += '						<td>124</td>';
		examcut += '						<td>96</td>';
		examcut += '						<td>94</td>';
		examcut += '						<td>121</td>';
		examcut += '						<td>87</td>';
		examcut += '						<td>89</td>';
		examcut += '						<td>117</td>';
		examcut += '						<td>77</td>';
		examcut += '					</tr>';
		examcut += '				</tbody>';
		examcut += '			</table>';
		examcut += '		</div>';
		examcut += '		<img alt="왼쪽 보기" class="rating-btn-prev" src="<c:url value="/resources/csatlatte/images/btn/btn_left.png"/>">';
		examcut += '		<img alt="오른쪽 보기" class="rating-btn-next" src="<c:url value="/resources/csatlatte/images/btn/btn_right.png"/>">';
		examcut += '	</div>';
		examcut += '</div>';
		var tableMarginLeft = ($(window).width() - $('.table').width()) / 2;
		$('.rating-animate-panel').css({"margin-left":tableMarginLeft + "px"});
		
		$(".rating-select-year").hide();
		$(".rating-select-exam").hide();
		
		var moveNextSlider = function (tableIndex) {
			var willMoveLeft = -(tableIndex * 904);
			$('.table').eq(tableIndex-1).fadeTo(300, 0.2);
			$('.table').eq(tableIndex).fadeTo(300, 1);
			$('.rating-animate-panel').animate({left:willMoveLeft}, 'normal');
		}
		
		var movePrevSlider = function (tableIndex) {
			var willMoveLeft = -(tableIndex * $('.table').width());
			$('.table').eq(tableIndex+1).fadeTo(300, 0.2);
			$('.table').eq(tableIndex).fadeTo(300, 1);
			$('.rating-animate-panel').animate({left:willMoveLeft}, 'normal');
		}
		
		$('.rating-select-exam-resource').on("click", function() {
			$('.rating-examcut').fadeTo(0,0);
			$('.rating-examcut').css({display:"none"});
			$('.container-examcut').remove();
			tableIndex = 0;
				
			$(examcut).insertBefore($("footer"));
			
			var tableMarginLeft = ($(window).width() - $('.table').width()) / 2;
			$('.rating-animate-panel').css({"margin-left":tableMarginLeft + "px"});
			
			$('.table').each(function (index) {
				$(this).fadeTo(0, 0.2);
			});
			
			$('.table').eq(0).fadeTo(600, 1);
			
			$('.rating-btn-next').on("click", function () {
				if (tableIndex < 2) {
					tableIndex = tableIndex + 1;
					moveNextSlider(tableIndex);	
				}
			});
			
			$('.rating-btn-prev').on("click", function () {
				if (tableIndex > 0) {
					tableIndex = tableIndex - 1;
					movePrevSlider(tableIndex);	
				}
			});
			
			$('.rating-examcut').fadeTo(500,1);
		});
		
		$(window).scroll(function () {
			var moveBtn = $(window).scrollTop() + 20;
			if ($(this).scrollTop() >= 100) {
				$('.rating-btn-prev').delay(0).animate({top:moveBtn + "px"},0);
				$('.rating-btn-next').delay(0).animate({top:moveBtn + "px"},0);
			} else {
				$('.rating-btn-prev').css({top:"55px"});
				$('.rating-btn-next').css({top:"55px"});
			}
		});
		
		$(window).resize(function () {
			if ($(window).width() > 933) {
				var tableMarginLeft = ($(window).width() - $('.table').width()) / 2;
				$('.rating-animate-panel').css({"margin-left":tableMarginLeft + "px"});
			} else {
				$('.rating-animate-panel').css({"margin-left":"18px"});
			}
		});
	});
</script>