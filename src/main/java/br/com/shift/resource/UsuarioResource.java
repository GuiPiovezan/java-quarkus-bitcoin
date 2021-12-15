package br.com.shift.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import br.com.shift.model.Usuario;

import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.adicionar(usuario);
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar(){
		 return Usuario.listAll();
	}
}
