<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/entespublicos/entespublicos/" var="transportReadUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Entes publicos</h1>

<kendo:grid name="grid" groupable="true" sortable="true" height="500px">
	<kendo:grid-pageable refresh="true" pageSizes="true" buttonCount="5">
	</kendo:grid-pageable>
	<kendo:grid-columns>
		<kendo:grid-column title="Nombre" field="nombreEnte" />
		<kendo:grid-column title="Nombre abreviado" field="nombreAbreviado"
			width="180" />
		<kendo:grid-column title="Direccion" field="direccion" />
		<kendo:grid-column title="Fecha alta" field="fechaAlta" width="140" />
		<kendo:grid-column title="Observaciones" field="observaciones" />
	</kendo:grid-columns>
	<kendo:dataSource pageSize="10">
		<kendo:dataSource-schema data="resultados">
			<kendo:dataSource-schema-model>
				<kendo:dataSource-schema-model-fields>
					<kendo:dataSource-schema-model-field name="contactName"
						type="string" />
					<kendo:dataSource-schema-model-field name="contactTitle"
						type="string" />
					<kendo:dataSource-schema-model-field name="companyName"
						type="string" />
					<kendo:dataSource-schema-model-field name="country" type="string" />
				</kendo:dataSource-schema-model-fields>
			</kendo:dataSource-schema-model>
		</kendo:dataSource-schema>
		<kendo:dataSource-transport>
			<kendo:dataSource-transport-read url="${transportReadUrl}" />
		</kendo:dataSource-transport>
	</kendo:dataSource>
</kendo:grid>

<style>
<!--

-->
</style>

<eiv:footer />
