package domain.cine.events;

import domain.cine.values.NombreCine;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeCineCambiado extends DomainEvent {

   private final NombreCine nombreCine;

    public NombreDeCineCambiado(NombreCine nombreCine){
        super("cineretoddd.domain.cine.nombredecineCambiado");
        this.nombreCine = nombreCine;
    }

    public NombreCine getNombreCine() {
        return nombreCine;
    }
}