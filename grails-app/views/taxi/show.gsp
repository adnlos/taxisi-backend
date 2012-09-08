
<%@ page import="taxisi.backend.Taxi" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'taxi.label', default: 'Taxi')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-taxi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-taxi" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list taxi">
			
				<g:if test="${taxiInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="taxi.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${taxiInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taxiInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="taxi.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${taxiInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taxiInstance?.placas}">
				<li class="fieldcontain">
					<span id="placas-label" class="property-label"><g:message code="taxi.placas.label" default="Placas" /></span>
					
						<span class="property-value" aria-labelledby="placas-label"><g:fieldValue bean="${taxiInstance}" field="placas"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${taxiInstance?.sitioTaxi}">
				<li class="fieldcontain">
					<span id="sitioTaxi-label" class="property-label"><g:message code="taxi.sitioTaxi.label" default="Sitio Taxi" /></span>
					
						<span class="property-value" aria-labelledby="sitioTaxi-label"><g:link controller="sitioTaxi" action="show" id="${taxiInstance?.sitioTaxi?.id}">${taxiInstance?.sitioTaxi?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${taxiInstance?.tipo}">
				<li class="fieldcontain">
					<span id="tipo-label" class="property-label"><g:message code="taxi.tipo.label" default="Tipo" /></span>
					
						<span class="property-value" aria-labelledby="tipo-label"><g:fieldValue bean="${taxiInstance}" field="tipo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${taxiInstance?.id}" />
					<g:link class="edit" action="edit" id="${taxiInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
