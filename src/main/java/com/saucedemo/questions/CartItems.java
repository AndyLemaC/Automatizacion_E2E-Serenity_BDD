package com.saucedemo.questions;

import com.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.stream.Collectors;

public class CartItems implements Question<List<String>> {

    public static CartItems displayed() {
        return new CartItems();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.ofEach(CartPage.CART_ITEM_NAMES)
                .answeredBy(actor)
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
