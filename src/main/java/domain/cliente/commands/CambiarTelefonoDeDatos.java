package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.Telefono;

public class CambiarTelefonoDeDatos implements Command {

    private final Telefono telefono;
    public final ClienteId clienteId;

    public CambiarTelefonoDeDatos (ClienteId clienteId, Telefono telefono){
        this.clienteId = clienteId;
        this.telefono = telefono;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}