
<%@ page import="taxisi.backend.Pasajero" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pasajero.label', default: 'Pasajero')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pasajero" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pasajero" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nick" title="${message(code: 'pasajero.nick.label', default: 'Nick')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'pasajero.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="latitude" title="${message(code: 'pasajero.latitude.label', default: 'Latitude')}" />
					
						<g:sortableColumn property="longitude" title="${message(code: 'pasajero.longitude.label', default: 'Longitude')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'pasajero.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellido" title="${message(code: 'pasajero.apellido.label', default: 'Apellido')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pasajeroInstanceList}" status="i" var="pasajeroInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pasajeroInstance.id}">${fieldValue(bean: pasajeroInstance, field: "nick")}</g:link></td>
					
						<td>${fieldValue(bean: pasajeroInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: pasajeroInstance, field: "latitude")}</td>
					
						<td>${fieldValue(bean: pasajeroInstance, field: "longitude")}</td>
					
						<td>${fieldValue(bean: pasajeroInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: pasajeroInstance, field: "apellido")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pasajeroInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
