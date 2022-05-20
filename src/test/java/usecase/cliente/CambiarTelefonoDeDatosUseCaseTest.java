package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.commands.CambiarTelefonoDeDatos;
import domain.cliente.entities.Datos;
import domain.cliente.entities.Pago;
import domain.cliente.entities.Reserva;
import domain.cliente.events.ClienteCreado;
import domain.cliente.events.TelefonoDeDatosCambiado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarTelefonoDeDatosUseCaseTest {

    private CambiarTelefonoDeDatosUseCase cambiarTelefonoDeDatosUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarTelefonoDeDatosUseCase = new CambiarTelefonoDeDatosUseCase();
        repository=mock(DomainEventRepository.class);
        cambiarTelefonoDeDatosUseCase.addRepository(repository);
    }

    @Test
    void cambiarTelefonoDeDatoshappyPath(){
        //arrage
        var command = new CambiarTelefonoDeDatos(
                ClienteId.of("xxx-xxx"),
                new Telefono("3154854525")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("---").syncExecutor(
                cambiarTelefonoDeDatosUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(TelefonoDeDatosCambiado)response.getDomainEvents().get(0);

        //Asserts
        Assertions.assertEquals("3154854525", event.getTelefono().value());
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