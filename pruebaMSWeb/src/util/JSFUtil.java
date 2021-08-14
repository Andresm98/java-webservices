package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {


	//Mensajes personalizados JSFG
	
	public static void crearMensajeInfo(String mensaje) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);	
		
	}
	
	public static void crearMensajeError(String mensaje) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
	
	public static void crearMensajeWarn(String mensaje) {
		FacesMessage msg = new FacesMessage();
		msg.setSeverity(FacesMessage.SEVERITY_WARN);
		msg.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, msg);	
	}
}