package usecase.notifications;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cliente.events.PagoRealizado;
import domain.cliente.values.FormaDePago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NotificarPagoRealizadoUseCaseTest {

    private NotificarPagoRealizadoUseCase notificarPagoRealizadoUseCase;

    private ClienteService clienteService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarPagoRealizadoUseCase = new NotificarPagoRealizadoUseCase();
        clienteService = mock(ClienteService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(clienteService);
        builder.addService(senderEmailService);

        notificarPagoRealizadoUseCase.addServiceBuilder(builder);
    }

    @Test
    void notificarPagoRealizadohappyPath(){
        var event = new PagoRealizado(
                new FormaDePago("En efectivo")
        );
        when(clienteService.getEmailByCliente(any())).thenReturn("cliente@gmail.com");
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarPagoRealizadoUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(clienteService).getEmailByCliente(any());
        verify(senderEmailService).sendEmail(any(),anyString());
    }

}