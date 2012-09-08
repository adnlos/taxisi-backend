<%@ page import="taxisi.backend.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nick', 'error')} required">
	<label for="nick">
		<g:message code="usuario.nick.label" default="Nick" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nick" required="" value="${usuarioInstance?.nick}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${usuarioInstance?.password}"/>
</div>

