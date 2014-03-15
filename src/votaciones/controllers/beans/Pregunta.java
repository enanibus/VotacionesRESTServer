package votaciones.controllers.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Pregunta {
	private static final String PREGUNTA = "¿CREES QUE LA SITUACIÓN ECONÓMICA DE ESPAÑA VA A MEJORAR?";

	public static String getPregunta() {
		return PREGUNTA;
	}
	
}
