package co.com.empresa.certificacion.producto.tasks;

import co.com.empresa.certificacion.producto.models.Api;
import co.com.empresa.certificacion.producto.utils.Constantes;
import co.com.empresa.certificacion.producto.utils.ReadFile;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static io.restassured.http.ContentType.JSON;


public class ApiPostServicioAdicionalOutline implements Task {
    private Api api;

    public ApiPostServicioAdicionalOutline(List<Api> api) {
        this.api = api.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String body=String.format(ReadFile.returnFile(Constantes.RUTA),api.getName(),api.getJob());

        actor.attemptsTo(
                Post.to(Constantes.EndPoint).with(request -> request.contentType(JSON)
                .body(body).relaxedHTTPSValidation())

        );

        actor.remember("nameVerdadero",api.getName());
        actor.remember("nameRecibido",SerenityRest.lastResponse().jsonPath().getString("name"));
    }
    public static ApiPostServicioAdicionalOutline apiPostServicioAdicionalOutline(List<Api> api){
        return Tasks.instrumented(ApiPostServicioAdicionalOutline.class,api);
    }
}
