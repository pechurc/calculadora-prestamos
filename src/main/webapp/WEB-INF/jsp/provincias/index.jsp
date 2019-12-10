<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/api/provincias" var="apiUrl" />

<eiv:header />

<h1 class="eiv-title" id="content">Provincias</h1>

<div class="row">
	<div class="col">
		<kendo:grid id="grid" name="grid" style="height:550px;">
			<kendo:grid-toolbar>
				<kendo:grid-toolbarItem name="create" text="Nueva provincia" />
			</kendo:grid-toolbar>
		</kendo:grid>
	</div>
</div>



<script id="popup_editor" type="text/x-kendo-template">
    <div class="form-group">
    	<label for="nombre">Nombre</label>
    	<input type="text" class="form-control" id="nombre" aria-describedby="nombreHelp" data-bind="value:nombre" required/>
    	<small id="nombreHelp" class="form-text text-muted">Nombre de la provincia</small>

  	</div>
	<div class="form-group">
			<input id="region" style="width: 100%;" data-bind="value:region" required/>
	</div>
</script>

<script>
$(function () {
	var dataSource = new kendo.data.DataSource({	
		  		pageSize: 10,			
			  transport: {
					    read: function(options) {
					        $.ajax({
					          url: "${apiUrl}",
					          dataType: "json",
					          success: function(result) {
					              options.success(result);
					            },
					          error: function(result) {
					              options.error(result);
					            }
					        });
					      },
					   	destroy:function(options) {
					   		$.ajax({
						          url: "${apiUrl}/" + options.data.id,
						          dataType: "json",
						          method: "DELETE",
						          success: function(result) {
						              options.success(result);
						            },
						          error: function(result) {
						              options.error(result);
						            }
						        });
					      },
					  	update: function(options) {
					  		$.ajax({
						          url: "${apiUrl}/" + options.data.id,
						          dataType: "json",
						          method: "PATCH",
						          data: kendo.stringify(options.data),
						          contentType: "application/json",
						          success: function(result) {
						              options.success(result);
						            },
						          error: function(result) {
						              options.error(result);
						            }
						        });
					      },
					   	create: function(options) {
					   		$.ajax({
						          url: "${apiUrl}",
						          dataType: "json",
						          method: "POST",
						          data: kendo.stringify(options.data),
						          contentType: "application/json",
						          success: function(result) {
						              options.success(result);
						            },
						          error: function(result) {
						              options.error(result);
						            }
						        });
					      },
					    parameterMap: function(data, type) {
								if (type === 'update' || type === 'create') {
									return kendo.stringify(data);
								}
							}		
			  },			  
			  schema: {
					model: {
						id: "id",
			          	fields: {
				            "id": { type: "number" },
				            "nombre": { type: "string", validation: { required: true, min: 1 }},
				            "region": { type: "string", validation: { required: true, min: 1 }}
			          		}
			        	}
			      	}				
		});
	
	function initDropDownLists() {
		
		var region = $("#region").kendoDropDownList({
            optionLabel: "Seleccionar region...",
            dataSource: ${regionEnum},
        }).data("kendoDropDownList");
	}
	
	$("#grid").kendoGrid({
	  columns: [
	    { field: "id" },
	    { field: "nombre" },
	    { field: "region" },
	    { command: ["edit", "delete"] }
	  ],
	  dataSource: dataSource,
	  editable: {mode: "popup", template: $("#popup_editor").html()},
	  edit: function (e) {
          initDropDownLists();
      },
	  toolbar:["create"],
	  pageable: {
		    pageSize: 10,
		    buttonCount: 1,
		    refresh: true
		  },
	});
});
</script>

<eiv:footer />
