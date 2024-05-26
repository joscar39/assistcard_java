package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/QuotationPage.feature"},
        glue = {"StepsDefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)

public class RunnerQuotation {
}
