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
	.panel-footer {padding:10px;}
	.community-profile-picture {width:40px; height:40px; border-radius:5px; border:1px solid #7a6253; vertical-align:top;}
	.community-text {text-align:left;}
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