package votaciones.controllers.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class I18n implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot()
			.getLocale();
	private Date date = new Date();

	// Getters & setters
	public void change(String lg) {
		this.locale = new Locale(lg);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public String msg(String key) {
		return ResourceBundle.getBundle("i18n.messages", this.locale)
				.getString(key);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
