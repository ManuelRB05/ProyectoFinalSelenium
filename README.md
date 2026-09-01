# Proyecto Final — Automatización Web con Selenium

Framework de automatización de pruebas para el sitio [saucedemo.com](https://www.saucedemo.com/), construido con **Selenium WebDriver**, **Java** y **TestNG**, aplicando el patrón **Page Object Model** con **Page Factory**.

## Escenarios automatizados

**Compra de un producto.** Recorre el buyflow completo: inicia sesión, selecciona un producto aleatorio, lo agrega al carrito, completa los datos personales y valida que se llega a la pantalla de confirmación de la orden.

**Eliminación de productos del carrito.** Agrega tres productos distintos, entra al carrito, los elimina uno a uno y valida que el carrito quede vacío.

**Cierre de sesión.** Abre el menú lateral, cierra la sesión y valida que el usuario sea redirigido a la página de login.

## Decisiones de diseño

Todos los page objects heredan de `BasePage`, que centraliza el `WebDriver`, el `WebDriverWait` y las acciones comunes (`click`, `type`, `getText`). Los localizadores se declaran con `@FindBy` y son privados: los tests nunca manipulan un `WebElement` directamente.

Los métodos que provocan una navegación devuelven la instancia de la página destino, de modo que cada test se lee como el flujo real del usuario. Las esperas viven dentro de las páginas y las aserciones únicamente dentro de los tests, manteniendo los page objects neutrales.

Los datos de prueba (credenciales, información de checkout y mensajes esperados) están centralizados en `Constants`, para que las páginas sean independientes de los datos.
## Autor

Manuel Rodríguez
