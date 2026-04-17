# 🚀 Dominando JPA & EclipseLink: De Objetos a Relaciones - [ADJGC](https://www.linkedin.com/in/adjgc/)


Este repositorio contiene el material didáctico, las guías prácticas y los laboratorios desarrollados para el curso avanzado de Programación Orientada a Objetos. El objetivo principal es proporcionar al estudiante una comprensión profunda de la capa de persistencia en entornos empresariales Java.

## 🎯 Objetivos de Aprendizaje
* Dominar el estándar **JPA (Jakarta Persistence)** mediante el uso de la implementación de referencia **EclipseLink**.
* Comprender y aplicar el paradigma **Object-Relational Mapping (ORM)** para la gestión de datos.
* Implementar operaciones de persistencia atómica (**CRUD**) siguiendo patrones de diseño robustos.
* Modelar arquitecturas de datos complejas mediante asociaciones `@OneToOne` y `@OneToMany`.

## 🛠️ Stack Tecnológico de Referencia
* **Lenguaje de Programación:** Java 21 (LTS)
* **Implementación de Persistencia:** EclipseLink 4.0+
* **Motor de Base de Datos:** MySQL 8.0
* **Herramientas de Desarrollo:**
    * IDE: IntelliJ IDEA (JetBrains)
    * Gestión de Base de Datos: DataGrip (JetBrains)
    * Automatización de Construcción: Maven

## 📂 Estructura del Programa
1. **Infraestructura y Configuración:** Definición de la Unidad de Persistencia (`persistence.xml`) y gestión del `EntityManager`.
2. **Modelado de Entidades:** Ciclo de vida de los objetos, mapeo de atributos y estrategias de generación de llaves primarias.
3. **Asociaciones y Relaciones:** Integridad referencial, relaciones bidireccionales y gestión de colecciones.
4. **Consultas y Optimización:** Introducción a JPQL (Java Persistence Query Language) y criterios de búsqueda.

## ⚙️ Requisitos de Instalación
Para el correcto seguimiento de las prácticas, es imperativo contar con el SDK de Java 21 y una instancia funcional de MySQL. La configuración de acceso debe ser gestionada estrictamente a través de las variables de entorno o archivos de configuración locales.