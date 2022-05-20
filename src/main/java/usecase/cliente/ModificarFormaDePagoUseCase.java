package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.commands.ModificarFormaDePago;

public class ModificarFormaDePagoUseCase extends UseCase <RequestCommand<ModificarFormaDePago>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarFormaDePago>modificarFormaDePagoRequestCommand){
        var command = modificarFormaDePagoRequestCommand.getCommand();
        var formaPago = Cliente.from(command.getClienteId(), retrieveEvents(command.getFormaDePago().value()));
        formaPago.modificarFormaDePago(command.getFormaDePago());
        emit().onResponse(new ResponseEvents((formaPago.getUncommittedChanges())));
    }

}