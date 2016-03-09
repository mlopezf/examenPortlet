package com.examen.portlet.todos;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
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

	public static String NOMBRE= "nombre";
	public static String DIRECCION= "direccion";
	public static String TELEFONO= "telefono";
	
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
	  int telefono= Integer.parseInt(request.getParameter(TELEFONO));
	  
	  Persona persona = new Persona(nombre, direccion, telefono);
	  
	 QName qName = new QName("http://examen.portlets.com", "irAPortletB", "x");
	 response.setEvent(qName, persona);
	
}
    

}
