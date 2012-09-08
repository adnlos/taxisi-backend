
<%@ page import="taxisi.backend.ReporteEvaluacion" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reporteEvaluacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reporteEvaluacion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="reporteEvaluacion.pasajero.label" default="Pasajero" /></th>
					
						<g:sortableColumn property="tipoReporte" title="${message(code: 'reporteEvaluacion.tipoReporte.label', default: 'Tipo Reporte')}" />
					
						<g:sortableColumn property="evaluacion" title="${message(code: 'reporteEvaluacion.evaluacion.label', default: 'Evaluacion')}" />
					
						<th><g:message code="reporteEvaluacion.chofer.label" default="Chofer" /></th>
					
						<g:sortableColumn property="foto" title="${message(code: 'reporteEvaluacion.foto.label', default: 'Foto')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reporteEvaluacionInstanceList}" status="i" var="reporteEvaluacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reporteEvaluacionInstance.id}">${fieldValue(bean: reporteEvaluacionInstance, field: "pasajero")}</g:link></td>
					
						<td>${fieldValue(bean: reporteEvaluacionInstance, field: "tipoReporte")}</td>
					
						<td>${fieldValue(bean: reporteEvaluacionInstance, field: "evaluacion")}</td>
					
						<td>${fieldValue(bean: reporteEvaluacionInstance, field: "chofer")}</td>
					
						<td>${fieldValue(bean: reporteEvaluacionInstance, field: "foto")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reporteEvaluacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
