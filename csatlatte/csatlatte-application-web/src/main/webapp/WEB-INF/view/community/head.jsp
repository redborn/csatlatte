<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.community-profile {text-align:center; margin-bottom:15px;}
	.community-profile img {width:200px; border-radius:10px; border:1px solid #7a6253; margin:auto; margin-bottom:10px;}
	.community-icon {margin-left:18px; margin-right:28px;}
	.community-icon img {display:inline;}
	.community-icon .dropdown {display:inline-block;}
	.community-icon-menu {cursor:pointer; display:inline-block; width:60px; text-align:center; margin-left:10px;}
	.community-icon .dropdown-menu {left:40px; top:40px; padding:15px; padding-top:7px;}
	.community-menu-title {font-size:13px; display:block;}
	.community-write-title {font-size:13px; display:inline;}
	.community-write-text {padding:0px;}
	.community-write-text textarea {width:100%; resize:none; border:none; padding-top:5px;}
	.community-write-text .form-control {float:none;}
	.community-btn-align-right {text-align:right;}
	.panel-footer {padding: 0 10px 10px;}
	.community-profile-picture {width:40px; height:40px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-text {text-align:left; margin:10px 0;}
	.community-text .community-name {font-size:13px; display:inline;}
	.community-text .community-calender {font-size:13px; color:gray;}
	.community-text .community-user-info {display:inline-block; margin-left:3px; width:500px;}
	.community-text .community-comment-content {font-size:13px; display:inline;}
	.dropdown {display:inline-block; vertical-align:top; text-align:right;}
	.community-text .dropdown .dropdown-menu {left:-135px; padding:15px; padding-top:7px;}
	.dropdown .dropdown-toggle {cursor:pointer;}
	.dropdown-menu-resource .dropdown-menu-message {margin-left:5px; margin-top:10px; display:inline-block;}
	.community-content {font-size:13px; display:block; margin-top:8px;}
	.community-comment {position:relative; margin-top:5px; height:40px;}
	.community-comment img {width:40px; height:40px; display:inline-block; border-radius:5px; border:1px solid #7a6253;}
	.community-comment .form-control {margin-top:3px; width:530px; display:inline-block; float:none;}
	.community-popup-background {position:absolute; display:none; width:100%; left:0px; top:0px; opacity:0; z-index:9001;}
	.community-btn-cancel {cursor:pointer; margin-right:10px;}
	.community-btn-accept {cursor:pointer;}
	.dropdown-menu-resource {cursor:pointer; margin-top:8px;}
	.modal-header .community-text .community-user-info {width:470px;}
	.community-report-reason {margin-top:10px; font-size:14px;}
	.community-report-body {margin-bottom:10px;}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		var format = function(ymdhms) {
			return ymdhms.substring(0, 4) + "-" + ymdhms.substring(4, 6) + "-" + ymdhms.substring(6, 8) + " " + ymdhms.substring(8, 10) + ":" + ymdhms.substring(10, 12) + ":" + ymdhms.substring(12, 14);
		};
		
		var makeCommunityHtml = function(community) {
			var html = '<div class="panel panel-default">';
			html += '	<div class="panel-body">';
			html += '		<div class="community-text">';
			html += '			<img alt="프로필사진" class="community-profile-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
			html += '			<div class="community-user-info">';
			html += '				<div class="community-name"><strong>' + community.nickname + '</strong></div>';
			html += '				<div class="community-calender">' + format(community.writeYmdhms) + '</div>';
			html += '			</div>';
			html += '			<div class="dropdown">';
			html += '				<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="' + contextPath +  '/resources/csatlatte/images/btn/btn_menu.png">';
			html += '				<ul class="dropdown-menu" aria-labelledby="community-text-menu">';
			html += '					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-modify"><img alt="글수정" src="' + contextPath +  '/resources/csatlatte/images/ico/ico_text_modify.png""> | 글을 수정하고 싶어요.</div></li>	';
			html += '					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-delete"><img alt="글삭제" src="' + contextPath +  '/resources/csatlatte/images/ico/ico_text_delete.png"> | 글을 삭제할레요.</div></li>';
			html += '					<li><div class="dropdown-menu-resource" data-toggle="modal" data-target="#community-text-report"><img alt="신고하기" src="' + contextPath +  '/resources/csatlatte/images/ico/ico_report.png"> | 신고하기</div></li>';
			html += '				</ul>';
			html += '			</div>';
			html += '		</div>';
			html += '		<div class="community-content">' + community.content + '</div>';
			html += '	</div>';
			html += '	<div class="panel-footer panel-comment" id="community-comment-' + community.communitySequence + '">';
			html += '		<div class="community-comment">';
			html += '			<img alt="프로필사진" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
			html += '			<input type="text" class="form-control" placeholder="댓글을 입력해주세요.">';
			html += '		</div>';
			html += '	</div>';
			html += '</div>';
			return html;
		};
		
		var makeCommentHtml = function(comment) {
			var html = '		<div class="community-text">';
			html += '			<img alt="프로필사진" class="community-profile-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
			html += '			<div class="community-user-info">';
			html += '				<div class="community-name"><strong>' + comment.nickname + '</strong></div>';
			html += '				<div class="community-comment-content">' + comment.content + '</div>';
			html += '				<div class="community-calender">' + format(comment.writeYmdhms) + '</div>';
			html += '			</div>';
			html += '			<div class="dropdown">';
			html += '				<img class="dropdown-toggle" id="community-text-menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" alt="글메뉴" src="' + contextPath +  '/resources/csatlatte/images/btn/btn_menu.png">';
			html += '				<ul class="dropdown-menu" aria-labelledby="community-text-menu">';
			html += '					<li><div class="dropdown-menu-resource">test1</div></li>';
			html += '					<li><div class="dropdown-menu-resource">test1</div></li>	';
			html += '					<li><div class="dropdown-menu-resource">test1</div></li>';
			html += '					<li><div class="dropdown-menu-resource">test1</div></li>';
			html += '				</ul>';
			html += '			</div>';
			html += '		</div>';
			return html;
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
						$(".content").append(makeCommunityHtml(community));

						$.ajax(contextPath + "/data/community/comment.json", {
							dataType : "json",
							type : "GET",
							data : {
								communitySequence : community.communitySequence
							},
							success : function(data) {
								if (data.list != null) {
									var commentList =  data.list;
									var commentListLength = commentList.length;
									for (var index = 0; index < commentListLength; index++) {
										$(makeCommentHtml(commentList[index])).insertBefore($("#community-comment-" + community.communitySequence + " .community-comment"));
									}
								}
							}
						});
					}
				}
			}
		})
	});
</script>