<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="panel panel-default">
	<div class="panel-heading">
		<p><strong>시험은 잘 보셨나요?</strong></p>
		<p>당신의 원점수와 등급을 비교해보세요.</p>
		<p>성적관리를 이용하면 조금 더 편하게 확인할 수 있습니다.</p>
	</div>
	<div class="panel-body">
		<div class="rating-select-grade">
			<h5><strong>학년 선택</strong></h5>
			<div class="rating-select-grade-list">
				<a class="rating-select-grade-resource" href="#">1학년</a> | 
				<a class="rating-select-grade-resource" href="#">2학년</a> | 
				<a class="rating-select-grade-resource" href="#">3학년</a>
			</div>
		</div>
		<div class="rating-select-year">
			<h5><strong>연도 선택</strong></h5>
			<div class="rating-select-year-list">
				<a class="rating-select-year-resource" href="#">2011년</a> | 
				<a class="rating-select-year-resource" href="#">2012년</a> | 
				<a class="rating-select-year-resource" href="#">2013년</a> | 
				<a class="rating-select-year-resource" href="#">2014년</a> | 
				<a class="rating-select-year-resource" href="#">2015년</a>
			</div>
		</div>
		<div class="rating-select-exam">
			<h5><strong>모의고사 선택</strong></h5>
			<div class="rating-select-exam-list">
				<a class="rating-select-exam-resource" href="#"><img alt="3월모의고사" src="<c:url value="/resources/csatlatte/images/btn/btn_postit_3.png"/>"></a>
				<a class="rating-select-exam-resource" href="#"><img alt="4월모의고사" src="<c:url value="/resources/csatlatte/images/btn/btn_postit_3.png"/>"></a>
				<a class="rating-select-exam-resource" href="#"><img alt="6월모의고사" src="<c:url value="/resources/csatlatte/images/btn/btn_postit_3.png"/>"></a>
				<a class="rating-select-exam-resource" href="#"><img alt="7월모의고사" src="<c:url value="/resources/csatlatte/images/btn/btn_postit_3.png"/>"></a>
				<a class="rating-select-exam-resource" href="#"><img alt="9월모의고사" src="<c:url value="/resources/csatlatte/images/btn/btn_postit_3.png"/>"></a>
			</div>
		</div>
	</div>
</div>
<div class="rating-examcut">
	<div class="rating-animate-panel">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th rowspan="2">과목</th>
					<th colspan="3">1등급</th>
					<th colspan="3">2등급</th>
					<th colspan="3">3등급</th>
				</tr>
				<tr>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>국어A</td>
					<td>98</td>
					<td>124</td>
					<td>96</td>
					<td>94</td>
					<td>121</td>
					<td>87</td>
					<td>89</td>
					<td>117</td>
					<td>77</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th rowspan="2">과목</th>
					<th colspan="3">4등급</th>
					<th colspan="3">5등급</th>
					<th colspan="3">6등급</th>
				</tr>
				<tr>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>국어A</td>
					<td>98</td>
					<td>124</td>
					<td>96</td>
					<td>94</td>
					<td>121</td>
					<td>87</td>
					<td>89</td>
					<td>117</td>
					<td>77</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th rowspan="2">과목</th>
					<th colspan="3">7등급</th>
					<th colspan="3">8등급</th>
					<th colspan="3">9등급</th>
				</tr>
				<tr>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
					<th>원점수</th>
					<th>표준점수</th>
					<th>백분위</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>국어A</td>
					<td>98</td>
					<td>124</td>
					<td>96</td>
					<td>94</td>
					<td>121</td>
					<td>87</td>
					<td>89</td>
					<td>117</td>
					<td>77</td>
				</tr>
			</tbody>
		</table>
	</div>
	<img alt="왼쪽 보기" class="rating-btn-prev" src="<c:url value="/resources/csatlatte/images/btn/btn_left.png"/>">
	<img alt="오른쪽 보기" class="rating-btn-next" src="<c:url value="/resources/csatlatte/images/btn/btn_right.png"/>">
</div>