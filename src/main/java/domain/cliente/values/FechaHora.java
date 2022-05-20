package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FechaHora implements ValueObject<String> {
    private final String value;

    public FechaHora(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Fecha y Hora no ha sido asignada");
        }
    }

    public String value() {
        return value;
    }
}