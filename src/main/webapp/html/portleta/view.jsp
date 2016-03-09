<%@page import="com.examen.portlet.entidades.Persona"%>
<%@page import="com.examen.portlet.todos.PortletA"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:actionURL name="irAPortletB" var="irAPortletB"/>
<portlet:actionURL name="irAPortletC" var="irAPortletC"/>

<h1>PORTLET A</h1>


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



<form>
<input type="submit" value="PortletB" formaction="<%=irAPortletB %>" formmethod="post" />
<input type="submit" value="PortletC" formaction="<%=irAPortletC %>" formmethod="post"/>
	<div>NOMBRE: <input type="text" name="<%=PortletA.NOMBRE%>" value="<%=nombre%>"/></div>
	<div>DIRECCIÓN: <input type="text" name="<%=PortletA.DIRECCION%>"value="<%=direccion%>"/></div>
	<div>TELÉFONO<input type="text" name="<%=PortletA.TELEFONO%>"value="<%=telefono%>"/></div>


</form>



