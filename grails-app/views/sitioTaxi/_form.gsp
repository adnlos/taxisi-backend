<%@ page import="taxisi.backend.SitioTaxi" %>



<div class="fieldcontain ${hasErrors(bean: sitioTaxiInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="sitioTaxi.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="latitude" required="" value="${sitioTaxiInstance?.latitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sitioTaxiInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="sitioTaxi.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longitude" required="" value="${sitioTaxiInstance?.longitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sitioTaxiInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="sitioTaxi.telefono.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" required="" value="${sitioTaxiInstance?.telefono}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sitioTaxiInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="sitioTaxi.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${sitioTaxiInstance?.nombre}"/>
</div>

