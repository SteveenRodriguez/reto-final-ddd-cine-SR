package usecase.cine;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cine.Cine;
import domain.cine.commands.ActualizarNombreDeVendedorDeTiquete;
import domain.cine.commands.ModificarPrecioDePeliculaDeCartelera;

public class ModificarPrecioDePeliculaDeCarteleraUseCase extends UseCase <RequestCommand<ModificarPrecioDePeliculaDeCartelera>, ResponseEvents> {

    @Override

    public void executeUseCase (RequestCommand<ModificarPrecioDePeliculaDeCartelera>modificarPrecioDePeliculaDeCarteleraRequestCommand){
        var command = modificarPrecioDePeliculaDeCarteleraRequestCommand.getCommand();
        var precioPelicula = Cine.from(command.getCineId(), retrieveEvents(command.getCineId().value()));
        precioPelicula.modificarPrecioDePeliculaDeCartelera(command.getPrecio());
        emit().onResponse(new ResponseEvents(precioPelicula.getUncommittedChanges()));
    }
}