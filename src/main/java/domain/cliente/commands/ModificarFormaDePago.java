package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteId;
import domain.cliente.values.FormaDePago;

public class ModificarFormaDePago implements Command {

    private final ClienteId clienteId;
    private final FormaDePago formaDePago;

    public ModificarFormaDePago(ClienteId clienteId, FormaDePago formaDePago){
        this.clienteId = clienteId;
        this.formaDePago = formaDePago;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }
}
