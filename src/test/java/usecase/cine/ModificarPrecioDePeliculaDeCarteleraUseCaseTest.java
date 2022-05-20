package usecase.cine;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cine.commands.ModificarPrecioDePeliculaDeCartelera;
import domain.cine.entities.Cartelera;
import domain.cine.entities.Sala;
import domain.cine.entities.Tiquete;
import domain.cine.events.CineCreado;
import domain.cine.events.PrecioDePeliculaDeCarteleraModificado;
import domain.cine.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModificarPrecioDePeliculaDeCarteleraUseCaseTest {

    private ModificarPrecioDePeliculaDeCarteleraUseCase modificarPrecioDePeliculaDeCarteleraUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        modificarPrecioDePeliculaDeCarteleraUseCase = new ModificarPrecioDePeliculaDeCarteleraUseCase();
        repository=mock(DomainEventRepository.class);
        modificarPrecioDePeliculaDeCarteleraUseCase.addRepository(repository);
    }

    @Test
    void modificarPrecioDePeliculaDeCartelerahappyPath(){
        //arrage
        var command = new ModificarPrecioDePeliculaDeCartelera(
                CineId.of("xxx-xxx"),
                new Precio("15000")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("---").syncExecutor(
                modificarPrecioDePeliculaDeCarteleraUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(PrecioDePeliculaDeCarteleraModificado)response.getDomainEvents().get(0);

        //Asserts
        Assertions.assertEquals("15000", event.getPrecio().value());
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