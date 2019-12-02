<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/pais/paises/" var="transportReadUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Nuevo pais</h1>
<div class="col-xs-12 col-sm-4 offset-sm-4">
	<div class="card">
		<form>
			<div class="card-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Nombre</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Ingrese nombre">
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Abreviatura</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Ingrese abreviatura">
				</div>

			</div>
			<div class="card-footer">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</form>
	</div>

</div>


<eiv:footer />
