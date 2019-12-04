<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/provincias/nueva" var="postUrl" />

<c:if test="${not empty id}">
	<c:url value="/provincias/${id}" var="postUrl" />
</c:if>

<eiv:header />

<h1 class="eiv-title" id="content">${empty id ? 'Nueva' : 'Modificar'} provincia</h1>
<div class="col-sm-12 col-lg-6 offset-lg-3">
	<div class="card">
		<form:form method="POST" action="${postUrl}"
			modelAttribute="provincia">
			<div class="card-body">

				<div class="form-group">
					<form:label path="nombre">Nombre</form:label>
					<form:input type="text" class="form-control" id="nombre"
						path="nombre" aria-describedby="nombreHelp"
						placeholder="Ingrese nombre"></form:input>
				</div>

				<div class="form-group">
					<form:label path="region" for="abreviatura">Region</form:label>
					<form:select path="region" class="form-control">
						<c:forEach var="opt" items="${regionEnum}">
							<option ${opt == provincia.region ? 'selected="selected"' : ''}>${opt}</option>
						</c:forEach>
					</form:select>
				</div>
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<c:if test="${success}">
					<div class="alert alert-success" role="alert">Provincia guardada con exito</div>
				</c:if>
			</div>
			<div class="card-footer">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</form:form>
	</div>

</div>


<eiv:footer />
