
<%@ page import="taxisi.backend.Tarjeton" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tarjeton.label', default: 'Tarjeton')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tarjeton" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tarjeton" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="numeroSerie" title="${message(code: 'tarjeton.numeroSerie.label', default: 'Numero Serie')}" />
					
						<th><g:message code="tarjeton.chofer.label" default="Chofer" /></th>
					
						<g:sortableColumn property="tipoTargeton" title="${message(code: 'tarjeton.tipoTargeton.label', default: 'Tipo Targeton')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tarjetonInstanceList}" status="i" var="tarjetonInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tarjetonInstance.id}">${fieldValue(bean: tarjetonInstance, field: "numeroSerie")}</g:link></td>
					
						<td>${fieldValue(bean: tarjetonInstance, field: "chofer")}</td>
					
						<td>${fieldValue(bean: tarjetonInstance, field: "tipoTargeton")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tarjetonInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
