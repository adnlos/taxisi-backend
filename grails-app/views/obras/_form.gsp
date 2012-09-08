<%@ page import="taxisi.backend.Obras" %>



<div class="fieldcontain ${hasErrors(bean: obrasInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="obras.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="latitude" required="" value="${obrasInstance?.latitude}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: obrasInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="obras.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longitude" required="" value="${obrasInstance?.longitude}"/>
</div>

