package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.NombreDeVendedor;

public class ActualizarNombreDeVendedorDeTiquete implements Command {

    private final CineId cineId;
    private final NombreDeVendedor nombreDeVendedor;

    public ActualizarNombreDeVendedorDeTiquete (CineId cineId, NombreDeVendedor nombreDeVendedor){
        this.cineId = cineId;
        this.nombreDeVendedor = nombreDeVendedor;
    }

    public CineId getCineId() {
        return cineId;
    }

    public NombreDeVendedor getNombreDeVendedor() {
        return nombreDeVendedor;
    }
}
