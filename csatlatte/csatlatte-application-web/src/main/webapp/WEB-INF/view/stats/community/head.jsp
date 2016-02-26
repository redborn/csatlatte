<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/bootstrap/datepicker.jsp" %>
<%@ include file="/WEB-INF/layout/include/google/chart.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/ajax.jsp" %>
<style>
	.stats-community-form-control {margin-left:5px; display:inline-block; float:none; width:100px; height:30px;}
	#stats-community-daily-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-monthly-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	#stats-community-annual-chart {width:95%; height:400px; margin-top:15px; margin-left:15px;}
	.stats-community-col-lg-6 {float:none; display:inline-block;}
	#stats-community-daily-datepicker {width:auto;}
	#stats-community-monthly-datepicker {width:auto;}
	#stats-community-annual-datepicker {width:auto;}
	.stats-community-input-group {display:inline-block; margin-top:4px;}
	.stats-community-input-group-addon {width:auto;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var ymd = '';
		var ym = '';
		var year = '';
		
		var communityDailyChartOptions = {
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
		var communityMonthlyChartOptions = {
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
					minValue:0,
					format:'',
					viewWindow:{
						min:0,
					},
				}
			};
		var communityAnnualChartOptions = {
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
						min:0,
					},
				}
			};
		
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
		$('#stats-community-daily-datepicker').on("change", function () {
			var dailyActiveDataTable = new google.visualization.DataTable();
			dailyActiveDataTable.addColumn("string", "hour");
			dailyActiveDataTable.addColumn("number", "커뮤니티 활성");
			ymd = $('#stats-community-daily-datepicker').val();
			$.ajax(contextPath + "/data/community/stats/daily.json", {
				dataType : "json",
				type : "GET",
				data : {ymd : ymd},
				success : function(data) {
					if (data.dailyActive != null) {
						var dailyActiveList = data.dailyActive;
						var dailyActiveLength = dailyActiveList.length;
						for (var index = 0; index < dailyActiveLength; index++) {
							var dailyActive = dailyActiveList[index];
							dailyActiveDataTable.addRow([dailyActive.key.toString(), dailyActive.count]);
						}
						var statsCommunityDailyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-daily-chart'));
						statsCommunityDailyChart.draw(dailyActiveDataTable, communityDailyChartOptions);
						
						$(window).resize(function() {
							communityChartOptions.animation.duration = 0;
							statsCommunityDailyChart.draw(dailyActiveDataTable, communityDailyChartOptions);
						});
						
					}
				}
			});
		});
		$('#stats-community-daily-datepicker').trigger("change");
		
		$('#stats-community-monthly-datepicker').datepicker({
			format:"yyyymm",
			startView:1,
			minViewMode:1,
			language:"kr",
			autoclose:true
		});
		$('#stats-community-monthly-datepicker').datepicker("setDate", new Date());
		$('#stats-community-monthly-datepicker').on("change", function() {
			ym = $('#stats-community-monthly-datepicker').val();
			var monthlyActiveDataTable = new google.visualization.DataTable();
			monthlyActiveDataTable.addColumn("string", "day");
			monthlyActiveDataTable.addColumn("number", "커뮤니티 활성");
			$.ajax(contextPath + "/data/community/stats/monthly.json", {
				dataType : "json",
				type : "GET",
				data : {ym : ym},
				success : function(data) {
					if (data.monthlyActive != null) {
						var monthlyActiveList = data.monthlyActive;
						var monthlyActiveLength = monthlyActiveList.length;
						for (var index = 0; index < monthlyActiveLength; index++) {
							var monthlyActive = monthlyActiveList[index];
							monthlyActiveDataTable.addRow([monthlyActive.key.toString(), monthlyActive.count]);
						}
						var statsCommunityMonthlyChart = new google.visualization.ColumnChart(document.getElementById('stats-community-monthly-chart'));
						statsCommunityMonthlyChart.draw(monthlyActiveDataTable, communityMonthlyChartOptions);
						
						$(window).resize(function() {
							communityChartOptions.animation.duration = 0;
							statsCommunityMonthlyChart.draw(monthlyActiveDataTable, communityMonthlyChartOptions);
						});
					}
				}
			});
		});
		$('#stats-community-monthly-datepicker').trigger("change");
		
		$('#stats-community-annual-datepicker').datepicker({
			format:"yyyy",
			startView:2,
			minViewMode:2,
			language:"kr",
			autoclose:true
		});
		$('#stats-community-annual-datepicker').datepicker("setDate", new Date());
		$('#stats-community-annual-datepicker').on("change", function () {
			year = $('#stats-community-annual-datepicker').val();
			var annualActiveDataTable = new google.visualization.DataTable();
			annualActiveDataTable.addColumn("string", "month");
			annualActiveDataTable.addColumn("number", "커뮤니티 활성");
			$.ajax(contextPath + "/data/community/stats/annual.json", {
				dataType : "json",
				type : "GET",
				data : {year : year},
				success : function(data) {
					if (data.annualActive != null) {
						var annualActiveList = data.annualActive;
						var annualActiveLength = annualActiveList.length;
						for (var index = 0; index < annualActiveLength; index++) {
							var annualActive = annualActiveList[index];
							annualActiveDataTable.addRow([annualActive.key.toString(), annualActive.count]);
						}
						var statsCommunityAnnualChart = new google.visualization.ColumnChart(document.getElementById('stats-community-annual-chart'));
						statsCommunityAnnualChart.draw(annualActiveDataTable, communityAnnualChartOptions);
						
						$(window).resize(function() {
							statsCommunityAnnualOptions.animation.duration = 0;
							statsCommunityAnnualChart.draw(annualActiveDataTable, communityAnnualChartOptions);
						});
					}
				}
			});
		});
		$('#stats-community-annual-datepicker').trigger("change");
	});
</script>
