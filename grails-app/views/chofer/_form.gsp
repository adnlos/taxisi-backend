<%@ page import="taxisi.backend.Chofer" %>



<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'nick', 'error')} required">
	<label for="nick">
		<g:message code="chofer.nick.label" default="Nick" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nick" required="" value="${choferInstance?.nick}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="chofer.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${choferInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="chofer.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${choferInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="chofer.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${choferInstance?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'licencia', 'error')} required">
	<label for="licencia">
		<g:message code="chofer.licencia.label" default="Licencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="licencia" required="" value="${choferInstance?.licencia}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'celular', 'error')} required">
	<label for="celular">
		<g:message code="chofer.celular.label" default="Celular" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="celular" required="" value="${choferInstance?.celular}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="chofer.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${choferInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'tarjeton', 'error')} required">
	<label for="tarjeton">
		<g:message code="chofer.tarjeton.label" default="Tarjeton" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tarjeton" name="tarjeton.id" from="${taxisi.backend.Tarjeton.list()}" optionKey="id" required="" value="${choferInstance?.tarjeton?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: choferInstance, field: 'taxi', 'error')} required">
	<label for="taxi">
		<g:message code="chofer.taxi.label" default="Taxi" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="taxi" name="taxi.id" from="${taxisi.backend.Taxi.list()}" optionKey="id" required="" value="${choferInstance?.taxi?.id}" class="many-to-one"/>
</div>

