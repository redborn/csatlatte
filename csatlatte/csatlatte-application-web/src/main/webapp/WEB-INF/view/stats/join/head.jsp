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
		var ymd = '';
		var ym = '';
		var year = '';
		
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
		$('#stats-join-daily-datepicker').datepicker("setDate", new Date());
		$('#stats-join-daily-datepicker').on("change", function() {
			ymd = $('#stats-join-daily-datepicker').val();
			var dailyJoinDataTable = new google.visualization.DataTable();
			dailyJoinDataTable.addColumn("string", "hour");
			dailyJoinDataTable.addColumn("number", "가입자 수");
			$.ajax(contextPath + "/data/student/join/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyJoin != null) {
						var dailyJoinList = data.dailyJoin;
						var dailyJoinLength = dailyJoinList.length;
						for (var index = 0; index < dailyJoinLength; index++) {
							var dailyJoin = dailyJoinList[index];
							dailyJoinDataTable.addRow([dailyJoin.key.toString(), dailyJoin.count]);
							
						}
						var statsJoinDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-daily-chart'));
						statsJoinDailyChart.draw(dailyJoinDataTable, statsJoinDailyOptions);
						
						$(window).resize(function() {
							statsJoinDailyOptions.animation.duration = 0;
							statsJoinDailyChart.draw(dailyJoinDataTable, statsJoinDailyOptions);
						});
					}
				}
			});
		});
		$('#stats-join-daily-datepicker').trigger("change");
		
		$('#stats-join-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-join-monthly-datepicker').datepicker("setDate", new Date());
		$('#stats-join-monthly-datepicker').on("change", function() {
			ym = $('#stats-join-monthly-datepicker').val();
			var monthlyJoinDataTable = new google.visualization.DataTable();
			monthlyJoinDataTable.addColumn("string", "day");
			monthlyJoinDataTable.addColumn("number", "가입자 수");
			$.ajax(contextPath + "/data/student/join/stats/monthly.json", {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyJoin != null) {
						var monthlyJoinList = data.monthlyJoin;
						var monthlyJoinLength = monthlyJoinList.length;
						for (var index = 0; index < monthlyJoinLength; index++) {
							var monthlyJoin = monthlyJoinList[index];
							monthlyJoinDataTable.addRow([monthlyJoin.key.toString(), monthlyJoin.count]);
						}
						var statsJoinMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-monthly-chart'));
						statsJoinMonthlyChart.draw(monthlyJoinDataTable, statsJoinMonthlyOptions);
						
						$(window).resize(function() {
							statsJoinMonthlyOptions.animation.duration = 0;
							statsJoinMonthlyChart.draw(monthlyJoinDataTable, statsJoinMonthlyOptions);
						});
					}
				}
			});
		});
		$('#stats-join-monthly-datepicker').trigger("change");
		
		$('#stats-join-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-join-annual-datepicker').datepicker("setDate", new Date());
		$('#stats-join-annual-datepicker').on("change", function () {
			year = $('#stats-join-annual-datepicker').val();
			var annualJoinDataTable = new google.visualization.DataTable();
			annualJoinDataTable.addColumn("string", "month");
			annualJoinDataTable.addColumn("number", "가입자 수");
			$.ajax(contextPath + "/data/student/join/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualJoin != null) {
						var annualJoinList = data.annualJoin;
						var annualJoinLength = annualJoinList.length;
						for (var index = 0; index < annualJoinLength; index++) {
							var annualJoin = annualJoinList[index];
							annualJoinDataTable.addRow([annualJoin.key.toString(), annualJoin.count]);
						}
						var statsJoinAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-join-annual-chart'));
						statsJoinAnnualChart.draw(annualJoinDataTable, statsJoinAnnualOptions);
						
						$(window).resize(function() {
							statsJoinAnnualOptions.animation.duration = 0;
							statsJoinAnnualChart.draw(annualJoinDataTable, statsJoinAnnualOptions);
						});
					}
				}
			});
		});
		$('#stats-join-annual-datepicker').trigger("change");
	});
</script>
