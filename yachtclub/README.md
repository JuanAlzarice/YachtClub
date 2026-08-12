# Yacht Club Puerto Madero

Aplicación web desarrollada como proyecto integrador de **Programación II**, orientada a la gestión de socios, embarcaciones y amarres de un club náutico.

## Descripción

El sistema permite administrar la información relacionada con los socios del club, sus embarcaciones y los amarres disponibles.

La aplicación fue desarrollada utilizando una arquitectura por capas, separando las responsabilidades entre controladores, servicios, repositorios y entidades.

## Funcionalidades principales

- Gestión de socios.
- Gestión de embarcaciones.
- Gestión de amarres.
- Gestión de usuarios.
- Gestión de roles.
- Autenticación mediante Spring Security.
- Autorización según el rol del usuario.
- Gestión de compras de amarres.
- Consulta de información asociada a los socios.
- Operaciones CRUD sobre las principales entidades.

## Tecnologías utilizadas

- Java 24
- Spring Boot 3.5.7
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- Thymeleaf
- Bootstrap
- MySQL
- Maven
- NetBeans

## Arquitectura

El proyecto utiliza una arquitectura por capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

Se encarga de recibir y procesar las peticiones HTTP y coordinar la interacción con las vistas.

### Service

Contiene la lógica de negocio y las validaciones correspondientes.

### Repository

Utiliza Spring Data JPA para realizar el acceso y persistencia de datos.

### Entity

Representa las entidades del dominio y su relación con las tablas de la base de datos mediante JPA.

## Seguridad

La aplicación utiliza **Spring Security** para gestionar la autenticación y autorización.

Los roles utilizados por el sistema son:

- ADMIN
- EMPLEADO
- SOCIO
- SUPERVISOR

El sistema obtiene el rol del usuario autenticado y genera dinámicamente la autoridad correspondiente.

## Base de datos

El proyecto utiliza **MySQL**.

Para ejecutar la aplicación es necesario crear una base de datos llamada:

```sql
CREATE DATABASE yachtclub_db;
```

Luego se deben configurar las credenciales de conexión en:

```text
src/main/resources/application.properties
```

Por motivos de seguridad, este archivo no debe incluirse en el repositorio cuando contiene credenciales reales.

Se proporciona como referencia:

```text
src/main/resources/application-example.properties
```

## Configuración

Copiar el archivo de ejemplo:

```text
application-example.properties
```

como:

```text
application.properties
```

y completar:

```properties
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
```

Verificar también que la URL de conexión corresponda al servidor MySQL utilizado:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/yachtclub_db?useSSL=false&serverTimezone=UTC
```

## Ejecución

### Desde NetBeans

1. Abrir el proyecto.
2. Verificar la configuración de MySQL.
3. Ejecutar el proyecto como aplicación Spring Boot.
4. Esperar a que Spring Boot inicie el servidor.
5. Acceder desde el navegador a:

```text
http://localhost:8080
```

### Desde Maven

También puede ejecutarse mediante:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

## Estructura principal

```text
src/
└── main/
    ├── java/
    │   └── ar.edu.utn.yachtclub/
    │       ├── config/
    │       ├── controller/
    │       ├── entity/
    │       ├── repository/
    │       └── service/
    │
    └── resources/
        ├── templates/
        ├── static/
        └── application.properties
```

## Principios y conceptos aplicados

Durante el desarrollo se aplicaron conceptos vistos en Programación II, entre ellos:

- Programación orientada a objetos.
- Arquitectura por capas.
- CRUD.
- Inyección de dependencias.
- IoC y DI.
- Principios SOLID.
- JPA.
- Hibernate.
- Spring Data JPA.
- Spring Security.
- Autenticación y autorización.
- Validaciones.
- Manejo de excepciones.

## Integrantes

- Juan Alzarice
- [Integrante 2]
- [Integrante 3]
- [Integrante 4]

## Proyecto

Repositorio del proyecto:

https://github.com/JuanAlzarice/YachtClub