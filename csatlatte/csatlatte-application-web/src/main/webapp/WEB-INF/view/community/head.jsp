<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<style>
	.community-write-btn {text-align:right;}
	.community-write-text {padding:0;}
	.community-write-text textarea {width:100%; resize:none; border:none; padding-top:5px;}
	
	.community-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-comment-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top; position:absolute;}
	
	.community-text .communuty-text-info {display:inline-block; margin-left:3px;}
	.community-text .community-name {font-size:12px; display:inline;}
	.community-text .community-calender {font-size:12px; color:gray;}
	.community-text .community-dropdown {display:inline-block; vertical-align:top; text-align:right; float:right;}
	.community-text .community-dropdown ul {margin-left:-150px;}
	.community-text .community-text-content {padding-top:15px;}
	.community-text .community-text-comment-info {padding-left:44px; display:inline-block; width:100%;}
	.community-text .community-text-comment-write-div {padding-left:44px;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var lastCommunitySequence;
	
	var format = function(ymdhms) {
		return ymdhms.substring(0, 4) + "-" + ymdhms.substring(4, 6) + "-" + ymdhms.substring(6, 8) + " " + ymdhms.substring(8, 10) + ":" + ymdhms.substring(10, 12) + ":" + ymdhms.substring(12, 14);
	};
	
	var makeCommunityHtml = function(community) {
		var html = '<div class="panel panel-default community-text" id="community-' +  community.communitySequence + '">';
		html += '	<div class="panel-body">';
		html += '		<div class="community-dropdown">';
		html += '			<div class="dropdown">';
		html += '				<a id="community-text-menu" href="#" class="dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-menu-down"></span></a>';
		html += '				<ul class="dropdown-menu" aria-labelledby="community-text-menu">';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 글을 수정하고 싶어요.</a></li>';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-trash"></span> 글을 삭제할래요.</a></li>';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-bell"></span> 신고하기</a></li>';
		html += '				</ul>';
		html += '			</div>';
		html += '		</div>';
		html += '		<img alt="프로필사진" class="community-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
		html += '		<div class="communuty-text-info">';
		html += '			<div class="community-name"><strong>' + community.nickname + '</strong></div>';
		html += '			<div class="community-calender">' + format(community.writeYmdhms) + '</div>';
		html += '		</div>';
		html += '		<div class="community-text-content">' + community.content + '</div>';
		html += '	</div>';
		html += '	<div class="panel-footer community-text-comment-write">';
		html += '		<img alt="프로필사진" class="community-comment-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png"/>';
		html += '		<div class="community-text-comment-write-div">';
		html += '			<label for="community-text-comment-write-input" class="sr-only">댓글을 입력하세요.</label>';
		html += '			<input id="community-text-comment-write-input" type="text" class="form-control" placeholder="댓글을 입력하세요." maxlength="140"/>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		return html;
	};
	
	var makeCommentHtml = function(comment) {
		var html = '<div class="panel-footer community-text-comment">';
		html += '	<img alt="프로필사진" class="community-comment-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png"/>';
		html += '	<div class="community-text-comment-info">';
		html += '		<div class="community-dropdown">';
		html += '			<div class="dropdown">';
		html += '				<a id="community-text-menu" href="#" class="dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-menu-down"></span></a>';
		html += '				<ul class="dropdown-menu" aria-labelledby="community-text-menu">';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> 글을 수정하고 싶어요.</a></li>';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-trash"></span> 글을 삭제할래요.</a></li>';
		html += '					<li><a href="#"><span class="glyphicon glyphicon-bell"></span> 신고하기</a></li>';
		html += '				</ul>';
		html += '			</div>';
		html += '		</div>';
		html += '		<div class="community-name">';
		html += '			<strong>' + comment.nickname + '</strong> ' + comment.content;
		html += '		</div>';
		html += '		<div class="community-calender">' + format(comment.writeYmdhms) + '</div>';
		html += '	</div>';
		html += '</div>';
		return html;
	};
	
	var makeComments = function(communitySequence) {
		$.ajax(contextPath + "/data/community/comment.json", {
			dataType : "json",
			type : "GET",
			data : {
				communitySequence : communitySequence
			},
			success : function(data) {
				if (data.list != null) {
					var commentList =  data.list;
					var commentListLength = commentList.length;
					for (var index = 0; index < commentListLength; index++) {
						$(makeCommentHtml(commentList[index])).insertBefore($("#community-" + communitySequence + " .community-text-comment-write"));
					}
				}
			}
		});
	};

	$.ajax(contextPath + "/data/community.json", {
		dataType : "json",
		type : "GET",
		success : function(data) {
			if (data.list != null) {
				var communityList = data.list;
				var communityListLength = communityList.length;
				for (var index = 0; index < communityListLength; index++) {
					var community = communityList[index];
					$(".community-list").append(makeCommunityHtml(community));
					makeComments(community.communitySequence);
				}
				lastCommunitySequence = communityList[communityListLength - 1].communitySequence;
			}
		}
	});
});
</script>