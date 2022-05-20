package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ModificarNombreDeSala;

public class ModificarNombreDeSalaUseCase extends UseCase <RequestCommand<ModificarNombreDeSala>, ResponseEvents> {

    @Override

    public void executeUseCase (RequestCommand<ModificarNombreDeSala>modificarNombreDeSalaRequestCommand){
        var command = modificarNombreDeSalaRequestCommand.getCommand();
        var nombreDeSala = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        nombreDeSala.modificarNombreDeSala(command.getNombreSala());
        emit().onResponse(new ResponseEvents(nombreDeSala.getUncommittedChanges()));
    }
}