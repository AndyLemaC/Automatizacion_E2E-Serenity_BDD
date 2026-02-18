# Prueba E2E de Compra en SauceDemo con Serenity BDD

Este proyecto implementa una prueba funcional automatizada de extremo a extremo (E2E) sobre `https://www.saucedemo.com/`, utilizando Serenity BDD con el patron Screenplay.

---

## ✅ Requisitos Previos

- Java JDK 11 o superior
- Maven 3.9.12
- IntelliJ IDEA (recomendado)
- Google Chrome actualizado

---

## ⚙️ Configuración del Entorno

### 1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/AndyLemaC/Automatizacion_E2E-Serenity_BDD.git
cd compra_test_e2e
```

### 2️⃣ Configurar IntelliJ IDEA

Instalar plugins recomendados:

  - Maven Integration
  - Cucumber for Java
  - Gherkin

### 3️⃣ Importar el Proyecto

1. Abrir IntelliJ IDEA
2. Seleccionar **"Open"** y elegir el archivo `pom.xml`
3. Elegir la opción **"Open as Project"**

---

## ▶️ Ejecución de Pruebas

### Desde IntelliJ IDEA

- Ir a `src/test/java/com/saucedemo/runners/TestRunner.java`
- Click derecho -> `Run TestRunner`

### Desde linea de comandos

```bash
# Ejecutar todas las pruebas
mvn clean verify

# Ejecutar pruebas con un tag especifico
mvn clean verify -Dtags="@compra"
```

---

## 🗂️ Estructura del Proyecto

```
e2e_compra/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── saucedemo/
│   │   │           ├── Main.java
│   │   │           ├── config/
│   │   │           │   ├── SerenityWebDriverConfiguration.java   # Setup de WebDriver
│   │   │           │   └── WebDriverConfig.java                  # Configuración ChromeDriver
│   │   │           ├── models/
│   │   │           │   ├── CsvDataReader.java                    # Lector de datos CSV
│   │   │           │   └── Customer.java                         # Modelo de datos de cliente
│   │   │           ├── questions/
│   │   │           │   ├── CartItems.java                        # Validación de productos en carrito
│   │   │           │   └── OrderConfirmation.java                # Validación de confirmación final
│   │   │           ├── tasks/
│   │   │           │   ├── AddProductToCart.java                 # Agregar productos
│   │   │           │   ├── CompleteCheckout.java                 # Completar checkout
│   │   │           │   ├── Login.java                            # Login en SauceDemo
│   │   │           │   └── ViewCart.java                         # Ir al carrito
│   │   │           └── ui/
│   │   │               ├── CartPage.java                         # Targets del carrito
│   │   │               ├── CheckoutPage.java                     # Targets de checkout
│   │   │               ├── ConfirmationPage.java                 # Targets de confirmación
│   │   │               ├── InventoryPage.java                    # Targets de inventario
│   │   │               └── LoginPage.java                        # Targets de login
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── saucedemo/
│       │           ├── runners/
│       │           │   └── TestRunner.java                       # Runner de pruebas Cucumber/Serenity
│       │           └── stepdefinitions/
│       │               └── CompraE2EStepDefinitions.java         # Definición de pasos E2E
│       └── resources/
│           ├── features/
│           │   └── purchase_flow.feature                         # Escenario E2E de compra
│           └── testdata/
│               └── Purchase_Data.csv                             # Datos de prueba
├── target/                                                       # Carpeta generada por Maven/Serenity
├── .gitignore
├── conclusiones.txt
├── pom.xml                                                       # Configuración Maven
├── README.md                                                     # Documentación del proyecto
└── serenity.properties                                           # Configuración Serenity/WebDriver
```

---

## 🧠 Patrón Screenplay

Se aplicó el patrón **Screenplay**, que favorece la escalabilidad, legibilidad y mantenibilidad de las pruebas.

### Componentes clave:

- 🎭 **Actors**: representan usuarios que interactúan con la aplicación
- 🧩 **Tasks**: acciones que realizan los actores (agregar producto, finalizar compra)
- ❓ **Questions**: validan resultados esperados (confirmación de compra, items en el carrito)
- 🗺️ **PageObjects**: encapsulan los elementos de la UI con Targets

---

## 🧩 Cobertura del Ejercicio

1. Autenticarse con el usuario `standard_user` y password `secret_sauce`.
2. Agregar dos productos al carrito.
3. Visualizar el carrito.
4. Completar el formulario de compra.
5. Finalizar la compra hasta la confirmacion: `THANK YOU FOR YOUR ORDER`.

---

## 📊 Reportes de Pruebas

Los reportes generados se ubican en:

```
target/site/serenity/
```

Abre el archivo:

```
target/site/serenity/index.html
```

Para visualizar el resultado completo con capturas y pasos ejecutados.

---


Para visualizar el resultado completo con capturas y pasos ejecutados.
