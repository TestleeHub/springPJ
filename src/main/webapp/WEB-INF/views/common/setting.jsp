<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 컨텍스트 패스 즉 플젝명을 path에 설정 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="sessionID" value="${sessionScope.SessionId}"/>
<c:set var="imagePath" value="${path}/resources/upload"/>
<c:set var="SessionAuthority" value="${sessionScope.SessionAuthority}"/><!-- expert, client -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/customer/jquery-3.7.0.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/848183bf48.js"
	crossorigin="anonymous"></script>
<script src="${path}/resources/js/customer/main.js" defer></script>