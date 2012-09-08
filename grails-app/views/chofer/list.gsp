
<%@ page import="taxisi.backend.Chofer" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'chofer.label', default: 'Chofer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-chofer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-chofer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nick" title="${message(code: 'chofer.nick.label', default: 'Nick')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'chofer.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'chofer.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellido" title="${message(code: 'chofer.apellido.label', default: 'Apellido')}" />
					
						<g:sortableColumn property="licencia" title="${message(code: 'chofer.licencia.label', default: 'Licencia')}" />
					
						<g:sortableColumn property="celular" title="${message(code: 'chofer.celular.label', default: 'Celular')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${choferInstanceList}" status="i" var="choferInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${choferInstance.id}">${fieldValue(bean: choferInstance, field: "nick")}</g:link></td>
					
						<td>${fieldValue(bean: choferInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: choferInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: choferInstance, field: "apellido")}</td>
					
						<td>${fieldValue(bean: choferInstance, field: "licencia")}</td>
					
						<td>${fieldValue(bean: choferInstance, field: "celular")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${choferInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
