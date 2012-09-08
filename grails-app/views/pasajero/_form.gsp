<%@ page import="taxisi.backend.Pasajero" %>



<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'nick', 'error')} required">
	<label for="nick">
		<g:message code="pasajero.nick.label" default="Nick" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nick" required="" value="${pasajeroInstance?.nick}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="pasajero.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${pasajeroInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="pasajero.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="latitude" required="" value="${pasajeroInstance?.latitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="pasajero.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longitude" required="" value="${pasajeroInstance?.longitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="pasajero.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${pasajeroInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="pasajero.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${pasajeroInstance?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'celular', 'error')} required">
	<label for="celular">
		<g:message code="pasajero.celular.label" default="Celular" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="celular" maxlength="13" required="" value="${pasajeroInstance?.celular}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pasajeroInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="pasajero.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${pasajeroInstance?.email}"/>
</div>

