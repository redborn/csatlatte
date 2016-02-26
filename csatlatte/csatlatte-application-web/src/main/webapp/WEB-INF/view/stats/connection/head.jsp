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
		
		$('#stats-connection-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-connection-daily-datepicker').datepicker("setDate", new Date());
		$('#stats-connection-daily-datepicker').on("change", function () {
			ymd = $('#stats-connection-daily-datepicker').val();
			var dailyConnectionDataTable = new google.visualization.DataTable();
			dailyConnectionDataTable.addColumn("string", "hour");
			dailyConnectionDataTable.addColumn("number", "접속자 수");
			$.ajax(contextPath + "/data/student/connection/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyConnection != null) {
						var dailyConnectionList = data.dailyConnection;
						var dailyConnectionLength = dailyConnectionList.length;
						for (var index = 0; index < dailyConnectionLength; index++) {
							var dailyConnection = dailyConnectionList[index];
							dailyConnectionDataTable.addRow([dailyConnection.key.toString(), dailyConnection.count]);
						}
						var statsConnectionDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-daily-chart'));
						statsConnectionDailyChart.draw(dailyConnectionDataTable, statsConnectionDailyOptions);
						
						$(window).resize(function() {
							statsConnectionDailyOptions.animation.duration = 0;
							statsConnectionDailyChart.draw(dailyConnectionDataTable, statsConnectionDailyOptions);
						});
					}
				}
			});
		});
		$('#stats-connection-daily-datepicker').trigger("change");
		
		$('#stats-connection-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-connection-monthly-datepicker').datepicker("setDate", new Date());
		$('#stats-connection-monthly-datepicker').on("change", function () {
			ym = $('#stats-connection-monthly-datepicker').val();
			var monthlyConnectionDataTable = new google.visualization.DataTable();
			monthlyConnectionDataTable.addColumn("string", "day");
			monthlyConnectionDataTable.addColumn("number", "접속자 수");
			$.ajax(contextPath + "/data/student/connection/stats/monthly.json" , {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyConnection != null) {
						var monthlyConnectionList = data.monthlyConnection;
						var monthlyConnectionLength = monthlyConnectionList.length;
						for (var index = 0; index < monthlyConnectionLength; index++) {
							var monthlyConnection = monthlyConnectionList[index];
							monthlyConnectionDataTable.addRow([monthlyConnection.key.toString(), monthlyConnection.count]);
						}
						var statsConnectionMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-monthly-chart'));
						statsConnectionMonthlyChart.draw(monthlyConnectionDataTable, statsConnectionMonthlyOptions);
						
						$(window).resize(function() {
							statsConnectionMonthlyOptions.animation.duration = 0;
							statsConnectionMonthlyChart.draw(monthlyConnectionDataTable, statsConnectionMonthlyOptions);
						});
					}
				}
			});			
		});
		$('#stats-connection-monthly-datepicker').trigger("change");
		
		$('#stats-connection-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-connection-annual-datepicker').datepicker("setDate", new Date());
		$('#stats-connection-annual-datepicker').on("change", function() {
			year = $('#stats-connection-annual-datepicker').val();
			var annualConnectionDataTable = new google.visualization.DataTable();
			annualConnectionDataTable.addColumn("string", "month");
			annualConnectionDataTable.addColumn("number", "접속자 수");
			$.ajax(contextPath + "/data/student/connection/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualConnection != null) {
						var annualConnectionList = data.annualConnection;
						var annualConnectionLength = annualConnectionList.length;
						for (var index = 0; index < annualConnectionLength; index++) {
							var annualConnection = annualConnectionList[index];
							annualConnectionDataTable.addRow([annualConnection.key.toString(), annualConnection.count]);
						}
						var statsConnectionAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-connection-annual-chart'));
						statsConnectionAnnualChart.draw(annualConnectionDataTable, statsConnectionAnnualOptions);
						
						$(window).resize(function() {
							statsConnectionAnnualOptions.animation.duration = 0;
							statsConnectionAnnualChart.draw(annualConnectionDataTable, statsConnectionAnnualOptions);
						});
					}
				}
			});
		});
		$('#stats-connection-annual-datepicker').trigger("change");
	});
</script>
