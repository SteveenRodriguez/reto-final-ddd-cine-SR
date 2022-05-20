package domain.cliente.events;

import domain.cliente.values.Silla;
import co.com.sofka.domain.generic.DomainEvent;

public class SillaDeReservaModificada extends DomainEvent {

    private final Silla silla;

    public SillaDeReservaModificada(Silla silla){
        super("cineretoddd.domain.cliente.silladereservamodificada");
        this.silla = silla;
    }

    public Silla getSilla() {
        return silla;
    }
}