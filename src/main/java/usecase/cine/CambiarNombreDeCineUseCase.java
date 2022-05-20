package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.CambiarNombreDeCine;

public class CambiarNombreDeCineUseCase extends UseCase <RequestCommand<CambiarNombreDeCine>, ResponseEvents> {

    @Override
    public void executeUseCase (RequestCommand<CambiarNombreDeCine>cambiarNombreDeCineRequestCommand){
        var command = cambiarNombreDeCineRequestCommand.getCommand();
        var cine = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        cine.cambiarNombreDeCine(command.getNombreCine());
        emit().onResponse(new ResponseEvents(cine.getUncommittedChanges()));
    }
}
