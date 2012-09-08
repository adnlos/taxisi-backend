
<%@ page import="taxisi.backend.Pasajero" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pasajero.label', default: 'Pasajero')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pasajero" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pasajero" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pasajero">
			
				<g:if test="${pasajeroInstance?.nick}">
				<li class="fieldcontain">
					<span id="nick-label" class="property-label"><g:message code="pasajero.nick.label" default="Nick" /></span>
					
						<span class="property-value" aria-labelledby="nick-label"><g:fieldValue bean="${pasajeroInstance}" field="nick"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="pasajero.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${pasajeroInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.latitude}">
				<li class="fieldcontain">
					<span id="latitude-label" class="property-label"><g:message code="pasajero.latitude.label" default="Latitude" /></span>
					
						<span class="property-value" aria-labelledby="latitude-label"><g:fieldValue bean="${pasajeroInstance}" field="latitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.longitude}">
				<li class="fieldcontain">
					<span id="longitude-label" class="property-label"><g:message code="pasajero.longitude.label" default="Longitude" /></span>
					
						<span class="property-value" aria-labelledby="longitude-label"><g:fieldValue bean="${pasajeroInstance}" field="longitude"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="pasajero.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${pasajeroInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.apellido}">
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label"><g:message code="pasajero.apellido.label" default="Apellido" /></span>
					
						<span class="property-value" aria-labelledby="apellido-label"><g:fieldValue bean="${pasajeroInstance}" field="apellido"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.celular}">
				<li class="fieldcontain">
					<span id="celular-label" class="property-label"><g:message code="pasajero.celular.label" default="Celular" /></span>
					
						<span class="property-value" aria-labelledby="celular-label"><g:fieldValue bean="${pasajeroInstance}" field="celular"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pasajeroInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="pasajero.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${pasajeroInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${pasajeroInstance?.id}" />
					<g:link class="edit" action="edit" id="${pasajeroInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
