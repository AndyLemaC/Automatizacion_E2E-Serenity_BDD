package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage {

    public static final Target CONFIRMATION_HEADER =
            Target.the("order confirmation header")
                    .locatedBy(".complete-header");

    public static final Target CONFIRMATION_TEXT =
            Target.the("order confirmation description text")
                    .locatedBy(".complete-text");

    public static final Target PONY_EXPRESS_IMAGE =
            Target.the("pony express confirmation image")
                    .locatedBy(".pony_express");

    public static final Target BACK_HOME_BUTTON =
            Target.the("back to products button")
                    .locatedBy("[data-test='back-to-products']");
}
