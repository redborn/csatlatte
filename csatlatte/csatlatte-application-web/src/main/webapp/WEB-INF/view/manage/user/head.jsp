<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}
	label {display:inline-block; width:80px; text-align:right;}
	.table {margin-top:15px;}
	
	.col-lg-5 {float:none; display:inline-block;}
	.manage-user-search {text-align:right;}
	
	.manage-user-title {display:inline-block; width:380px;}
	.manage-user-apply {width:50px; display:inline-block;}
	.manage-user-apply-align {text-align:right;}
	.manage-user-id {cursor:pointer;}
	
	.modal-body {text-align:center;}
	.modal-dialog {width:400px;}
	.manage-user-picture {width:100px; border-radius:5px; border:1px solid #7a6253;}
	.manage-user-info {margin-top:10px;}
	.manage-user-info-content {text-align:left; margin-left:40px; margin-top:5px;}
	.manage-user-info-content-value {margin-left:10px; display:inline-block;}
</style>
<script>
	$(document).ready(function () {
		
		var pageNumber = null;
		var search = null;
		
		var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		
		var makeStudentDataRow = function(student) {
			var html = '';
			html += '<tr>';
			html += '	<td>' + student.studentSequence + '</td>';
			html += '	<td>' + student.studentId + '</td>';
			html += '	<td>' + student.nickname + '</td>';
			html += '	<td>' + student.countConnection + '</td>';
			html += '	<td><input type="checkbox" name="blindCheck" value="'+ student.studentSequence + '"';
			if (student.useYn == 'N') {
				html += ' checked';
			}
			html += '	</td>';
			html += '	<td>' + (student.countCommunity + student.countComment) + '</td>';
			html += '	<td>' + student.averageScore + '</td>';
			html += '<tr>';
			return html;
		}
		
		pageNumber = getUrlParameter('pageNumber');
		search = getUrlParameter('search');
		
		$.ajax("<c:url value="/data/student.json"/>", {
			dataType : "json",
			type : "GET",
			data : {pageNumber : pageNumber, search : search},
			success : function(data) {
				if (data.userList != null) {
					var studentList = data.userList;
					var studentListLength = studentList.length;
					for (var index = 0; index < studentListLength; index++) {
						var student = studentList[index];
						$("#table-content").append(makeStudentDataRow(student));
					}
				}
			}
		});
		
	});
</script>