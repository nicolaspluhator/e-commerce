# Diseño y planificación

## Indice
1. [Trabajo en equipo](#trabajo-en-equipo)
2. [Distribución de trabajo](#distribución-de-trabajo)
3. [Diseño OO](#diseño-OO)
4. [Wireframe y caso de uso](#wireframe-y-caso-de-uso)
    - [Página principal](#página-principal)
    - [Ingresos - Wireframes y Casos de uso](#ingresos---wireframes-y-casos-de-uso)
        - [Wireframe: Listar ingresos](#wireframe-listar-ingresos-extiende-de-home)
        - [Caso de uso: Listar ingresos](#caso-de-uso-listar-ingresos)
        - [Wireframe: Crear ingreso](#wireframe-crear-ingreso-extiende-de-home)
        - [Caso de uso: Listar ingresos](#caso-de-uso-crear-ingreso)
        - [Wireframe: Agregar renglon](#wireframe-agregar-renglon-extiende-de-ingresos)
        - [Caso de uso: Agregar renglon](#caso-de-uso-agregar-renglon)
        - [Wireframe: Editar renglon](#wireframe-editar-renglon-extiende-de-ingresos)
        - [Caso de uso: Editar renglon](#caso-de-uso-editar-renglon)
        - [Wireframe: Quitar renglon](#wireframe-quitar-renglon-extiende-de-ingresos)
        - [Caso de uso: Editar renglon](#caso-de-uso-quitar-renglon)
        - [Wireframe: Eliminar ingreso](#wireframe-eliminar-ingreso-extiende-de-ingresos)
        - [Caso de uso: Eliminar ingreso](#caso-de-uso-eliminar-ingreso)
5. [Backlog de las iteraciones](#backlog-de-las-iteraciones)
6. [Tareas](#tareas)

---

## Trabajo en equipo
**Lider de Iteración:** Pluhator, C. Nicolas

---

### Distribución de trabajo
_**Pluhator Nicolás:**_ Crear y programar modelos\clases, controladores, desarrollo de interfaz de usuario (vistas), controles de validacion, definicion de rutas.

---
 
## Diseño OO
![Diagrama de clases de IT2](/docs/iteracion2/diagrams/IT2_diagramaDeClases.JPG)

---

## Wireframe y caso de uso

### Página principal

![Página principal](/docs/iteracion2/diagrams/w1_home.JPG)

En nuestra página principal nos dirigiremos a la barra de navegación en la opción "Ingresos".

---

### Ingresos - Wireframes y Casos de uso

---

#### Wireframe: Listar ingresos (Extiende de Home) 
![Listar ingresos](/docs/iteracion2/diagrams/w2_ListIngresos.JPG)

#### Caso de uso: Listar ingresos

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a "Ingresos".
4. El sistema traerá y mostrará un listado de todos los ingresos.

---

#### Wireframe: Crear ingreso (Extiende de Home)
![Crear ingreso](/docs/iteracion2/diagrams/w3_createIngreso.JPG)
![Listar renglones](/docs/iteracion2/diagrams/w4_ListRenglones.JPG)
![Finalizar ingreso](/docs/iteracion2/diagrams/w6_confirmationStore.JPG)

#### Caso de uso: Crear Ingreso

Una vez en la página de listado de ingresos (Referirse al caso de uso Listar ingresos).

1. El usuario deberá acceder a **"Nuevo"**.
2. Se le presentará al usuario el formulario para rellenar los datos del ingreso.
3. Una vez completado el relleno de datos se hará click al boton **"Siguiente"**.
4. Este nos llevará al listado de los renglones del ingreso. Si deseamos agregar renglones al ingreso, debemos presionar el botón **"Agregar".** (Vease Caso de Uso: Agregar renglon).
5. Luego de haber agregado los renglones correspondientes, el usuario deberá hacer click en el boton **"Finalizar"**.
6. Se le presentará una pantalla de confirmación.
7. El usuario deberá hacer click en el botón **"Aceptar".**

**_Caso alternativo_**

**"_Paso 4:_"** En caso de no agregar ningún renglón y volver, el ingreso quedará con estado de "En progreso".

--- 

#### Wireframe: Agregar renglon (Extiende de Ingresos)
![Agregar renglon](/docs/iteracion2/diagrams/w5_createRenglon.JPG)

#### Caso de uso: Agregar renglon
1. El usuario deberá haber creado un ingreso. (Vease Caso de uso: Crear Ingreso).
2. El usuario deberá hacer click en el botón de **"Agregar".**
3. Se le presentará un formulario para rellenar los datos del renglon.
4. El usuario luego de rellenar los campos, deberá hacer click en el botón **"Agregar".**

---

#### Wireframe: Editar renglon (Extiende de Ingresos)
![Listar renglones](/docs/iteracion2/diagrams/w4_ListRenglones.JPG)
![Editar renglon](/docs/iteracion2/diagrams/w8_editRenglon.JPG)

#### Caso de uso: Editar renglon

1. El usuario debe estar en el listado de renglones (Vease Caso de uso: Crear Ingreso).
2. El usuario deberá hacer click en el botón **"Editar"**.
3. Se le presentará el formulario con los campos rellenados del renglon a editar.
4. El usuario deberá modificar en caso que requiera y hacerle click al boton **"Guardar"**.

---

#### Wireframe: Quitar renglon (Extiende de Ingresos)
![Listar renglones](/docs/iteracion2/diagrams/w4_ListRenglones.JPG)

#### Caso de uso: Quitar renglon

1. El usuario debe estar en el listado de renglones (Vease Caso de uso: Crear Ingreso).
2. El usuario deberá hacer click en el botón **"Quitar"**.

---

#### Wireframe: Eiminar Ingreso (Extiende de Ingresos)
![Listar ingresos](/docs/iteracion2/diagrams/w2_ListIngresos.JPG)
![Eliminar ingreso](/docs/iteracion2/diagrams/w7_confimationDelete.JPG)

#### Caso de uso: Eliminar Ingreso

1. El usuario debe estar en el listado de ingresos (Vease Caso de uso: Listado de Ingresos).
2. El usuario deberá hacer click en el botón **"Eliminar"**.
3. Se le presentará una pantalla de confirmación.
4. El usuario deberá hacerle click al boton **"Aceptar"**.

---

## Backlog de las iteraciones

- Como _**comerciante**_, quiero leer los ingresos para poder visualizar los ingresos que he tenido.
- Como _**comerciante**_, quiero ver un ingreso para poder ver detalladamente que se compró.
- Como _**comerciante**_, quiero crear un ingreso para poder registrar los nuevos ingresos a mi tienda.
- Como _**comerciante**_, quiero actualizar un ingreso para poder corregir aquella información erronea.
- Como _**comerciante**_, quiero eliminar un ingreso para dar de baja un ingreso en caso de haber sido creado por error.

---

## Tareas

- Crear modelos de las clases Transaccion y TransaccionesProductos.
- Crear repositorios de las clases Transaccion y TransaccionesProductos.
- Crear servicios de las clases Transaccion y TransaccionesProductos.
- Relacionar los modelos correspondientes.
- Crear controladores de las clases Transaccion y TransaccionesProductos.
- Documentar las clases Transaccion y TransaccionesProductos con Javadoc.
- Realizar Test de clases Transaccion y TransaccionesProductos.
- Crear y configurar rutas.
- Crear vistas relacionadas al CRUD del Transaccion.

---

[Ir al índice](#indice)