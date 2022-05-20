package domain.cine.events;

import domain.cine.values.NombreSala;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeSalaModificado extends DomainEvent {

    private final NombreSala nombreSala;

    public NombreDeSalaModificado(NombreSala nombreSala){
        super("cineretoddd.domain.cine.nombredesalamodificado");
        this.nombreSala = nombreSala;
    }

    public NombreSala getNombreSala() {
        return nombreSala;
    }
}