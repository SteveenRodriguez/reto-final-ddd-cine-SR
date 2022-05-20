package domain.cine.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCine implements ValueObject<String> {

    private final String value;

    public NombreCine(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre del cine está vacío");
        }
    }
    public String value(){
        return value;
    }
}