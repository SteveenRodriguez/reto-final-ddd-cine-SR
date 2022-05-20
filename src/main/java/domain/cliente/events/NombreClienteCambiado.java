package domain.cliente.events;

import domain.cliente.values.ClienteId;
import domain.cliente.values.NombreCliente;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreClienteCambiado extends DomainEvent {

    private final NombreCliente nombreCliente;
    private final ClienteId clienteId;

    public NombreClienteCambiado (ClienteId clienteId, NombreCliente nombreCliente){
        super("cineretoddd.domain.cliente.nombreclientecambiado");
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}