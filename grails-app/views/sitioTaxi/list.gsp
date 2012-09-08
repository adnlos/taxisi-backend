
<%@ page import="taxisi.backend.SitioTaxi" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sitioTaxi.label', default: 'SitioTaxi')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-sitioTaxi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-sitioTaxi" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="latitude" title="${message(code: 'sitioTaxi.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'sitioTaxi.longitude.label', default: 'Longitude')}" />
					
						<g:sortableColumn property="telefono" title="${message(code: 'sitioTaxi.telefono.label', default: 'Telefono')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'sitioTaxi.nombre.label', default: 'Nombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${sitioTaxiInstanceList}" status="i" var="sitioTaxiInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${sitioTaxiInstance.id}">${fieldValue(bean: sitioTaxiInstance, field: "latitude")}</g:link></td>
					
						<td>${fieldValue(bean: sitioTaxiInstance, field: "longitude")}</td>
					
						<td>${fieldValue(bean: sitioTaxiInstance, field: "telefono")}</td>
					
						<td>${fieldValue(bean: sitioTaxiInstance, field: "nombre")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${sitioTaxiInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
