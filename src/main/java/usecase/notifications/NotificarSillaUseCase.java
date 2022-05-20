package usecase.notifications;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cliente.events.SillaDeReservaModificada;

public class NotificarSillaUseCase extends UseCase<TriggeredEvent<SillaDeReservaModificada>, ResponseEvents> {

    public void executeUseCase(TriggeredEvent<SillaDeReservaModificada> sillaDeReservaModificadaTriggeredEvent) {
        var event = sillaDeReservaModificadaTriggeredEvent.getDomainEvent();
        var clienteService = getService(ClienteService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();


        var email = clienteService.getEmailByCliente("admin");
        sender.sendEmail(email, "Silla asignada No. 10C");

    }
}