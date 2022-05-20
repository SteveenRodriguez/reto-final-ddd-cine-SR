package domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import domain.cliente.entities.Datos;
import domain.cliente.entities.Pago;
import domain.cliente.entities.Reserva;
import domain.cliente.values.ClienteId;
import domain.cliente.values.NombreCliente;

public class CrearCliente implements Command {

    private final ClienteId clienteId;
    private final NombreCliente nombreCliente;
    private final Datos datos;
    private final Pago pago;
    private final Reserva reserva;

public CrearCliente (ClienteId clienteId, NombreCliente nombreCliente, Datos datos, Pago pago, Reserva reserva){
    this.clienteId = clienteId;
    this.nombreCliente = nombreCliente;
    this.datos = datos;
    this.pago = pago;
    this.reserva = reserva;
}

    public ClienteId getClienteId() {
        return clienteId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public Datos getDatos() {
        return datos;
    }

    public Pago getPago() {
        return pago;
    }

    public Reserva getReserva() {
        return reserva;
    }
}
