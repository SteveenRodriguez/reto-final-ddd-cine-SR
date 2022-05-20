package domain.cine.values;

import co.com.sofka.domain.generic.Identity;

public class CineId extends Identity {
    public CineId(String id) {
        super(id);
    }

    public static CineId of(String id) {
        return new CineId(id);
    }

    public CineId (){

    }
}
