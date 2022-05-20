package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.commands.CambiarCorreoDeDatos;

public class CambiarCorreoDeDatosUseCase extends UseCase <RequestCommand<CambiarCorreoDeDatos>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarCorreoDeDatos>cambiarCorreoDeDatosRequestCommand){
        var command = cambiarCorreoDeDatosRequestCommand.getCommand();
        var correo = Cliente.from(command.getClienteId(), retrieveEvents(command.getCorreo().value()));
        correo.cambiarCorreoDeDatos(command.getCorreo());
       emit().onResponse(new ResponseEvents((correo.getUncommittedChanges())));
    }

}