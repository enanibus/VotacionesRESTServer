package votaciones.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Voto
 * 
 */

@Entity @XmlRootElement
@Table(name = "Voto2")
public class Voto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ipCliente;
	private Respuesta respVoto;

	public Voto(int id, String ipCliente, Respuesta respVoto) {
		super();
		this.setId(id);
		this.setIpCliente(ipCliente);
		this.setRespVoto(respVoto);
	}

	public Voto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Respuesta getRespVoto() {
		return respVoto;
	}

	public void setRespVoto(Respuesta respVoto) {
		this.respVoto = respVoto;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ipCliente=" + ipCliente + ", respVoto="
				+ respVoto + "]";
	}

}
