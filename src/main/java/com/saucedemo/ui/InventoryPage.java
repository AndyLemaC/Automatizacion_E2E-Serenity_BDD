package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target PAGE_TITLE =
            Target.the("inventory page title")
                    .locatedBy(".title");

    public static final Target PRODUCT_LIST =
            Target.the("product list container")
                    .locatedBy(".inventory_list");

    public static final Target SHOPPING_CART_ICON =
            Target.the("shopping cart icon")
                    .locatedBy("[data-test='shopping-cart-link']");

    public static final Target CART_BADGE =
            Target.the("shopping cart badge counter")
                    .locatedBy(".shopping_cart_badge");

    public static Target addToCartButtonFor(String productName) {
        return Target.the("add to cart button for '" + productName + "'")
                .locatedBy("//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']" +
                        "/ancestor::div[@class='inventory_item']" +
                        "//button[contains(@data-test,'add-to-cart')]");
    }

    public static Target removeFromCartButtonFor(String productName) {
        return Target.the("remove from cart button for '" + productName + "'")
                .locatedBy("//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']" +
                        "/ancestor::div[@class='inventory_item']" +
                        "//button[contains(@data-test,'remove')]");
    }

    public static Target productNamed(String productName) {
        return Target.the("product named '" + productName + "'")
                .locatedBy("//div[@class='inventory_item_name' and text()='" + productName + "']");
    }
}
