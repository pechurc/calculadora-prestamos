<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/api/provincias" var="transportReadUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Provincias</h1>

<div class="row mb-1">
	<div class="col text-right">
		<a class='btn btn-primary' href='/provincias/nueva' role="button"><span
			class='k-icon k-i-plus'></span>Nueva</a>
	</div>
</div>
<div class="row">
	<div class="col">
		<kendo:grid name="grid" groupable="true" sortable="true"
			style="height:550px;">
			<kendo:grid-pageable refresh="true" pageSizes="true" buttonCount="5">
			</kendo:grid-pageable>
			<kendo:grid-columns>
				<kendo:grid-column title="Nombre" field="nombre" />
				<kendo:grid-column title="Region" field="region" width="180" />
				<kendo:grid-column title="Acciones" field="actions" sortable="false"
					filterable="false" width="100"
					template="<a class='k-button' href='/provincias/#:data.id#'><span class='k-icon k-i-edit'></span>Editar</a>" />
			</kendo:grid-columns>
			<kendo:dataSource pageSize="10">
				<kendo:dataSource-schema>
					<kendo:dataSource-schema-model>
						<kendo:dataSource-schema-model-fields>
							<kendo:dataSource-schema-model-field name="nombre" type="string" />
							<kendo:dataSource-schema-model-field name="region" type="string" />
						</kendo:dataSource-schema-model-fields>
					</kendo:dataSource-schema-model>
				</kendo:dataSource-schema>
				<kendo:dataSource-transport>
					<kendo:dataSource-transport-read url="${transportReadUrl}" />
				</kendo:dataSource-transport>
			</kendo:dataSource>
		</kendo:grid>
	</div>
</div>

<eiv:footer />
