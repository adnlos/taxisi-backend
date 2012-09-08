<%@ page import="taxisi.backend.IncidenteVial" %>



<div class="fieldcontain ${hasErrors(bean: incidenteVialInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="incidenteVial.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="latitude" required="" value="${incidenteVialInstance?.latitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: incidenteVialInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="incidenteVial.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longitude" required="" value="${incidenteVialInstance?.longitude}"/>
</div>

