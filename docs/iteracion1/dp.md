# Diseño y planificación

## Indice

1. [Trabajo en equipo](#trabajo-en-equipo)
2. [Distribución de trabajo](#distribución-de-trabajo)
3. [Diseño OO](#diseño-OO)
4. [Wireframe y caso de uso](#wireframe-y-caso-de-uso)
    - [Página principal](#página-principal)
    - [Productos - Wireframes y Casos de uso](#productos---wireframes-y-casos-de-uso)
        - [Wireframe: Listar productos](#wireframe-listar-productos-extiende-de-home)
        - [Caso de uso: Listar productos](#caso-de-uso-listar-productos)
        - [Wireframe: Crear producto](#wireframe-crear-producto-extiende-de-home)
        - [Caso de uso: Crear producto](#caso-de-uso-crear-producto)
        - [Wireframe: Editar producto](#wireframe-editar-producto-extiende-de-home)
        - [Caso de uso: Editar producto](#caso-de-uso-editar-producto)
        - [Wireframe: Ver producto](#wireframe-ver-producto-extiende-de-home)
        - [Caso de uso: Ver producto](#caso-de-uso-ver-producto)
        - [Wireframe: Borrar producto](#wireframe-borrar-producto-modal)
        - [Caso de uso: Borrar producto](#caso-de-uso-borrar-producto)
    - [Categorias - Wireframes y Casos de uso](#categorias---wireframes-y-casos-de-uso)
        - [Wireframe: Listar categorias](#wireframe-listar-categorias-extiende-de-home)
        - [Caso de uso: Listar categorias](#caso-de-uso-listar-categorias)
        - [Wireframe: Crear categoria](#wireframe-crear-categoria-extiende-de-home)
        - [Caso de uso: Crear categoria](#caso-de-uso-crear-categoria)
        - [Wireframe: Editar categoria](#wireframe-editar-categoria-extiende-de-home)
        - [Caso de uso: Editar categoria](#caso-de-uso-editar-categoria)
        - [Wireframe: Ver categoria](#wireframe-ver-categoria-extiende-de-home)
        - [Caso de uso: Ver categoria](#caso-de-uso-ver-categoria)
        - [Wireframe: Borrar categoria](#wireframe-borrar-categoria-modal)
        - [Caso de uso: Borrar categoria](#caso-de-uso-borrar-categoria)
5. [Backlog de las iteraciones](#backlog-de-las-iteraciones)
6. [Tareas](#tareas)


---

## Trabajo en equipo
**Lider de Iteración:** Pluhator, C. Nicolas

---

### Distribución de trabajo
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

#### Wireframe: Listar categorias (Extiende de Home) 

![Listar categorias](/docs/iteracion1/diagrams/w3_ListCateg.PNG)

#### Caso de uso: Listar categorias

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
- Crear servicios de las clases Producto, Precio y Categoría.
- Relacionar los modelos correspondientes.
- Crear controladores de las clases Producto, Precio y Categoría.
- Crear y configurar rutas.
- Crear vista de navegacion inicial.
- Crear vistas relacionadas al CRUD del producto.
- Crear vistas relacionadas al CRUD de categoría.

---

[Ir al índice](#indice)
