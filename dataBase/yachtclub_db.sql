DROP DATABASE IF EXISTS yachtclub_db;
CREATE DATABASE yachtclub_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE yachtclub_db;

--------------------------------------------------------
-- TABLA ROLES
--------------------------------------------------------
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

--------------------------------------------------------
-- TABLA SOCIOS
--------------------------------------------------------
CREATE TABLE socios (
    id_socio BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    direccion VARCHAR(120),
    dni VARCHAR(20) UNIQUE,
    telefono VARCHAR(20),
    fecha_ingreso DATE
);

--------------------------------------------------------
-- TABLA USUARIOS
--------------------------------------------------------
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol_id BIGINT NOT NULL,
    socio_id BIGINT,
    FOREIGN KEY (rol_id) REFERENCES roles(id),
    FOREIGN KEY (socio_id) REFERENCES socios(id_socio)
);

--------------------------------------------------------
-- TABLA ZONAS
--------------------------------------------------------
CREATE TABLE zonas (
    id_zona BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio_mensual DECIMAL(10,2)
);

--------------------------------------------------------
-- TABLA AMARRES
--------------------------------------------------------
CREATE TABLE amarres (
    id_amarre BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL UNIQUE,
    lectura_agua DECIMAL(10,2),
    lectura_luz DECIMAL(10,2),
    mantenimiento BOOLEAN,
    id_zona BIGINT NOT NULL,
    FOREIGN KEY (id_zona) REFERENCES zonas(id_zona)
);


--------------------------------------------------------
-- TABLA EMPLEADOS
--------------------------------------------------------
CREATE TABLE empleados (
    id_empleado BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60),
    telefono VARCHAR(20),
    direccion VARCHAR(120),
    codigo VARCHAR(10) UNIQUE,
    especialidad VARCHAR(60),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

--------------------------------------------------------
-- TABLA INTERMEDIA empleado_zona (MUCHOS A MUCHOS)
--------------------------------------------------------
CREATE TABLE empleado_zona (
    id_empleado BIGINT NOT NULL,
    id_zona BIGINT NOT NULL,
    barcosacargo INT DEFAULT 0,
    PRIMARY KEY (id_empleado, id_zona),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_zona) REFERENCES zonas(id_zona) ON DELETE CASCADE ON UPDATE CASCADE
);
--------------------------------------------
-- TABLA EMBARCACIONES
--------------------------------------------------------
CREATE TABLE embarcaciones (
    id_embarcacion BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60),
    matricula VARCHAR(20) UNIQUE,
    tipo VARCHAR(40),
    eslora DECIMAL(10,2),
    manga DECIMAL(10,2),
    fecha_asignacion DATE,
    id_socio BIGINT NOT NULL,
    id_amarre BIGINT,
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio),
    FOREIGN KEY (id_amarre) REFERENCES amarres(id_amarre)
);

--------------------------------------------------------
-- TABLA COMPRAS AMARRE
--------------------------------------------------------
CREATE TABLE compras_amarre (
    id_compra BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DECIMAL(10,2),
    id_socio BIGINT NOT NULL,
    id_amarre BIGINT NOT NULL,
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio),
    FOREIGN KEY (id_amarre) REFERENCES amarres(id_amarre)
);
