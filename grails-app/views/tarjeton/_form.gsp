<%@ page import="taxisi.backend.Tarjeton" %>



<div class="fieldcontain ${hasErrors(bean: tarjetonInstance, field: 'numeroSerie', 'error')} required">
	<label for="numeroSerie">
		<g:message code="tarjeton.numeroSerie.label" default="Numero Serie" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numeroSerie" required="" value="${tarjetonInstance?.numeroSerie}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tarjetonInstance, field: 'chofer', 'error')} required">
	<label for="chofer">
		<g:message code="tarjeton.chofer.label" default="Chofer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="chofer" name="chofer.id" from="${taxisi.backend.Chofer.list()}" optionKey="id" required="" value="${tarjetonInstance?.chofer?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tarjetonInstance, field: 'tipoTargeton', 'error')} ">
	<label for="tipoTargeton">
		<g:message code="tarjeton.tipoTargeton.label" default="Tipo Targeton" />
		
	</label>
	<g:textField name="tipoTargeton" value="${tarjetonInstance?.tipoTargeton}"/>
</div>

