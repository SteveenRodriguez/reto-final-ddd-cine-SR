package domain.cliente.events;

import domain.cliente.entities.Reserva;
import domain.cliente.values.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ReservaRealizada extends DomainEvent {

    private final ClienteId clienteId;
    private final Reserva reserva;

    public ReservaRealizada(ClienteId clienteId, Reserva reserva){
        super("cineretoddd.domain.cliente.reservarealizada");
        this.clienteId = clienteId;
        this.reserva = reserva;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Reserva getReserva() {
        return reserva;
    }

}