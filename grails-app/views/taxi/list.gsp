
<%@ page import="taxisi.backend.Taxi" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'taxi.label', default: 'Taxi')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-taxi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-taxi" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="latitude" title="${message(code: 'taxi.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'taxi.longitude.label', default: 'Longitude')}" />
					
						<g:sortableColumn property="placas" title="${message(code: 'taxi.placas.label', default: 'Placas')}" />
					
						<th><g:message code="taxi.sitioTaxi.label" default="Sitio Taxi" /></th>
					
						<g:sortableColumn property="tipo" title="${message(code: 'taxi.tipo.label', default: 'Tipo')}" />
					
						<g:sortableColumn property="vehiculo" title="${message(code: 'taxi.vehiculo.label', default: 'Vehiculo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${taxiInstanceList}" status="i" var="taxiInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${taxiInstance.id}">${fieldValue(bean: taxiInstance, field: "latitude")}</g:link></td>
					
						<td>${fieldValue(bean: taxiInstance, field: "longitude")}</td>
					
						<td>${fieldValue(bean: taxiInstance, field: "placas")}</td>
					
						<td>${fieldValue(bean: taxiInstance, field: "sitioTaxi")}</td>
					
						<td>${fieldValue(bean: taxiInstance, field: "tipo")}</td>
					
						<td>${fieldValue(bean: taxiInstance, field: "vehiculo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${taxiInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
