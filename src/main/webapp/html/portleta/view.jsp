<%@page import="com.examen.portlet.todos.PortletA"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />



<h1>PORTLET A</h1>

<form>
<input type="submit" value="PortletB" formaction="urlPortletB" formmethod="post" />
<input type="submit" value="PortletC" formaction="urlPortletC" formmethod="post"/>
	<div>NOMBRE: <input type="text" name="<%=PortletA.NOMBRE %>"/></div>
	<div>DIRECCIÓN: <input type="text" name="<%=PortletA.DIRECCION %>"/></div>
	<div>TELÉFONO<input type="number" name="<%=PortletA.TELEFONO %>"/></div>


</form>




