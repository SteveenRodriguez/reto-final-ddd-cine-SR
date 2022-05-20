package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.commands.CambiarCorreoDeDatos;
import domain.cliente.entities.Datos;
import domain.cliente.entities.Pago;
import domain.cliente.entities.Reserva;
import domain.cliente.events.ClienteCreado;
import domain.cliente.events.CorreoDeDatosCambiado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarCorreoDeDatosUseCaseTest {

    private CambiarCorreoDeDatosUseCase cambiarCorreoDeDatosUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarCorreoDeDatosUseCase = new CambiarCorreoDeDatosUseCase();
        repository=mock(DomainEventRepository.class);
        cambiarCorreoDeDatosUseCase.addRepository(repository);
    }

    @Test
    void cambiarCorreoDeDatoshappyPath(){
        //arrage
        var command = new CambiarCorreoDeDatos(
                ClienteId.of("xxx-xxx"),
                new Correo("cliente@hotmail.com")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("---").syncExecutor(
                cambiarCorreoDeDatosUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(CorreoDeDatosCambiado)response.getDomainEvents().get(0);

        //Asserts
        Assertions.assertEquals("cliente@hotmail.com", event.getCorreo().value());
    }

    private List<DomainEvent> events() {
        return List.of(new ClienteCreado(
                new ClienteId("xxx-xx"),
                new NombreCliente("Paola"),
                new Datos(
                        new DatosId("--"),
                        new Correo("Tarde"),
                        new Telefono("NN")),
                new Pago(
                        new PagoId("--"),
                        new FormaDePago("Sala1")),
                new Reserva(
                        new ReservaId("--"),
                        new FechaHora("Joaquin"),
                        new Silla("Joaquin"))
        ));
    }
}
