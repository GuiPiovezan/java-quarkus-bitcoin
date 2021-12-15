package br.com.shift.service;

import br.com.shift.model.Ordem;
import br.com.shift.model.Usuario;
import br.com.shift.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {

        Optional<Usuario> usuarioOptional =  Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();

        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new RuntimeException("O usuário logado é diferente da operação");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listarTodasAsOrdens(){
        return ordemRepository.listAll();
    }
}
