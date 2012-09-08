
<%@ page import="taxisi.backend.Chofer" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'chofer.label', default: 'Chofer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-chofer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-chofer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list chofer">
			
				<g:if test="${choferInstance?.nick}">
				<li class="fieldcontain">
					<span id="nick-label" class="property-label"><g:message code="chofer.nick.label" default="Nick" /></span>
					
						<span class="property-value" aria-labelledby="nick-label"><g:fieldValue bean="${choferInstance}" field="nick"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="chofer.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${choferInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="chofer.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${choferInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.apellido}">
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label"><g:message code="chofer.apellido.label" default="Apellido" /></span>
					
						<span class="property-value" aria-labelledby="apellido-label"><g:fieldValue bean="${choferInstance}" field="apellido"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.licencia}">
				<li class="fieldcontain">
					<span id="licencia-label" class="property-label"><g:message code="chofer.licencia.label" default="Licencia" /></span>
					
						<span class="property-value" aria-labelledby="licencia-label"><g:fieldValue bean="${choferInstance}" field="licencia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.celular}">
				<li class="fieldcontain">
					<span id="celular-label" class="property-label"><g:message code="chofer.celular.label" default="Celular" /></span>
					
						<span class="property-value" aria-labelledby="celular-label"><g:fieldValue bean="${choferInstance}" field="celular"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="chofer.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${choferInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.tarjeton}">
				<li class="fieldcontain">
					<span id="tarjeton-label" class="property-label"><g:message code="chofer.tarjeton.label" default="Tarjeton" /></span>
					
						<span class="property-value" aria-labelledby="tarjeton-label"><g:link controller="tarjeton" action="show" id="${choferInstance?.tarjeton?.id}">${choferInstance?.tarjeton?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${choferInstance?.taxi}">
				<li class="fieldcontain">
					<span id="taxi-label" class="property-label"><g:message code="chofer.taxi.label" default="Taxi" /></span>
					
						<span class="property-value" aria-labelledby="taxi-label"><g:link controller="taxi" action="show" id="${choferInstance?.taxi?.id}">${choferInstance?.taxi?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${choferInstance?.id}" />
					<g:link class="edit" action="edit" id="${choferInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
