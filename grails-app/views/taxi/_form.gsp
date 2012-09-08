<%@ page import="taxisi.backend.Taxi" %>



<div class="fieldcontain ${hasErrors(bean: taxiInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="taxi.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="latitude" required="" value="${taxiInstance?.latitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taxiInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="taxi.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longitude" required="" value="${taxiInstance?.longitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taxiInstance, field: 'placas', 'error')} required">
	<label for="placas">
		<g:message code="taxi.placas.label" default="Placas" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="placas" required="" value="${taxiInstance?.placas}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taxiInstance, field: 'sitioTaxi', 'error')} required">
	<label for="sitioTaxi">
		<g:message code="taxi.sitioTaxi.label" default="Sitio Taxi" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sitioTaxi" name="sitioTaxi.id" from="${taxisi.backend.SitioTaxi.list()}" optionKey="id" required="" value="${taxiInstance?.sitioTaxi?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taxiInstance, field: 'tipo', 'error')} ">
	<label for="tipo">
		<g:message code="taxi.tipo.label" default="Tipo" />
		
	</label>
	<g:textField name="tipo" value="${taxiInstance?.tipo}"/>
</div>

