<%@page import="com.examen.portlet.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>PORTLET C</h1>


<%

Persona persona = (Persona)request.getAttribute("recibePersona");
if (persona!=null){
%>

	<div>NOMBRE: <input type="text" value="<%=persona.getNombre() %>"/></div>
	<div>DIRECCIÓN: <input type="text" value="<%=persona.getDireccion() %>"/></div>
	<div>TELÉFONO<input type="number" value="<%=persona.getTelefono() %>"/></div>

<%	
}else {
%>
<h3>Introduce tus datos en el PortletA</h3>
<%	
}
%>