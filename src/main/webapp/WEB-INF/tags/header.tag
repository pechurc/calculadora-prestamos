<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
	   	<base href="${base}/">
		<title>Home</title>
		<link href="<c:url value='/resources/css/web/bootstrap.min.css'/>"
			rel="stylesheet" />
		<link href="<c:url value='/resources/css/web/kendo.rtl.min.css'/>"
			rel="stylesheet" />
		<link
			href="<c:url value='/resources/css/web/kendo.bootstrap.mobile.min.css'/>"
			rel="stylesheet" />
		<link
			href="<c:url value='/resources/css/dataviz/kendo.dataviz.min.css'/>"
			rel="stylesheet" />
		<link
			href="<c:url value='/resources/css/dataviz/kendo.dataviz.default.min.css'/>"
			rel="stylesheet" />
		<link href="<c:url value='/resources/shared/styles/eiv.css'/>"
			rel="stylesheet" />
		
		<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
		<script src="<c:url value='/resources/js/kendo.all.min.js' />"></script>
		<script src="<c:url value='/resources/js/kendo.timezones.min.js' />"></script>
		<script src="<c:url value='/resources/shared/js/console.js'/>"></script>
		<script src="<c:url value='/resources/shared/js/popper.min.js'/>"></script>
		<script src="<c:url value='/resources/shared/js/bootstrap.min.js'/>"></script>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark eiv-navbar">
			<a class="navbar-brand" href="#"> <img
				src="resources/shared/images/logo.png" width="30" height="30" alt="">
			</a> <a class="navbar-brand" href="#">Cliente 1</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
	
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li
						class="nav-item <c:if test="${navItemActive == 'home'}">active</c:if>"><a
						class="nav-link" href="<c:url value='${base}/' />">Home <span
							class="sr-only">(current)</span>
					</a></li>
	
					<c:forEach items="${usuario.menu}" var="item">
						<li
							class="nav-item <c:if test="${navItemActive == item.uri}">active</c:if>"><a
							class="nav-link" href="${base}${item.defaultUri}">${item.nombre}</a></li>
					</c:forEach>
	
				</ul>
	
				<div class="my-2 my-lg-0 dropdown">
					<button type="button" class="btn btn-secondary dropdown-toggle"
						id="dropdownUsuario" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false" data-offset="10,20">
						${usuario.nombre}</button>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownUsuario">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="/logout">Cerrar sesion</a>
					</div>
	
				</div>
			</div>
		</nav>
		<div class="container-fluid">
			<div class="row flex-xl-nowrap eiv-row">
				<eiv:sidebar></eiv:sidebar>
				<main class="col-12 col-md-9 col-xl-10 pb-3 eiv-content" role="main">