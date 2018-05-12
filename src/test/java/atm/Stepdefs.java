package atm;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Stepdefs {
    private ATM atm;
    private double cash;
    private String exceptionMsg;

    @Given("^I have \\$(\\d+) in my account$")
    public void i_have_$_in_my_account(double amount) {
        atm = new ATM(amount);
    }

    @When("^I choose to withdraw the fixed amount of \\$(\\d+)$")
    public void i_choose_to_withdraw_the_fixed_amount_of_$(double amount) {
        try {
            cash = atm.withdraw(amount);
        } catch (IllegalArgumentException ex) {
            exceptionMsg = ex.getMessage();
        }
    }

    @Then("^I should Receive \\$(\\d+) cash$")
    public void i_should_Receive_$_cash(double amount) {
        assertThat(cash, is(amount));
    }

    @Then("^the balance of my account should be \\$(\\d+)$")
    public void the_balance_of_my_account_should_be_$(double amount) {
        double balance = atm.getBalance();
        assertThat(balance, is(amount));
    }

    @Then("^I should See an error message$")
    public void i_should_See_an_error_message() {
        assertThat(exceptionMsg, is("Not enough balance for this withdrawal."));
    }

}
