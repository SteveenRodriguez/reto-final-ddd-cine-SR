package usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.commands.ModificarFormaDePago;
import domain.cliente.entities.Datos;
import domain.cliente.entities.Pago;
import domain.cliente.entities.Reserva;
import domain.cliente.events.ClienteCreado;
import domain.cliente.events.FormaDePagoModificada;
import domain.cliente.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModificarFormaDePagoUseCaseTest {

    private ModificarFormaDePagoUseCase modificarFormaDePagoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        modificarFormaDePagoUseCase = new ModificarFormaDePagoUseCase();
        repository=mock(DomainEventRepository.class);
        modificarFormaDePagoUseCase.addRepository(repository);
    }

    @Test
    void modificarFormaDePagohappyPath(){
        //arrage
        var command = new ModificarFormaDePago(
                ClienteId.of("xxx-xxx"),
                new FormaDePago("Tarjeta")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("---").syncExecutor(
                modificarFormaDePagoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event=(FormaDePagoModificada)response.getDomainEvents().get(0);

        //Asserts
        Assertions.assertEquals("Tarjeta", event.getFormaDePago().value());
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
