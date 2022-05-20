package domain.cliente.entities;

import domain.cliente.values.FormaDePago;
import domain.cliente.values.PagoId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Pago extends Entity <PagoId> {

    private FormaDePago formaDePago;

    public Pago (PagoId entityId, FormaDePago formaDePago){
        super(entityId);
        this.formaDePago = formaDePago;
    }

    public void modificarFormaDePago(FormaDePago formaDePago){
        this.formaDePago = Objects.requireNonNull(formaDePago);
    }

    public FormaDePago formaDePago (){
        return formaDePago;
    }
}