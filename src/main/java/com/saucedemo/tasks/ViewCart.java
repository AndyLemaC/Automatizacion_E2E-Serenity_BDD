package com.saucedemo.tasks;

import com.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewCart implements Task {

    public static ViewCart contents() {
        return new ViewCart();
    }

    @Step("{0} navigates to the shopping cart")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement cartLink = driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLink);

        actor.attemptsTo(
                WaitUntil.the(CartPage.PAGE_TITLE, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(CartPage.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(15).seconds()
        );
    }
}
