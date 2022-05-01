package co.com.empresa.certificacion.producto.tasks;

import co.com.empresa.certificacion.producto.utils.ReadFile;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import co.com.empresa.certificacion.producto.utils.Constantes;
import org.openqa.selenium.json.Json;

import java.util.List;

import static io.restassured.http.ContentType.JSON;


public class ApiPostServicioAdicional implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        String body=String.format(ReadFile.returnFile(Constantes.RUTA),"Camila","QA");

        actor.attemptsTo(
                Post.to(Constantes.EndPoint).with(request -> request.contentType(JSON)
                .body(body).relaxedHTTPSValidation())

        );

        actor.remember("nameVerdadero","Camila");
        actor.remember("nameRecibido",SerenityRest.lastResponse().jsonPath().getString("name"));
    }
    public static ApiPostServicioAdicional apiPostServicioAdicional(){
        return Tasks.instrumented(ApiPostServicioAdicional.class);
    }
}
