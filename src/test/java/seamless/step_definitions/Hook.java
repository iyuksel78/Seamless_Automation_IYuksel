package seamless.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
    @Before
    public void setup(Scenario scenario){
        System.out.println(" running before the scenarios");
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());
    }
}
