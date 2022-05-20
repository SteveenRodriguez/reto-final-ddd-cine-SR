package domain.cine.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cine.entities.Cartelera;
import domain.cine.entities.Sala;
import domain.cine.entities.Tiquete;
import domain.cine.values.CineId;
import domain.cine.values.NombreCine;

public class CineCreado extends DomainEvent {

    private final CineId cineId;
    private final NombreCine nombreCine;
    private final Cartelera cartelera;
    private final Sala sala;
    private final Tiquete tiquete;

    public CineCreado(CineId cineId, NombreCine nombreCine, Cartelera cartelera, Sala sala, Tiquete tiquete){
        super("cineretoddd.domain.cine.cinecreado");
        this.cineId = cineId;
        this.nombreCine = nombreCine;
        this.cartelera = cartelera;
        this.sala = sala;
        this.tiquete = tiquete;
    }

    public CineId getCineId() {
        return cineId;
    }

    public NombreCine getNombreCine() {
        return nombreCine;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public Sala getSala() {
        return sala;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }
}
