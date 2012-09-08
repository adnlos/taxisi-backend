<%@ page import="taxisi.backend.ReporteEvaluacion" %>



<div class="fieldcontain ${hasErrors(bean: reporteEvaluacionInstance, field: 'pasajero', 'error')} required">
	<label for="pasajero">
		<g:message code="reporteEvaluacion.pasajero.label" default="Pasajero" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pasajero" name="pasajero.id" from="${taxisi.backend.Pasajero.list()}" optionKey="id" required="" value="${reporteEvaluacionInstance?.pasajero?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reporteEvaluacionInstance, field: 'tipoReporte', 'error')} required">
	<label for="tipoReporte">
		<g:message code="reporteEvaluacion.tipoReporte.label" default="Tipo Reporte" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="tipoReporte" required="" value="${reporteEvaluacionInstance?.tipoReporte}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reporteEvaluacionInstance, field: 'evaluacion', 'error')} required">
	<label for="evaluacion">
		<g:message code="reporteEvaluacion.evaluacion.label" default="Evaluacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="evaluacion" required="" value="${reporteEvaluacionInstance?.evaluacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reporteEvaluacionInstance, field: 'chofer', 'error')} required">
	<label for="chofer">
		<g:message code="reporteEvaluacion.chofer.label" default="Chofer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="chofer" name="chofer.id" from="${taxisi.backend.Chofer.list()}" optionKey="id" required="" value="${reporteEvaluacionInstance?.chofer?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reporteEvaluacionInstance, field: 'foto', 'error')} ">
	<label for="foto">
		<g:message code="reporteEvaluacion.foto.label" default="Foto" />
		
	</label>
	<g:textField name="foto" value="${reporteEvaluacionInstance?.foto}"/>
</div>

