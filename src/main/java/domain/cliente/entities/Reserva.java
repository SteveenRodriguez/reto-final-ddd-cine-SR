package domain.cliente.entities;

import domain.cliente.values.FechaHora;
import domain.cliente.values.ReservaId;
import domain.cliente.values.Silla;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Reserva extends Entity <ReservaId> {

    private FechaHora fechaHora;
    private Silla silla;

    public Reserva (ReservaId entityId, FechaHora fechaHora, Silla silla){
        super(entityId);
        this.fechaHora = fechaHora;
        this.silla = silla;
    }

    public void modificarFechaHora(FechaHora fechaHora){
        this.fechaHora = Objects.requireNonNull(fechaHora);
    }

    public void modificarSilla(Silla silla){
        this.silla = Objects.requireNonNull(silla);
    }

    public FechaHora fechaHora(){
        return fechaHora;
    }

    public Silla silla(){
        return silla;
    }
}
