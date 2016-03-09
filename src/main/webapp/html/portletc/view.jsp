<%@page import="com.examen.portlet.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>PORTLET C</h1>


<%
String nombre="";
String direccion="";
String telefono="";
Persona persona = (Persona)request.getAttribute("persona");
if (persona!=null){
	
	nombre=persona.getNombre();
	direccion=persona.getDireccion();
	telefono=persona.getTelefono();
}

%>

	<div>NOMBRE: <input type="text" value="<%=nombre %>"/></div>
	<div>DIRECCIÓN: <input type="text" value="<%=direccion %>"/></div>
	<div>TELÉFONO<input type="text" value="<%=telefono %>"/></div>
