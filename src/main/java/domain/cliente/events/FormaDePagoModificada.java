package domain.cliente.events;

import domain.cliente.values.FormaDePago;
import co.com.sofka.domain.generic.DomainEvent;

public class FormaDePagoModificada extends DomainEvent {

    private final FormaDePago formaDePago;

    public FormaDePagoModificada(FormaDePago formaDePago){
        super("cineretoddd.domain.cliente.formadepagomodificada");
        this.formaDePago = formaDePago;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }
}