<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/jqplot.jsp" %>
<style>
	#grade-analysis-rating-average-chart {width:600px; height:500px;}
	#grade-analysis-standard-score-chart {width:600px; height:500px;}
	.grade-analysis-add-score {margin-left:15px; margin-top:5px; font-size:13px;}
</style>
<script type="text/javascript" src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization','version':'1','packages':['corechart']}]}"></script>

<script type="text/javascript">
	var drawChart = function () {
		var ratingAverageData = google.visualization.arrayToDataTable ([
			['Year', '등급 평균'], 
			['2004', 1.4],
			['2005', 1.2], 
			['2006', 1.6],
			['2007', 2.432],
			['2008', 1.1] 
		]);
	
		var ratingAverageOptions = {
			title:'등급 평균 변화 그래프',
			vAxis:{baseline:1.0, baseline:9.0, direction:-1, gridlines:{count:9},},
			curveType:'function',
			legend:{position:'none'}
		};
	
		var ratingAverageChart = new google.visualization.LineChart(document.getElementById('grade-analysis-rating-average-chart'));
	
		ratingAverageChart.draw(ratingAverageData, ratingAverageOptions);
		
		var standardScoreData = google.visualization.arrayToDataTable([
			['Year', '표준점수'], 
			['2004', 432],
			['2005', 416], 
			['2006', 389],
			['2007', 279],
			['2008', 553] 
		]);
		
		var standardScoreOptions = {
			title:'표준점수 변화 그래프',
			vAxis:{gridlines:{count:9}},
			curveType:'function',
			legend:{position:'none'}
		};
		
		var standardScoreChart = new google.visualization.LineChart(document.getElementById('grade-analysis-standard-score-chart'));
		
		standardScoreChart.draw(standardScoreData, standardScoreOptions);
	}
	
	google.setOnLoadCallback(drawChart);
</script>