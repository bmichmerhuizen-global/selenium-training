package features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	



	@Given("^This is a common given step from scenario \"([^\"]*)\"$")
	public void this_is_a_common_given_step_from_scenario(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^this is the when step from scenario (\\d+)$")
	public void this_is_the_when_step_from_scenario(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^and this is the last step from scenario (\\d+)$")
	public void and_this_is_the_last_step_from_scenario(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

}
