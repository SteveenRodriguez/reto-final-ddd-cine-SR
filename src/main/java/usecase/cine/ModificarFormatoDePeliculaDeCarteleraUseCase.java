package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ModificarFormatoDePeliculaDeCartelera;

public class ModificarFormatoDePeliculaDeCarteleraUseCase extends UseCase <RequestCommand<ModificarFormatoDePeliculaDeCartelera>, ResponseEvents> {
    @Override

    public void executeUseCase (RequestCommand<ModificarFormatoDePeliculaDeCartelera>modificarFormatoDePeliculaDeCarteleraRequestCommand){
        var command = modificarFormatoDePeliculaDeCarteleraRequestCommand.getCommand();
        var formato = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        formato.modificarFormatoDePeliculaDeCartelera(command.getFormato());
        emit().onResponse(new ResponseEvents(formato.getUncommittedChanges()));
    }
}