package domain.cine.events;

import domain.cine.values.Formato;
import co.com.sofka.domain.generic.DomainEvent;

public class FormatoDePeliculaDeCarteleraModificado extends DomainEvent {

    private final Formato formato;

    public FormatoDePeliculaDeCarteleraModificado(Formato formato){
        super("cineretoddd.domain.cine.formatodepeliculadecarteleramodificado");
        this.formato = formato;
    }

    public Formato getFormato() {
        return formato;
    }

}