package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    // ─── Step 1: Personal Information ────────────────────────────────────────

    public static final Target FIRST_NAME_FIELD =
            Target.the("first name input field")
                    .locatedBy("[data-test='firstName']");

    public static final Target LAST_NAME_FIELD =
            Target.the("last name input field")
                    .locatedBy("[data-test='lastName']");

    public static final Target POSTAL_CODE_FIELD =
            Target.the("postal code input field")
                    .locatedBy("[data-test='postalCode']");

    public static final Target CONTINUE_BUTTON =
            Target.the("continue button")
                    .locatedBy("[data-test='continue']");

    public static final Target CANCEL_BUTTON_STEP1 =
            Target.the("cancel button on step 1")
                    .locatedBy("[data-test='cancel']");

    public static final Target ERROR_MESSAGE =
            Target.the("checkout error message")
                    .locatedBy("[data-test='error']");

    // ─── Step 2: Order Overview ───────────────────────────────────────────────

    public static final Target ORDER_SUMMARY_ITEMS =
            Target.the("order summary items list")
                    .locatedBy(".cart_item");

    public static final Target SUBTOTAL_LABEL =
            Target.the("subtotal label")
                    .locatedBy(".summary_subtotal_label");

    public static final Target TAX_LABEL =
            Target.the("tax label")
                    .locatedBy(".summary_tax_label");

    public static final Target TOTAL_LABEL =
            Target.the("total price label")
                    .locatedBy(".summary_total_label");

    public static final Target PAYMENT_INFO =
            Target.the("payment information")
                    .locatedBy(".summary_value_label");

    public static final Target FINISH_BUTTON =
            Target.the("finish order button")
                    .locatedBy("[data-test='finish']");

    public static final Target CANCEL_BUTTON_STEP2 =
            Target.the("cancel button on step 2")
                    .locatedBy("[data-test='cancel']");
}
