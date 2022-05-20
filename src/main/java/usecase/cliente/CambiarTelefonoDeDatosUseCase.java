package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.commands.CambiarTelefonoDeDatos;

public class CambiarTelefonoDeDatosUseCase extends UseCase <RequestCommand<CambiarTelefonoDeDatos>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoDeDatos>cambiarTelefonoDeDatosRequestCommand){
        var command = cambiarTelefonoDeDatosRequestCommand.getCommand();
        var telefono = Cliente.from(command.getClienteId(), retrieveEvents(command.getTelefono().value()));
        telefono.cambiarTelefonoDeDatos(command.getTelefono());
        emit().onResponse(new ResponseEvents((telefono.getUncommittedChanges())));
    }

}
