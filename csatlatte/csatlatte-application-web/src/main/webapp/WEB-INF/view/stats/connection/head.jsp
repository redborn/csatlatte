<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<style>
	h5 {display:inline-block;  vertical-align:top;}
	.form-control {margin-left:5px; display:inline-block; float:none; width:100px; height:30px;}
	#stats-connection-daily-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-connection-monthly-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-connection-annual-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	
	.col-lg-6 {float:none; display:inline-block;}
	#stats-connection-daily-datepicker {width:auto;}
	#stats-connection-monthly-datepicker {width:auto;}
	#stats-connection-annual-datepicker {width:auto;}
	.input-group {display:inline-block; margin-top:4px;}
	.input-group-addon {width:auto;}
	
	.btn-default {width:100%; display:block;}
</style>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#stats-connection-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-connection-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-connection-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
	});

	google.load("visualization", "1", {packages: ["corechart"]});
	var drawChart = function() {
		var statsConnectionDailyData = google.visualization.arrayToDataTable([
			[ '시간', '접속자' ], [ '00', 165 ], [ '01', 165 ], [ '02', 157 ],
			[ '03', 157 ], [ '04', 139 ], [ '05', 139 ], [ '06', 167 ],
			[ '07', 101 ], [ '08', 193 ], [ '09', 124 ], [ '10', 163 ],
			[ '11', 112 ], [ '12', 181 ], [ '13', 119 ], [ '14', 138 ],
			[ '15', 110 ], [ '16', 100 ], [ '17', 192 ], [ '18', 181 ],
			[ '19', 137 ], [ '20', 148 ], [ '21', 189 ], [ '22', 112 ],
			[ '23', 110 ], [ '24', 12 ] ]);
		
		var statsConnectionDailyView = new google.visualization.DataView(statsConnectionDailyData);
		statsConnectionDailyView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);

		var statsConnectionDailyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};
		
		var statsConnectionDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-daily-chart'));
		statsConnectionDailyChart.draw(statsConnectionDailyView, statsConnectionDailyOptions);
		
		var statsConnectionMonthlyData = google.visualization.arrayToDataTable([
			[ '날짜', '접속자' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ], [ '13', 181 ], [ '14', 119 ], [ '15', 138 ],
			[ '16', 110 ], [ '17', 100 ], [ '18', 192 ], [ '19', 137 ], 
			[ '20', 148 ], [ '21', 189 ], [ '22', 112 ], [ '23', 110 ], 
			[ '24', 148 ], [ '25', 189 ], [ '26', 112 ], [ '27', 110 ], 
			[ '28', 148 ], [ '29', 189 ], [ '30', 112 ]]);
		
		var statsConnectionMonthlyView = new google.visualization.DataView(statsConnectionMonthlyData);
		statsConnectionMonthlyView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);

		var statsConnectionMonthlyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsConnectionMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-monthly-chart'));
		statsConnectionMonthlyChart.draw(statsConnectionMonthlyView, statsConnectionMonthlyOptions);

		var statsConnectionAnnualData = google.visualization.arrayToDataTable([
			[ '날짜', '접속자' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ]]);
		
		var statsConnectionAnnualView = new google.visualization.DataView(statsConnectionAnnualData);
		statsConnectionAnnualView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);

		var statsConnectionAnnualOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsConnectionAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-annual-chart'));
		statsConnectionAnnualChart.draw(statsConnectionAnnualView, statsConnectionAnnualOptions);
	};
	google.setOnLoadCallback(drawChart);
</script>