package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ActualizarNombreDeVendedorDeTiquete;

public class ActualizarNombreDeVendedorDeTiqueteUseCase extends UseCase <RequestCommand<ActualizarNombreDeVendedorDeTiquete>, ResponseEvents> {
    @Override

    public void executeUseCase (RequestCommand<ActualizarNombreDeVendedorDeTiquete>actualizarNombreDeVendedorDeTiqueteRequestCommand){
        var command = actualizarNombreDeVendedorDeTiqueteRequestCommand.getCommand();
        var nombreVendedor = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        nombreVendedor.actualizarNombreDeVendedorDeTiquete(command.getNombreDeVendedor());
        emit().onResponse(new ResponseEvents(nombreVendedor.getUncommittedChanges()));
    }
}