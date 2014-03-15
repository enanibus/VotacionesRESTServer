package votaciones.controllers.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import votaciones.controllers.ejb.VotarEjb;
import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

@ManagedBean
@SessionScoped
public class VotarBeanJSF {

	private Voto voto;

	public VotarBeanJSF() {
		this.voto = new Voto();
	}

	public Respuesta[] getRespuestas() {
		return Respuesta.values();
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String getPregunta() {
		return Pregunta.getPregunta();
	}

	public void setPregunta(Pregunta pregunta) {
	}

	public String votar() {
		FacesContext context = FacesContext.getCurrentInstance();
		VotarEjb vEjb = new VotarEjb();
		String result = "votar";
		String ip = ((HttpServletRequest) context.getExternalContext()
				.getRequest()).getRemoteAddr();
		voto.setIpCliente(ip);
		if (!vEjb.votar(voto)) {
			context.addMessage("form", new FacesMessage(
					"Error en el proceso de votación"));
		} else {
			Logger.getLogger(VotarBeanJSF.class).info(
					"voto realizado correctamente: " + voto.toString());
		}
		return result;
	}

}