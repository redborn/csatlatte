<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<style>
	h5 {display:inline-block; vertical-align:top;}
	.form-control {margin-left:5px; display:inline-block; float:none; width:auto; height:30px;}
	#stats-join-daily-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-join-monthly-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-join-annual-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	
	.col-lg-6 {float:none; display:inline-block;}
	#stats-join-daily-datepicker {width:auto;}
	#stats-join-monthly-datepicker {width:auto;}
	#stats-join-annual-datepicker {width:auto;}
	.input-group {display:inline-block; margin-top:4px;}
	.input-group-addon {width:auto;}
	
	.btn-default {width:100%; display:block;}
</style>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#stats-join-daily-datepicker').datepicker({
			startView : 0,
			minViewMode : 0,
			autoclose : true,
			todayHighlight : true
		});
		$('#stats-join-monthly-datepicker').datepicker({
			format : "yyyy.mm",
			startView : 1,
			minViewMode : 1,
			autoclose : true
		});
		$('#stats-join-annual-datepicker').datepicker({
			format : "yyyy",
			startView : 2,
			minViewMode : 2,
			autoclose : true
		});
	});

	google.load("visualization", "1", {packages: ["corechart"]});
	var drawChart = function() {
		var statsJoinDailyData = google.visualization.arrayToDataTable([
			[ '시간', '신규가입자' ], [ '00', 165 ], [ '01', 165 ], [ '02', 157 ],
			[ '03', 157 ], [ '04', 139 ], [ '05', 139 ], [ '06', 167 ],
			[ '07', 101 ], [ '08', 193 ], [ '09', 124 ], [ '10', 163 ],
			[ '11', 112 ], [ '12', 181 ], [ '13', 119 ], [ '14', 138 ],
			[ '15', 110 ], [ '16', 100 ], [ '17', 192 ], [ '18', 181 ],
			[ '19', 137 ], [ '20', 148 ], [ '21', 189 ], [ '22', 112 ],
			[ '23', 110 ], [ '24', 12 ] ]);

		var statsJoinDailyView = new google.visualization.DataView(statsJoinDailyData);
		statsJoinDailyView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);
		
		var statsJoinDailyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			},
		};
		
		var statsJoinDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-daily-chart'));
		statsJoinDailyChart.draw(statsJoinDailyView, statsJoinDailyOptions);
		
		var statsJoinMonthlyData = google.visualization.arrayToDataTable([
			[ '날짜', '신규가입자' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ], [ '13', 181 ], [ '14', 119 ], [ '15', 138 ],
			[ '16', 110 ], [ '17', 100 ], [ '18', 192 ], [ '19', 137 ], 
			[ '20', 148 ], [ '21', 189 ], [ '22', 112 ], [ '23', 110 ], 
			[ '24', 148 ], [ '25', 189 ], [ '26', 112 ], [ '27', 110 ], 
			[ '28', 148 ], [ '29', 189 ], [ '30', 112 ]]);
		
		var statsJoinMonthlyView = new google.visualization.DataView(statsJoinMonthlyData);
		statsJoinMonthlyView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);
		
		var statsJoinMonthlyOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsJoinMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-monthly-chart'));
		statsJoinMonthlyChart.draw(statsJoinMonthlyView, statsJoinMonthlyOptions);

		var statsJoinAnnualData = google.visualization.arrayToDataTable([
			[ '날짜', '신규가입자' ], [ '1', 165 ], [ '2', 165 ], [ '3', 157 ],
			[ '4', 157 ], [ '5', 139 ], [ '6', 139 ], [ '7', 167 ],
			[ '8', 101 ], [ '9', 193 ], [ '10', 124 ], [ '11', 163 ],
			[ '12', 112 ]]);

		var statsJoinAnnualView = new google.visualization.DataView(statsJoinAnnualData);
		statsJoinAnnualView.setColumns([0,1, { 
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation" 
		}]);
		
		var statsJoinAnnualOptions = {
			chartArea:{left:30,top:10,width:'90%',height:'80%'},
			legend : {
				position : 'none'
			}
		};

		var statsJoinAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-join-annual-chart'));
		statsJoinAnnualChart.draw(statsJoinAnnualView, statsJoinAnnualOptions);
	};
	google.setOnLoadCallback(drawChart);
</script>