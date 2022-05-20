package domain.cine.events;

import domain.cine.values.Horario;
import co.com.sofka.domain.generic.DomainEvent;

public class HorarioDeCarteleraModificado extends DomainEvent {

    private final Horario horario;

    public  HorarioDeCarteleraModificado (Horario horario){
        super("cineretoddd.domain.cine.horariodecarteleramodificado");
        this.horario = horario;
    }

    public Horario getHorario() {
        return horario;
    }
}