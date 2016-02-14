<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/google/chart.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.stats-connection-form-control {margin-left:5px; display:inline-block; float:none; width:100px; height:30px;}
	#stats-connection-daily-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-connection-monthly-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-connection-annual-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	.stats-connection-col-lg-6 {float:none; display:inline-block;}
	#stats-connection-daily-datepicker {width:auto;}
	#stats-connection-monthly-datepicker {width:auto;}
	#stats-connection-annual-datepicker {width:auto;}
	.stats-connection-input-group {display:inline-block; margin-top:4px;}
	.stats-connection-input-group-addon {width:auto;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var ymd = '';
		var ym = '';
		var year = '';
		
		$('#stats-connection-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-connection-daily-datepicker').datepicker("setDate", new Date());
		ymd = $('#stats-connection-daily-datepicker').val();
		$.ajax(contextPath + "/data/student/connection/stats/daily.json", {
			dataType : "json",
			type : "GET",
			data : {ymd : ymd},
			success : function(data) {
				if (data.dailyConnection != null) {
					var dailyConnection = data.dailyConnection;
					drawDailyChart(dailyConnection);
				}
			}
		});
		$('#stats-connection-daily-datepicker').on("change", function () {
			ymd = $('#stats-connection-daily-datepicker').val();
			$.ajax(contextPath + "/data/student/connection/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyConnection != null) {
						var dailyConnection = data.dailyConnection;
						drawDailyChart(dailyConnection);
					}
				}
			});
		});
		
		$('#stats-connection-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-connection-monthly-datepicker').datepicker("setDate", new Date());
		ym = $('#stats-connection-monthly-datepicker').val();
		$.ajax(contextPath + "/data/student/connection/stats/monthly.json" , {
			dataType : "json",
			type : "GET",
			data : {ym : ym},
			success : function(data) {
				if (data.monthlyConnection != null) {
					var monthlyConnection = data.monthlyConnection;
					drawMonthlyChart(monthlyConnection);
				}
			}
		});
		$('#stats-connection-monthly-datepicker').on("change", function () {
			ym = $('#stats-connection-monthly-datepicker').val();
			$.ajax(contextPath + "/data/student/connection/stats/monthly.json" , {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyConnection != null) {
						var monthlyConnection = data.monthlyConnection;
						drawMonthlyChart(monthlyConnection);
					}
				}
			});			
		});
		
		$('#stats-connection-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-connection-annual-datepicker').datepicker("setDate", new Date());
		year = $('#stats-connection-annual-datepicker').val();
		$.ajax(contextPath + "/data/student/connection/stats/annual.json", {
			dataType : "json",
			type : "GET",
			data : {year : year},
			success : function(data) {
				if (data.annualConnection != null) {
					var annualConnection = data.annualConnection;
					drawAnnualChart(annualConnection);
				}
			}
		});
		$('#stats-connection-annual-datepicker').on("change", function() {
			year = $('#stats-connection-annual-datepicker').val();
			$.ajax(contextPath + "/data/student/connection/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualConnection != null) {
						var annualConnection = data.annualConnection;
						drawAnnualChart(annualConnection);
					}
				}
			});
		});
		
		var drawDailyChart = function(dailyConnection) {
			
			var data = new Array();
			var dailyConnectionLength = dailyConnection.length;
			data[0] = ['시간', '접속자'];
			for (var index = 0; index < dailyConnectionLength; index++) {
				data[index + 1] = [index.toString(), dailyConnection[index].count]; 
			}
			
			var statsConnectionDailyData = google.visualization.arrayToDataTable(data);
			
			var statsConnectionDailyView = new google.visualization.DataView(statsConnectionDailyData);
			statsConnectionDailyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
	
			var statsConnectionDailyOptions = {
				chartArea:{left:50,top:10,width:'90%',height:'80%'},
				animation:{
					startup:true,
			        duration:2000,
			        easing:'out',
			    },
				legend : {
					position : 'none'
				},
				hAxis: {
					title:'시간'
				},
				vAxis: {
					title:'접속자 수',
					minValue:0,
					format:'',
					viewWindow:{
						min:0,
					},
				}
			};
			
			var statsConnectionDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-daily-chart'));
			statsConnectionDailyChart.draw(statsConnectionDailyView, statsConnectionDailyOptions);
			google.setOnLoadCallback(drawDailyChart);
			
			$(window).resize(function() {
				statsConnectionDailyOptions.animation.duration = 0;
				statsConnectionDailyChart.draw(statsConnectionDailyView, statsConnectionDailyOptions);
			});
		}
		
		var drawMonthlyChart = function(monthlyConnection) {
			var data = new Array();
			var monthlyConnectionLength = monthlyConnection.length;
			data[0] = ['날짜', '접속자'];
			for (var index = 1; index <= monthlyConnectionLength; index++) {
				data[index] = [index.toString(), monthlyConnection[index - 1].count]; 
			}
			
			var statsConnectionMonthlyData = google.visualization.arrayToDataTable(data);
			
			var statsConnectionMonthlyView = new google.visualization.DataView(statsConnectionMonthlyData);
			statsConnectionMonthlyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
	
			var statsConnectionMonthlyOptions = {
				chartArea:{left:50,top:10,width:'90%',height:'80%'},
				animation:{
					startup:true,
			        duration:2000,
			        easing:'out',
			    },
				legend : {
					position : 'none'
				},
				hAxis: {
					title:'일'
				},
				vAxis: {
					title:'접속자 수',
					minValue:0,
					format:'',
					viewWindow:{
						min:0,
					},
				}
			};
	
			var statsConnectionMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-monthly-chart'));
			statsConnectionMonthlyChart.draw(statsConnectionMonthlyView, statsConnectionMonthlyOptions);
			google.setOnLoadCallback(drawMonthlyChart);
			
			$(window).resize(function() {
				statsConnectionMonthlyOptions.animation.duration = 0;
				statsConnectionMonthlyChart.draw(statsConnectionMonthlyView, statsConnectionMonthlyOptions);
			});
		}
	
		var drawAnnualChart = function(annualConnection) {
			var data = new Array();
			var annualConnectionLength = annualConnection.length;
			data[0] = ['날짜', '접속자'];
			for (var index = 1; index <= annualConnectionLength; index++) {
				data[index] = [index.toString(), annualConnection[index - 1].count]; 
			}
			
			var statsConnectionAnnualData = google.visualization.arrayToDataTable(data);
			
			var statsConnectionAnnualView = new google.visualization.DataView(statsConnectionAnnualData);
			statsConnectionAnnualView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
	
			var statsConnectionAnnualOptions = {
				chartArea:{left:50,top:10,width:'90%',height:'80%'},
				animation:{
					startup:true,
			        duration:2000,
			        easing:'out',
			    },
				legend : {
					position : 'none'
				},
				hAxis: {
					title:'월'
				},
				vAxis: {
					title:'접속자 수',
					minValue:0,
					format:'',
					viewWindow:{
						min:0,
					},
				}
			};
	
			var statsConnectionAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-annual-chart'));
			statsConnectionAnnualChart.draw(statsConnectionAnnualView, statsConnectionAnnualOptions);
			google.setOnLoadCallback(drawAnnualChart);
			
			$(window).resize(function() {
				statsConnectionAnnualOptions.animation.duration = 0;
				statsConnectionAnnualChart.draw(statsConnectionAnnualView, statsConnectionAnnualOptions);
			});
		}
	});
</script>
