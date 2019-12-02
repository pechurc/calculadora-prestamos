<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%@taglib prefix="eiv" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<eiv:header />

		<h1 class="eiv-title" id="content">Provincias</h1>
		<div class="card col-6">
			<div class="card-body">
				<h5 class="card-title">Telerik - Bootstrap</h5>
				<p class="card-text">Prueba de Telerik con Bootstrap</p>
				<div>
					<h4>Disabled buttons</h4>
					<p>
						<kendo:button name="primaryDisabledButton" tag="a" enable="false"
							class="k-primary">
							<kendo:button-content>
                    Disabled primary button
                </kendo:button-content>
						</kendo:button>

						<kendo:button name="disabledButton" enable="false">
							<kendo:button-content>
                    Disabled button
                </kendo:button-content>
						</kendo:button>
					</p>
				</div>

				<div>
					<h4>Buttons with icons</h4>
					<p>
						<kendo:button name="iconTextButton" tag="a"
							spriteCssClass="k-icon k-i-funnel">
							<kendo:button-content>
                    Filter
                </kendo:button-content>
						</kendo:button>

						<kendo:button name="kendoIconTextButton" tag="a"
							icon="funnel-clear">
							<kendo:button-content>
                    Clear Filter
                   
                </kendo:button-content>
						</kendo:button>

						<kendo:button name="iconButton" tag="em"
							spriteCssClass="k-icon k-i-refresh">
						</kendo:button>
					</p>
				</div>
			</div>
		</div>


<eiv:footer />
