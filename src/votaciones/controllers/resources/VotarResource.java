package votaciones.controllers.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import votaciones.controllers.ejb.VotarEjb;
import votaciones.models.entities.Voto;

@Path("/voto")
public class VotarResource {
	@Context
	private UriInfo ui; // inyección de objetos
	@Context
	private HttpServletRequest request; // inyección de objetos

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response votoPost(Voto voto) {
		VotarEjb vEjb = new VotarEjb();
		String ip = request.getRemoteAddr();
		voto.setIpCliente(ip);
		if (!vEjb.votar(voto)) {
			return Response.status(400).build();
		} else {
			Logger.getLogger(VotarResource.class).info(
					"voto correcto: " + voto.toString());
			return Response.status(201).build();
		}
	}

}
