<%@page import="com.examen.portlet.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>PORTLET B</h1>

<%


Persona persona = (Persona)request.getAttribute("recibePersona");

%>

	<div>NOMBRE: <input type="text" name="<%=persona.getNombre() %>"/></div>
	<div>DIRECCI�N: <input type="text" name="<%=persona.getDireccion() %>"/></div>
	<div>TEL�FONO<input type="number" name="<%=persona.getTelefono() %>"/></div>

