<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="session" uri="/WEB-INF/tld/session.tld" %>
<script type="text/javascript">
	var manager = <session:isManager>true</session:isManager><session:isGuest>false</session:isGuest><session:isStudent>false</session:isStudent>;
</script>