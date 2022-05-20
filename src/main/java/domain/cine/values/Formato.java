package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Formato implements ValueObject<String> {

    private final String value;

    public Formato(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Formato sin establecer");
        }
    }

    public String value() {
        return value;
    }
}
