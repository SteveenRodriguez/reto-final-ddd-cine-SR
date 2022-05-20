package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.Correo;

public class CambiarCorreoDeDatos implements Command {

    private final Correo correo;
    private final ClienteId clienteId;

    public CambiarCorreoDeDatos(ClienteId clienteId, Correo correo) {
        this.clienteId = clienteId;
        this.correo = correo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Correo getCorreo() {
        return correo;
    }
}