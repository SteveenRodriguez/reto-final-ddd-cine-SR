package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreSala implements ValueObject<String> {
    private final String value;

    public NombreSala(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Nombre de la sala vacío");
        }
    }

    public String value() {
        return value;
    }
}
