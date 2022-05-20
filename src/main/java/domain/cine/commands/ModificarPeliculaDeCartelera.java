package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.Pelicula;

public class ModificarPeliculaDeCartelera implements Command {

    private final CineId cineId;
    private final Pelicula pelicula;

    public ModificarPeliculaDeCartelera(CineId cineId, Pelicula pelicula){
        this.cineId = cineId;
        this.pelicula = pelicula;
    }

    public CineId getCineId() {
        return cineId;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
