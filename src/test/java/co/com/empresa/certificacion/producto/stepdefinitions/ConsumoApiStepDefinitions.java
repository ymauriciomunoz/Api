package co.com.empresa.certificacion.producto.stepdefinitions;

import co.com.empresa.certificacion.producto.models.Api;
import co.com.empresa.certificacion.producto.questions.ApiPost;
import co.com.empresa.certificacion.producto.tasks.ApiPostServicioAdicional;
import co.com.empresa.certificacion.producto.tasks.ApiPostServicioAdicionalOutline;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.regex.Matcher;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumoApiStepDefinitions {
    private EnvironmentVariables environmentVariables;
    @Given("^I want to run an Api$")
    public void iWantToRunAnApi() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("yeison oe2");

        //String baseUrl=environmentVariables.optionalProperty("https://reqres.in").orElse
               // ("https://reqres.in");
        theActorInTheSpotlight().whoCan(CallAnApi.at("https://reqres.in"));

    }

    @When("^run an Api with params$")
    public void runAnApiWithParams() {
        theActorInTheSpotlight().attemptsTo(ApiPostServicioAdicional.apiPostServicioAdicional());
    }

    @Then("^I Get a Response$")
    public void iGetAResponse() {
       theActorInTheSpotlight().should(GivenWhenThen.seeThat(ApiPost.apiPost(), Matchers.is(true)));
    }

    @When("^run an Api with params differents$")
    public void runAnApiWithParamsDifferents(List<Api> data) {
        theActorInTheSpotlight().attemptsTo(ApiPostServicioAdicionalOutline.apiPostServicioAdicionalOutline(data));
    }


}
