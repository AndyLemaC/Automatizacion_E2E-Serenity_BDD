@purchase
Feature: Flujo de compra en SauceDemo

  Como cliente registrado
  Quiero comprar productos en SauceDemo
  Para completar una orden exitosa

  Background:
    Given que el usuario está autenticado en SauceDemo

  @smoke @regression
  Scenario: Compra exitosa end-to-end de dos productos
    When el usuario agrega dos productos al carrito
    And el usuario visualiza el carrito de compras
    Then el carrito debe contener ambos productos seleccionados
    When el usuario completa el formulario de compra y confirma el pedido
    Then debe mostrarse el mensaje de confirmación "Thank you for your order!"
