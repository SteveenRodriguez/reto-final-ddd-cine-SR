package domain.cine.events;

import domain.cine.values.NombreDeVendedor;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeVendedorDeTiqueteActualizado extends DomainEvent {

    private final NombreDeVendedor nombreDeVendedor;

    public NombreDeVendedorDeTiqueteActualizado(NombreDeVendedor nombreDeVendedor){
        super("cineretoddd.domain.cine.nombredevendedordetiqueteactualizado");
        this.nombreDeVendedor = nombreDeVendedor;
    }

    public NombreDeVendedor getNombreDeVendedor() {
        return nombreDeVendedor;
    }
}