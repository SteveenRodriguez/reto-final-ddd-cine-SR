package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ModificarPeliculaDeCartelera;

public class ModificarPeliculaDeCarteleraUseCase extends UseCase <RequestCommand<ModificarPeliculaDeCartelera>, ResponseEvents> {
    @Override

    public void executeUseCase (RequestCommand<ModificarPeliculaDeCartelera>modificarPeliculaDeCarteleraRequestCommand){
        var command = modificarPeliculaDeCarteleraRequestCommand.getCommand();
        var pelicula = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        pelicula.modificarPeliculaDeCartelera(command.getPelicula());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}