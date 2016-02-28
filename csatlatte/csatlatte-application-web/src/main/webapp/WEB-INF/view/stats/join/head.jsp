<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/google/chart.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.stats-join-form-control {margin-left:5px; display:inline-block; float:none; width:auto; height:30px;}
	#stats-join-daily-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-join-monthly-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-join-annual-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	.stats-join-col-lg-6 {float:none; display:inline-block;}
	#stats-join-daily-datepicker {width:auto;}
	#stats-join-monthly-datepicker {width:auto;}
	#stats-join-annual-datepicker {width:auto;}
	.stats-join-input-group {display:inline-block; margin-top:4px;}
	.stats-join-input-group-addon {width:auto;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var dailyJoinDataTable;
		var monthlyJoinDataTable;
		var annualJoinDataTable;
		
		var statsJoinDailyChart;
		var statsJoinMonthlyChart;
		var statsJoinAnnualChart;
		
		var statsJoinDailyOptions = {
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
				title:'가입자 수',
				minValue:0,
				format:'',
				viewWindow:{
					min:0,
				},
			}
		};
		
		var statsJoinMonthlyOptions = {
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
				title:'가입자 수',
				minValue:0,
				format:'',
				viewWindow:{
					min:0,
				},
			}
		};
		
		var statsJoinAnnualOptions = {
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
				title:'가입자 수',
				minValue:0,
				format:'',
				viewWindow:{
					min:0,
				},
			}
		};
		
		$('#stats-join-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-join-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-join-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		
		$('#stats-join-daily-datepicker').datepicker("setDate", new Date());
		$('#stats-join-monthly-datepicker').datepicker("setDate", new Date());
		$('#stats-join-annual-datepicker').datepicker("setDate", new Date());
		
		$('#stats-join-daily-datepicker').on("changeDate", function() {
			dailyJoinDataTable = new google.visualization.DataTable();
			dailyJoinDataTable.addColumn("string", "hour");
			dailyJoinDataTable.addColumn("number", "가입자 수");
			$.ajax(contextPath + "/data/student/join/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {
					ymd : $('#stats-join-daily-datepicker').val()
				},
				success : function(data) {
					if (data.dailyJoin != null) {
						var dailyJoinList = data.dailyJoin;
						var dailyJoinLength = dailyJoinList.length;
						for (var index = 0; index < dailyJoinLength; index++) {
							var dailyJoin = dailyJoinList[index];
							dailyJoinDataTable.addRow([dailyJoin.key.toString(), dailyJoin.count]);
						}
						statsJoinDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-daily-chart'));
						statsJoinDailyOptions.animation.duration = 2000;
						statsJoinDailyChart.draw(dailyJoinDataTable, statsJoinDailyOptions);
					}
				}
			});
		});
		
		$('#stats-join-monthly-datepicker').on("changeMonth", function() {
			setTimeout(function () {
				monthlyJoinDataTable = new google.visualization.DataTable();
				monthlyJoinDataTable.addColumn("string", "day");
				monthlyJoinDataTable.addColumn("number", "가입자 수");
				$.ajax(contextPath + "/data/student/join/stats/monthly.json", {
					dataType : "json",
					type : "GET",
					data : {
						ym : $('#stats-join-monthly-datepicker').val()
					},
					success : function(data) {
						if (data.monthlyJoin != null) {
							var monthlyJoinList = data.monthlyJoin;
							var monthlyJoinLength = monthlyJoinList.length;
							for (var index = 0; index < monthlyJoinLength; index++) {
								var monthlyJoin = monthlyJoinList[index];
								monthlyJoinDataTable.addRow([monthlyJoin.key.toString(), monthlyJoin.count]);
							}
							statsJoinMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-monthly-chart'));
							statsJoinMonthlyOptions.animation.duration = 2000;
							statsJoinMonthlyChart.draw(monthlyJoinDataTable, statsJoinMonthlyOptions);
						}
					}
				});
			}, 1);
		});
		
		$('#stats-join-annual-datepicker').on("changeYear", function () {
			setTimeout(function () {
				annualJoinDataTable = new google.visualization.DataTable();
				annualJoinDataTable.addColumn("string", "month");
				annualJoinDataTable.addColumn("number", "가입자 수");
				$.ajax(contextPath + "/data/student/join/stats/annual.json", {
					dataType : "json",
					type : "GET",
					data : {
						year : $('#stats-join-annual-datepicker').val()
					},
					success : function(data) {
						if (data.annualJoin != null) {
							var annualJoinList = data.annualJoin;
							var annualJoinLength = annualJoinList.length;
							for (var index = 0; index < annualJoinLength; index++) {
								var annualJoin = annualJoinList[index];
								annualJoinDataTable.addRow([annualJoin.key.toString(), annualJoin.count]);
							}
							statsJoinAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-join-annual-chart'));
							statsJoinAnnualOptions.animation.duration = 2000;
							statsJoinAnnualChart.draw(annualJoinDataTable, statsJoinAnnualOptions);
						}
					}
				});
			}, 1);
		});
		
		$(window).resize(function() {
			if (statsJoinDailyChart != null) {
				statsJoinDailyOptions.animation.duration = 0;
				statsJoinDailyChart.draw(dailyJoinDataTable, statsJoinDailyOptions);				
			}
			if (statsJoinMonthlyChart != null) {
				statsJoinMonthlyOptions.animation.duration = 0;
				statsJoinMonthlyChart.draw(monthlyJoinDataTable, statsJoinMonthlyOptions);				
			}
			if (statsJoinAnnualChart != null) {
				statsJoinAnnualOptions.animation.duration = 0;
				statsJoinAnnualChart.draw(annualJoinDataTable, statsJoinAnnualOptions);
			}
		});
		
		$('#stats-join-daily-datepicker').trigger("changeDate");
		$('#stats-join-monthly-datepicker').trigger("changeMonth");
		$('#stats-join-annual-datepicker').trigger("changeYear");
	});
</script>
