package usecase.cine;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cine.commands.ModificarFormatoDePeliculaDeCartelera;
import domain.cine.entities.Cartelera;
import domain.cine.entities.Sala;
import domain.cine.entities.Tiquete;
import domain.cine.events.CineCreado;
import domain.cine.events.FormatoDePeliculaDeCarteleraModificado;
import domain.cine.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModificarFormatoDePeliculaDeCarteleraUseCaseTest {

    private ModificarFormatoDePeliculaDeCarteleraUseCase modificarFormatoDePeliculaDeCarteleraUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        modificarFormatoDePeliculaDeCarteleraUseCase = new ModificarFormatoDePeliculaDeCarteleraUseCase();
        repository=mock(DomainEventRepository.class);
        modificarFormatoDePeliculaDeCarteleraUseCase.addRepository(repository);
    }

    @Test
    void modificarFormatoDePeliculaDeCartelerahappyPath(){
        //arrage
        var command = new ModificarFormatoDePeliculaDeCartelera(
                CineId.of("xxx-xxx"),
                new Formato("2D")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("---").syncExecutor(
                modificarFormatoDePeliculaDeCarteleraUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(FormatoDePeliculaDeCarteleraModificado)response.getDomainEvents().get(0);

        //Asserts
        Assertions.assertEquals("2D", event.getFormato().value());
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
