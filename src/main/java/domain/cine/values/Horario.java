package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Horario implements ValueObject<String> {

    private final String value;

    public Horario(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Horario no establecido");
        }
    }

    public String value() {
        return value;
    }
}
