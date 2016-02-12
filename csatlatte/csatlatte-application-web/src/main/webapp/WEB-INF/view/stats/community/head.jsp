<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/google/chart.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.stats-community-form-control {margin-left:5px; display:inline-block; float:none; width:100px; height:30px;}
	#stats-community-daily-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-monthly-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-annual-chart {width:580px; height:400px; margin-top:15px; margin-left:15px;}
	.stats-community-col-lg-6 {float:none; display:inline-block;}
	#stats-community-daily-datepicker {width:auto;}
	#stats-community-monthly-datepicker {width:auto;}
	#stats-community-annual-datepicker {width:auto;}
	.stats-community-input-group {display:inline-block; margin-top:4px;}
	.stats-community-input-group-addon {width:auto;}
	
	.btn-default {width:100%; display:block;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var ymd = '';
		var ym = '';
		var year = '';

		$('#stats-community-daily-datepicker').datepicker({
			format:"yyyymmdd",
			startView:0,
			minViewMode:0,
			language:"kr",
			autoclose:true,
			todayHighlight:true,
			setDate:new Date()
		});
		$('#stats-community-daily-datepicker').datepicker("setDate", new Date());
		ymd = $('#stats-community-daily-datepicker').val();
		$.ajax(contextPath + "/data/community/stats/daily.json", {
			dataType : "json",
			type : "GET",
			data : {ymd : ymd},
			success : function(data) {
				if (data.dailyActive != null) {
					var dailyActive = data.dailyActive;
					drawDailyChart(dailyActive);
				}
			}
		});
		$('#stats-community-daily-datepicker').on("change", function () {
			ymd = $('#stats-community-daily-datepicker').val();
			$.ajax(contextPath + "/data/community/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyActive != null) {
						var dailyActive = data.dailyActive;
						drawDailyChart(dailyActive);
					}
				}
			});
		});
		
		$('#stats-community-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-community-monthly-datepicker').datepicker("setDate", new Date());
		ym = $('#stats-community-monthly-datepicker').val();
		$.ajax(contextPath + "/data/community/stats/monthly.json", {
			dataType : "json",
			type : "GET",
			data : {ym : ym},
			success : function(data) {
				if (data.monthlyActive != null) {
					var monthlyActive = data.monthlyActive;
					drawMonthlyChart(monthlyActive);
				}
			}
		});
		$('#stats-community-monthly-datepicker').on("change", function() {
			ym = $('#stats-community-monthly-datepicker').val();
			$.ajax(contextPath + "/data/community/stats/monthly.json", {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyActive != null) {
						var monthlyActive = data.monthlyActive;
						drawMonthlyChart(monthlyActive);
					}
				}
			});
		});
		
		$('#stats-community-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-community-annual-datepicker').datepicker("setDate", new Date());
		year = $('#stats-community-annual-datepicker').val();
		$.ajax(contextPath + "/data/community/stats/annual.json", {
			dataType : "json",
			type : "GET",
			data : {year : year},
			success : function(data) {
				if (data.annualActive != null) {
					var annualActive = data.annualActive;
					drawAnnualChart(annualActive);
				}
			}
		});
		$('#stats-community-annual-datepicker').on("change", function () {
			year = $('#stats-community-annual-datepicker').val();
			$.ajax(contextPath + "/data/community/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualActive != null) {
						var annualActive = data.annualActive;
						drawAnnualChart(annualActive);
					}
				}
			});
		});

		var drawDailyChart = function(dailyActive) {
			
			var data = new Array();
			var dailyActiveLength = dailyActive.length;
			data[0] = ['시간', '커뮤니티 활성'];
			for (var index = 0; index < dailyActiveLength; index++) {
				data[index + 1] = [index.toString(), dailyActive[index].count];
			}
			
			var statsCommunityDailyData = google.visualization.arrayToDataTable(data);
			
			var statsCommunityDailyView = new google.visualization.DataView(statsCommunityDailyData);
			statsCommunityDailyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);

			var statsCommunityDailyOptions = {
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
					title:'커뮤니티 활성도',
					minValue:0,
					format:'',
					viewWindow:{
						min:0,
					},
				}
			};
			
			var statsCommunityDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-daily-chart'));
			statsCommunityDailyChart.draw(statsCommunityDailyView, statsCommunityDailyOptions);
			google.setOnLoadCallback(drawDailyChart);
		}
	
		var drawMonthlyChart = function(monthlyActive) {
			
			var data = new Array();
			var monthlyActiveLength = monthlyActive.length;
			data[0] = ['날짜', '커뮤니티 활성'];
			for (var index = 1; index <= monthlyActiveLength; index++) {
				data[index] = [index.toString(), monthlyActive[index - 1].count];
			}
			
			var statsCommunityMonthlyData = google.visualization.arrayToDataTable(data);
			
			var statsCommunityMonthlyView = new google.visualization.DataView(statsCommunityMonthlyData);
			statsCommunityMonthlyView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);

			var statsCommunityMonthlyOptions = {
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
					title:'커뮤니티 활성도',
					format:'',
					minValue:0,
					viewWindow:{
						min:0
					},
				}
			};

			var statsCommunityMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-monthly-chart'));
			statsCommunityMonthlyChart.draw(statsCommunityMonthlyView, statsCommunityMonthlyOptions);
			google.setOnLoadCallback(drawMonthlyChart);
		}
		
		var drawAnnualChart = function (annualActive) {
			
			var data = new Array();
			var annualActiveLength = annualActive.length;
			data[0] = ['날짜', '커뮤니티 활성'];
			for (var index = 1; index <= annualActiveLength; index++) {
				data[index] = [index.toString(), annualActive[index - 1].count];
			}
			
			var statsCommunityAnnualData = google.visualization.arrayToDataTable(data);
			
			var statsCommunityAnnualView = new google.visualization.DataView(statsCommunityAnnualData);
			statsCommunityAnnualView.setColumns([0,1, { 
				calc: "stringify",
				sourceColumn: 1,
				type: "string",
				role: "annotation" 
			}]);

			var statsCommunityAnnualOptions = {
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
					title:'커뮤니티 활성도',
					minValue:0,
					format:'',
					viewWindow:{
						min:0
					},
				}
			};

			var statsCommunityAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-community-annual-chart'));
			statsCommunityAnnualChart.draw(statsCommunityAnnualView, statsCommunityAnnualOptions);
			google.setOnLoadCallback(drawAnnualChart);
		}
	});
</script>
