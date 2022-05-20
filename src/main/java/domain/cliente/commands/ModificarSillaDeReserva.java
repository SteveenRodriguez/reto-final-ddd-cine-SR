package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.Silla;

public class ModificarSillaDeReserva implements Command {

    private final ClienteId clienteId;
    private final Silla silla;

    public ModificarSillaDeReserva (ClienteId clienteId, Silla silla){
        this.clienteId = clienteId;
        this.silla = silla;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Silla getSilla() {
        return silla;
    }
}
