package br.com.shift.repository;

import br.com.shift.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class OrdemRepositoryTest {

    @InjectMock
    OrdemRepository ordemRepository;

    @Test
    public void testarSeRetornoDasOrdensEstaCorreto(){
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();

        List<Ordem> ordens = new ArrayList<>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(this.ordemRepository.listAll()).thenReturn(ordens);

        Assertions.assertSame(segundaOrdem, this.ordemRepository.listAll().get(1));
    }
}
