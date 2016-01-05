<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	nav {text-align:center;}
	th {text-align:center;}
	tr {text-align:center;}
	.table {margin-top:15px;}
	label {width:80px; text-align:right; display:inline-block; margin-left:10px;}
	
	.col-lg-5 {float:none; display:inline-block;}
	.manage-exam-search {text-align:right;}
	
	.manage-exam-info-content-value {margin-left:10px; display:inline-block; margin-top:5px;}
	.manage-exam-info-content-value .form-control {width:auto;}

	.manage-exam-title {display:inline-block; width:380px;}
	.manage-exam-modify {cursor:pointer;}
	.manage-exam-delete {cursor:pointer;}
	.manage-exam-btn-align {text-align:right;}
	
	.manage-exam-add {width:100px; display:inline-block;}
	
	.modal-footer {text-align:right;}
	.manage-exam-btn-cancel {cursor:pointer; margin-right:10px;}
	.manage-exam-btn-accept {cursor:pointer;}
</style>
<script>

	$(document).ready(function () {
		
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
		
		$('#manage-exam-search').val(getUrlParameter("search"));
		
		$('#manage-exam-search').on("keyup", function (event) {
			if (event.which == 13) {
				var search = $('#manage-exam-search').val();
				$(location).attr('href', '<c:url value="/manage/exam?search="/>' + search);
			}
		});
	});
	
</script>