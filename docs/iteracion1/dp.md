# Diseño y planificación

## Indice

---

## Trabajo en equipo
**Lider de Iteración:** Pluhator, C. Nicolas

---

### Distribucion de trabajo
_**Pluhator Nicolás:**_ Configuracion inicial del proyecto, crear y programar modelos\clases, controladores, desarrollo de interfaz de usuario (vistas), controles de validacion, definicion de rutas, creacion de seeders.

---
 
## Diseño OO
![Diagrama de clases de IT1](/docs/iteracion1/diagrams/IT1_diagramaDeClases.jpg)

---

## Wireframe y caso de uso

### Página principal

![Página principal](/docs/iteracion1/diagrams/w1_home.PNG)

Esta será la página principal de la página, donde podemos ver:
- Nombre de la tienda en la zona superior.
- Una barra de navegación, donde estos elementos son de ejemplo, se iran agregando y cambiando a medido de las iteraciones.
- Luego tenemos la zona de contenido. Ésta es donde se mostrará el contenido.
- Y al final de la página en la zona inferior contará con un footer con los datos de contacto de la tienda o cualquier información que se crea necesaria.

Las dos primeras zonas mencionadas estarán presentes en todas las páginas.

---

### Productos - Wireframes y Casos de uso

---

#### Wireframe: Listar productos (Extiende de Home) 

![Listar productos](/docs/iteracion1/diagrams/w2_ListProduct.PNG)

#### Caso de uso: Listar productos

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a "Productos".
4. El sistema traerá y mostrará un listado de todos los productos en el sistema.

---

#### Wireframe: Crear producto (Extiende de Home) 

![ Crear producto](/docs/iteracion1/diagrams/w4_CreateProduct.PNG)

#### Caso de uso: Crear producto

Una vez en la página de listado de productos (Referirse al caso de uso Listar productos).

1. El usuario deberá acceder a **"Nuevo"**.
2. Se le presentará al usuario el formulario para rellenar los datos del producto.
3. Una vez completado el relleno de datos se hará click al boton **"Guardar"**.

---

#### Wireframe: Editar producto (Extiende de Home) 

![Editar producto](/docs/iteracion1/diagrams/w5_UpdateProduct.PNG)

#### Caso de uso: Editar producto

Una vez en la página de listado de productos (Referirse al caso de uso Listar productos).

1. El usuario deberá acceder a **"Editar"** del producto al cual quiere modificar.
2. Se le presentará al usuario el formulario para rellenar los datos del producto ya cargado con los datos actuales.
3. Una vez modificado los datos se hará click al boton **"Guardar"**.

_**Caso alternativo:**_ Desde la vista de ver un producto (Referirse a Caso de uso: Ver Producto)

1. El usuario deberá acceder a **"Editar"**
2. Se le presentará al usuario el formulario para rellenar los datos del producto ya cargado con los datos actuales.
3. Una vez modificado los datos se hará click al boton **"Guardar"**.

---

#### Wireframe: Ver producto (Extiende de Home) 

![Ver producto](/docs/iteracion1/diagrams/w6_ShowProduct.PNG)

#### Caso de uso: Ver producto

Una vez en la página de listado de productos (Referirse al caso de uso Listar productos).

1. El usuario deberá acceder a **"Ver"** del producto al cual quiere ver información.
2. Se le presentará al usuario la página de información del producto seleccionado.

---

#### Wireframe: Borrar producto (Modal) 

![Borrar Producto](/docs/iteracion1/diagrams/w10_DeleteProduct.PNG)

#### Caso de uso: Borrar producto

Una vez en la página de listado de productos (Referirse al caso de uso Listar productos)

1. El usuario deberá acceder a **"Eliminar"** producto al cual quiere eliminar.
2. Se le presentará al usuario una advertencia y consulta para confirmar la eliminación del producto.
3. El usuario hará click al boton **"Aceptar"**.

---

### Categorias - Wireframes y Casos de uso

---

#### Wireframe: Listar categoría (Extiende de Home) 

