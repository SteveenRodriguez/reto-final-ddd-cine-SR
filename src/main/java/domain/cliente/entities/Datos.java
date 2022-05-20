package domain.cliente.entities;

import domain.cliente.values.Correo;
import domain.cliente.values.DatosId;
import domain.cliente.values.Telefono;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Datos extends Entity <DatosId> {

    private Correo correo;
    private Telefono telefono;

    public Datos (DatosId entityID, Correo correo, Telefono telefono){
        super(entityID);
        this.correo = correo;
        this.telefono = telefono;
    }

    public void cambiarCorreo (Correo correo){
        this.correo = Objects.requireNonNull(correo);
    }

    public void cambiarTelefono (Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public Correo correo(){
        return correo;
    }

    public Telefono telefono(){
        return telefono;
    }

}