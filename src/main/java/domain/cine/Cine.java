package domain.cine;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cine.entities.Cartelera;
import domain.cine.entities.Sala;
import domain.cine.entities.Tiquete;
import domain.cine.events.*;
import domain.cine.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import java.util.List;

public class Cine extends AggregateEvent <CineId>{

protected NombreCine nombreCine;
protected Sala sala;
protected Cartelera cartelera;
protected Tiquete tiquete;

public Cine (CineId cineId, NombreCine nombreCine, Cartelera cartelera, Sala sala, Tiquete tiquete){
    super(cineId);
    appendChange(new CineCreado(cineId, nombreCine, cartelera, sala, tiquete)).apply();
}

    private Cine(CineId cineId){
        super(cineId);
        subscribe(new CineChange(this));
    }

    //Factoría que permite crear el agregado
    public static Cine from (CineId cineId, List<DomainEvent> events){
        var cine = new Cine(cineId);
        events.forEach(cine::applyEvent);
        return cine;
    }

    public void cambiarNombreDeCine (NombreCine nombreCine){
        appendChange(new NombreDeCineCambiado(nombreCine)).apply();
    }

    public void modificarNombreDeSala (NombreSala nombreSala){
        appendChange(new NombreDeSalaModificado(nombreSala)).apply();
    }

    public void modificarHorarioDeCartelera (Horario horario){
        appendChange(new HorarioDeCarteleraModificado(horario)).apply();
    }

    public void modificarPeliculaDeCartelera (Pelicula pelicula){
        appendChange(new PeliculaDeCarteleraModificada(pelicula)).apply();
    }

    public void modificarFormatoDePeliculaDeCartelera (Formato formato){
        appendChange(new FormatoDePeliculaDeCarteleraModificado(formato)).apply();
    }

    public void modificarPrecioDePeliculaDeCartelera (Precio precio){
        appendChange(new PrecioDePeliculaDeCarteleraModificado(precio)).apply();
    }

    public void actualizarNombreDeVendedorDeTiquete (NombreDeVendedor nombreDeVendedor){
        appendChange(new NombreDeVendedorDeTiqueteActualizado(nombreDeVendedor)).apply();
    }

    public Cartelera cartelera() {
        return cartelera;
    }

    public NombreCine nombreCine() {
        return nombreCine;
    }

    public Sala sala() {
        return sala;
    }

    public Tiquete tiquete() {
        return tiquete;
    }

}