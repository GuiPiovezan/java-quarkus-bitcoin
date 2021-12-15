package br.com.shift.resource;

import br.com.shift.model.Ordem;
import br.com.shift.service.OrdemService;

import javax.annotation.security.RolesAllowed;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/orders")
public class OrdermResource {

    @Inject
    OrdemService ordemService;

    @POST
    @RolesAllowed("user")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem){
        ordemService.inserir(securityContext, ordem);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar(){
        return ordemService.listarTodasAsOrdens();
    }
}
