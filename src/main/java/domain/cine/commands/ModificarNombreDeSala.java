package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.NombreSala;

public class ModificarNombreDeSala implements Command {

    private final CineId cineId;
    private final NombreSala nombreSala;

    public ModificarNombreDeSala (CineId cineId, NombreSala nombreSala){
        this.cineId = cineId;
        this.nombreSala = nombreSala;
    }

    public CineId getCineId() {
        return cineId;
    }

    public NombreSala getNombreSala() {
        return nombreSala;
    }
}
