package domain.cine.values;

import co.com.sofka.domain.generic.Identity;

public class CarteleraId extends Identity {

    public CarteleraId(){

    }

    public CarteleraId(String id){
        super(id);
    }

    public static CarteleraId of(String id){
        return new CarteleraId(id);

    }
}
