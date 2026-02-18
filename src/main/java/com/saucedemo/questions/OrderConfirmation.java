package com.saucedemo.questions;

import com.saucedemo.ui.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmationPage.CONFIRMATION_HEADER)
                .answeredBy(actor)
                .trim();
    }
}

