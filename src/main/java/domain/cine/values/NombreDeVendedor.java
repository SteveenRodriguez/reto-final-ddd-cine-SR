package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreDeVendedor implements ValueObject {

    private final String value;

    public NombreDeVendedor(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Nombre de vender no relacionado");
        }
    }

    public String value() {
        return value;
    }
}
