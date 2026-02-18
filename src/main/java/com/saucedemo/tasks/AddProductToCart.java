package com.saucedemo.tasks;

import com.saucedemo.ui.InventoryPage;
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

public class AddProductToCart implements Task{

    private final String productName;

    private AddProductToCart(String productName) {
        this.productName = productName;
    }

    public static AddProductToCart named(String productName) {
        return new AddProductToCart(productName);
    }

    @Step("{0} adds product '#productName' to the shopping cart")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String addToCartXpath = "//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']" +
                "/ancestor::div[@class='inventory_item']" +
                "//button[contains(@data-test,'add-to-cart')]";
        WebElement addToCartButton = driver.findElement(By.xpath(addToCartXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);

        actor.attemptsTo(
                WaitUntil.the(InventoryPage.removeFromCartButtonFor(productName), isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
