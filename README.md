# Biblioteca de libros de Stephen King

Proyecto desarrollado en Java para la asignatura de Programación.

La aplicación permite importar libros desde una API externa en formato JSON, buscar libros por id, gestionar una lista de favoritos y exportar/importar esos favoritos mediante serialización en un fichero local. :contentReference[oaicite:1]{index=1}

## Objetivo del proyecto

Crear una biblioteca de libros del autor Stephen King que permita:

- importar el catálogo de libros desde una API externa
- buscar información de un libro por id
- añadir libros a favoritos
- exportar favoritos a un fichero local
- importar favoritos desde un fichero previamente guardado

El enunciado establece además el uso de un fichero `favoritos.obj` para guardar los libros favoritos.

## Funcionalidades implementadas

- Importación de libros desde la API:
  - `https://stephen-king-api.onrender.com/api/books`
- Búsqueda de libros por id
- Gestión de favoritos en memoria
- Exportación de favoritos a `favoritos.obj`
- Importación de favoritos desde `favoritos.obj`
- Menú por consola para interactuar con la aplicación.

## Tecnologías utilizadas

- Java
- Maven
- API REST
- JSON
- Gson
- org.json
- Serialización de objetos
- Git y GitHub

## Estructura del proyecto

```text
src/
└── main/
    └── java/
        ├── model/
        │   ├── Libro.java
        │   └── Biblioteca.java
        ├── controller/
        │   ├── APIController.java
        │   ├── BibliotecaController.java
        │   └── FileController.java
        └── Main.java
```
## Autora del proyecto
Belén Jiménez Sánchez

## Licencia
Proyecto académico con fines educativos
