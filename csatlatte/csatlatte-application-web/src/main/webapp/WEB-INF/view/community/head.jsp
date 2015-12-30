<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/form.jsp" %>
<style>
	.community-write-btn {text-align:right;}
	.community-write-text {padding:0;}
	.community-write-text textarea {width:100%; resize:none; border:none; padding-top:5px;}
	
	.community-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-comment-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top; position:absolute;}
	
	.community-text .communuty-text-info {display:inline-block; margin-left:3px;}
	.community-text .community-name {font-size:12px; display:inline;}
	.community-text .community-name strong, .community-text  .community-name xmp {display:inline-block;}
	.community-text .community-calender {font-size:12px; color:gray;}
	.community-text .community-action {display:inline-block; vertical-align:top; text-align:right; float:right;}
	.community-text .community-text-content {padding-top:15px;}
	.community-text .community-text-comment-info {padding-left:44px; display:inline-block; width:100%;}
	.community-text .community-text-comment-write-div {padding-left:44px;}
	.community-text xmp {white-space: pre-wrap; word-break: break-all;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var firstCommunitySequence;
	var lastCommunitySequence;
	
	var format = function(ymdhms) {
		return ymdhms.substring(0, 4) + "-" + ymdhms.substring(4, 6) + "-" + ymdhms.substring(6, 8) + " " + ymdhms.substring(8, 10) + ":" + ymdhms.substring(10, 12) + ":" + ymdhms.substring(12, 14);
	};
	
	var makeCommunityHtml = function(community, show) {
		if (show === undefined) {
			show = true;
		}
		var html = '<div class="panel panel-default community-text" id="community-' +  community.communitySequence + '" ' + (!show ? "style='display:none;'" : '') + '>';
		html += '	<div class="panel-body">';
		html += '		<div class="community-action">';
		if (studentSequence === community.studentSequence) {
			html += '			<button type="button" class="community-delete btn btn-default close"><span class="glyphicon glyphicon-remove"></span></button>';
		} else if (studentSequence !== 0) {
			html += '			<button type="button" class="community-report btn btn-default close"><span class="glyphicon glyphicon-bell"></span></button>';
		}
		html += '		</div>';
		html += '		<img alt="프로필사진" class="community-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
		html += '		<div class="communuty-text-info">';
		html += '			<div class="community-name"><strong>' + community.nickname + '</strong></div>';
		html += '			<div class="community-calender">' + format(community.writeYmdhms) + '</div>';
		html += '		</div>';
		html += '		<div class="community-text-content"><xmp>' + community.content + '</xmp></div>';
		html += '	</div>';
		html += '	<div class="panel-footer community-text-comment-write">';
		html += '		<img alt="프로필사진" class="community-comment-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png"/>';
		html += '		<div class="community-text-comment-write-div">';
		html += '			<label for="community-text-comment-write-input-' + community.communitySequence + '" class="sr-only">댓글을 입력하세요.</label>';
		html += '			<input id="community-text-comment-write-input-' + community.communitySequence + '" type="text" class="form-control" placeholder="댓글을 입력하세요." maxlength="140"/>';
		html += '		</div>';
		html += '	</div>';
		html += '</div>';
		return html;
	};
	
	var makeCommentHtml = function(communitySequence, comment, show) {
		if (show === undefined) {
			show = true;
		}
		var html = '<div class="panel-footer community-text-comment" id="community-comment-' + communitySequence + '-' + comment.commentSequence + '" ' + (!show ? "style='display:none;'" : '') + '>';
		html += '	<img alt="프로필사진" class="community-comment-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png"/>';
		html += '	<div class="community-text-comment-info">';
		html += '		<div class="community-action">';
		html += '			<div class="dropdown">';
		if (studentSequence === comment.studentSequence) {
			html += '			<button type="button" class="community-comment-delete btn btn-default close"><span class="glyphicon glyphicon-remove"></span></button>';
		} else if (studentSequence !== 0) {
			html += '			<button type="button" class="btn btn-default close"><span class="glyphicon glyphicon-bell"></span></button>';
		}
		html += '			</div>';
		html += '		</div>';
		html += '		<div class="community-name">';
		html += '			<strong>' + comment.nickname + '</strong> <xmp>' + comment.content + '</xmp>';
		html += '		</div>';
		html += '		<div class="community-calender">' + format(comment.writeYmdhms) + '</div>';
		html += '	</div>';
		html += '</div>';
		return html;
	};
	
	var ajaxComment = function(communitySequence, callback) {
		$.ajax(contextPath + "/data/community/comment.json", {
			dataType : "json",
			type : "GET",
			data : {
				communitySequence : communitySequence
			},
			success : function(data) {
				callback(data);
			}
		});
	}
	
	var makeComment = function(communitySequence, callback) {
		ajaxComment(communitySequence, function(data) {
			if (data.list != null) {
				var commentList =  data.list;
				var commentListLength = commentList.length;
				for (var index = 0; index < commentListLength; index++) {
					$(makeCommentHtml(communitySequence, commentList[index])).insertBefore($("#community-" + communitySequence + " .community-text-comment-write"));
				}
			}
			if (callback) {
				callback(communitySequence);
			}
		});
	};

	var refreshComment = function(communitySequence) {
		ajaxComment(communitySequence, function(data) {
			if (data.list != null) {
				var commentList =  data.list;
				var commentListLength = commentList.length;
				for (var index = 0; index < commentListLength; index++) {
					var comment = commentList[index];
					if ($("#community-comment-" + communitySequence + "-" + comment.commentSequence).length === 0) {
						$(makeCommentHtml(communitySequence, comment, false)).insertBefore($("#community-" + communitySequence + " .community-text-comment-write"));
						$("#community-comment-" + communitySequence + "-" + comment.commentSequence).slideDown("fast");
						addCommentDeleteEvent(communitySequence, comment.commentSequence);
					}
				}
			}
		});
	}
	
	var addCommunityDeleteEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-delete").on("click", function() {
			$.ajax(contextPath + "/data/community/" + communitySequence + ".json", {
				dataType : "json",
				type : "DELETE",
				data : {
					_method : "DELETE"
				},
				success : function(data) {
					if (data.result) {
						$("#community-" + communitySequence).slideUp("normal", function() {
							$(this).remove();
						});
					}
				}
			});
		});
	};
	
	
	var addCommunityReportEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-report").on("click", function() {
			$("#community-report").modal("show");
			console.log($("#community-report-form").attr("action"));
			var action = $("#community-report-form").attr("action");
			console.log(action.substring(0, action.lastIndexOf("/") + 1) + communitySequence + ".json");
			$("#community-report-form").attr("action", action.substring(0, action.lastIndexOf("/") + 1) + communitySequence + ".json");
		});
	}
	
	var addCommentWriteEvent = function(communitySequence) {
		$("#community-text-comment-write-input-" + communitySequence).on("keyup", function(event) {
			var $this = $(this);
			if (event.which === 13 && $.trim($(this).val()) != "") {
				$.ajax(contextPath + "/data/community/comment.json", {
					dataType : "json",
					type : "POST",
					data : {
						communitySequence : communitySequence,
						content : $(this).val()
					},
					success : function(data) {
						if (data.result) {
							refreshComment(communitySequence);
							$this.val("");
						}
					}
				});
			}
		});
	};
	
	var addCommentsDeleteEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-text-comment").each(function() {
			var id = $(this).attr("id");
			addCommentDeleteEvent(communitySequence, id.substring(id.lastIndexOf("-") + 1));
		});
	};
	
	var addCommentDeleteEvent = function(communitySequence, commentSequence) {
		$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-comment-delete").on("click", function() {
			$.ajax(contextPath + "/data/community/comment/" + communitySequence + "/" + commentSequence +  ".json", {
				dataType : "json",
				type : "DELETE",
				data : {
					_method : "DELETE"
				},
				success : function(data) {
					if (data.result) { 
						$("#community-comment-" + communitySequence + "-" + commentSequence).slideUp("fast", function() {
							$(this).remove();
						});
					}
				}
			});
			return false;
		});
	};
	
	var addCommunityAndCommentEvent = function(communitySequence) {
		addCommunityDeleteEvent(communitySequence);
		addCommunityReportEvent(communitySequence);
		addCommentWriteEvent(communitySequence);
		addCommentsDeleteEvent(communitySequence);
	};
	
	var ajaxCommunity = function(data, callback) {
		$.ajax(contextPath + "/data/community.json", {
			dataType : "json",
			type : "GET",
			data : data,
			success : function(data) {
				callback(data);
			}
		});
	};
	
	var makeCommunityAndComments = function(start) {
		if (start === undefined) {
			start = -1;
		}
		ajaxCommunity({
			start : start
		}, function(data) {
			if (data.list != null) {
				var communityList = data.list;
				var communityListLength = communityList.length;
				for (var index = 0; index < communityListLength; index++) {
					var community = communityList[index];
					$(".community-list").append(makeCommunityHtml(community));
					makeComment(community.communitySequence, function(communitySequence) {
						addCommunityAndCommentEvent(communitySequence);
					});
				}
				if (start === -1) {
					firstCommunitySequence = communityList[0].communitySequence;
				}
				lastCommunitySequence = communityList[communityListLength - 1].communitySequence;
			} else {
				lastCommunitySequence = 1;
			}
		});
	};
	
	var refreshCommunityAndComment = function() {
		ajaxCommunity({
			end : firstCommunitySequence,
			limit : -1
		}, function(data) {
			if (data.list != null) {
				var communityList = data.list;
				var communityListLength = communityList.length;
				for (var index = 0; index < communityListLength; index++) {
					var community = communityList[index];
					if ($("#community-" + community.communitySequence).length == 0) {
						$(".community-text:first").before(makeCommunityHtml(community, false));
						makeComment(community.communitySequence, function(communitySequence) {
							addCommunityAndCommentEvent(communitySequence);
							$("#community-" + communitySequence).slideDown();
						});
					}
				}
				firstCommunitySequence = communityList[0].communitySequence;
			}
		});
	};
	
	var minuteRefresh = function() {
		setTimeout(function() {
			refreshCommunityAndComment();
			minuteRefresh();
		}, 60000);
	};

	$(window).scroll(function() {
		if ($(window).scrollTop() === ($(document).height() - $(window).height()) && lastCommunitySequence > 1) {
			makeCommunityAndComments(lastCommunitySequence - 1);
		}
	});

	$("#community-write-content").on("keyup", function() {
		if ($(this).val() != "") {
			$("#community-write-submit").attr("disabled", false);
		} else {
			$("#community-write-submit").attr("disabled", true);
		}
	});
	
	$("#community-write-submit").on("click", function() {
		$.ajax(contextPath + "/data/community.json", {
			dataType : "json",
			type : "POST",
			data : {
				content : $("#community-write-content").val()
			},
			success : function(data) {
				if (data.result) {
					$("#community-write-submit").attr("disabled", true);
					$("#community-write-content").val("");
					refreshCommunityAndComment();
				}
			}
		});
	});
	
	$("#community-report-form").ajaxForm({
		dataType : "json",
		success : function(data) {
			if (data.result) {
				var action = $("#community-report-form").attr("action");
				$("#community-" + action.substring(action.lastIndexOf("/") + 1, action.lastIndexOf(".")) + " .community-report").fadeOut("normal", function() {
					$(this).remove();
				});
				$("#community-report").modal("hide");
			} else {
				// 실패 처리..
			}
		}
	});

	makeCommunityAndComments();
	minuteRefresh();
});
</script>