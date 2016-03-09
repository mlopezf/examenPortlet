package com.examen.portlet.todos;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.examen.portlet.entidades.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {

	public static String TELEFONO = "telefono";
	public static String NOMBRE= "nombre";
	public static String DIRECCION= "direccion";
	
	
	protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletA.class);
	
	
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
  @ProcessAction(name="irAPortletB")

  public void irAPortletB(ActionRequest request, ActionResponse response) throws PortletException, IOException {
	
	  String nombre= request.getParameter(NOMBRE);
	  String direccion=request.getParameter(DIRECCION);
	  String telefono= request.getParameter(TELEFONO);
	  
	  Persona persona = new Persona(nombre, direccion, telefono);
	  
	 QName qName = new QName("http://examen.portlets.com", "irAPortletB", "x");
	 response.setEvent(qName, persona);
	 request.setAttribute("persona", persona);
	
}
    
  @ProcessAction(name="irAPortletC")

  public void irAPortletC(ActionRequest request, ActionResponse response) throws PortletException, IOException {
	
	  String nombre= request.getParameter(NOMBRE);
	  String direccion=request.getParameter(DIRECCION);
	  String telefono= request.getParameter(TELEFONO);
	  
	  Persona persona = new Persona(nombre, direccion,telefono);
	  
	 QName qName = new QName("http://examen.portlets.com", "irAPortletC", "x");
	 response.setEvent(qName, persona);
	 request.setAttribute("persona", persona);
	
}
  @ProcessEvent(qname="{http://examen.portlets.com}irAPortletB")

  public void recibirPortletA1(EventRequest request, EventResponse response) throws PortletException, IOException {
	
	  Event evento = request.getEvent();
	  Serializable persona = evento.getValue();
	  request.setAttribute("persona", persona);
	  
} 
  @ProcessEvent(qname="{http://examen.portlets.com}irAPortletC")
  public void recibirPortletA2(EventRequest request, EventResponse response) throws PortletException, IOException {
		
	  Event evento = request.getEvent();
	  Serializable persona = evento.getValue();
	  request.setAttribute("persona", persona);
	  
} 
  
}
