<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/google/chart.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<%@ include file="/WEB-INF/layout/include/banner/250x250.jsp" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<style>
	#grade-analysis-rating-average-chart {height:500px; margin-top:20px;}
	#grade-analysis-standard-score-chart {height:500px; margin-top:20px;}
	.grade-analysis-add-score {margin-left:15px; margin-top:5px; font-size:13px;}
</style>

<script type="text/javascript">
var id = "<session:id/>";

$(document).ready(function() {

	var ratingAverageChart;
	var standardScoreChart;
	var ratingAverageOption = {
		chartArea : {
			left : 50,
			top : 10,
			width : '90%',
			height : '80%'
		},
		title : "등급 평균",
		vAxis: {
			title : "등급 평균",
			minValue : 1.0,
			maxValue : 9.0,
			baseline : 9.0,
			direction : -1,
			gridlines : {
				count:9
			}
		},
		animation : {
			duration : 0
		}
	};
	var standardScoreOption = {
		chartArea : {
			left : 50,
			top : 10,
			width : '90%',
			height : '80%'
		},
		title : "표준점수 합계",
		vAxis: {
			title : "표준 점수 합계",
			gridlines : {
				count:9
			},
			minValue : 1
		},
		animation : {
			duration : 0
		}
	};
	
	var ratingAverageDataTable = new google.visualization.DataTable();
	ratingAverageDataTable.addColumn("string", "examName");
	ratingAverageDataTable.addColumn("number", "등급 평균");
	
	var standardScoreDataTable = new google.visualization.DataTable();
	standardScoreDataTable.addColumn("string", "examName");
	standardScoreDataTable.addColumn("number", "표준 점수 합계");
	
	$.ajax(contextPath + "/" + id + "/data/grade/rating.json", {
		dataType : "json",
		success : function(data) {
			if (data && data.list) {
				var list = data.list;
				var listLength = list.length;
				for (var index = 0; index < listLength; index++) {
					var ratingAverage = list[index];
					ratingAverageDataTable.addRow([ratingAverage.examName, ratingAverage.ratingAverage]);
				}
				ratingAverageChart = new google.visualization.LineChart(document.getElementById('grade-analysis-rating-average-chart'));
				ratingAverageChart.draw(ratingAverageDataTable, ratingAverageOption);
			}
		}
	});
	$.ajax(contextPath + "/" + id + "/data/grade/standardscore.json", {
		dataType : "json",
		success : function(data) {
			if (data && data.list) {
				var list = data.list;
				var listLength = list.length;
				for (var index = 0; index < listLength; index++) {
					var standardScore = list[index];
					standardScoreDataTable.addRow([standardScore.examName, standardScore.standardScoreSum]);
				}
				standardScoreChart = new google.visualization.LineChart(document.getElementById('grade-analysis-standard-score-chart'));
				standardScoreChart.draw(standardScoreDataTable, standardScoreOption);
			}
		}
	});
	$(window).resize(function() {
		ratingAverageChart.draw(ratingAverageDataTable, ratingAverageOption);
		standardScoreChart.draw(standardScoreDataTable, standardScoreOption);
	});
	
});
</script>