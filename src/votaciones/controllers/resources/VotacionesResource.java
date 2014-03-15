package votaciones.controllers.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

@Path("/votaciones")
public class VotacionesResource {
	
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Voto> get() {
    	return VotacionesEjb.votaciones();
    }
}
