package domain.cliente;

import domain.cliente.events.*;
import co.com.sofka.domain.generic.EventChange;

public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente){

        apply((ClienteCreado event) ->{
            cliente.nombreCliente = event.getNombreCliente();
            cliente.datos = event.getDatos();
            cliente.pago = event.getPago();
            cliente.reserva = cliente.reserva();
        });

        apply((CorreoDeDatosCambiado event) -> {
            cliente.datos.cambiarCorreo(event.getCorreo());
        });

        apply((FechaHoraDeReservaModificada event) ->{
            cliente.reserva.modificarFechaHora(event.getFechaHora());
        });

        apply((FormaDePagoModificada event) ->{
            cliente.pago.modificarFormaDePago(event.getFormaDePago());
        });

        apply((NombreClienteCambiado event) ->{
            cliente.cambiarNombreCliente(event.getClienteId(), event.getNombreCliente());
        });

        apply((PagoRealizado event) ->{
            cliente.realizarPago(event.getFormaDePago());
        });

        apply((ReservaRealizada event) ->{
            cliente.realizarReserva(event.getClienteId(), event.getReserva());
        });

        apply((SillaDeReservaModificada event) ->{
            cliente.modificarSillaDeReserva(event.getSilla());
        });

        apply((TelefonoDeDatosCambiado event) ->{
            cliente.datos.cambiarTelefono(event.getTelefono());
        });
    }
}