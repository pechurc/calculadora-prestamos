<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/pais/paises/" var="transportReadUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Nuevo Ente Público</h1>
<div class="col-xs-12 col-sm-8 offset-sm-2">
	<div class="card">
		<form>
			<div class="card-body">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12 col-xl-6">
							<div class="form-group">
								<label for="exampleInputEmail1">Nombre</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Ingrese nombre">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Nombre abreviado</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"
									placeholder="Ingrese nombre abreviado">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Teléfono</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Ingrese Teléfono">
							</div>
						</div>
						<div class="col-12 col-xl-6">
							<div class="form-group">
								<label for="exampleInputEmail1">Dirección</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Ingrese Dirección">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Correo</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Ingrese Correo">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contacto</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Ingrese Contacto">
							</div>
				
						</div>
					</div>
				</div>


			</div>
			<div class="card-footer text-right">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</form>
	</div>

</div>


<eiv:footer />
