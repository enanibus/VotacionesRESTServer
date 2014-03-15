package votaciones.controllers.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class FormularioBean {
	private String nick;
	private String clave;
	private int edad;
	private String email;
	private String email2;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void validarNick(FacesContext context,
			UIComponent componentToValidate, Object value)
			throws ValidatorException {
		String nick = (String) value;
		if ((nick.equals("admin")) || (nick.equals("nick"))) {
			FacesMessage message = new FacesMessage("Nick ocupado. Elige otro.");
			throw new ValidatorException(message);
		}
	}

	public String process() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!getEmail().equals(getEmail2())) {
			context.addMessage("form", new FacesMessage(
					"Las direcciones de email deben ser iguales"));
		}
		if (context.getMessageList().size() > 0) {
			return null;
		}
		return "validatorOk";
	}

}
