package com.saucedemo.stepdefinitions;

import com.saucedemo.config.SerenityWebDriverConfiguration;
import com.saucedemo.models.CsvDataReader;
import com.saucedemo.models.Customer;
import com.saucedemo.questions.CartItems;
import com.saucedemo.questions.OrderConfirmation;
import com.saucedemo.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CompraE2EStepDefinitions {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    private Actor buyer;
    private Customer customer;

    @Before
    public void setUp() {
        SerenityWebDriverConfiguration.setupChromeDriver();

        customer = CsvDataReader.loadPurchaseData();

        buyer = Actor.named("Buyer");
        buyer.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario está autenticado en SauceDemo")
    public void theUserIsAuthenticatedOnSauceDemo() {
        buyer.attemptsTo(
                Login.withCredentials(customer.getUsername(), customer.getPassword())
        );
    }

    @When("el usuario agrega dos productos al carrito")
    public void theUserAddsTwoProductsToTheCart() {
        buyer.attemptsTo(
                AddProductToCart.named(customer.getProduct1()),
                AddProductToCart.named(customer.getProduct2())
        );
    }

    @When("el usuario visualiza el carrito de compras")
    public void theUserViewsTheShoppingCart() {
        buyer.attemptsTo(
                ViewCart.contents()
        );
    }

    @When("el usuario completa el formulario de compra y confirma el pedido")
    public void theUserCompletesThePurchaseFormAndConfirmsTheOrder() {
        buyer.attemptsTo(
                CompleteCheckout.withDataFrom(customer)
        );
    }

    @Then("el carrito debe contener ambos productos seleccionados")
    public void theCartShouldContainBothSelectedProducts() {
        buyer.should(
                seeThat("the cart contains product 1",
                        CartItems.displayed(),
                        hasItem(customer.getProduct1())),
                seeThat("the cart contains product 2",
                        CartItems.displayed(),
                        hasItem(customer.getProduct2()))
        );
    }

    @Then("debe mostrarse el mensaje de confirmación {string}")
    public void theOrderConfirmationMessageShouldBeDisplayed(String expectedMessage) {
        buyer.should(
                seeThat("the order confirmation message",
                        OrderConfirmation.message(),
                        equalToIgnoringCase(expectedMessage))
        );
    }
}
