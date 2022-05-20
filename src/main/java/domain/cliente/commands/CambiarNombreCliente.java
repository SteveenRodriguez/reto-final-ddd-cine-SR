package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.NombreCliente;

public class CambiarNombreCliente implements Command {

    private final NombreCliente nombreCliente;
    private final ClienteId clienteId;

    public CambiarNombreCliente(ClienteId clienteId, NombreCliente nombreCliente){
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
