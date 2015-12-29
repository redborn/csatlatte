<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="container">
	<h2 style="color:#7a6253;">커뮤니티</h2>
</div>
<div style="border-top: 1px solid #7a6253; border-bottom: 1px solid #7a6253; padding:10px; margin-bottom:10px;">
	<div class="container">
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a href="#">전체 글</a></li>
			<li role="presentation"><a href="#">내가 작성한 글</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-12 community-list">
			<div id="community-write" class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">글 작성</h3>
				</div>
				<div class="panel-body community-write-text">
					<textarea id="community-write-content" rows="5" class="form-control" placeholder="무슨일이 있으셨나요?" maxlength="140"></textarea>
				</div>
				<div class="panel-footer community-write-btn">
					<input id="community-write-submit" type="submit" class="btn btn-default" value="게시" disabled="disabled"/>
				</div>
			</div>
		</div>
	</div>
</div>