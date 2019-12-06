<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/api/provincias" var="apiUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Provincias</h1>

<div class="row">
	<div class="col">
		<kendo:grid name="grid" groupable="false" sortable="true"
			style="height:550px;">
			<kendo:grid-editable mode="popup" />
			<kendo:grid-toolbar>
				<kendo:grid-toolbarItem name="create" text="Nueva provincia"/>
			</kendo:grid-toolbar>
			<kendo:grid-pageable refresh="true" pageSizes="true" buttonCount="5">
			</kendo:grid-pageable>
			<kendo:grid-columns>
				<kendo:grid-column title="Nombre" field="nombre" />
				<kendo:grid-column title="Region" field="region" editor="regionDropDownEditor" />
				<kendo:grid-column title="&nbsp;">
					<kendo:grid-column-command>
						<kendo:grid-column-commandItem name="edit" />
						<kendo:grid-column-commandItem name="destroy" />
					</kendo:grid-column-command>
				</kendo:grid-column>
			</kendo:grid-columns>
			<kendo:dataSource pageSize="10">
				<kendo:dataSource-transport>
					<kendo:dataSource-transport-create url="${apiUrl}" dataType="json"
						type="POST" contentType="application/json" />
					<kendo:dataSource-transport-read url="${apiUrl}" dataType="json"
						type="GET" contentType="application/json" />
					<kendo:dataSource-transport-update dataType="json" type="PATCH"
						contentType="application/json">
						<kendo:dataSource-transport-update-url>
							<script>
					            function(e) {
					            	return "${apiUrl}/" + e.id;
					            }
					        </script>
						</kendo:dataSource-transport-update-url>
					</kendo:dataSource-transport-update>
					<kendo:dataSource-transport-destroy dataType="json" type="DELETE"
						contentType="application/json">
						<kendo:dataSource-transport-destroy-url>
							<script>
					            function(e) {
					            	return "${apiUrl}/" + e.id;
					            }
					        </script>
						</kendo:dataSource-transport-destroy-url>
					</kendo:dataSource-transport-destroy>
					<kendo:dataSource-transport-parameterMap>
						<script>
							function parameterMap(data, type) {
								if (type === 'update' || type === 'create') {
									return kendo.stringify(data);
								}
							}
						</script>
					</kendo:dataSource-transport-parameterMap>
				</kendo:dataSource-transport>
				<kendo:dataSource-schema>
					<kendo:dataSource-schema-model id="id">
						<kendo:dataSource-schema-model-fields>
							<kendo:dataSource-schema-model-field name="nombre" type="string" nullable="false"/>
							<kendo:dataSource-schema-model-field name="region" type="string" nullable="false"/>
						</kendo:dataSource-schema-model-fields>
					</kendo:dataSource-schema-model>
				</kendo:dataSource-schema>
			</kendo:dataSource>
		</kendo:grid>
	</div>
</div>
<script>
	function regionDropDownEditor(container, options) {
		$('<input data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList({
            autoBind: false,
            dataSource: ${regionEnum}
        });
	}
</script>
<eiv:footer />
