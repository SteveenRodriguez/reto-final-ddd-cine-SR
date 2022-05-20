package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.FechaHora;

public class ModificarFechaHoraDeReserva implements Command {

    private final ClienteId clienteId;
    private final FechaHora fechaHora;

    public ModificarFechaHoraDeReserva(ClienteId clienteId, FechaHora fechaHora){
        this.clienteId = clienteId;
        this.fechaHora = fechaHora;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public FechaHora getFechaHora() {
        return fechaHora;
    }
}