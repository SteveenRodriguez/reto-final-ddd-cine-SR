package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ActualizarNombreDeVendedorDeTiquete;
import domain.cine.commands.ModificarHorarioDeCartelera;

public class ModificarHorarioDeCarteleraUseCase extends UseCase <RequestCommand<ModificarHorarioDeCartelera>, ResponseEvents>{

    @Override

    public void executeUseCase (RequestCommand<ModificarHorarioDeCartelera>modificarHorarioDeCarteleraRequestCommand){
        var command = modificarHorarioDeCarteleraRequestCommand.getCommand();
        var horario = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        horario.modificarHorarioDeCartelera(command.getHorario());
        emit().onResponse(new ResponseEvents(horario.getUncommittedChanges()));
    }
}