package com.examen.portlet.todos;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletB
 */
public class PortletB extends GenericPortlet {
	
	public static String NOMBRE= "nombre";
	public static String DIRECCION= "direccion";
	public static String TELEFONO= "telefono";
	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletB.class);

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
 
  @ProcessEvent(qname="{http://examen.portlets.com}irAPortletB")

  public void recibirPortletA(EventRequest request, EventResponse response) throws PortletException, IOException {
	
	  Event evento = request.getEvent();
	  Serializable persona = evento.getValue();
	  request.setAttribute("persona", persona);
	  
}

}
