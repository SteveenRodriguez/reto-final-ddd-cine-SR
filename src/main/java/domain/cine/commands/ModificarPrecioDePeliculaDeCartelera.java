package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.Precio;

public class ModificarPrecioDePeliculaDeCartelera implements Command {

    private final CineId cineId;
    private final Precio precio;

    public ModificarPrecioDePeliculaDeCartelera (CineId cineId, Precio precio){
        this.cineId = cineId;
        this.precio = precio;
    }

    public CineId getCineId() {
        return cineId;
    }

    public Precio getPrecio() {
        return precio;
    }
}