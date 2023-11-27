# Diseño y planificación

## Indice

1. [Trabajo en equipo](#trabajo-en-equipo)
2. [Distribución de trabajo](#distribución-de-trabajo)
3. [Diseño OO](#diseño-OO)
4. [Wireframe y caso de uso](#wireframe-y-caso-de-uso)
    - [Página principal](#página-principal)
    - [Clientes - Wireframes y Casos de uso](#clientes---wireframes-y-casos-de-uso)
        - [Wireframe: Listar Cliente](#wireframe-listar-cliente-extiende-de-home)
        - [Caso de uso: Listar Cliente](#caso-de-uso-listar-cliente)
        - [Wireframe: Crear Cliente](#wireframe-crear-cliente)
        - [Caso de uso: Crear Cliente](#caso-de-uso-crear-cliente)
        - [Wireframe: Editar Cliente](#wireframe-editar-cliente)
        - [Caso de uso: Editar Cliente](#caso-de-uso-editar-cliente)
        - [Wireframe: Baja Cliente](#wireframe-baja-cliente)
        - [Caso de uso: Baja Cliente](#caso-de-uso-baja-cliente)
    - [Proveedores - Wireframes y Casos de uso](#proveedores---wireframes-y-casos-de-uso)
        - [Wireframe: Listar Proveedor](#wireframe-listar-proveedor-extiende-de-home)
        - [Caso de uso: Listar Proveedor](#caso-de-uso-listar-proveedor)
        - [Wireframe: Crear Proveedor](#wireframe-crear-proveedor)
        - [Caso de uso: Crear Proveedor](#caso-de-uso-crear-proveedor)
        - [Wireframe: Editar Proveedor](#wireframe-editar-proveedor)
        - [Caso de uso: Editar Proveedor](#caso-de-uso-editar-proveedor)
        - [Wireframe: Baja Proveedor](#wireframe-baja-proveedor)
        - [Caso de uso: Baja Proveedor](#caso-de-uso-baja-proveedor)
5. [Backlog de las iteraciones](#backlog-de-las-iteraciones)
6. [Tareas](#tareas)

## Trabajo en equipo
**Lider de Iteración:** Pluhator, C. Nicolas

---

### Distribución de trabajo
_**Pluhator Nicolás:**_ Crear y programar modelos\clases, controladores, desarrollo de interfaz de usuario (vistas), controles de validacion, definicion de rutas.

---
 
## Diseño OO
![Diagrama de clases de IT4](/docs/iteracion4/diagrams/IT4_diagramaDeClases.JPG)

---

## Wireframe y caso de uso

### Página principal

![Página principal](/docs/iteracion4/diagrams/w1_home.JPG)

En nuestra página principal nos podremos dirigir tanto a "Clientes" como a "Proveedores".

---

### Clientes - Wireframes y Casos de uso

---

#### Wireframe: Listar Cliente (Extiende de Home) 
![Listar clientes](/docs/iteracion4/diagrams/w2_ListCliente.JPG)

#### Caso de uso: Listar Cliente

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a "Clientes".
4. El sistema traerá y mostrará un listado de todos los clientes.

---

#### Wireframe: Crear Cliente
![Crear cliente](/docs/iteracion4/diagrams/w3_createCliente.JPG)

#### Caso de uso: Crear Cliente

Una vez en la página de listado de clientes (Referirse al caso de uso Listar Clientes).

1. El usuario deberá acceder a **"Nuevo Cliente"**.
2. Se le presentará al usuario el formulario para rellenar los datos del cliente.
3. Una vez completado el relleno de datos se hará click al boton **"Guardar"**.

---


#### Wireframe: Editar Cliente
![Editar cliente](/docs/iteracion4/diagrams/w4_editCliente.JPG)

#### Caso de uso: Editar Cliente

Una vez en la página de listado de clientes (Referirse al caso de uso Listar Clientes).

1. El usuario deberá hacer click en el botón **"Editar"**.
2. Se le presentará al usuario el formulario con los datos del cliente.
3. Una vez cambiado los datos se hará click al boton **"Editar"**.

---

#### Wireframe: Baja Cliente
![Baja cliente](/docs/iteracion4/diagrams/w5_deleteCliente.JPG)

#### Caso de uso: Baja Cliente

Una vez en la página de listado de clientes (Referirse al caso de uso Listar Clientes).

1. El usuario deberá hacer click en el botón **"Baja"**.
2. Se le presentará al usuario un mensaje de confirmacion.
3. El usuario hara click en **"Aceptar"**.

---

---

### Proveedores - Wireframes y Casos de uso

---

#### Wireframe: Listar Proveedor (Extiende de Home) 
![Listar proveedores](/docs/iteracion4/diagrams/w6_ListProveedor.JPG)

#### Caso de uso: Listar Proveedor

1. El usuario accederá a la aplicación web a través de un navegador.
2. Se le presentará al usuario la página de inicio.
3. En la barra de navegación accederá a "Proveedores".
4. El sistema traerá y mostrará un listado de todos los proveedores.

---

#### Wireframe: Crear Proveedor
![Crear cliente](/docs/iteracion4/diagrams/w7_createProveedor.JPG)

#### Caso de uso: Crear Proveedor

Una vez en la página de listado de proveedores (Referirse al caso de uso Listar Proveedores).

1. El usuario deberá acceder a **"Nuevo Proveedor"**.
2. Se le presentará al usuario el formulario para rellenar los datos del proveedor.
3. Una vez completado el relleno de datos se hará click al boton **"Guardar"**.

---

#### Wireframe: Editar Proveedor
![Editar proveedor](/docs/iteracion4/diagrams/w8_editProveedor.JPG)

#### Caso de uso: Editar Proveedor

Una vez en la página de listado de proveedores (Referirse al caso de uso Listar Proveedores).

1. El usuario deberá hacer click en el botón **"Editar"**.
2. Se le presentará al usuario el formulario con los datos del proveedor.
3. Una vez cambiado los datos se hará click al boton **"Editar"**.

---

#### Wireframe: Baja Proveedor
![Baja cliente](/docs/iteracion4/diagrams/w9_deleteProveedor.JPG)

#### Caso de uso: Baja Proveedor

Una vez en la página de listado de proveedores (Referirse al caso de uso Listar Proveedores).

1. El usuario deberá hacer click en el botón **"Baja"**.
2. Se le presentará al usuario un mensaje de confirmacion.
3. El usuario hara click en **"Aceptar"**.

---

## Backlog de las iteraciones

- Como _**comerciante**_, quiero leer los clientes para poder visualizar los clientes que tengo en mi sistema.
- Como _**comerciante**_, quiero ver un cliente para poder ver detalladamente sus datos.
- Como _**comerciante**_, quiero crear un cliente para poder registrar un nuevo cliente de mi tienda.
- Como _**comerciante**_, quiero actualizar un cliente para poder corregir aquella información erronea.
- Como _**comerciante**_, quiero eliminar un cliente para dar de baja un cliente en caso de haber sido creado por error.
- Como _**comerciante**_, quiero leer los proveedores para poder visualizar los proveedores que tengo en mi sistema.
- Como _**comerciante**_, quiero ver un proveedor para poder ver detalladamente sus datos.
- Como _**comerciante**_, quiero crear un proveedor para poder registrar un nuevo proveedor de mi tienda.
- Como _**comerciante**_, quiero actualizar un proveedor para poder corregir aquella información erronea.
- Como _**comerciante**_, quiero eliminar un proveedor para dar de baja un proveedor en caso de haber sido creado por error.

---

## Tareas

- Crear modelos de las clases Cliente y Proveedor.
- Crear repositorios de las clases Cliente y Proveedor.
- Crear servicios de las clases Cliente y Proveedor.
- Relacionar los modelos correspondientes.
- Crear controladores de las clases Cliente y Proveedor.
- Documentar las clases Cliente y Proveedor con Javadoc.
- Realizar Test de clases Cliente y Proveedor.
- Crear y configurar rutas.
- Crear vistas relacionadas al CRUD del Cliente.
- Crear vistas relacionadas al CRUD del Proveedor.

---

[Ir al índice](#indice)