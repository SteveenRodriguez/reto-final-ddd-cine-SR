package domain.cine;

import domain.cine.events.*;
import co.com.sofka.domain.generic.EventChange;

public class CineChange extends EventChange {

    public CineChange(Cine cine){

        apply((CineCreado event) -> {
        cine.nombreCine = event.getNombreCine();
        cine.cartelera = event.getCartelera();
        cine.sala = event.getSala();
        cine.tiquete = event.getTiquete();
        });

        apply((FormatoDePeliculaDeCarteleraModificado event)->{
            cine.cartelera.modificarFormatoDePelicula(event.getFormato());
        });

        apply((HorarioDeCarteleraModificado event)->{
            cine.cartelera.modificarHorario(event.getHorario());
        });

        apply((NombreDeCineCambiado event)->{
            cine.nombreCine = event.getNombreCine();

        });

        apply((NombreDeSalaModificado event)->{
            cine.sala.modificarNombreDeSala(event.getNombreSala());
        });

        apply((NombreDeVendedorDeTiqueteActualizado event)->{
            cine.tiquete.actualizarNombreDeVendedor(event.getNombreDeVendedor());
        });

        apply((PeliculaDeCarteleraModificada event)->{
            cine.cartelera.modificarPelicula(event.getPelicula());
        });

        apply((PrecioDePeliculaDeCarteleraModificado event)->{
            cine.cartelera.modificarPrecioDePelicula(event.getPrecio());
        });
    }
}
