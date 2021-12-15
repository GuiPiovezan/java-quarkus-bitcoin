package br.com.shift.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.shift.model.Bitcoin;

@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoins-api")
public interface BitcoinService {
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();
	

}
