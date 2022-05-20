package domain.cliente.events;

import domain.cliente.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class TelefonoDeDatosCambiado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoDeDatosCambiado (Telefono telefono){
        super("cineretoddd.domain.cliente.telefonodedatoscambiado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}