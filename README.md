# Prueba E2E de Compra en SauceDemo con Serenity BDD

Este proyecto implementa una prueba funcional automatizada de extremo a extremo (E2E) sobre `https://www.saucedemo.com/`, utilizando Serenity BDD con el patron Screenplay.

## Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6.3 o superior
- IntelliJ IDEA (recomendado)
- Google Chrome actualizado

## Configuracion del Entorno

1. Clonar el repositorio

```bash
git clone https://github.com/AndyLemaC/compra_test_e2e.git
cd compra_test_e2e
```

2. Configurar IntelliJ IDEA
- Instalar plugins recomendados:
  - Maven Integration
  - Cucumber for Java
  - Gherkin

3. Importar el proyecto
- Abrir IntelliJ IDEA
- Seleccionar `Open` y elegir el archivo `pom.xml`
- Elegir la opcion `Open as Project`

## Ejecucion de Pruebas

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

## Datos de Prueba

El archivo de datos se encuentra en:

`src/test/resources/testdata/Purchase_Data.csv`

Formato esperado:

```csv
username,password,product1,product2,firstName,lastName,postalCode
standard_user,secret_sauce,Sauce Labs Backpack,Sauce Labs Bike Light,Andy,Lema,12345
```

## Componentes Clave

- Actors: representan usuarios que interactuan con la aplicacion.
- Tasks: acciones que realizan los actores (agregar producto, finalizar compra).
- Questions: validan resultados esperados (confirmacion de compra, items en el carrito).
- PageObjects: encapsulan los elementos de la UI con `Target`.

## Cobertura del Ejercicio

- Autenticarse con el usuario `standard_user` y password `secret_sauce`.
- Agregar dos productos al carrito.
- Visualizar el carrito.
- Completar el formulario de compra.
- Finalizar la compra hasta la confirmacion: `THANK YOU FOR YOUR ORDER`.

## Reportes de Pruebas

Los reportes generados se ubican en:

`target/site/serenity/`

Abrir el archivo:

`target/site/serenity/index.html`

Para visualizar el resultado completo con capturas y pasos ejecutados.
