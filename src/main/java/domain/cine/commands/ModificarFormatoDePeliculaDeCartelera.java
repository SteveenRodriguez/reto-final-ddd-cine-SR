package domain.cine.commands;

import co.com.sofka.domain.generic.Command;
import domain.cine.values.CineId;
import domain.cine.values.Formato;

public class ModificarFormatoDePeliculaDeCartelera implements Command {

   private final Formato formato;
   private final CineId cineId;

    public ModificarFormatoDePeliculaDeCartelera (CineId cineId, Formato formato){
        this.cineId = cineId;
        this.formato = formato;
    }

   public Formato getFormato() {
        return formato;
    }

    public CineId getCineId() {
        return cineId;
    }
}