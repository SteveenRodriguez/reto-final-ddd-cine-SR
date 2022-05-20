package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.entities.Reserva;
import domain.cliente.values.ClienteId;

public class RealizarReserva implements Command {

    private final ClienteId clienteId;
    private final Reserva reserva;

    public RealizarReserva (ClienteId clienteId, Reserva reserva){
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