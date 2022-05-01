package co.com.empresa.certificacion.producto.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ApiPost implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        System.out.println(actor.recall("nameVerdadero").toString());
        System.out.println(actor.recall("nameRecibido").toString());
        return actor.recall("nameVerdadero").toString().
                equals(SerenityRest.lastResponse().jsonPath().getString("name"));
    }
    public static ApiPost apiPost(){
        return new ApiPost();
    }
}