![Listar categoría](/docs/iteracion1/diagrams/w3_ListCateg.PNG)

#### Caso de uso: Listar categoría

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a **"Categorias"**.
4. El sistema traerá y mostrará un listado de todos las categorias en el sistema.

---

#### Wireframe: Crear categoría (Extiende de Home) 

![ Crear categoria](/docs/iteracion1/diagrams/w7_CreateCateg.PNG)

#### Caso de uso: Crear producto

Una vez en la página de listado de categorias (Referirse al caso de uso Listar categorias).

1. El usuario deberá acceder a **"Nuevo"**.
2. Se le presentará al usuario el formulario para rellenar los datos de la categoría.
3. Una vez completado el relleno de datos se hará click al boton **"Guardar"**.

---

#### Wireframe: Editar categoría (Extiende de Home) 

![Editar Categoría](/docs/iteracion1/diagrams/w8_UpdateCateg.PNG)

#### Caso de uso: Editar categoría

Una vez en la página de listado de categorias (Referirse al caso de uso Listar categorias).

1. El usuario deberá acceder a **"Editar"** de la categoría la cual quiere modificar.
2. Se le presentará al usuario el formulario para rellenar los datos de la categoría ya cargado con los datos actuales.
3. Una vez modificado los datos se hará click al boton **"Guardar"**.

_**Caso alternativo:**_ Desde la vista de ver una categoría (Referirse a Caso de uso: Ver Categoría)

1. El usuario deberá acceder a **"Editar"**
2. Se le presentará al usuario el formulario para rellenar los datos de la categoría ya cargado con los datos actuales.
3. Una vez modificado los datos se hará click al boton **"Guardar"**.

---


#### Wireframe: Ver categoría (Extiende de Home) 

![Ver categoría](/docs/iteracion1/diagrams/w9_ShowCateg.PNG)

#### Caso de uso: Ver categoría

Una vez en la página de listado de categorias (Referirse al caso de uso Listar categorias).

1. El usuario deberá acceder a **"Ver"** de la caegoría la cual quiere ver información.
2. Se le presentará al usuario la página de información de la categoría seleccionada.

---

#### Wireframe: Borrar categoría (Modal) 

![Borrar Categoría](/docs/iteracion1/diagrams/w11_DeleteCategoria.PNG)

#### Caso de uso: Borrar categoría

Una vez en la página de listado de categorias (Referirse al caso de uso Listar categorias).

1. El usuario deberá acceder a **"Eliminar"** categoría la cual quiere eliminar.
2. Se le presentará al usuario una advertencia y consulta para confirmar la eliminación de la categoría.
3. El usuario hará click al boton **"Aceptar"**.

---

## Backlog de las iteraciones

1. Como _**comerciante**_, quiero leer mis productos para poder revisar lo que está disponible actualmente en mi sitio.
2. Como  _**comerciante**_, quiero crear un producto para poder ofrecer a mis clientes los productos.
3. Como  _**comerciante**_, quiero actualizar un producto para poder ofrecer a mis clientes los productos.
4. Como  _**comerciante**_, quiero eliminar un producto para quitar aquellos productos que no serán usados.
5. Como _**comerciante**_, quiero leer las categorias para poder revisar cuales son las disponibles.
6. Como  _**comerciante**_, quiero crear una categoría para poder clasificar los productos.
7. Como  _**comerciante**_, quiero actualizar una categoría para poder mantener actualizada la información.
8. Como  _**comerciante**_, quiero eliminar una categoría para poder quitar aquellas categorías que no serán usadas.

---

## Tareas

- Configuración inicial del proyecto.
- Crear modelos de las clases Producto, Precio y Categoría.
- Crear repositorios de las clases Producto, Precio y Categoría.
- Relacionar los modelos correspondientes.
- Crear controladores de las clases Producto, Precio y Categoría.
- Crear y configurar rutas.
- Crear vista de navegacion inicial.
- Crear vistas relacionadas al CRUD del producto.
- Crear vistas relacionadas al CRUD de categoría.


## ~~Retrospectiva~~
