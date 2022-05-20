package usecase.notifications;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cliente.events.SillaDeReservaModificada;
import domain.cliente.values.Silla;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class NotificarSillaUseCaseTest {

    private NotificarSillaUseCase notificarSillaUseCase;

    private ClienteService clienteService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup(){
        notificarSillaUseCase = new NotificarSillaUseCase();
        clienteService = mock(ClienteService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(clienteService);
        builder.addService(senderEmailService);

        notificarSillaUseCase.addServiceBuilder(builder);
    }

    @Test
    void notificarSillaReservadahappyPath(){
        var event = new SillaDeReservaModificada(
                new Silla("10C")
        );
        when(clienteService.getEmailByCliente(any())).thenReturn("cliente@gmail.com");
        doNothing().when(senderEmailService).sendEmail(any(),anyString());

        UseCaseHandler.getInstance()
                .syncExecutor(
                        notificarSillaUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(clienteService).getEmailByCliente(any());
        verify(senderEmailService).sendEmail(any(),anyString());
    }

}