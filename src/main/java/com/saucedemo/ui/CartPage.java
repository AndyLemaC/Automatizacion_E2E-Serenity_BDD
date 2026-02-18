package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target PAGE_TITLE =
            Target.the("cart page title")
                    .locatedBy(".title");

    public static final Target CART_ITEMS_LIST =
            Target.the("cart items list")
                    .locatedBy(".cart_list");

    public static final Target CART_ITEM_NAMES =
            Target.the("cart item names")
                    .locatedBy(".cart_item .inventory_item_name");

    public static final Target CART_ITEM_PRICES =
            Target.the("cart item prices")
                    .locatedBy(".inventory_item_price");

    public static final Target CART_QUANTITY =
            Target.the("cart item quantity")
                    .locatedBy(".cart_quantity");

    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("continue shopping button")
                    .locatedBy("[data-test='continue-shopping']");

    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button")
                    .locatedBy("[data-test='checkout']");


    public static Target cartItemNamed(String productName) {
        return Target.the("cart item '" + productName + "'")
                .locatedBy("//div[@class='inventory_item_name' and text()='" + productName + "']");
    }
}
