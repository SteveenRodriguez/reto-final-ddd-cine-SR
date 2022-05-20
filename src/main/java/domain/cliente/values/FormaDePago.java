package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FormaDePago implements ValueObject<String> {
    private final String value;

    public FormaDePago(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La forma de pago no ha sido relacionada");
        }
    }

    public String value() {
        return value;
    }
}