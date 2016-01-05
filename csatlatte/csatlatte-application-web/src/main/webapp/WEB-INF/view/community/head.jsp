<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layout/include/student.jsp" %>
<%@ include file="/WEB-INF/layout/include/manager.jsp" %>
<%@ include file="/WEB-INF/layout/include/jquery/form.jsp" %>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<style>
	.community-write-btn {text-align:right;}
	.community-write-text {padding:0;}
	.community-write-text textarea {width:100%; resize:none; border:none; padding-top:5px;}
	#community-write-count {margin-right:10px;}
	
	.community-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-comment-picture {width:34px; height:34px; border-radius:5px; border:1px solid #7a6253; vertical-align:top; position:absolute;}
	
	.community-text .communuty-text-info {display:inline-block; margin-left:3px;}
	.community-text .community-name {font-size:12px; display:inline;}
	.community-text .community-name strong, .community-text  .community-name xmp {display:inline-block;}
	.community-text .community-date {font-size:12px; color:gray;}
	.community-text .community-blind-text {color:red;}
	.community-text .community-action {display:inline-block; vertical-align:top; text-align:right; float:right;}
	.community-text .community-text-content {padding-top:15px;}
	.community-text .community-text-comment-info {padding-left:44px; display:inline-block; width:100%;}
	.community-text .community-text-comment-write {position:relative;}
	.community-text .community-text-comment-write .community-text-comment-write-div {padding-left:44px; margin-right:34px;}
	.community-text .community-text-comment-write .community-text-comment-write-div input {padding-right:-40px;}
	.community-text .community-text-comment-write .community-comment-write-count {position:absolute; right:15px; height:34px; line-height:34px;}
	.community-text xmp {white-space: pre-wrap; word-break: break-all;}
</style>
<script type="text/javascript">
var communityUrl = contextPath + "<c:if test="${nav == 1}">/<session:id/></c:if>/data/community.json"
$(document).ready(function() {
	var lastCommunitySequence;
	var blindText = "이 글은 관리자에 의해 블라인드 처리 되었습니다.";
	
	var format = function(ymdhms) {
		var gapTime = new Date().getTime() - new Date(ymdhms.substring(0, 4), parseInt(ymdhms.substring(4, 6)) - 1, ymdhms.substring(6, 8), ymdhms.substring(8, 10), ymdhms.substring(10, 12), ymdhms.substring(12, 14)).getTime(); 
		var result = "";
		if (gapTime >= 1000 * 60 * 60 * 24) {
			result = ymdhms.substring(0, 4) + "-" + ymdhms.substring(4, 6) + "-" + ymdhms.substring(6, 8) + " " + ymdhms.substring(8, 10) + ":" + ymdhms.substring(10, 12) + ":" + ymdhms.substring(12, 14)
		} else if (gapTime >= 1000 * 60 * 60) {
			result = parseInt(gapTime / (1000 * 60 * 60), 10) + "시간 전";
		} else if (gapTime >= 1000 * 60) {
			result = parseInt(gapTime / (1000 * 60), 10) + "분 전";
		} else {
			result = "방금 전";
		}
		return result;
	};
	
	var makeCommunityHtml = function(community, show) {
		if (show === undefined) {
			show = true;
		}
		var html = '<div class="panel panel-default community-text" id="community-' +  community.communitySequence + '" ' + (!show ? "style='display:none;'" : '') + '>';
		html += '	<div class="panel-body">';
		html += '		<div class="community-action">';
		if (!community.blind) {
			if (studentSequence === community.studentSequence) {
				html += '			<button type="button" class="community-delete btn btn-default close"><span class="glyphicon glyphicon-remove"></span></button>';
			} else if (manager) {
				html += '			<button type="button" class="community-blind btn btn-default close"><span class="glyphicon glyphicon-lock"></span></button>';
			} else if (studentSequence !== 0 && !community.report) {
				html += '			<button type="button" class="community-report btn btn-default close"><span class="glyphicon glyphicon-bell"></span></button>';
			}
		}
		html += '		</div>';
		html += '		<img alt="프로필사진" class="community-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png">';
		html += '		<div class="communuty-text-info">';
		html += '			<div class="community-name"><strong>' + community.nickname + '</strong></div>';
		html += '			<div class="community-date" data-ymdhms="' + community.writeYmdhms + '">' + format(community.writeYmdhms) + '</div>';
		html += '		</div>';
		if (!community.blind) {
			html += '		<div class="community-text-content"><xmp>' + community.content + '</xmp></div>';
		} else {
			html += '		<div class="community-text-content"><xmp class="community-blind-text">' + blindText + '</xmp></div>';
		}
		html += '	</div>';
		if (!community.blind) {
			html += '	<div class="panel-footer community-text-comment-write">';
			html += '		<img alt="프로필사진" class="community-comment-picture" src="' + contextPath +  '/resources/csatlatte/images/img/img_person.png"/>';
			html += '		<div class="community-comment-write-count"">140</div>';
			html += '		<div class="community-text-comment-write-div">';
			html += '			<label for="community-text-comment-write-input-' + community.communitySequence + '" class="sr-only">' + (studentSequence !== 0 ?  '댓글을 입력하세요.' : '로그인 후 작성 할 수 있습니다.') + '</label>';
			html += '			<input id="community-text-comment-write-input-' + community.communitySequence + '" type="text" class="form-control" placeholder="' + (studentSequence !== 0 ?  '댓글을 입력하세요.' : '로그인 후 작성 할 수 있습니다.') + '" maxlength="140 " ' + (studentSequence === 0 ?  'disabled="disabled"' : '') + '/>';
			html += '		</div>';
			html += '	</div>';
		} else {
			html += '	<div class="community-text-comment-write"></div>';
		}
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
		if (!comment.blind) {
			if (studentSequence === comment.studentSequence) {
				html += '			<button type="button" class="community-comment-delete btn btn-default close"><span class="glyphicon glyphicon-remove"></span></button>';
			} else if (manager) {
				html += '			<button type="button" class="community-comment-blind btn btn-default close"><span class="glyphicon glyphicon-lock"></span></button>';
			} else if (studentSequence !== 0 && !comment.report) {
				html += '			<button type="button" class="community-comment-report btn btn-default close"><span class="glyphicon glyphicon-bell"></span></button>';
			}
		}
		html += '		</div>';
		html += '		<div class="community-name">';
		html += '			<strong>' + comment.nickname + '</strong> ';
		if (!comment.blind) {
			html += '<xmp>' + comment.content + '</xmp>';
		} else {
			html += '<xmp class="community-blind-text">' + blindText + '</xmp>';
		}
		html += '		</div>';
		html += '		<div class="community-date" data-ymdhms="' + comment.writeYmdhms + '">' + format(comment.writeYmdhms) + '</div>';
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
				var commentListIndex = 0;
				
				$("#community-" + communitySequence + " .community-text-comment").each(function(index) {
					var id = $(this).attr("id");
					var comment = commentList[commentListIndex];
					if (commentListIndex < commentListLength && parseInt(id.substring(id.lastIndexOf("-") + 1)) === comment.commentSequence) {
						commentListIndex++;
						if (comment.blind) {
							$("#community-comment-" + communitySequence + "-" + comment.commentSequence + " .community-comment-blind").fadeOut("normal", function() {
								$(this).remove();
							});
							$("#community-comment-" + communitySequence + "-" + comment.commentSequence + " .community-name xmp").addClass("community-blind-text").text(blindText);
						}
					} else {
						$(this).slideUp("fast", function() {
							$(this).remove();
						});
					}
				});
				
				for (var index = commentListIndex; index < commentListLength; index++) {
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
					} else {
						// 실패 처리..
					}
				}
			});
		});
	};
	
	
	var addCommunityReportEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-report").on("click", function() {
			$("#community-report").modal("show");
			var action = $("#community-report-form").attr("action");
			$("#community-report-form").attr("action", action.substring(0, action.lastIndexOf("/") + 1) + communitySequence + ".json");
		});
	}
	
	var addCommunityBlindEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-blind").on("click", function() {
			$("#community-blind").modal("show");
			var action = $("#community-blind-form").attr("action");
			$("#community-blind-form").attr("action", action.substring(0, action.lastIndexOf("/") + 1) + communitySequence + ".json");
		});
	}
	
	var addCommentWriteEvent = function(communitySequence) {
		$("#community-text-comment-write-input-" + communitySequence).on("keyup", function(event) {
			var $this = $(this);
			$("#community-" + communitySequence + " .community-comment-write-count").text(140 - $(this).val().length);
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
							$("#community-" + communitySequence + " .community-comment-write-count").text(140);
							refreshCommunityDate();
						} else {
							// 실패 처리..
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
					} else {
						// 실패 처리..
					}
				}
			});
		});
	};
	
	var addCommentsReportEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-text-comment").each(function() {
			var id = $(this).attr("id");
			addCommentReportEvent(communitySequence, id.substring(id.lastIndexOf("-") + 1));
		});
	};
	
	var addCommentReportEvent = function(communitySequence, commentSequence) {
		$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-comment-report").on("click", function() {
			$("#community-comment-report").modal("show");
			var action = $("#community-comment-report-form").attr("action");
			$("#community-comment-report-form").attr("action", action.substring(0, action.lastIndexOf("report/") + 7) + communitySequence + "/" + commentSequence + ".json");
		});
	};
	
	var addCommentsBlindEvent = function(communitySequence) {
		$("#community-" + communitySequence + " .community-text-comment").each(function() {
			var id = $(this).attr("id");
			addCommentBlindEvent(communitySequence, id.substring(id.lastIndexOf("-") + 1));
		});
	};
	
	var addCommentBlindEvent = function(communitySequence, commentSequence) {
		$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-comment-blind").on("click", function() {
			$("#community-comment-blind").modal("show");
			var action = $("#community-comment-blind-form").attr("action");
			$("#community-comment-blind-form").attr("action", action.substring(0, action.lastIndexOf("blind/") + 6) + communitySequence + "/" + commentSequence + ".json");
		});
	};
	
	var addCommunityAndCommentEvent = function(communitySequence) {
		addCommunityDeleteEvent(communitySequence);
		addCommunityReportEvent(communitySequence);
		addCommunityBlindEvent(communitySequence);
		addCommentWriteEvent(communitySequence);
		addCommentsDeleteEvent(communitySequence);
		addCommentsReportEvent(communitySequence);
		addCommentsBlindEvent(communitySequence);
	};
	
	var ajaxCommunity = function(data, callback) {
		$.ajax(communityUrl, {
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
				lastCommunitySequence = communityList[communityListLength - 1].communitySequence;
			} else {
				lastCommunitySequence = 1;
			}
		});
	};
	
	var refreshCommunityAndComment = function() {
		ajaxCommunity({
			end : lastCommunitySequence,
			limit : -1
		}, function(data) {
			if (data.list != null) {
				var communityList = data.list;
				var communityListLength = communityList.length;
				var communityListIndex = 0;
				
				for (var index = 0; index < communityListLength; index++) {
					var community = communityList[index];
					if ($("#community-" + community.communitySequence).length == 0) {
						$(".community-text:first").before(makeCommunityHtml(community, false));
						makeComment(community.communitySequence, function(communitySequence) {
							addCommunityAndCommentEvent(communitySequence);
							$("#community-" + communitySequence).slideDown();
						});
					} else if (community.blind) {
						$("#community-" + community.communitySequence + " .community-blind").fadeOut("normal", function() {
							$(this).remove();
						});
						$("#community-" + community.communitySequence + " .community-text-comment-write").slideUp("fast", function() {
							$(this).remove();
						});
						$("#community-" + community.communitySequence + " .community-text-content xmp").addClass("community-blind-text").text(blindText);
					}
				}
				
				$(".community-text").each(function(index) {
					var id = $(this).attr("id");
					var communitySequence = parseInt(id.substring(id.lastIndexOf("-") + 1));
					if (communityListIndex < communityListLength && communitySequence === communityList[communityListIndex].communitySequence) {
						communityListIndex++;
						refreshComment(communitySequence);
					} else {
						$(this).slideUp("fast", function() {
							$(this).remove();
						});
					}
				});
			}
		});
	};
	
	var refreshCommunityDate = function() {
		$(".community-date").each(function() {
			$(this).text(format(String($(this).data("ymdhms"))));
		});
	};
	
	var minuteRefresh = function() {
		setTimeout(function() {
			refreshCommunityAndComment();
			refreshCommunityDate();
			minuteRefresh();
		}, 60000);
	};

	$(window).scroll(function() {
		if ($(window).scrollTop() === ($(document).height() - $(window).height()) && lastCommunitySequence > 1) {
			makeCommunityAndComments(lastCommunitySequence - 1);
		}
	});

	$("#community-write-content").on("keyup", function() {
		var $communityWriteContent = $(this);
		$("#community-write-count").text(140 - $(this).val().length);
		if ($.trim($(this).val()) != "") {
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
					$("#community-write-count").text(140);
					refreshCommunityDate();
					refreshCommunityAndComment();
				} else {
					// 실패 처리..
				}
			}
		});
	});
	
	$("#community-report-form input[name='reportTypeSequence']").on("change", function() {
		if ($("#community-report-form input[name='reportTypeSequence']:checked").length >= 1) {
			$("#community-report-form button[type='submit']").attr("disabled", false);
		}
	});
	
	$("#community-report").on("hidden.bs.modal", function() {
		$("#community-report-form input[name='reportTypeSequence']:checked").attr("checked", false);
		$("#community-report-form button[type='submit']").attr("disabled", true);
	});
	

	$("#community-comment-report-form input[name='reportTypeSequence']").on("change", function() {
		if ($("#community-comment-report-form input[name='reportTypeSequence']:checked").length >= 1) {
			$("#community-comment-report-form button[type='submit']").attr("disabled", false);
		}
	});
	
	$("#community-comment-report").on("hidden.bs.modal", function() {
		$("#community-comment-report-form input[name='reportTypeSequence']:checked").attr("checked", false);
		$("#community-comment-report-form button[type='submit']").attr("disabled", true);
	});

	$("#community-blind-form input[name='blindTypeSequence']").on("change", function() {
		if ($("#community-blind-form input[name='blindTypeSequence']:checked").length >= 1) {
			$("#community-blind-form button[type='submit']").attr("disabled", false);
		}
	});
	
	$("#community-blind").on("hidden.bs.modal", function() {
		$("#community-blind-form input[name='blindTypeSequence']:checked").attr("checked", false);
		$("#community-blind-form button[type='submit']").attr("disabled", true);
	});

	$("#community-comment-blind-form input[name='blindTypeSequence']").on("change", function() {
		if ($("#community-comment-blind-form input[name='blindTypeSequence']:checked").length >= 1) {
			$("#community-comment-blind-form button[type='submit']").attr("disabled", false);
		}
	});
	
	$("#community-comment-blind").on("hidden.bs.modal", function() {
		$("#community-comment-blind-form input[name='blindTypeSequence']:checked").attr("checked", false);
		$("#community-comment-blind-form button[type='submit']").attr("disabled", true);
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
	
	$("#community-comment-report-form").ajaxForm({
		dataType : "json",
		success : function(data) {
			if (data.result) {
				var action = $("#community-comment-report-form").attr("action");
				var commentSequence = action.substring(action.lastIndexOf("/") + 1, action.lastIndexOf("."));
				action = action.substring(0, action.lastIndexOf("/"));
				var communitySequence = action.substring(action.lastIndexOf("/") + 1);
				$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-comment-report").fadeOut("normal", function() {
					$(this).remove();
				});
				$("#community-comment-report").modal("hide");
			} else {
				// 실패 처리..
			}
		}
	});
	
	$("#community-blind-form").ajaxForm({
		dataType : "json",
		success : function(data) {
			if (data.result) {
				var action = $("#community-blind-form").attr("action");
				var communitySequence = action.substring(action.lastIndexOf("/") + 1, action.lastIndexOf("."));
				$("#community-" + communitySequence + " .community-blind").fadeOut("normal", function() {
					$(this).remove();
				});
				$("#community-" + communitySequence + " .community-text-comment-write").slideUp("fast", function() {
					$(this).remove();
				});
				$("#community-" + communitySequence + " .community-text-content xmp").addClass("community-blind-text").text(blindText);
				$("#community-blind").modal("hide");
			}
		}
	});
	
	$("#community-comment-blind-form").ajaxForm({
		dataType : "json",
		success : function(data) {
			if (data.result) {
				var action = $("#community-comment-blind-form").attr("action");
				var commentSequence = action.substring(action.lastIndexOf("/") + 1, action.lastIndexOf("."));
				action = action.substring(0, action.lastIndexOf("/"));
				var communitySequence = action.substring(action.lastIndexOf("/") + 1);
				$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-comment-blind").fadeOut("normal", function() {
					$(this).remove();
				});
				$("#community-comment-" + communitySequence + "-" + commentSequence + " .community-name xmp").addClass("community-blind-text").text(blindText);
				$("#community-comment-blind").modal("hide");
			}
		}
	});

	makeCommunityAndComments();
	minuteRefresh();
});
</script>