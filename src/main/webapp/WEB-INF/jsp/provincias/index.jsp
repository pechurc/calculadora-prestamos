<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/pais/paises/" var="transportReadUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Paises</h1>
<div class="card col py-1">
	<kendo:grid name="grid" groupable="true" sortable="true"
		style="height:550px;">
		<kendo:grid-pageable refresh="true" pageSizes="true" buttonCount="5">
		</kendo:grid-pageable>
		<kendo:grid-columns>
			<kendo:grid-column title="Nombre" field="nombre" />
			<kendo:grid-column title="Nombre abreviado" field="nombreAbreviado"
				width="180" />
		</kendo:grid-columns>
		<kendo:dataSource pageSize="10">
			<kendo:dataSource-schema data="resultados">
				<kendo:dataSource-schema-model>
					<kendo:dataSource-schema-model-fields>
						<kendo:dataSource-schema-model-field name="nombre"
							type="string" />
						<kendo:dataSource-schema-model-field name="nombreAbreviado"
							type="string" />
					</kendo:dataSource-schema-model-fields>
				</kendo:dataSource-schema-model>
			</kendo:dataSource-schema>
			<kendo:dataSource-transport>
				<kendo:dataSource-transport-read url="${transportReadUrl}" />
			</kendo:dataSource-transport>
		</kendo:dataSource>
	</kendo:grid>
</div>


<eiv:footer />
