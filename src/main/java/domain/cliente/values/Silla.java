package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Silla implements ValueObject<String> {
    private final String value;

    public Silla(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La silla no ha sido relacionada");
        }
    }

    public String value() {
        return value;
    }
}