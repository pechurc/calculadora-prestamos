<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="reqUri" value="${requestScope['javax.servlet.forward.servlet_path']}" />
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}" />


<div class="col-12 col-md-3 col-xl-2 eiv-sidebar">
	<form class="d-flex align-items-center eiv-search">

		<input type="text" class="form-control" id="busquedaInput"
			aria-describedby="buscarHelp" placeholder="Buscar..">
		<button class="btn btn-link d-md-none p-0 ml-3 eiv-sidebar-toggle"
			type="button" data-toggle="collapse" data-target="#eiv-sidebar-nav"
			aria-controls="eiv-sidebar-nav" aria-expanded="false"
			aria-label="Toggle navigation">
			<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
				viewBox="0 0 30 30" role="img" focusable="false">
				<title>Menu</title><path stroke="currentColor"
					stroke-linecap="round" stroke-miterlimit="10" stroke-width="2"
					d="M4 7h22M4 15h22M4 23h22"></path></svg>
		</button>
	</form>
	<nav class="collapse eiv-nav" id="eiv-sidebar-nav">

		<c:forEach items="${menu}" var="item">
			<div
				class="eiv-nav-item <c:if test="${navItemActive == item.uri}">active</c:if>">
				<a class="eiv-nav-link" href="${base}${item.defaultUri}"> ${item.nombre} </a>

				<ul class="nav eiv-sidenav">
					<c:forEach items="${item.navLinks}" var="link">
						<li <c:if test="${reqUri == link.uri}">class="active"</c:if>><a
							href="${base}${link.uri}"> ${link.nombre} </a></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>


	</nav>
</div>