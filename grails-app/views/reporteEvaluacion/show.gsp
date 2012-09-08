
<%@ page import="taxisi.backend.ReporteEvaluacion" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reporteEvaluacion.label', default: 'ReporteEvaluacion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reporteEvaluacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reporteEvaluacion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reporteEvaluacion">
			
				<g:if test="${reporteEvaluacionInstance?.pasajero}">
				<li class="fieldcontain">
					<span id="pasajero-label" class="property-label"><g:message code="reporteEvaluacion.pasajero.label" default="Pasajero" /></span>
					
						<span class="property-value" aria-labelledby="pasajero-label"><g:link controller="pasajero" action="show" id="${reporteEvaluacionInstance?.pasajero?.id}">${reporteEvaluacionInstance?.pasajero?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reporteEvaluacionInstance?.tipoReporte}">
				<li class="fieldcontain">
					<span id="tipoReporte-label" class="property-label"><g:message code="reporteEvaluacion.tipoReporte.label" default="Tipo Reporte" /></span>
					
						<span class="property-value" aria-labelledby="tipoReporte-label"><g:fieldValue bean="${reporteEvaluacionInstance}" field="tipoReporte"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reporteEvaluacionInstance?.evaluacion}">
				<li class="fieldcontain">
					<span id="evaluacion-label" class="property-label"><g:message code="reporteEvaluacion.evaluacion.label" default="Evaluacion" /></span>
					
						<span class="property-value" aria-labelledby="evaluacion-label"><g:fieldValue bean="${reporteEvaluacionInstance}" field="evaluacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reporteEvaluacionInstance?.chofer}">
				<li class="fieldcontain">
					<span id="chofer-label" class="property-label"><g:message code="reporteEvaluacion.chofer.label" default="Chofer" /></span>
					
						<span class="property-value" aria-labelledby="chofer-label"><g:link controller="chofer" action="show" id="${reporteEvaluacionInstance?.chofer?.id}">${reporteEvaluacionInstance?.chofer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reporteEvaluacionInstance?.foto}">
				<li class="fieldcontain">
					<span id="foto-label" class="property-label"><g:message code="reporteEvaluacion.foto.label" default="Foto" /></span>
					
						<span class="property-value" aria-labelledby="foto-label"><g:fieldValue bean="${reporteEvaluacionInstance}" field="foto"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${reporteEvaluacionInstance?.id}" />
					<g:link class="edit" action="edit" id="${reporteEvaluacionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
