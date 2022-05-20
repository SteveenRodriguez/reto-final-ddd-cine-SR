package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Pelicula implements ValueObject<String> {
    private final String value;

    public Pelicula(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Película sin definir");
        }
    }

    public String value() {
        return value;
    }
}