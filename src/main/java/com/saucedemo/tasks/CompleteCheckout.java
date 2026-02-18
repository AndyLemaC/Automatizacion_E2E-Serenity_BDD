package com.saucedemo.tasks;

import com.saucedemo.models.Customer;
import com.saucedemo.ui.CheckoutPage;
import com.saucedemo.ui.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {
    private final Customer customer;

    private CompleteCheckout(Customer customer) {
        this.customer = customer;
    }

    public static CompleteCheckout withDataFrom(Customer customer) {
        return new CompleteCheckout(customer);
    }

    @Step("{0} completes checkout with customer data for '#customer.firstName #customer.lastName'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/checkout-step-one.html"),
                WaitUntil.the(CheckoutPage.FIRST_NAME_FIELD, isVisible()).forNoMoreThan(15).seconds()
        );

        actor.attemptsTo(
                Enter.theValue(customer.getFirstName()).into(CheckoutPage.FIRST_NAME_FIELD)
        );

        actor.attemptsTo(
                Enter.theValue(customer.getLastName()).into(CheckoutPage.LAST_NAME_FIELD)
        );

        actor.attemptsTo(
                Enter.theValue(customer.getPostalCode()).into(CheckoutPage.POSTAL_CODE_FIELD)
        );

        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/checkout-step-two.html")
        );

        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/checkout-complete.html"),
                WaitUntil.the(ConfirmationPage.CONFIRMATION_HEADER, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
