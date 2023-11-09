# Diseño y planificación

## Indice

1. [Trabajo en equipo](#trabajo-en-equipo)
2. [Distribución de trabajo](#distribución-de-trabajo)
3. [Diseño OO](#diseño-OO)
4. [Wireframe y caso de uso](#wireframe-y-caso-de-uso)
    - [Página principal](#página-principal)
    - [Ventas - Wireframes y Casos de uso](#ventas---wireframes-y-casos-de-uso)
        - [Wireframe: Listar ventas](#wireframe-listar-ventas-extiende-de-home)
        - [Caso de uso: Listar ventas](#caso-de-uso-listar-ventas)
        - [Wireframe: Crear Venta](#wireframe-crear-venta-extiende-de-home)
        - [Caso de uso: Crear Venta](#caso-de-uso-crear-venta)
        - [Wireframe: Agregar articulo](#wireframe-agregar-articulo-extiende-de-ventas)
        - [Caso de uso: Agregar articulo](#caso-de-uso-agregar-articulo)
        - [Wireframe: Editar articulo](#wireframe-editar-articulo-extiende-de-ventas)
        - [Caso de uso: Editar articulo](#caso-de-uso-editar-articulo)
        - [Wireframe: Quitar articulo](#wireframe-quitar-articulo-extiende-de-ventas)
        - [Caso de uso: Quitar articulo](#caso-de-uso-quitar-articulo)
        - [Wireframe: Eliminar Venta](#wireframe-eliminar-venta)
        - [Caso de uso: Eliminar venta](#caso-de-uso-eliminar-venta)
5. [Backlog de las iteraciones](#backlog-de-las-iteraciones)
6. [Tareas](#tareas)

## Trabajo en equipo
**Lider de Iteración:** Pluhator, C. Nicolas

---

### Distribución de trabajo
_**Pluhator Nicolás:**_ Crear y programar modelos\clases, controladores, desarrollo de interfaz de usuario (vistas), controles de validacion, definicion de rutas.

---
 
## Diseño OO
![Diagrama de clases de IT3](/docs/iteracion3/diagrams/IT3_diagramaDeClases.JPG)

---

## Wireframe y caso de uso

### Página principal

![Página principal](/docs/iteracion3/diagrams/w1_home.JPG)

En nuestra página principal nos dirigiremos a la barra de navegación en la opción "Ventas".

---

### Ventas - Wireframes y Casos de uso

---

---

#### Wireframe: Listar ventas (Extiende de Home) 
![Listar ventas](/docs/iteracion3/diagrams/w2_ListFacturas.JPG)

#### Caso de uso: Listar ventas

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a "Ventas".
4. El sistema traerá y mostrará un listado de todos las ventas.

---

#### Wireframe: Crear Venta (Extiende de Home)
![Crear venta](/docs/iteracion3/diagrams/w3_createVenta.JPG)
![Crear venta](/docs/iteracion3/diagrams/w6_ListLinea.JPG)
![Crear venta](/docs/iteracion3/diagrams/w10_finishVenta.JPG)

#### Caso de uso: Crear venta

Una vez en la página de listado de ventas (Referirse al caso de uso Listar ventas).

1. El usuario deberá acceder a **"Nuevo"**.
2. Se le presentará al usuario el formulario para rellenar los datos de la venta.
3. Una vez completado el relleno de datos se hará click al boton **"Siguiente"**.
4. Este nos llevará al listado de los articulos de la venta. Si deseamos agregar articulos a la venta, debemos presionar el botón **"Agregar".** (Vease Caso de Uso: Agregar articulo).
5. Luego de haber agregado los articulos correspondientes, el usuario deberá hacer click en el boton **"Finalizar"**.
6. Se le presentará una pantalla de confirmación.
7. El usuario deberá hacer click en el botón **"Aceptar".**

**_Caso alternativo_**

**"_Paso 4:_"** En caso de no agregar ningún articulo y volver, la venta quedará con estado de "En progreso".

--- 

#### Wireframe: Agregar articulo (Extiende de ventas)
![Agregar articulo](/docs/iteracion3/diagrams/w7_createLinea.JPG)

#### Caso de uso: Agregar articulo
1. El usuario deberá haber creado una venta. (Vease Caso de uso: Crear Venta).
2. El usuario deberá hacer click en el botón de **"Agregar".**
3. Se le presentará un formulario para rellenar los datos del articulo.
4. El usuario luego de rellenar los campos, deberá hacer click en el botón **"Agregar".**

---

#### Wireframe: Editar articulo (Extiende de ventas)
![Listar articulos](/docs/iteracion3/diagrams/w6_ListLinea.JPG)
![Editar articulo](/docs/iteracion3/diagrams/w8_editLinea.JPG)

#### Caso de uso: Editar articulo

1. El usuario debe estar en el listado de articulos (Vease Caso de uso: Crear Venta).
2. El usuario deberá hacer click en el botón **"Editar"**.
3. Se le presentará el formulario con los campos rellenados del articulo a editar.
4. El usuario deberá modificar en caso que requiera y hacerle click al boton **"Editar"**.

---

#### Wireframe: Quitar articulo (Extiende de ventas)
![Listar articulos](/docs/iteracion3/diagrams/w6_ListLinea.JPG)
![Quitar articulo](/docs/iteracion3/diagrams/w9_deleteLinea.JPG)

#### Caso de uso: Quitar articulo

1. El usuario debe estar en el listado de articulos (Vease Caso de uso: Listar articulos).
2. El usuario deberá hacer click en el botón **"Quitar"**.
3. Se le presentara un mensaje de confirmacion.
4. El usuario debera confirmar.

---

#### Wireframe: Eliminar Venta
![Listar ventas](/docs/iteracion3/diagrams/w2_ListFacturas.JPG)
![Eliminar venta](/docs/iteracion3/diagrams/w5_deleteVenta.JPG)

#### Caso de uso: Eliminar Venta

1. El usuario debe estar en el listado de ventas (Vease Caso de uso: Listado de Ventas).
2. El usuario deberá hacer click en el botón **"Eliminar"**.
3. Se le presentará una pantalla de confirmación.
4. El usuario deberá hacerle click al boton **"Aceptar"**.

---

## Backlog de las iteraciones

- Como _**comerciante**_, quiero leer las ventas para poder revisar los registros de las ventas realizadas.
- Como _**comerciante**_, quiero crear una venta para poder realizar el regsitro de una venta efectuada.
- Como _**comerciante**_, quiero editar una venta para poder corregir cuando haya un error en una venta.
- Como _**comerciante**_, quiero eliminar una venta para cuando se cancele una venta.

---

## Tareas

- Adaptar las clases Transaccion y TransaccionesProductos.
- Adaptar repositorios de las clases Transaccion y TransaccionesProductos.
- Adaptar servicios de las clases Transaccion y TransaccionesProductos.
- Crear controladores de las clases Factura y DetalleFactura.
- Documentar las clases Factura y DetalleFactura con Javadoc.
- Crear y configurar rutas.

---

[Ir al índice](#indice)