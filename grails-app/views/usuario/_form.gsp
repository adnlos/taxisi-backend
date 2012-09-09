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

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="usuario.role.label" default="Role" />
		
	</label>
	<g:select name="role" from="${usuarioInstance.constraints.role.inList}" value="${usuarioInstance?.role}" valueMessagePrefix="usuario.role" noSelection="['': '']"/>
</div>

