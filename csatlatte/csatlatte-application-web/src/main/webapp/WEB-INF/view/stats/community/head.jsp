<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<style>
	h5 {display:inline-block;}
	.input-group .form-control {margin-left:5px; display:inline-block; float:none; width:100px; height:30px;}
	#stats-community-daily-chart {width:600px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-monthly-chart {width:600px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-annual-chart {width:600px; height:400px; margin-top:15px; margin-left:15px;}
	
	.btn-default {width:100%; display:block;}
</style>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#stats-community-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-community-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-community-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
	});

	google.load("visualization", "1", {packages: ["corechart"]});
	var drawChart = function() {
		var statsCommunityDailyData = google.visualization.arrayToDataTable([
			[ '시간', '커뮤니티 활성' ], [ '00', 165 ], [ '01', 165 ], [ '02', 157 ],
			[ '03', 157 ], [ '04', 139 ], [ '05', 139 ], [ '06', 167 ],
			[ '07', 101 ], [ '08', 193 ], [ '09', 124 ], [ '10', 163 ],
			[ '11', 112 ], [ '12', 181 ], [ '13', 119 ], [ '14', 138 ],
			[ '15', 110 ], [ '16', 100 ], [ '17', 192 ], [ '18', 181 ],
			[ '19', 137 ], [ '20', 148 ], [ '21', 189 ], [ '22', 112 ],
			[ '23', 110 ], [ '24', 12 ] ]);

		var statsCommunityDailyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};
		
		var statsCommunityDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-daily-chart'));
		statsCommunityDailyChart.draw(statsCommunityDailyData, statsCommunityDailyOptions);
		
		var statsCommunityMonthlyData = google.visualization.arrayToDataTable([
			[ '날짜', '커뮤니티 활성' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ], [ '13', 181 ], [ '14', 119 ], [ '15', 138 ],
			[ '16', 110 ], [ '17', 100 ], [ '18', 192 ], [ '19', 137 ], 
			[ '20', 148 ], [ '21', 189 ], [ '22', 112 ], [ '23', 110 ], 
			[ '24', 148 ], [ '25', 189 ], [ '26', 112 ], [ '27', 110 ], 
			[ '28', 148 ], [ '29', 189 ], [ '30', 112 ]]);

		var statsCommunityMonthlyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsCommunityMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-monthly-chart'));
		statsCommunityMonthlyChart.draw(statsCommunityMonthlyData, statsCommunityMonthlyOptions);

		var statsCommunityAnnualData = google.visualization.arrayToDataTable([
			[ '날짜', '커뮤니티 활성' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ]]);

		var statsCommunityAnnualOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsCommunityAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-community-annual-chart'));
		statsCommunityAnnualChart.draw(statsCommunityAnnualData, statsCommunityAnnualOptions);
	};
	google.setOnLoadCallback(drawChart);
</script>