package domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.FormaDePago;

public class PagoRealizado extends DomainEvent {

    private final FormaDePago formaDePago;

    public PagoRealizado(FormaDePago formaDePago){
        super("cineretoddd.domain.cliente.pagorealizado");
        this.formaDePago = formaDePago;
    }
    
    public FormaDePago getFormaDePago() {
        return formaDePago;
    }
}