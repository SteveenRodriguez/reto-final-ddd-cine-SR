package domain.cine.events;

import domain.cine.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PrecioDePeliculaDeCarteleraModificado extends DomainEvent {

    private final Precio precio;

    public PrecioDePeliculaDeCarteleraModificado (Precio precio){
        super("cineretoddd.domain.cine.preciodepeliculadecarteleramodificado");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}