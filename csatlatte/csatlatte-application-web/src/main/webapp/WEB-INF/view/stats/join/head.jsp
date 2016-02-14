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
	
	.btn-default {width:100%; display:block;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var ymd = '';
		var ym = '';
		var year = '';
		
		$('#stats-join-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true
		});
		$('#stats-join-daily-datepicker').datepicker("setDate", new Date());
		ymd = $('#stats-join-daily-datepicker').val();
		$.ajax(contextPath + "/data/student/join/stats/daily.json", {
			dataType : "json",
			type : "GET",
			data : {ymd : ymd},
			success : function(data) {
				if (data.dailyJoin != null) {
					var dailyJoin = data.dailyJoin;
					drawDailyChart(dailyJoin);
				}
			}
		});
		$('#stats-join-daily-datepicker').on("change", function() {
			ymd = $('#stats-join-daily-datepicker').val();
			$.ajax(contextPath + "/data/student/join/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyJoin != null) {
						var dailyJoin = data.dailyJoin;
						drawDailyChart(dailyJoin);
					}
				}
			});
		});
		
		$('#stats-join-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-join-monthly-datepicker').datepicker("setDate", new Date());
		ym = $('#stats-join-monthly-datepicker').val();
		$.ajax(contextPath + "/data/student/join/stats/monthly.json", {
			dataType : "json",
			type : "GET",
			data : {ym : ym},
			success : function(data) {
				if (data.monthlyJoin != null) {
					var monthlyJoin = data.monthlyJoin;
					drawMonthlyChart(monthlyJoin);
				}
			}
		});
		$('#stats-join-monthly-datepicker').on("change", function() {
			ym = $('#stats-join-monthly-datepicker').val();
			$.ajax(contextPath + "/data/student/join/stats/monthly.json", {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyJoin != null) {
						var monthlyJoin = data.monthlyJoin;
						drawMonthlyChart(monthlyJoin);
					}
				}
			});
		});
		
		$('#stats-join-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-join-annual-datepicker').datepicker("setDate", new Date());
		year = $('#stats-join-annual-datepicker').val();
		$.ajax(contextPath + "/data/student/join/stats/annual.json", {
			dataType : "json",
			type : "GET",
			data : {year : year},
			success : function(data) {
				if (data.annualJoin != null) {
					var annualJoin = data.annualJoin;
					drawAnnualChart(annualJoin);
				}
			}
		});
		$('#stats-join-annual-datepicker').on("change", function () {
			year = $('#stats-join-annual-datepicker').val();
			$.ajax(contextPath + "/data/student/join/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualJoin != null) {
						var annualJoin = data.annualJoin;
						drawAnnualChart(annualJoin);
					}
				}
			});
		});
	
		var drawDailyChart = function(dailyJoin) {
			
			var data = new Array();
			var dailyJoinLength = dailyJoin.length;
			data[0] = ['시간', '가입자 수'];
			for (var index = 0; index < dailyJoinLength; index++) {
				data[index + 1] = [index.toString(), dailyJoin[index].count];
				console.log(data[index + 1]);
			}
			
			var statsJoinDailyData = google.visualization.arrayToDataTable(data);
	
			var statsJoinDailyView = new google.visualization.DataView(statsJoinDailyData);
			statsJoinDailyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
			
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
			
			var statsJoinDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-daily-chart'));
			statsJoinDailyChart.draw(statsJoinDailyView, statsJoinDailyOptions);
			google.setOnLoadCallback(drawDailyChart);
			
			$(window).resize(function() {
				statsJoinDailyChart.draw(statsJoinDailyView, statsJoinDailyOptions);
			});
		}
		
		var drawMonthlyChart = function(monthlyJoin) {
			
			var data = new Array();
			var monthlyJoinLength = monthlyJoin.length;
			data[0] = ['일', '가입자 수'];
			for (var index = 1; index <= monthlyJoinLength; index++) {
				data[index] = [index.toString(), monthlyJoin[index - 1].count];
			}
			
			var statsJoinMonthlyData = google.visualization.arrayToDataTable(data);
			
			var statsJoinMonthlyView = new google.visualization.DataView(statsJoinMonthlyData);
			statsJoinMonthlyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
			
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
	
			var statsJoinMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-join-monthly-chart'));
			statsJoinMonthlyChart.draw(statsJoinMonthlyView, statsJoinMonthlyOptions);
			google.setOnLoadCallback(drawMonthlyChart);
			
			$(window).resize(function() {
				statsJoinMonthlyChart.draw(statsJoinMonthlyView, statsJoinMonthlyOptions);
			});
		}
	
		var drawAnnualChart = function(annualJoin) {
			
			var data = new Array();
			var annualJoinLength = annualJoin.length;
			data[0] = ['월', '가입자 수'];
			for (var index = 1; index <= annualJoinLength; index++) {
				data[index] = [index.toString(), annualJoin[index - 1].count];
			}
			
			var statsJoinAnnualData = google.visualization.arrayToDataTable(data);
	
			var statsJoinAnnualView = new google.visualization.DataView(statsJoinAnnualData);
			statsJoinAnnualView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);
			
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
	
			var statsJoinAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-join-annual-chart'));
			statsJoinAnnualChart.draw(statsJoinAnnualView, statsJoinAnnualOptions);
			google.setOnLoadCallback(drawAnnualChart);
			
			$(window).resize(function() {
				statsJoinAnnualChart.draw(statsJoinAnnualView, statsJoinAnnualOptions);
			});
		}
	});
</script>
