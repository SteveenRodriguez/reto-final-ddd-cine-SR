package usecase.notifications;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cliente.events.PagoRealizado;

public class NotificarPagoRealizadoUseCase extends UseCase<TriggeredEvent<PagoRealizado>, ResponseEvents> {

    public void executeUseCase(TriggeredEvent<PagoRealizado> pagoRealizadoTriggeredEvent) {
        var event = pagoRealizadoTriggeredEvent.getDomainEvent();
        var clienteService = getService(ClienteService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();


        var email = clienteService.getEmailByCliente("admin");
        sender.sendEmail(email, "Nuevo pago cambiado");

    }
    }