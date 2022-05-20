package domain.cliente.events;

import domain.cliente.values.FechaHora;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaHoraDeReservaModificada extends DomainEvent {

    private final FechaHora fechaHora;

    public FechaHoraDeReservaModificada(FechaHora fechaHora){
        super("cineretoddd.domain.cliente.fechahoradereservamodificada");
        this.fechaHora = fechaHora;
    }

    public FechaHora getFechaHora() {
        return fechaHora;
    }
}