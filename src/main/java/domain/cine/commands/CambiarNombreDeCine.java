package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.NombreCine;

public class CambiarNombreDeCine implements Command {

    private final CineId cineId;
    private final NombreCine nombreCine;

    public CambiarNombreDeCine (CineId cineId, NombreCine nombreCine){
        this.cineId = cineId;
        this.nombreCine = nombreCine;
    }

    public CineId getCineId() {
        return cineId;
    }

    public NombreCine getNombreCine() {
        return nombreCine;
    }
}