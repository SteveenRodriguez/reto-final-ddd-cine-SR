package domain.cine.events;

import domain.cine.values.Pelicula;
import co.com.sofka.domain.generic.DomainEvent;

public class PeliculaDeCarteleraModificada extends DomainEvent {

    private final Pelicula pelicula;

    public PeliculaDeCarteleraModificada (Pelicula pelicula){
        super("cineretoddd.domain.cine.peliculadecarteleramodificada");
        this.pelicula = pelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}