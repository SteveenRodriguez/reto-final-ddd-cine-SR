package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.Horario;

public class ModificarHorarioDeCartelera implements Command {

    private final Horario horario;
    private final CineId cineId;

    public ModificarHorarioDeCartelera(CineId cineId, Horario horario){
        this.cineId = cineId;
        this.horario = horario;
    }

    public CineId getCineId() {
        return cineId;
    }

    public Horario getHorario() {
        return horario;
    }
}