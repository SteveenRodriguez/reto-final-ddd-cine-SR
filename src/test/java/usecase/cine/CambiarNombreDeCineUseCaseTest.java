package usecase.cine;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cine.commands.CambiarNombreDeCine;
import domain.cine.entities.Cartelera;
import domain.cine.entities.Sala;
import domain.cine.entities.Tiquete;
import domain.cine.events.CineCreado;
import domain.cine.events.NombreDeCineCambiado;
import domain.cine.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CambiarNombreDeCineUseCaseTest {

    private CambiarNombreDeCineUseCase cambiarNombreDeCineUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarNombreDeCineUseCase= new CambiarNombreDeCineUseCase();
        repository=mock(DomainEventRepository.class);
        cambiarNombreDeCineUseCase.addRepository(repository);
    }

    @Test
    void cambiarNombreDeCinehappyPath(){
        //arrage
        var command = new CambiarNombreDeCine(
                CineId.of("xxx-xxx"),
                new NombreCine("CineMax")
        );

        when(repository.getEventsBy(any())).thenReturn(events());


        //Act
        var response= UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xxx").syncExecutor(
                cambiarNombreDeCineUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(NombreDeCineCambiado)response.getDomainEvents().get(0);

        //Asserts:
        Assertions.assertEquals("CineMax", event.getNombreCine().value());

    }

    private List<DomainEvent> events() {
        return List.of(new CineCreado(
                new CineId("xxx-xx"),
                new NombreCine("CineCol"),
                new Cartelera(
                        new CarteleraId("--"),
                        new Horario("Tarde"),
                        new Pelicula("NN"),
                        new Formato("3D"),
                        new Precio("10000")),
                new Sala(
                        new SalaId("--"),
                        new NombreSala("Sala1"),
                        new Capacidad("50 personas")),
                new Tiquete(
                        new TiqueteId("--"),
                        new NombreDeVendedor("Joaquin"))
        ));
    }
}