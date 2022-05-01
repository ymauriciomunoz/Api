package co.com.empresa.certificacion.producto.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/consumo_api.feature",
        glue= "co.com.empresa.certificacion.producto.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
//co.com.empresa.certificacion.producto.stepdefinitions
public class ConsumoApi {
}
